import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import javax.swing.*;
import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Methods {

  // Settings WebDriver - START
  static WebDriver driver;

  @BeforeAll
  static void setUp() {
//    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//    driver = new ChromeDriver();

    FirefoxOptions options = new FirefoxOptions();
    driver = new FirefoxDriver(options);

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(0));
//    driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(1));
  }

  @AfterAll
  static void tearDown() {
    var sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(sourceFile, new File("data/screenshot.png"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    driver.quit();
  }
  // Settings WebDriver - END


  // Variables

  // variables of Main page - START
  // Login form
  static By locatorLoginFormH1 = By.cssSelector("#l_overlay div.h1");
  static By locatorLoginFormBtnCancel = By.cssSelector("#l_overlay button.button-cleared");

  // Sign up form
  static By locatorSignUpFormH1 = By.cssSelector("#s_overlay div.h1");
  static By locatorSignUpFormBtnCancel = By.cssSelector("#s_overlay button.button-cleared");
  // Main page - END


  String variableUrl;
  static HashSet<String> hashUniqueLinksFromWebElements = new HashSet<>();
  static ArrayList<String> listUrl = new ArrayList<>();
  static HashSet<String> hashUrlDone = new HashSet<>();
  private int i = 0;
  int amount = 1;

  static String fileAddressWithUrls = "data/urlList.txt";
  static String fileHasFinalResult = "data/buttonAmount.txt";
  static String fileWithFinalUrls = "data/finalUrls.txt";

  long start = System.currentTimeMillis();
  long end = start + 10 * 1000;

   //Вызов временной задержки
  public void timeOut(int sec){
    for(int i = 0; i < sec; i++ ){
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  //
  // Выявление всех страниц

  // Парсинг страницы
  // 1. Парсинг WebElements
  // 2. Выделение из WebElements ссылок
  // 3. Добавление уникальных ссылок в лист
  // Вариант 1 (1 локатор)
  public HashSet<String> parsingElementsAndCreateUniqueElementsInList(HashSet<String> whereToAdd, By elementLocator) {
    ArrayList<WebElement> internalList1 = new ArrayList<>(driver.findElements(elementLocator));
    ArrayList<String> internalList2 = new ArrayList<>();
    for (int l = 0; l < internalList1.size(); l++) {
      internalList2.add(internalList1.get(l).getAttribute("href"));
    }
    whereToAdd.addAll(internalList2);
    return whereToAdd;
  }
  // Вариант 2 (2 локатора)
  public HashSet<String> parsingElementsAndCreateUniqueElementsInList2(HashSet<String> whereToAdd, By element1Locator, By element2Locator) {
    ArrayList<WebElement> internalList1 = new ArrayList<>(driver.findElements(element1Locator));
    ArrayList<WebElement> internalList2 = new ArrayList<>(driver.findElements(element2Locator));
    internalList1.addAll(internalList2);
    ArrayList<String> internalList3 = new ArrayList<>();
    for (int l = 0; l < internalList1.size(); l++) {
      internalList3.add(internalList1.get(l).getAttribute("href"));
    }
    whereToAdd.addAll(internalList3);
    return whereToAdd;
  }


  // Обновление списка URL, по которым совершается обход сайта
  public ArrayList updateUrlList(ArrayList whereToAdd, HashSet whatToAdd) {
    whereToAdd.addAll(whereToAdd.size(), whatToAdd);
    return whereToAdd;
  }

  // Дополнение списка URL одним элементом
  public HashSet updateUrl(HashSet whereToAdd, String whatElementToAdd) {
    whereToAdd.add(whatElementToAdd);
    return whereToAdd;
  }

  // Получить URL для обхода программой
  public String getElement(String elementVariable, ArrayList<String> whereToGet, int numberOfListElement) {
    elementVariable = whereToGet.get(numberOfListElement);
    return elementVariable;
  }

  // Получение URL текущей страницы
  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }


//   Проверка кнопок
  public int findButtonThatISVisible(By locator) {
    int counter = 0;
    ArrayList<WebElement> internalList1 = new ArrayList<>(driver.findElements(locator));
    for (int l = 0; l < internalList1.size(); l++) {
      if(internalList1.get(l).isDisplayed()) {
        counter = counter + 1;
      }
    }
    return counter;
  }

  public int findTotalButtonOnPage(By locator) {
    int counter = 0;
    return counter = driver.findElements(locator).size();
  }

  // Чтение файла с URL и внесение их в список для применения в алгоритме прохождения данных страниц сайта
  public ArrayList transferDataFromFileToList(ArrayList listUrl, String fileAddress) {
    try {
      BufferedReader urlFile = new BufferedReader(new FileReader(fileAddress));
      for(;;) {
        String internalLine = urlFile.readLine();
        if(internalLine == null) {
          break;
        }
       listUrl.add(internalLine);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return listUrl;
  }

  public void writeTextToFile(String fileAddress, String lineText) throws FileNotFoundException {
    PrintWriter writer = new PrintWriter(fileAddress);
    writer.write(lineText + "\n");
    writer.flush();
    writer.close();
  }
  // Search url methods - END



  // Main page methods - START

  public void goToPageAndCheckingUrl(String url) {
    driver.navigate().to(url);
    if (url != getCurrentUrl()) {
      driver.navigate().to(url);
    }
  }

  // Проверка соответствия лицензии и если не та, то переход на нужную
  public void checkLicense(By locatorBtnLicenseMenu, String nameLicense, By locatorBtnLicense) {
    WebElement btnLicenseMenu = driver.findElement(locatorBtnLicenseMenu);
    if(!nameLicense.equals(btnLicenseMenu.getText())) {
      btnLicenseMenu.click();
      timeOut(1);
      driver.findElement(locatorBtnLicense).click();
    }
  }

  // Проверка появления формы авторизации (Login)
  public void checkingAppearanceLoginForm() {
    WebElement LoginFormH1 = driver.findElement(locatorLoginFormH1);
    Assertions.assertTrue(LoginFormH1.isDisplayed(), "'Login' form not showing");
    driver.findElement(locatorLoginFormBtnCancel).click();
  }


  // Проверка появления формы регистрации (Sign up)
  public void checkingAppearanceSingUpForm() {
    WebElement LoginFormH1 = driver.findElement(locatorSignUpFormH1);
    Assertions.assertTrue(LoginFormH1.isDisplayed(), "'Sing up' form not showing");
    driver.findElement(locatorSignUpFormBtnCancel).click();
  }

  public void checkingVisibilityOfBtnAndClickingIt(By locatorBtn) {
    WebElement btn = driver.findElement(locatorBtn);
//     Checking visibility of the cookie notice
//    if (driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).isDisplayed()) {
//      timeOut(1);
//      System.out.println("У элемента с локатором" + "\n" + locatorBtn + "\n" + "обраружено окно с COOKIES");
//      driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
//      timeOut(1);
//    }
    Assertions.assertTrue(btn.isDisplayed(), "Кнопка не видна на странице");
    btn.click();
  }

  public void scrollToElement(By locatorElement, int x, int y) {
    WebElement element = driver.findElement(locatorElement);
    int coordinateX = element.getRect().x;
    int coordinateY = element.getRect().y;
    new Actions(driver)
            .scrollByAmount(coordinateX + x, coordinateY + y)
            .perform();
  }

  public void cursorMovementFromElementAndClick(By locatorElement) {
    WebElement element = driver.findElement(locatorElement);

    new Actions(driver).moveToElement(element, 0,10).click();
  }

  public String getUrlOfLink(By locator) {
    return driver.findElement(locator).getAttribute("href");
  }

  public void takeScreenshot(String fileAddress) throws IOException {
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile, new File(fileAddress));
  }
}

