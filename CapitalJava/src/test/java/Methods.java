import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;

public class Methods {
  // Settings WebDriver - START
  static WebDriver driver;

  @BeforeAll
  static void setUp() throws RuntimeException {
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
    driver.quit();
  }
  // Settings WebDriver - END

  String logText = "";
  static String filesAddressOfReportForSectionShares = "data/reportAboutBugCardsForSectionShares.txt";
  static String filesAddressOfReportForSectionIndices = "data/reportAboutBugCardsForSectionIndices.txt";
  static String filesAddressOfReportForSectionCommodities = "data/reportAboutBugCardsForSectionCommodities.txt";
  static String filesAddressOfReportForSectionCryptocurrencies = "data/reportAboutBugCardsForSectionCryptocurrencies.txt";
  static String filesAddressOfReportForSectionForex = "data/reportAboutBugCardsForSectionForex.txt";
  int totalBugCards = 0;

  // Variables of locators
  By locatorOfLastPageNumber = By.cssSelector("ul[class='pagination'] li:nth-last-child(2)");
  String locatorsFirstPartForElementsName = "tbody[data-mob-deep-link] tr:nth-child(";
  String locatorsSecondPartForElementsName = ") td p[class='stringEllipsed']";

  String locatorsFirstPartForElementSell = "tbody[data-mob-deep-link] tr:nth-child(";
  String locatorsSecondPartForElementSell = ") td[class^='sell'] a";

  String locatorsFirstPartForElementLink = "tbody[data-mob-deep-link] tr:nth-child(";
  String locatorsSecondPartForElementLink = ") a[data-type = 'wdg_markets_deep']";

  By locatorAllStringsOnTableOfTradeInstruments = By.cssSelector("tbody[data-mob-deep-link] tr");



  public boolean checkingVisibilityElement (By locator) {
    return equals(driver.findElement(locatorOfLastPageNumber).isDisplayed());
  }

  public int searchLastPageNumber(String url) {
    // create variable of last page number
    int lastPageNumber;

    // go to checking page
    driver.navigate().to(url);

    // Get last page number
    logText = logText + "\n" + url + "\t" + "Checking visibility of the last page number is - " + checkingVisibilityElement(locatorOfLastPageNumber);
    String lastPageNumberString = driver.findElement(locatorOfLastPageNumber).getText();
    lastPageNumber = Integer.parseInt (lastPageNumberString);

    return lastPageNumber;
  }


  // Метод выявления бракованных карточек на страницах
  public void searchCardOnPage(String url, String addressOfReportFile)
  {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfReportFile);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    int number = searchLastPageNumber(url);

    // Цикл перебора страниц с 1 до последней в выдаче
    for (int n = 1; n <= number; n++)
    {
      // Условие перехода на нужную страницу для поиска бракованных карточек товаров
      if (n == 1)
      {
        driver.navigate().to(url);
      } else {
        driver.navigate().to(url + "/" + n);
      }

      // Вычисление количества строк на исследуемой странице
      var totalElementsOnPage = driver.findElements(locatorAllStringsOnTableOfTradeInstruments).size();

      // Цикл перебора строк с товарами с 1 по последнюю
      for (int stringNumber = 1; stringNumber<= totalElementsOnPage; stringNumber++)
      {
        // Получение названия товара из ячейки в DOM-дереве
        String nameOfElement = driver.findElement(By.cssSelector(locatorsFirstPartForElementsName + stringNumber
                + locatorsSecondPartForElementsName)).getText();

        // Получение показателя Sell из ячейки в DOM-дереве
        String valueOfElementSell = driver.findElement(By.cssSelector(locatorsFirstPartForElementSell + stringNumber
                + locatorsSecondPartForElementSell)).getText();

        // Получение URL багованной карточки
        String linkOfBugCard = driver.findElement(By.cssSelector(locatorsFirstPartForElementLink + stringNumber
                + locatorsSecondPartForElementLink)).getAttribute("href");

        // Условие сравнения, выявляющее товары с отсутствующим показателем Sell. Добавляет такие товары в результирующую переменную.
        if (valueOfElementSell.length() == 1) {
          writer.write("\n" + "На странице: " + "\t" + linkOfBugCard + "\t" + "В карточке торгового инструмента: " + nameOfElement
                  + "\t" + " не подгружается информация о цене покупки");
          totalBugCards++;
        }
      }
    }
    if (totalBugCards == 0){
      writer.write("Замечательно! Бракованных карточек не обнаружено.");
    } else {
      // Включение в отчёт стороки Итого
      writer.write("\n" + "\n" + "Итого карточек:  " + totalBugCards + "\n" + "Как?! Опять писать багрепорты?");
    }
    writer.flush();
    writer.close();
  }
}