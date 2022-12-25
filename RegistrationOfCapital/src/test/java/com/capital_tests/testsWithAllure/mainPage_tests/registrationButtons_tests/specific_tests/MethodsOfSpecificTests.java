package com.capital_tests.testsWithAllure.mainPage_tests.registrationButtons_tests.specific_tests;

import com.capital_tests.Locators;
import com.capital_tests.testsWithAllure.MethodsWithAllure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.*;
import java.util.ArrayList;

public class MethodsOfSpecificTests {
  MethodsWithAllure methodsWithAllure = new MethodsWithAllure();

  // Settings of WebDriver - START
  static WebDriver driver;
  @BeforeAll
  public static void setUp() {
    FirefoxOptions options = new FirefoxOptions();
    driver = new FirefoxDriver(options);

    Dimension dimension = new Dimension(1600, 1100);

    driver.manage().window().setSize(dimension);
    driver.manage().deleteAllCookies();
  }

  @AfterAll
  public static void tearDown() {
    driver.quit();
  }
  // Settings WebDriver - END


  // Variables - START
  static By locatorOfCookies = By.cssSelector("#onetrust-accept-btn-handler");
  private int waitingTime = MethodsWithAllure.waitingTime;
  // Variables - END



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

  // Methods for user annotations - START
  public boolean visibilityOfElement(By locatorOfElement) {
    goToPageAndCheckUrl(Locators.url);
    try {
      return driver.findElement(locatorOfElement).isDisplayed();
    }
    catch (Exception e) {
      return false;
    }
  }
  // Module Widget "Trading instrument" - END



  // Methods use MethodsWithAllure class methods
  public void goToPageAndCheckUrl(String url) {
    methodsWithAllure.goToPageAndCheckUrl(url);
  }

  public void checkLicense(String nameLicense, By locatorBtnLicense) {
    methodsWithAllure.checkLicense(nameLicense, locatorBtnLicense);
  }

  public void scrollToElement(By locatorElement, int coordinateX, int coordinateY) {
    methodsWithAllure.scrollToElement(locatorElement, coordinateX, coordinateY);
  }

  public void waitForElement(By locatorOfElement) {
    methodsWithAllure.waitForElement(locatorOfElement);
  }

  public void clickOnElement(By locatorOfElement) {
    methodsWithAllure.clickOnElement(locatorOfElement);
  }

  public int getNumberOfElements(By locatorOfElements) {
    return methodsWithAllure.getNumberOfElements(locatorOfElements);
  }

  public void checkShowingUpSignUpForm() {
    methodsWithAllure.checkShowingUpSignUpForm();
  }

  public static void timeOut(int milliSec){
    MethodsWithAllure.timeOut(milliSec);
  }

  public boolean waitAndCheckingVisibilityOfElement(By locatorOfElement) {
    return methodsWithAllure.waitAndCheckingVisibilityOfElement(locatorOfElement);
  }

  public byte[] takeScreenshot(String fileAddress) throws IOException {
    return methodsWithAllure.takeScreenshot(fileAddress);
  }

  // Method of write to file
  public void writingToFile(String addressOfFileWhereToWrite, String whatToWrite) {
    methodsWithAllure.writingToFile(addressOfFileWhereToWrite, whatToWrite);
  }

  // Reading the file having the list of URL and adding the URL to ArrayList to check the pages
  public ArrayList transferDataFromFileToList(ArrayList listUrl, String fileAddress) {
    return methodsWithAllure.transferDataFromFileToList(listUrl, fileAddress);
  }

  public void writeTextToFile(String fileAddress, String lineText) throws FileNotFoundException {
    methodsWithAllure.writeTextToFile(fileAddress,lineText);
  }
}