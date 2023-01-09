package com.capital_tests.testsWithAllure.mainPage_tests.registrationButtons_tests.specific_tests;
import com.capital_tests.Locators;
import com.capital_tests.userAnnotations.UserCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

public class Tests_TradingInstrumentsWidget extends MethodsOfSpecificTests {

  //Tests registration elements in section "Trading instruments widget"
  // Tests option A
  @ParameterizedTest(name = "Checking Trade buttons on Trading instrument widget tab Most Trade (option A)")
//  @UserCondition(enabledFor = "Option_A")
  @ValueSource(strings = {"mtr", "com", "ind", "ind", "cryp","shar", "fx", "etf"})
  public void mainPageTradingInstrumentWidget_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear_A(String codename) {
    // arrange
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    //act
    waitForElement(By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_A1
            + codename + Locators.locatorTradingInstrumentWidgetTab_A2));

    clickOnElement(By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_A1
            + codename + Locators.locatorTradingInstrumentWidgetTab_A2));

    //assert
    checkingAllItemOnTabOption_A(codename);

//    takeScreenshot(Locators.addressOfScreenshotFile_TradingInstrumentWidgetTabMostTraded1);
  }


  // Tests option B
  @ParameterizedTest(name = "Checking Trade buttons on Trading instrument widget tab Most Traded (option B)")
  @UserCondition(enabledFor = "Option_B")
  @ValueSource(strings = {"Most", "Commodities", "Indices", "Crypto", "Shares", "Forex", "ETFs"})
  public void mainPageTradingInstrumentWidget_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear_B(String codename) {
    // arrange
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);
    waitForElement(By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_B1
            + codename + Locators.locatorTradingInstrumentWidgetTab_B2));

    // act
    clickOnElement(By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_B1
            + codename + Locators.locatorTradingInstrumentWidgetTab_B2));

    // assert
    checkingAllItemOnTabOption_B(codename);

//    takeScreenshot(Locators.addressOfScreenshotFile_TradingInstrumentWidgetTabMostTraded2);
  }
}
