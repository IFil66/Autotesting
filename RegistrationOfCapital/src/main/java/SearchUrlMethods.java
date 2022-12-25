import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class SearchUrlMethods {
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
    driver.quit();
  }
  // Settings WebDriver - END



  static String fileAddressWithUrls = "data/urlList.txt";
  static String fileHasFinalResult = "data/buttonAmount.txt";
  static String fileWithFinalUrls = "data/finalUrls.txt";

  static HashSet<String> hashUniqueLinksFromWebElements = new HashSet<>();
  static ArrayList<String> listUrl = new ArrayList<>();
  static HashSet<String> hashUrlDone = new HashSet<>();
  private int i;


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

  // com.capital_tests.testsWithCustomReport.Methods to search all Trading instrument card pages and writing their URL to file - START
  public int getNumberOfTradingInstrumentsOnPage() {
    return driver.findElements(By.cssSelector("tr a[data-type = 'wdg_markets_deep']")).size();
  }

  public int getNumberOfLastPage(By locatorOfElement) {
    return Integer.parseInt(driver.findElement(locatorOfElement).getText());
  }

  // Utility methods ---------- START
  // Method of strict wait
  public static void timeOut(int milliSec){
    for(int i = 0; i < milliSec; i = i + 250 ){
      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  // Method of get URL the current page
  public static String getCurrentUrl() {
    return driver.getCurrentUrl();
  }



// Utility methods ---------- END
}
