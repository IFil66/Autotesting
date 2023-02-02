package com.capital_tests.testsWithAllure.mainPage_tests.registrationButtons_tests;

import com.capital_tests.Licenses;
import com.capital_tests.Locators;
import com.capital_tests.testsWithAllure.MethodsWithAllure;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import java.io.IOException;

@DisplayName("Tests checking registration and authorization buttons on Main page in English version")
public class Tests_RegistrationButtons extends MethodsWithAllure {

  String language = "";

  // Tests registration elements in Header
  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Login button on page header")
  public void mainPageHeader_ClickOnBtnLogIn_LoginFormWasAppear(Licenses license) throws  IOException {

  // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    // act
    waitForElement(Locators.headerBtnLogIn);
    clickOnElement(Locators.headerBtnLogIn);

    // assert
    checkShowingUpLoginForm();

    getScreenshot(Locators.addressOfScreenshotFile_HeaderBtnLogIn);
  }


  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Sign up button on page header")
  public void  mainPageHeader_ClickOnBtnTradeNow_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    // act
    waitForElement(Locators.headerBtnTradeNow);
    clickOnElement(Locators.headerBtnTradeNow);

    // assert
    checkShowingUpSignUpForm();

    getScreenshot(Locators.addressOfScreenshotFile_HeaderBtnTradeNow);
  }


  //Tests registration elements in section Main banner
  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Sign up button on Main banner in first tab (left button)")
  public void mainPageMainBanner_clickOnTabOneAndClickOnLeftBtn_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    // act
    waitForElement(Locators.locatorMainBannerBtnOne);
    clickOnElement(Locators.locatorMainBannerBtnOne);
    waitForElement(Locators.locatorMainBannerSlideOneBtnLeft);
    clickOnElement(Locators.locatorMainBannerSlideOneBtnLeft);

    // assert
    checkShowingUpSignUpForm();

    getScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideOneBtnLeft);
  }


  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Sign up button on Main banner in first tab (right button)")
  public void mainPageMainBanner_clickOnTabOneAndClickOnRightBtn_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    // act
    waitForElement(Locators.locatorMainBannerBtnOne);
    clickOnElement(Locators.locatorMainBannerBtnOne);
    waitForElement(Locators.locatorMainBannerSlideOneBtnRight);
    clickOnElement(Locators.locatorMainBannerSlideOneBtnRight);

    // assert
    checkShowingUpSignUpForm();

    getScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideOneBtnLeft);
  }


  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Sign up button on Main banner in third tab (left button)")
  public void mainPageMainBanner_clickOnTabThreeAndClickOnLeftBtn_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    // act
    waitForElement(Locators.locatorMainBannerBtnThree);
    clickOnElement(Locators.locatorMainBannerBtnThree);
    waitForElement(Locators.locatorMainBannerSlideThreeBtnLeft);
    clickOnElement(Locators.locatorMainBannerSlideThreeBtnLeft);

    // assert
    checkShowingUpSignUpForm();

    getScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideThreeBtnLeft);
  }


  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Sign up button on Main banner in third tab (right button)")
  public void mainPageMainBanner_clickOnTabThreeAndClickOnRightBtn_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    // act
    waitForElement(Locators.locatorMainBannerBtnThree);
    clickOnElement(Locators.locatorMainBannerBtnThree);
    waitForElement(Locators.locatorMainBannerSlideThreeBtnRight);
    clickOnElement(Locators.locatorMainBannerSlideThreeBtnRight);

    // assert
    checkShowingUpSignUpForm();

    getScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideThreeBtnRight);
  }


  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking user plus button on module 'Still looking for a broker you can trust?'")
  public void mainPageModuleStillLookingForBrokerYouCanTrust_clickOnBtnUserPlus_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    // act
    scrollToElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    waitForElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    clickOnElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);

    // assert
    checkShowingUpSignUpForm();

    getScreenshot(Locators.addressOfScreenshotFile_ModuleStillLookingForBrokerYouCanTrustBtnUserPlus);
  }


  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking buttons 'Trade Now' (4 items) on module widget promo market")
  public void mainPageModuleWidgetPromoMarket_clickOnBtnTradeNow_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    // act and assert
    checkingModuleWidgetPromoMarketForMainPage();

    getScreenshot(Locators.addressOfScreenshotFile_ModuleWidgetPromoMarket);
  }


  //Tests registration elements in section "Explore our platform"
  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking button 'Trade Now' on module 'Explore our platform'")
  public void mainPageModuleExploreOurPlatform_clickOnBtnTryNow_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    // act
    scrollToElement(Locators.locatorExploreOurPlatformBtnTryNow);
    waitForElement(Locators.locatorExploreOurPlatformBtnTryNow);
    clickOnElement(Locators.locatorExploreOurPlatformBtnTryNow);

    // assert
    checkShowingUpSignUpForm();

    getScreenshot(Locators.addressOfScreenshotFile_ModuleExploreOurPlatform);
  }


  //Tests registration elements in module "New to trading?"
  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking button 'Practice for free' on module 'New to trading?'")
  public void mainPageModuleNewToTrading_clickOnBtnPractiseForFree_SignUpFormWasAppear(Licenses license) throws IOException{
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));
//    cookiesAcceptConsent();

    // act
    scrollToElement(Locators.locatorNewToTradingBtnPractiseForFree);
    waitForElement(Locators.locatorNewToTradingBtnPractiseForFree);
    clickOnElement(Locators.locatorNewToTradingBtnPractiseForFree);

    // assert
    checkShowingUpSignUpForm();

    getScreenshot(Locators.addressOfScreenshotFile_ModuleNewToTrading);
  }


  //Tests registration elements in section "Trading calculator"
  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking button 'Start trading' on module 'Trading calculator'")
  public void mainPageModuleTradingCalculator_clickOnBtnStartTrading_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));
//    cookiesAcceptConsent();

    // act
    scrollToElement(Locators.moduleTradingCalculatorBtnStartTrading);
    waitForElement(Locators.moduleTradingCalculatorBtnStartTrading);
    clickOnElement(Locators.moduleTradingCalculatorBtnStartTrading);

    // assert
    checkShowingUpSignUpForm();

    getScreenshot(Locators.addressOfScreenshotFile_ModuleTradingCalculator);
  }


  //Tests registration elements in section "Trader's Dashboard"
  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking buttons 'Trade' (5 items) on module 'Trader's Dashboard'")
  public void mainPageModuleTradersDashboard_clickOnBtnTrade_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));
//    cookiesAcceptConsent();

    // act
    scrollToElement(Locators.locatorTradersDashboard);

    // and assert
    checkingAllBtnOnTradersDashboard();

    getScreenshot(Locators.addressOfScreenshotFile_ModuleTradersDashboard);
 }


  //Tests registration elements in section "Why choose Capital.com? Our numbers speak for themselves"
  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking button 'Try Now' on module 'Why choose Capital.com? Our numbers speak for themselves.'")
  public void mainPageModuleWhyChooseCapitalCom_clickOnBtnTryNow_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    // act


    scrollToElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
    waitForElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
    clickOnElement(Locators.moduleWhyChooseCapitalComBtnTryNow);

    // assert
    checkShowingUpSignUpForm();

    getScreenshot(Locators.addressOfScreenshotFile_ModuleWhyChooseCapitalCom);
  }

  // Trading instruments widget module --- START

  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Most Traded")
  public void mainPageTradingInstrumentWidget_MostTraded_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear(Licenses license) throws IOException{
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    String codename = "mtr";
    By locatorOptionA = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_A1
            + codename + Locators.locatorTradingInstrumentWidgetTab_A2);
    if(checkingVisibleElementForOptionsAorB(locatorOptionA)) {

      //act
      scrollToElement(locatorOptionA);
      waitForElement(locatorOptionA);
      clickOnElement(locatorOptionA);

      //assert
      checkingAllItemOnTabOption_A(codename);
    }
    else {
      // act
      codename = "Most";
      By locatorOptionB = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_B1
              + codename + Locators.locatorTradingInstrumentWidgetTab_B2);
      scrollToElement(locatorOptionB);
      waitForElement(locatorOptionB);
      clickOnElement(locatorOptionB);

      // assert
      checkingAllItemOnTabOption_B(codename);
    }
    getScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_MostTraded);
  }

  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Commodities")
  public void mainPageTradingInstrumentWidget_Commodities_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    String codename = "com";
    By locatorOptionA = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_A1
            + codename + Locators.locatorTradingInstrumentWidgetTab_A2);
    if(checkingVisibleElementForOptionsAorB(locatorOptionA)) {

      //act
      scrollToElement(locatorOptionA);
      waitForElement(locatorOptionA);
      clickOnElement(locatorOptionA);

      //assert
      checkingAllItemOnTabOption_A(codename);
    }
    else {
      // act
      codename = "Commodities";
      By locatorOptionB = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_B1
              + codename + Locators.locatorTradingInstrumentWidgetTab_B2);
      scrollToElement(locatorOptionB);
      waitForElement(locatorOptionB);
      clickOnElement(locatorOptionB);

      // assert
      checkingAllItemOnTabOption_B(codename);

    }
    getScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_Commodities);
  }

  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Indices")
  public void mainPageTradingInstrumentWidget_Indices_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    String codename = "ind";
    By locatorOptionA = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_A1
            + codename + Locators.locatorTradingInstrumentWidgetTab_A2);
    if(checkingVisibleElementForOptionsAorB(locatorOptionA)) {

      //act
      waitForElement(locatorOptionA);
      clickOnElement(locatorOptionA);

      //assert
      checkingAllItemOnTabOption_A(codename);
    }
    else {
      // act
      codename = "Indices";
      By locatorOptionB = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_B1
              + codename + Locators.locatorTradingInstrumentWidgetTab_B2);
      waitForElement(locatorOptionB);
      clickOnElement(locatorOptionB);

      // assert
      checkingAllItemOnTabOption_B(codename);
    }
    getScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_Indices);
  }

  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Crypto")
  public void mainPageTradingInstrumentWidget_Crypto_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    String codename = "cryp";
    By locatorOptionA = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_A1
            + codename + Locators.locatorTradingInstrumentWidgetTab_A2);
    if(checkingVisibleElementForOptionsAorB(locatorOptionA)) {

      //act
      scrollToElement(locatorOptionA);
      waitForElement(locatorOptionA);
      clickOnElement(locatorOptionA);

      //assert
      checkingAllItemOnTabOption_A(codename);
    }
    else {
      // act
      codename = "Crypto";
      By locatorOptionB = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_B1
              + codename + Locators.locatorTradingInstrumentWidgetTab_B2);
      scrollToElement(locatorOptionB);
      waitForElement(locatorOptionB);
      clickOnElement(locatorOptionB);

      // assert
      checkingAllItemOnTabOption_B(codename);
    }
    getScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_Crypto);
  }

  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Shares")
  public void mainPageTradingInstrumentWidget_Shares_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    String codename = "shar";
    By locatorOptionA = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_A1
            + codename + Locators.locatorTradingInstrumentWidgetTab_A2);
    if(checkingVisibleElementForOptionsAorB(locatorOptionA)) {

      //act
      scrollToElement(locatorOptionA);
      waitForElement(locatorOptionA);
      clickOnElement(locatorOptionA);

      //assert
      checkingAllItemOnTabOption_A(codename);
    }
    else {
      // act
      codename = "Shares";
      By locatorOptionB = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_B1
              + codename + Locators.locatorTradingInstrumentWidgetTab_B2);
      scrollToElement(locatorOptionB);
      waitForElement(locatorOptionB);
      clickOnElement(locatorOptionB);

      // assert
      checkingAllItemOnTabOption_B(codename);
    }
    getScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_Shares);
  }

  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Forex")
  public void mainPageTradingInstrumentWidget_Forex_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    String codename = "fx";
    By locatorOptionA = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_A1
            + codename + Locators.locatorTradingInstrumentWidgetTab_A2);
    if(checkingVisibleElementForOptionsAorB(locatorOptionA)) {

      //act
      scrollToElement(locatorOptionA);
      waitForElement(locatorOptionA);
      clickOnElement(locatorOptionA);

      //assert
      checkingAllItemOnTabOption_A(codename);
    }
    else {
      // act
      codename = "Forex";
      By locatorOptionB = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_B1
              + codename + Locators.locatorTradingInstrumentWidgetTab_B2);
      scrollToElement(locatorOptionB);
      waitForElement(locatorOptionB);
      clickOnElement(locatorOptionB);

      // assert
      checkingAllItemOnTabOption_B(codename);
    }
    getScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_Forex);
  }

  @ParameterizedTest
  @EnumSource(Licenses.class)
  @DisplayName("Checking Trade buttons on Trading instrument widget tab ETFs")
  public void mainPageTradingInstrumentWidget_ETFs_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear(Licenses license) throws IOException {
    // arrange
    goToPageAndCheckUrl(constructMainPagesUrl(language, license));

    String codename = "etf";
    By locatorOptionA = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_A1
            + codename + Locators.locatorTradingInstrumentWidgetTab_A2);
    if(checkingVisibleElementForOptionsAorB(locatorOptionA)) {

      //act
      scrollToElement(locatorOptionA);
      waitForElement(locatorOptionA);
      clickOnElement(locatorOptionA);

      //assert
      checkingAllItemOnTabOption_A(codename);
    }
    else {
      // act
      codename = "ETFs";
      By locatorOptionB = By.cssSelector(Locators.locatorTradingInstrumentWidgetTab_B1
              + codename + Locators.locatorTradingInstrumentWidgetTab_B2);
      scrollToElement(locatorOptionB);
      waitForElement(locatorOptionB);
      clickOnElement(locatorOptionB);

      // assert
      checkingAllItemOnTabOption_B(codename);
    }
    getScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_ETFs);
  }
  // Trading instruments widget module --- END
}