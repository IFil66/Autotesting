package com.capital_tests.testsWithAllure;

import com.capital_tests.Locators;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;

public class MethodsWithAllure {

  // Settings of WebDriver - START
  static WebDriver driver;
  @BeforeEach
  public void setUp() {
    FirefoxOptions options = new FirefoxOptions();
    driver = new FirefoxDriver(options);

    Dimension dimension = new Dimension(1600, 900);
    driver.manage().window().setSize(dimension);
    driver.manage().deleteAllCookies();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  // Settings WebDriver - END


  // Variables - START
  static By locatorOfCookies = By.cssSelector("#onetrust-accept-btn-handler");
  public static final int waitingTime = 10000;

  // Variables - END


  // Basic methods ---------- START
  // Method of flexible wait for element to appear (with exception)
  @Step("Waiting for an element when it's visibility")
  public void waitForElement(By locatorOfElement) {
    for (int time = 0;; time = time + 250) {
      timeOut(500);
      if (time >= waitingTime) {
        System.out.println("Method 'waitForElement': Element waiting is over. Element ("
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

  // Method of flexible wait for element to appear (with return and exception)
  public boolean waitForElementAndReturnOfVisibilityResult(By locatorOfElement) {
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        System.out.println("Method 'waitForElement': Element waiting is over. Element ("
                + locatorOfElement + ") don't visibility.");
        return false;
      }
      try {
        if (driver.findElement(locatorOfElement).isDisplayed()) {
          return true;
        }
      } catch (Exception e) {
        timeOut(250);
        continue;
      }
    }
  }

  @Step("Clicking on the Element")
  public void clickOnElement(By locatorOfElement) {
    for(int i = 1; i <= 5; i++) {
      try {
        driver.findElement(locatorOfElement).click();
        break;
      }
      catch (Exception e) {
        System.out.println("Waiting for an element to appear. Timeout is - " + (i * 250) + " milliSec");
        timeOut(250);
        continue;
      }
    }
  }

  @Step("Getting number of elements ")
  public int getNumberOfElements(By locatorOfElements) {
    if (driver.findElement(locatorOfElements).isDisplayed()) {
      return driver.findElements(locatorOfElements).size();
    }
    System.out.println("Elements not found");
    return 0;
  }



  // Method to scroll screen to element
  @Step("Scroll to the element")
  public void scrollToElement(By locatorElement, int coordinateX, int coordinateY) {
//    if(waitAndCheckingVisibilityOfElement(locatorElement)) {
      WebElement element = driver.findElement(locatorElement);
      int coordinateXOfElement = element.getRect().x;
      int coordinateYOfElement = element.getRect().y;
      new Actions(driver).scrollByAmount(0,-50000).perform();
      new Actions(driver).scrollByAmount(coordinateXOfElement + coordinateX,coordinateYOfElement + coordinateY).perform();
    }
//    else {
//      System.out.println("Method 'scrollToElement' failed because element is not visible");
//    }
//  }


  // Verification methods ---- START
  // Method to go to the page and check the current URL
  @Step("Go to the page")
  public void goToPageAndCheckUrl(String url) {
    driver.navigate().to(Locators.url);
    if (url != getCurrentUrl()) {
      driver.navigate().to(Locators.url);
    }
  }

  // Method of checking a licence
  @Step("License compliance check")
  public void checkLicense(String nameLicense, By locatorBtnLicense) {
    waitForElement(Locators.licenseBtnMenu);
    WebElement btnLicenseMenu = driver.findElement(Locators.licenseBtnMenu);
    if(!nameLicense.equals(btnLicenseMenu.getText())) {
      btnLicenseMenu.click();
      waitForElement(locatorBtnLicense);
      driver.findElement(locatorBtnLicense).click();
    }
  }

  // Method of checking if the Login form appears
  @Step("Login form was appears")
  public void checkShowingUpLoginForm() {
    String localReport = waitAndCheckingVisibilityOfElement(Locators.loginFormH1) &&
            waitAndCheckingVisibilityOfElement(Locators.loginFormFieldEmail) &&
            waitAndCheckingVisibilityOfElement(Locators.loginFormFieldPassword) &&
            waitAndCheckingVisibilityOfElement(Locators.loginFormBtnCancel) ?
            "Login form was appears - Pass" : "Login form was appears - Fail";
    System.out.println(localReport);
    clickOnElement(Locators.loginFormBtnCancel);
  }

  // Method of checking if the SignUp form appears
  @Step("Sign up form was appears")
  public void checkShowingUpSignUpForm() {
    String localReport = "";
    timeOut(500);
    if(waitAndCheckingVisibilityOfElement(Locators.signUpFormH1)) {
      localReport = waitAndCheckingVisibilityOfElement(Locators.signUpFormH1) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldEmail) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldPassword) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormBtnCancel) ?
              "Sign up form was appears - Pass" : "Sign up form was appears - Fail";
      clickOnElement(Locators.signUpFormBtnCancel);
    }
    else {
      localReport = waitAndCheckingVisibilityOfElement(Locators.signUpFormH1_onNewPage) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldEmail_onNewPage) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldPassword_onNewPage) ?
              "Sign up form was appears - Pass" : "Sign up form was appears - Fail";
      driver.navigate().back();
    }
    System.out.println(localReport);
  }
  // Verification methods ---- END



  // Utility methods ---------- START
  public static void timeOut(int milliSec){
    for(int i = 0; i < milliSec; i = i + 250 ){
      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
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
  static String getCurrentUrl() {
    return driver.getCurrentUrl();
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
  @Attachment(value = "Page screenshot", type = "png")
  public byte[] takeScreenshot(String fileAddress) throws IOException {
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile, new File(fileAddress));
    return Files.readAllBytes(Paths.get(fileAddress));
  }
  // Utility methods ---------- END


  // Module Widget "Trading instrument" - START
  @Step("Checking all buttons on a tab (option A)")
  public void checkingAllItemOnTabOption_A (String codeName) {
    By locatorOfBtns = By.cssSelector(Locators.locatorAllButtonsOnWidgetTradingInstrument_A_1
            + codeName + Locators.locatorAllButtonsOnWidgetTradingInstrument_A_2);
    int numberOfBtn = getNumberOfElements(locatorOfBtns);
    scrollToElement(locatorOfBtns, 0, -400);
    for (int number = 1; number <= numberOfBtn; number++) {
      By locatorOfCurrentBtn = By.cssSelector(Locators.locatorCssWidgetMarketBtnTrade_A_1 + codeName
              + Locators.locatorCssWidgetMarketBtnTrade_A_2 + number
              + Locators.locatorCssWidgetMarketBtnTrade_A_3);
      waitForElement(locatorOfCurrentBtn);
      clickOnElement(locatorOfCurrentBtn);
      checkShowingUpSignUpForm();
    }
  }

  @Step("Checking all buttons on a tab (option B)")
  public void checkingAllItemOnTabOption_B (String codeName) {
    By locatorOfBtns = By.cssSelector(Locators.locatorAllButtonsOnWidgetTradingInstrument_B_1
            + codeName + Locators.locatorAllButtonsOnWidgetTradingInstrument_B_2);
    int numberOfBtn = getNumberOfElements(locatorOfBtns);
    scrollToElement(locatorOfBtns,0,-400);
    for (int number = 1; number <= numberOfBtn; number++) {
      By locatorOfCurrentBtn = By.cssSelector(Locators.locatorTradingInstrumentWidgetBtnTrade_B_1
              + codeName + Locators.locatorTradingInstrumentWidgetBtnTrade_B_2
              + number + Locators.locatorTradingInstrumentWidgetBtnTrade_B_3);
      waitForElement(locatorOfCurrentBtn);
      clickOnElement(locatorOfCurrentBtn);
      checkShowingUpSignUpForm();
    }
  }

  // Checking condition to run test group A or B (for annotation JUnit)
  @Step("Checking the visibility of option A or B the Trading instruments widget module")
  static boolean checkingConditionToRunTestGroup_AorB() {
    return driver.findElement(Locators.locatorTradingInstrumentWidgetTabMostTraded1).isDisplayed();
  }

  // Module Widget "Trading instrument" - END

  // Module Widget “Promo Market” - START
  @Step("Checking all buttons on tabs (4 items)")
  public void checkingModuleWidgetPromoMarketForMainPage() {
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
                + " " + tabNamesHashSet.size() + " out of " + totalTabs);
        String tabName = driver.findElement(Locators.moduleWidgetPromoMarketTabName).getText();
        if(!tabNamesHashSet.contains(tabName)) {
          tabNamesHashSet.add(tabName);
          waitAndClickElement(Locators.moduleWidgetPromoMarketBtnTradeNow);
          // assert
          checkShowingUpSignUpForm();
        }
        // This cursor movement is necessary to remove the tooltip of module Widget “Promo Market”
        cursorMovementFromElementAndClick(Locators.moduleWidgetPromoMarketBtnTradeNow);
        timeOut(250);
        continue;
      }
    }
    System.out.println("Finished checking the block" + "\n" + "Result - " + localReport);
  }
  // Module Widget “Promo Market” - END

  @Step("Checking all buttons on tabs (5 items)")
  public void checkingAllBtnOnTradersDashboard() {
    int numberOfElements = driver.findElements(Locators.locatorTradersDashboard).size();
    for (int i = 1; i <= numberOfElements; i++) {
      By locator = By.cssSelector(Locators.locatorTradersDashboardBtnTrad1 + i
              + Locators.locatorTradersDashboardBtnTrad2);
      waitForElement(locator);
      System.out.println("Circle is running. Step - " + i + " out of " + numberOfElements);
      clickOnElement(locator);
      checkShowingUpSignUpForm();
    }
  }


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
}