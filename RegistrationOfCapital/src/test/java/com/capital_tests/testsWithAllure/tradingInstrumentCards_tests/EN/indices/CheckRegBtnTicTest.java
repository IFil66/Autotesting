package com.capital_tests.testsWithAllure.tradingInstrumentCards_tests.EN.indices;

import com.capital_tests.Locators;
import com.capital_tests.testsWithAllure.MethodsWithAllure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CheckRegBtnTicTest extends MethodsWithAllure {

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Check 'Log In' button on page header")
  public void ticPageHeader_ClickOnBtnLogIn_LoginFormWasAppear(
          String language,  String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.headerBtnLogIn);
    waitForElement(Locators.headerBtnLogIn);
    clickOnElement(Locators.headerBtnLogIn);

    // assert
    checkShowingUpLoginForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Check 'Trade Now' button on page header")
  public void ticPageHeader_ClickOnBtnTradeNow_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.headerBtnTradeNow);
    waitForElement(Locators.headerBtnTradeNow);
    clickOnElement(Locators.headerBtnTradeNow);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Check 'Add to favourite' button on title block")
  public void ticPage_ClickOnBtnAddToFavourite_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.tradingInstrumentNamePanelBtnAddToFavourite);
    waitForElement(Locators.tradingInstrumentNamePanelBtnAddToFavourite);
    clickOnElement(Locators.tradingInstrumentNamePanelBtnAddToFavourite);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Check Bell on trading instrument widget")
  public void ticWidget_ClickOnBtnBell_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.widgetBtnBell);
    waitForElement(Locators.widgetBtnBell);
    clickOnElement(Locators.widgetBtnBell);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Check 'View detailed chart' button on trading instrument widget")
  public void ticWidget_ClickOnViewDetailedChart_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.widgetBtnViewDetailedChart);
    waitForElement(Locators.widgetBtnViewDetailedChart);
    clickOnElement(Locators.widgetBtnViewDetailedChart);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Check 'Sell' button on trading instrument widget")
  public void ticWidget_ClickOnBtnSell_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.widgetBtnSell);
    waitForElement(Locators.widgetBtnSell);
    clickOnElement(Locators.widgetBtnSell);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Check 'Buy' button on trading instrument widget")
  public void ticWidget_ClickOnBtnBuy_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.widgetBtnBuy);
    waitForElement(Locators.widgetBtnBuy);
    clickOnElement(Locators.widgetBtnBuy);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Check button on Long position overnight fee")
  public void ticLongPosition_ClickOnGoToPlatform_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.LONG_POSITION);
    waitForElement(Locators.LONG_POSITION);
    clickOnElement(Locators.LONG_POSITION);
    elementToBeClickable(Locators.LONG_POSITION_BTN);
    clickOnElement(Locators.LONG_POSITION_BTN);

    // assert
    checkShowingUpSignUpFormOnPlatform();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Check button on Short position overnight fee")
  public void ticShotPosition_ClickOnGoToPlatform_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.SHORT_POSITION);
    waitForElement(Locators.SHORT_POSITION);
    clickOnElement(Locators.SHORT_POSITION);
    elementToBeClickable(Locators.SHORT_POSITION_BTN);
    clickOnElement(Locators.SHORT_POSITION_BTN);

    // assert
    checkShowingUpSignUpFormOnPlatform();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Checking button 'Try Now' on module 'Why choose Capital.com? Our numbers speak for themselves.'")
  public void ticModuleWhyChooseCapitalCom_clickOnBtnTryNow_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
    waitForElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
    clickOnElement(Locators.moduleWhyChooseCapitalComBtnTryNow);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Checking button 'Start trading' on module 'Trading calculator'")
  public void ticModuleTradingCalculator_clickOnBtnStartTrading_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.moduleTradingCalculatorBtnStartTrading);
    waitForElement(Locators.moduleTradingCalculatorBtnStartTrading);
    clickOnElement(Locators.moduleTradingCalculatorBtnStartTrading);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Checking buttons 'Trade Now' (4 items) on module widget promo market")
  public void ticModuleWidgetPromoMarket_clickOnBtnTradeNow_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act and assert
    checkingModuleWidgetPromoMarketForMainPage();

    saveScreenshot();
  }

  @ParameterizedTest
  @CsvFileSource(files = "data/tradingInstrumentCards/csvFiles/commoditiesTicName.csv", numLinesToSkip = 1)
  @DisplayName("Checking user plus button on module 'Still looking for a broker you can trust?'")
  public void ticModuleStillLookingForBrokerYouCanTrust_clickOnBtnUserPlus_SignUpFormWasAppear(
          String language, String licence, String nameTradingInstrument) throws IOException {

    // arrange
    goToPageAndCheckUrl(constructTradingInstrumentCardsUrl(language, nameTradingInstrument, licence));

    // act
    scrollToElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    waitForElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    clickOnElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);

    // assert
    checkShowingUpSignUpForm();

    saveScreenshot();
  }

}