package com.capital_tests.testsWithAllure.mainPage_tests.registrationButtons_tests.specific_tests;

import com.capital_tests.Locators;
import com.capital_tests.testsWithAllure.MethodsWithAllure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

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
//  public void goToPageAndCheckUrl(String url) {
//    methodsWithAllure.goToPageAndCheckUrl(url);
//  }

  @Step("Go to the page")
  public void goToPageAndCheckUrl(String url) {
    driver.navigate().to(url);
    if (url != getCurrentUrl()) {
      System.out.println("Перезаход на страницу");
      driver.navigate().to(url);
    }
  }


  static String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

  public void checkLicense(String nameLicense, By locatorBtnLicense) {
    methodsWithAllure.checkLicense(nameLicense, locatorBtnLicense);
  }

//  public void scrollToElement(By locatorElement, int coordinateX, int coordinateY) {
//    methodsWithAllure.scrollToElement(locatorElement, coordinateX, coordinateY);
//  }

  // Method to scroll screen to element
  @Step("Scroll to the element")
  public void scrollToElement(By locatorElement, int coordinateX, int coordinateY) {
    WebElement element = driver.findElement(locatorElement);
    int coordinateXOfElement = element.getRect().x;
    int coordinateYOfElement = element.getRect().y;
    new Actions(driver).scrollByAmount(0,-50000).perform();
    new Actions(driver).scrollByAmount(coordinateXOfElement + coordinateX,coordinateYOfElement + coordinateY).perform();
  }

//  public void waitForElement(By locatorOfElement) {
//    methodsWithAllure.waitForElement(locatorOfElement);
//  }

  // Method of flexible wait for element to appear (with exception)
  @Step("Waiting for an element when it's visibility")
  public void waitForElement(By locatorOfElement) {
    String localReport = "";
    for (int time = 0;; time = time + 250) {
      if (time >= waitingTime) {
        localReport = "\nElement isn't visible for allotted time! \n His locator is - " + locatorOfElement;
        break;
      }
      try {
        if (driver.findElement(locatorOfElement).isDisplayed()) {
          localReport = "\nElement is visible. \n His locator is - " + locatorOfElement;
          break;
        }
      } catch (Exception e) {
        timeOut(250);
        System.out.println("\n" + " Таймаут = " + time + "\n");
        continue;
      }
    }
    System.out.println("\n" + "Method 'waitForElement' is reporting: " + localReport + "\n");
    Assertions.assertEquals("\nElement is visible. \n His locator is - " + locatorOfElement, localReport, localReport);
  }

//  public void clickOnElement(By locatorOfElement) {
//    methodsWithAllure.clickOnElement(locatorOfElement);
//  }

  @Step("Clicking on the Element")
  public void clickOnElement(By locatorOfElement) {
    driver.findElement(locatorOfElement).click();

    String localReport = "";
//    for(int i = 1; i <= 5; i++) {
//      try {
//        driver.findElement(locatorOfElement).click();
//        localReport = localReport + "\nElement visible and clicked. \n His locator is - " + locatorOfElement;
//        break;
//      }
//      catch (Exception e) {
//        System.out.println("Waiting for an element to appear. Timeout is - " + (i * 250) + " milliSec");
//        timeOut(250);
//        localReport = "\nElement isn't visible. The program can't click it! \n His locator is - " + locatorOfElement;
//        continue;
//      }
//    }
    System.out.println("\n" + "Method 'clickOnElement' is reporting: " + localReport + "\n");
//    Assertions.assertEquals("\nElement visible and clicked. \n His locator is - " + locatorOfElement, localReport, localReport);
  }


//  public int getNumberOfElements(By locatorOfElements) {
//    return methodsWithAllure.getNumberOfElements(locatorOfElements);
//  }

  @Step("Getting number of elements ")
  public int getNumberOfElements(By locatorOfElements) {
    if (driver.findElement(locatorOfElements).isDisplayed()) {
      return driver.findElements(locatorOfElements).size();
    }
    System.out.println("Elements not found");
    return 0;
  }




//  public void checkShowingUpSignUpForm() {
//    methodsWithAllure.checkShowingUpSignUpForm();
//  }

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
              "Sign up form was appears ==> Pass" : "Sign up form was appears ==> Fail";

      System.out.println("\n" + "Method 'checkShowingUpSignUpForm' is reporting: " + localReport + "\n");
      Assertions.assertEquals("Sign up form was appears ==> Pass", localReport,"Sign up form was appears ==> Fail");

      clickOnElement(Locators.signUpFormBtnCancel);
    }
    else {
      localReport = waitAndCheckingVisibilityOfElement(Locators.signUpFormH1_onNewPage) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldEmail_onNewPage) &&
              waitAndCheckingVisibilityOfElement(Locators.signUpFormFieldPassword_onNewPage) ?
              "Sign up form was appears ==> Pass" : "Sign up form was appears ==> Fail";

      System.out.println("\n" + "Method 'checkShowingUpSignUpForm' is reporting: " + localReport + "\n");
      Assertions.assertEquals("Sign up form was appears ==> Pass", localReport,"Sign up form was appears ==> Fail");

      driver.navigate().back();
      timeOut(1000);
    }
  }





  public static void timeOut(int milliSec){
    MethodsWithAllure.timeOut(milliSec);
  }

//  public boolean waitAndCheckingVisibilityOfElement(By locatorOfElement) {
//    return methodsWithAllure.waitAndCheckingVisibilityOfElement(locatorOfElement);
//  }

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