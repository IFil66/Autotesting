import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;

public class Methods {

  // Settings of WebDriver - START
  static WebDriver driver;

  @BeforeAll
  static void setUp() {
//    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//    driver = new ChromeDriver();

    FirefoxOptions options = new FirefoxOptions();
    driver = new FirefoxDriver(options);

    // Timeout settings
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(0));
//    driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(1));

    driver.manage().window().fullscreen();
    driver.manage().deleteAllCookies();
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


  // Variables - START

  static HashSet<String> hashUniqueLinksFromWebElements = new HashSet<>();
  static ArrayList<String> listUrl = new ArrayList<>();
  static HashSet<String> hashUrlDone = new HashSet<>();
  private int numberOfURL = 1;
  private int i = 0;
  int amount = 1;

  static String fileAddressWithUrls = "data/urlList.txt";
  static String fileHasFinalResult = "data/buttonAmount.txt";
  static String fileWithFinalUrls = "data/finalUrls.txt";

  static By locatorOfCookies = By.cssSelector("#onetrust-accept-btn-handler");
  // Variables - END

  // Call timeout
  int waitingTime = 10000;

  public void timeOut(int milliSec){
    for(int i = 0; i < milliSec; i = i + 250 ){
      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  // Get URL the current page
  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

  // Method to go to the page and check the current URL
  public void goToPageAndCheckUrl(String url) {
    driver.navigate().to(url);
    if (url != getCurrentUrl()) {
      driver.navigate().to(url);
    }
  }

  // Checking a licence
  public void checkLicense(String nameLicense, By locatorBtnLicense) {
    WebElement btnLicenseMenu = driver.findElement(Locators.licenseBtnMenu);
    if(!nameLicense.equals(btnLicenseMenu.getText())) {
      btnLicenseMenu.click();
      waitingOfElement(locatorBtnLicense);
      driver.findElement(locatorBtnLicense).click();
    }
  }

  // Checking if the Login form appears
  public void checkingAppearanceLoginForm() {
    WebElement LoginFormH1 = driver.findElement(Locators.loginFormH1);
    Assertions.assertTrue(LoginFormH1.isDisplayed(), "'Login' form not showing");
    driver.findElement(Locators.loginFormBtnCancel).click();
  }

  // Checking if the SignUp form appears
  public void checkingAppearanceSingUpForm() {
    WebElement LoginFormH1 = driver.findElement(Locators.signUpFormH1);
    Assertions.assertTrue(LoginFormH1.isDisplayed(), "'Sing up' form not showing");
    driver.findElement(Locators.signUpFormBtnCancel).click();
  }

  // Method to check the visibility of a button and click on it
  public void checkingVisibilityOfBtnAndClickingIt(By locatorBtn) {
    WebElement btn = driver.findElement(locatorBtn);
//     Checking visibility of the cookie notice
//    if (driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).isDisplayed()) {
//      timeOut(1000);
//      driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
//      timeOut(1000);
//    }
    Assertions.assertTrue(btn.isDisplayed(), "The button not showing");
    btn.click();
  }

  // Method to scroll screen to element
  public void scrollToElement(By locatorElement, int coordinateX, int coordinateY) {
    if(waitAndCheckingVisibilityOfElement(locatorElement)) {
      WebElement element = driver.findElement(locatorElement);
      int coordinateXOfElement = element.getRect().x;
      int coordinateYOfElement = element.getRect().y;
      new Actions(driver).scrollByAmount(0,-50000).perform();
      new Actions(driver).scrollByAmount(coordinateXOfElement + coordinateX,coordinateYOfElement + coordinateY).perform();
    }
    else {
      System.out.println("Method 'scrollToElement' failed because element is not visible");
    }
  }

  // Method to move the cursor relative to an element
  public void cursorMovementFromElementAndClick(By locatorElement) {
    if(waitAndCheckingVisibilityOfElement(locatorElement)) {
      WebElement element = driver.findElement(locatorElement);
      new Actions(driver).moveToElement(element, 0,10).click();
    }
    else {
      System.out.println("Method 'cursorMovementFromElementAndClick' failed because element is not visible");
    }
  }

  // Method to get the link URL
  public String getUrlOfLink(By locator) {
    return driver.findElement(locator).getAttribute("href");
  }

  // Method to take a screenshot
  public void takeScreenshot(String fileAddress) throws IOException {
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile, new File(fileAddress));
  }

  // Trading instrument cards Methods - START
  // Methods to search all Trading instrument card pages and writing their URL to file - START
  public void getUrlOfTradingInstrumentCardsAndWriteItToFile(String fileAddress, String url) {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(fileAddress);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    driver.navigate().to(url);
    if(driver.getCurrentUrl() != url) {
      driver.navigate().to(url);
    }
    int numberOfLastPage = getNumberOfLastPage(SearchUrl.locatorNumberOfLastPage);
    for(int i = 1; i <= numberOfLastPage; i++) {
      System.out.println("Go to page number " + i);
      if(i ==1) {
        int numberOfElements = getNumberOfTradingInstrumentsOnPage();
        for(int n = 1; n <= numberOfElements; n++) {
          System.out.println("Get trading instrument URL in row number " + n);
          String tradingInstrumentURL = driver.findElement(By.cssSelector(SearchUrl.locatorOfTableRow1
                  + n + SearchUrl.locatorOfTableRow2)).getAttribute("href");
          writer.write(tradingInstrumentURL + "\n");
        }
      }
      else {
        driver.navigate().to(url + "/" + i);
        int numberOfElements = getNumberOfTradingInstrumentsOnPage();
        for(int n = 1; n <= numberOfElements; n++) {
          System.out.println("Get trading instrument URL in row number " + n);
          String tradingInstrumentURL = driver.findElement(By.cssSelector(SearchUrl.locatorOfTableRow1
                  + n + SearchUrl.locatorOfTableRow2)).getAttribute("href");
          writer.write(tradingInstrumentURL + "\n");
        }
      }
    }
    writer.flush();
    writer.close();
  }

  public int getNumberOfTradingInstrumentsOnPage() {
    return driver.findElements(By.cssSelector("tr a[data-type = 'wdg_markets_deep']")).size();
  }

  public int getNumberOfLastPage(By locatorOfElement) {
    return Integer.parseInt(driver.findElement(locatorOfElement).getText());
  }


  // Methods to search all Trading instrument card pages and writing their URL to file - START

  // Main method
  public String checkingAllRegistrationBtnOnPage() {
    String localReport = getCurrentUrl() + "\t";
    System.out.println("Element - " + numberOfURL++ + " - " + localReport);
    return localReport
            + checkingTheBtnToGoToLoginFormAndCreateReport(Locators.headerBtnLogIn) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.headerBtnTradeNow) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(TradingInstrumentCards.locatorTradingInstrumentNamePanelBtnAddToFavourite) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(TradingInstrumentCards.locatorWidgetBtnBell) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(TradingInstrumentCards.locatorWidgetBtnViewDetailedChart) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(TradingInstrumentCards.locatorWidgetBtnSell) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(TradingInstrumentCards.locatorWidgetBtnBuy) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(TradingInstrumentCards.locatorWidgetBtnCreateAccount) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.moduleWhyChooseCapitalComBtnTryNow) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.moduleTradingCalculatorBtnStartTrading) + "\t"
            + checkingModuleWidgetPromoMarketForTradingInstrumentCard() + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus) + "\t" + "\n"
            ;
  }

  // Subordinate methods
  public String checkShowingUpLoginFormAndCreateReport() {
    String localReport = waitAndCheckingVisibilityOfElement(Locators.loginFormH1) &&
            waitAndCheckingVisibilityOfElement(Locators.loginFormFieldEmail) &&
            waitAndCheckingVisibilityOfElement(Locators.loginFormFieldPassword) &&
            waitAndCheckingVisibilityOfElement(Locators.loginFormBtnCancel) ?
            "Pass" : "Fail ('Login' form not showing up)";
    waitAndClickElement(Locators.loginFormBtnCancel);
    return localReport;
  }

  public String checkShowingUpSignUpFormAndCreateReport() {
    String localReport = waitAndCheckingVisibilityOfElement(Locators.signUpFormH1) &&
            waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldEmail) &&
            waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldPassword) &&
            waitAndCheckingVisibilityOfElement(Locators.signUpFormBtnCancel) ?
            "Pass" : "Fail ('Sign up' form not showing up)";
    waitAndClickElement(Locators.signUpFormBtnCancel);
    return localReport;
  }

  public String checkingTheBtnToGoToLoginFormAndCreateReport(By btnLocator) {
    String localReport = "";
    localReport = waitAndCheckingVisibilityOfElement(btnLocator) ? localReport : "Fail (Button isn't visible)";
    if(localReport == "") {
      System.out.println("Starts - " + driver.findElement(btnLocator).getText());
      System.out.println(driver.findElement(btnLocator).getText());
      scrollToElement(btnLocator,0,-500);
      waitAndClickElement(btnLocator);
      waitingOfElement(Locators.loginFormH1);
      localReport = checkShowingUpLoginFormAndCreateReport();
      System.out.println("Finished - " + driver.findElement(btnLocator).getText());
    }
    System.out.println(localReport);
    return localReport;
  }
  public String checkingTheBtnToGoToSignUpFormAndCreateReport(By btnLocator) {
    String localReport = "";
    localReport = waitAndCheckingVisibilityOfElement(btnLocator) ? localReport : "Fail (Button isn't visible)";
    if(localReport == "") {
      System.out.println("Starts - " + driver.findElement(btnLocator).getText());
      scrollToElement(btnLocator,0,-500);
      waitAndClickElement(btnLocator);
      waitingOfElement(Locators.signUpFormH1);
      localReport = checkShowingUpSignUpFormAndCreateReport();
      System.out.println("Finished - " + driver.findElement(btnLocator).getText());
    }
    System.out.println(localReport);
    return localReport;
  }

  // Module Widget “Promo Market” - START
  public String checkingModuleWidgetPromoMarketForTradingInstrumentCard() {
    String localReport = "";
    scrollToElement(Locators.moduleWidgetPromoMarketTabName, 0,-500);
    localReport = waitAndCheckingVisibilityOfElement(Locators.moduleWidgetPromoMarketTabName)
            ? localReport : "Fail (Button isn't visible)";
    if(localReport == "") {
      HashSet tabNamesHashSet = new HashSet<>();
      int totalTabs = driver.findElements(Locators.moduleWidgetPromoMarketTab).size();
      System.out.println("Starts - Total elements - " + totalTabs + "\n");
      while(tabNamesHashSet.size() < totalTabs) {
        System.out.println("Element - " + driver.findElement(Locators.moduleWidgetPromoMarketTabName).getText() + " " + tabNamesHashSet.size() + " èç " + totalTabs);
        String tabName = driver.findElement(Locators.moduleWidgetPromoMarketTabName).getText();
        if(!tabNamesHashSet.contains(tabName)) {
          tabNamesHashSet.add(tabName);
         waitAndClickElement(Locators.moduleWidgetPromoMarketBtnTradeNow);
          // assert
          localReport = checkShowingUpSignUpFormAndCreateReport();
        }
        // This cursor movement is necessary to remove the tooltip of module Widget “Promo Market”
        cursorMovementFromElementAndClick(Locators.moduleWidgetPromoMarketBtnTradeNow);
        timeOut(250);
        continue;
      }
    }
    System.out.println("Finished checking the block");
    return localReport;
  }

  // Methods with exceptions - START

  public void waitingOfElement(By locatorOfElement) {
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        System.out.println("Method 'waitingOfElement': Element waiting is over. Element (" + locatorOfElement + ") don't visibility.");
        break;
      }
      try {
        if (driver.findElement(locatorOfElement).isDisplayed()) {
          break;
        }
      } catch (Exception e) {
        timeOut(250);
        continue;
      }
    }
  }

  public boolean waitAndCheckingVisibilityOfElement(By locatorOfElement) {
    boolean isVisibility = false;
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        System.out.println("Method 'waitAndCheckingVisibilityOfElement': Element waiting is over. Element (" + locatorOfElement + ") don't visibility.");
        break;
      }
      try {
        if (driver.findElement(locatorOfElement).isDisplayed()) {
          isVisibility = true;
          break;
        }
      } catch (Exception e) {
        timeOut(250);
        continue;
      }
    }
    return isVisibility;
  }

  public void waitAndClickElement(By locatorOfElement) {
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        System.out.println("Method 'waitAndClickElement': Element waiting is over. Element (" + locatorOfElement + ") don't visibility.");
        break;
      }
      try {
        if (driver.findElement(locatorOfElement).isDisplayed()) {
          driver.findElement(locatorOfElement).click();
          break;
        }
      } catch (Exception e) {
        timeOut(250);
        continue;
      }
    }
  }
// Methods with exceptions - END
  // Trading instrument cards Methods - END



  // Module Widget “Promo Market” - START
  public void checkingModuleWidgetPromoMarket() {
    HashSet tabNamesHashSet = new HashSet<>();
    int totalTabs = driver.findElements(Locators.moduleWidgetPromoMarketTab).size();
    scrollToElement(Locators.moduleWidgetPromoMarketTab, 0, -300);
    while(tabNamesHashSet.size() < totalTabs) {
      String tabName = driver.findElement(Locators.moduleWidgetPromoMarketTabName).getText();
      if(!tabNamesHashSet.contains(tabName)) {
        tabNamesHashSet.add(tabName);
        checkingVisibilityOfBtnAndClickingIt(Locators.moduleWidgetPromoMarketBtnTradeNow);
        timeOut(2000);
        // assert
        checkingAppearanceSingUpForm();
      }
      cursorMovementFromElementAndClick(Locators.moduleWidgetPromoMarketBtnTradeNow);
      timeOut(1000);
      continue;
    }
  }
  // Module Widget “Promo Market” - END





  // -------------------------------
  // Search all pages of Capital.com

  // Page parsing
  // 1. WebElements parsing
  // 2. Get WebElement's link
  // 3. Add unique links to HashSet

  // Option 1 (one locator)
  public HashSet<String> parsingElementsAndCreateUniqueElementsInList(HashSet<String> whereToAdd, By elementLocator) {
    ArrayList<WebElement> internalList1 = new ArrayList<>(driver.findElements(elementLocator));
    ArrayList<String> internalList2 = new ArrayList<>();
    for (int l = 0; l < internalList1.size(); l++) {
      internalList2.add(internalList1.get(l).getAttribute("href"));
    }
    whereToAdd.addAll(internalList2);
    return whereToAdd;
  }
  // Option 2 (two locators)
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

  // Search url methods - START
  public ArrayList updateUrlList(ArrayList whereToAdd, HashSet whatToAdd) {
    whereToAdd.addAll(whereToAdd.size(), whatToAdd);
    return whereToAdd;
  }

  // Adding a single element to the list of URL
  public HashSet updateUrl(HashSet whereToAdd, String whatElementToAdd) {
    whereToAdd.add(whatElementToAdd);
    return whereToAdd;
  }

  // Get URL from the list of URL
  public String getElement(String elementVariable, ArrayList<String> whereToGet, int numberOfListElement) {
    elementVariable = whereToGet.get(numberOfListElement);
    return elementVariable;
  }

  //   Checking buttons
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

  // Reading the file having the list of URL and adding the URL to ArrayList to check the pages
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
}