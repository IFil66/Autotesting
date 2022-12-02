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
  static String filesAddressOfReportForSectionForex = "data/1_reportAboutBugCardsForSectionForex.txt";
  static String filesAddressOfReportForSectionIndices = "data/2_reportAboutBugCardsForSectionIndices.txt";
  static String filesAddressOfReportForSectionCommodities = "data/3_reportAboutBugCardsForSectionCommodities.txt";
  static String filesAddressOfReportForSectionCryptocurrencies = "data/4_reportAboutBugCardsForSectionCryptocurrencies.txt";
  static String filesAddressOfReportForSectionShares = "data/5_reportAboutBugCardsForSectionShares.txt";
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

  public int getLastPageNumber(String url) {
    // create variable of last page number
    int lastPageNumber;

    // Go to checking page
    driver.navigate().to(url);

    // Get last page number
    logText = logText + "\n" + url + "\t" + "Checking visibility of the last page number is - " + checkingVisibilityElement(locatorOfLastPageNumber);
    String lastPageNumberString = driver.findElement(locatorOfLastPageNumber).getText();
    lastPageNumber = Integer.parseInt (lastPageNumberString);

    return lastPageNumber;
  }


  // Search method for bug cards on a page
  public void searchCardOnPage(String url, String addressOfReportFile)
  {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfReportFile);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    int number = getLastPageNumber(url);

    // Cycle through pages from first to last page
    for (int n = 1; n <= number; n++)
    {
      // Condition for moving to the next page to search
      if (n == 1)
      {
        driver.navigate().to(url);
      } else {
        driver.navigate().to(url + "/" + n);
      }

      // Calculating the number of rows on the checked page
      var totalElementsOnPage = driver.findElements(locatorAllStringsOnTableOfTradeInstruments).size();

      // Cycle through rows with trading instruments from first to last
      for (int stringNumber = 1; stringNumber<= totalElementsOnPage; stringNumber++)
      {
        // Get trading instrument name
        String nameOfElement = driver.findElement(By.cssSelector(locatorsFirstPartForElementsName + stringNumber
                + locatorsSecondPartForElementsName)).getText();

        // Get a value of the Sell parameter
        String valueOfElementSell = driver.findElement(By.cssSelector(locatorsFirstPartForElementSell + stringNumber
                + locatorsSecondPartForElementSell)).getText();

        // Get bug card URL
        String linkOfBugCard = driver.findElement(By.cssSelector(locatorsFirstPartForElementLink + stringNumber
                + locatorsSecondPartForElementLink)).getAttribute("href");

        // Condition for detecting trading instrument with missing Sell parameter. Will add this trading instrument into report file.
        if (valueOfElementSell.length() == 1) {
          writer.write("\n" + "On page: " + "\t" + linkOfBugCard + "\t" + "Trading instrument: " + nameOfElement
                  + "\t" + " no data on the value of the trading instrument");
          totalBugCards++;
        }
      }
    }
    if (totalBugCards == 0){
      writer.write("Congratulations! Bug cards not found.");
    } else {
      // Add into report file row "Total cards"
      writer.write("\n" + "\n" + "Total cards:  " + "\t" + totalBugCards);
    }
    writer.flush();
    writer.close();
  }
}