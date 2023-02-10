package com.capital.testsWithCustomReport;

import com.capital.Locators;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class MethodsWithCustomReport {

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


  // Variables - START
  private int numberOfURL = 1;
  static By locatorOfCookies = By.cssSelector("#onetrust-accept-btn-handler");
  private int waitingTime = 10000;
  // Variables - END


  // Action methods ---------- START
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

  // Method of flexible wait for element to appear (with exception)
  @Step("Waiting for an element when it's visibility")
  public void waitingOfElement(By locatorOfElement) {
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        System.out.println("Method 'waitingOfElement': Element waiting is over. Element ("
                + locatorOfElement + ") don't visibility.");
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

  // Method of flexible wait for element to appear and checking it visibility (with return and exception)
  public boolean waitAndCheckingVisibilityOfElement(By locatorOfElement) {
    boolean isVisibility = false;
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        System.out.println("Method 'waitAndCheckingVisibilityOfElement': Element waiting is over. Element ("
                + locatorOfElement + ") don't visibility.");
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

  // Method of flexible wait for element to appear and click it (with exception)
  public void waitAndClickElement(By locatorOfElement) {
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        System.out.println("Method 'waitAndClickElement': Element waiting is over. Element ("
                + locatorOfElement + ") don't visibility.");
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

  // Method of get URL the current page
  static public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

  // Method to go to the page and check the current URL
  @Step("Go to the page")
  public void goToPageAndCheckUrl(String url) {
    driver.navigate().to(url);
    if (url != getCurrentUrl()) {
      driver.navigate().to(url);
    }
  }

  // Method to scroll screen to element
  @Step("Scroll to the element")
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
  // Action methods ---------- END



  // Verification methods ---- START
  // Method of checking a licence
  @Step("License compliance check")
  public void checkLicense(String nameLicense, By locatorBtnLicense) {
    WebElement btnLicenseMenu = driver.findElement(Locators.licenseBtnMenu);
    if(!nameLicense.equals(btnLicenseMenu.getText())) {
      btnLicenseMenu.click();
      waitingOfElement(locatorBtnLicense);
      driver.findElement(locatorBtnLicense).click();
    }
  }

  // Method of checking if the Login form appears
  public void checkingAppearanceLoginForm() {
    WebElement LoginFormH1 = driver.findElement(Locators.loginFormH1);
    Assertions.assertTrue(LoginFormH1.isDisplayed(), "'Login' form not showing");
    driver.findElement(Locators.loginFormBtnCancel).click();
  }

  //  Method of checking if the SignUp form appears
  public void checkingAppearanceSignUpForm() {
    WebElement LoginFormH1 = driver.findElement(Locators.signUpFormH1);
    Assertions.assertTrue(LoginFormH1.isDisplayed(), "'Sign up' form not showing");
    driver.findElement(Locators.signUpFormBtnCancel).click();
  }

  // Method to check the visibility of a button and click on it
  public void checkingVisibilityOfBtnAndClickingIt(By locatorBtn) {
    WebElement btn = driver.findElement(locatorBtn);
    Assertions.assertTrue(btn.isDisplayed(), "The button not showing");
    btn.click();
  }
  // Verification methods ---- END



  // Trading instrument cards com.capital_tests.testsWithCustomReport.Methods - START
  // Main method
  public String checkingAllRegistrationBtnOnPage() {
    String localReport = getCurrentUrl() + "\t";
    System.out.println("Element - " + numberOfURL++ + " - " + localReport);
    return localReport
            + checkingTheBtnToGoToLoginFormAndCreateReport(Locators.headerBtnLogIn) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.headerBtnTradeNow) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.tradingInstrumentNamePanelBtnAddToFavourite) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.widgetBtnBell) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.widgetBtnViewDetailedChart) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.widgetBtnSell) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.widgetBtnBuy) + "\t"
            + checkingTheBtnToGoToSignUpFormAndCreateReport(Locators.locatorWidgetBtnCreateAccount) + "\t"
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
        System.out.println("Element - " + driver.findElement(Locators.moduleWidgetPromoMarketTabName).getText()
                + " " + tabNamesHashSet.size() + " из " + totalTabs);
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
  // Trading instrument cards com.capital_tests.testsWithCustomReport.Methods - END


  // Special methods - START
  // Method of accepting the terms of use of cookies
  public void cookiesAcceptConsent() {
    for (int time = 0;; time = time + 250) {
      if (time >= 15000) {
        System.out.println("notification with cookies don't showed up");
        break;
      }
      try {
        if (driver.findElement(locatorOfCookies).isDisplayed()) {
          driver.findElement(locatorOfCookies).click();
          break;
        }
      } catch (Exception e) {
        timeOut(250);
        continue;
      }
    }
  }

  // Method of write to file
  public void writingToFile(String addressOfFileWhereToWrite, String whatToWrite) {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfFileWhereToWrite);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    writer.write(whatToWrite);
    writer.flush();
    writer.close();
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

  // Special methods - END


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
        checkingAppearanceSignUpForm();
      }
      cursorMovementFromElementAndClick(Locators.moduleWidgetPromoMarketBtnTradeNow);
      timeOut(1000);
      continue;
    }
  }
  // Module Widget “Promo Market” - END
}