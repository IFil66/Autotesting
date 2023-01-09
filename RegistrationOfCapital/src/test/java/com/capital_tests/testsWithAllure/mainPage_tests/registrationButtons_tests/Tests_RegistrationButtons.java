package com.capital_tests.testsWithAllure.mainPage_tests.registrationButtons_tests;

import com.capital_tests.Locators;
import com.capital_tests.testsWithAllure.MethodsWithAllure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import java.io.IOException;

@DisplayName("Tests checking registration and authorization buttons on Main page")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests_RegistrationButtons extends MethodsWithAllure {

  // Tests registration elements in Header
  @Test
  @DisplayName("Checking Login button on page header")
  public void mainPageHeader_ClickOnBtnLogIn_LoginFormWasAppear() throws  IOException {

  // arrange
    goToPageAndCheckUrl(Locators.url);

    // act
    waitForElement(Locators.headerBtnLogIn);
    clickOnElement(Locators.headerBtnLogIn);

    // assert
    checkShowingUpLoginForm();

    takeScreenshot(Locators.addressOfScreenshotFile_HeaderBtnTradeNow);
  }

  @Test
  @DisplayName("Checking Sign up button on page header")
  public void  mainPageHeader_ClickOnBtnTradeNow_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

    // act
    waitForElement(Locators.headerBtnTradeNow);
    clickOnElement(Locators.headerBtnTradeNow);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_HeaderBtnTradeNow);
  }


  //Tests registration elements in section Main banner
  @Test
  @DisplayName("Checking Sign up button on Main banner in first tab (left button)")
  public void mainPageMainBanner_clickOnTabOneAndClickOnLeftBtn_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

    // act
    waitForElement(Locators.locatorMainBannerBtnOne);
    clickOnElement(Locators.locatorMainBannerBtnOne);
    waitForElement(Locators.locatorMainBannerSlideOneBtnLeft);
    clickOnElement(Locators.locatorMainBannerSlideOneBtnLeft);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideOneBtnLeft);
  }

  @Test
  @DisplayName("Checking Sign up button on Main banner in first tab (right button)")
  public void mainPageMainBanner_clickOnTabOneAndClickOnRightBtn_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

    // act
    waitForElement(Locators.locatorMainBannerBtnOne);
    clickOnElement(Locators.locatorMainBannerBtnOne);
    waitForElement(Locators.locatorMainBannerSlideOneBtnRight);
    clickOnElement(Locators.locatorMainBannerSlideOneBtnRight);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideOneBtnLeft);
  }



  @Test
  @DisplayName("Checking Sign up button on Main banner in third tab (left button)")
  public void mainPageMainBanner_clickOnTabThreeAndClickOnLeftBtn_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

    // act
    waitForElement(Locators.locatorMainBannerBtnThree);
    clickOnElement(Locators.locatorMainBannerBtnThree);
    waitForElement(Locators.locatorMainBannerSlideThreeBtnLeft);
    clickOnElement(Locators.locatorMainBannerSlideThreeBtnLeft);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideThreeBtnLeft);
  }


  @Test
  @DisplayName("Checking Sign up button on Main banner in third tab (right button)")
  public void mainPageMainBanner_clickOnTabThreeAndClickOnRightBtn_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

    // act
    waitForElement(Locators.locatorMainBannerBtnThree);
    clickOnElement(Locators.locatorMainBannerBtnThree);
    waitForElement(Locators.locatorMainBannerSlideThreeBtnRight);
    clickOnElement(Locators.locatorMainBannerSlideThreeBtnRight);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideThreeBtnRight);
  }


  @Test
  @DisplayName("Checking user plus button on module 'Still looking for a broker you can trust?'")
  public void mainPageModuleStillLookingForBrokerYouCanTrust_clickOnBtnUserPlus_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

    // act
    scrollToElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    waitForElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    clickOnElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleStillLookingForBrokerYouCanTrustBtnUserPlus);
  }


  @Test
  @DisplayName("Checking buttons 'Trade Now' (4 items) on module widget promo market")
  public void mainPageModuleWidgetPromoMarket_clickOnBtnTradeNow_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

    // act and assert
    checkingModuleWidgetPromoMarketForMainPage();

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleWidgetPromoMarket);
  }


  //Tests registration elements in section "Explore our platform"
  @Test
  @DisplayName("Checking button 'Trade Now' on module 'Explore our platform'")
  public void mainPageModuleExploreOurPlatform_clickOnBtnTryNow_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

    // act
    scrollToElement(Locators.locatorExploreOurPlatformBtnTryNow);
    waitForElement(Locators.locatorExploreOurPlatformBtnTryNow);
    clickOnElement(Locators.locatorExploreOurPlatformBtnTryNow);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleExploreOurPlatform);
  }


  //Tests registration elements in module "New to trading?"
  @Test
  @DisplayName("Checking button 'Practice for free' on module 'New to trading?'")
  public void mainPageModuleNewToTrading_clickOnBtnPractiseForFree_SignUpFormWasAppear() throws IOException{
    // arrange
    goToPageAndCheckUrl(Locators.url);
//    cookiesAcceptConsent();

    // act
    scrollToElement(Locators.locatorNewToTradingBtnPractiseForFree);
    waitForElement(Locators.locatorNewToTradingBtnPractiseForFree);
    clickOnElement(Locators.locatorNewToTradingBtnPractiseForFree);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleNewToTrading);
  }


  //Tests registration elements in section "Trading calculator"
  @Test
  @DisplayName("Checking button 'Start trading' on module 'Trading calculator'")
  public void mainPageModuleTradingCalculator_clickOnBtnStartTrading_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);
//    cookiesAcceptConsent();

    // act
    scrollToElement(Locators.moduleTradingCalculatorBtnStartTrading);
    waitForElement(Locators.moduleTradingCalculatorBtnStartTrading);
    clickOnElement(Locators.moduleTradingCalculatorBtnStartTrading);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradingCalculator);
  }


  //Tests registration elements in section "Trader's Dashboard"
  @Test
  @DisplayName("Checking buttons 'Trade' (5 items) on module 'Trader's Dashboard'")
  public void mainPageModuleTradersDashboard_clickOnBtnTrade_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);
//    cookiesAcceptConsent();

    // act
    scrollToElement(Locators.locatorTradersDashboard);

    // and assert
    checkingAllBtnOnTradersDashboard();

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradersDashboard);
 }


  //Tests registration elements in section "Why choose Capital.com? Our numbers speak for themselves"
  @Test
  @DisplayName("Checking button 'Try Now' on module 'Why choose Capital.com? Our numbers speak for themselves.'")
  public void mainPageModuleWhyChooseCapitalCom_clickOnBtnTryNow_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

    // act


    scrollToElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
    waitForElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
    clickOnElement(Locators.moduleWhyChooseCapitalComBtnTryNow);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleWhyChooseCapitalCom);
  }

  // Trading instruments widget module --- START

  @Test
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Most Traded")
  public void mainPageTradingInstrumentWidget_MostTraded_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear() throws IOException{
    // arrange
    goToPageAndCheckUrl(Locators.url);

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
    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_MostTraded);
  }

  @Test
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Commodities")
  public void mainPageTradingInstrumentWidget_Commodities_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

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
    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_Commodities);
  }

  @Test
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Indices")
  public void mainPageTradingInstrumentWidget_Indices_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

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
    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_Indices);
  }

  @Test
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Crypto")
  public void mainPageTradingInstrumentWidget_Crypto_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

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
    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_Crypto);
  }

  @Test
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Shares")
  public void mainPageTradingInstrumentWidget_Shares_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

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
    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_Shares);
  }

  @Test
  @DisplayName("Checking Trade buttons on Trading instrument widget tab Forex")
  public void mainPageTradingInstrumentWidget_Forex_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

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
    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_Forex);
  }

  @Test
  @DisplayName("Checking Trade buttons on Trading instrument widget tab ETFs")
  public void mainPageTradingInstrumentWidget_ETFs_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);

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
    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradingInstrumentWidget_ETFs);
  }
  // Trading instruments widget module --- END
}