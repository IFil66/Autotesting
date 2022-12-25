package com.capital_tests.testsWithAllure.mainPage_tests.registrationButtons_tests;
import com.capital_tests.Locators;
import com.capital_tests.testsWithAllure.MethodsWithAllure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import java.io.IOException;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests_RegistrationButtons extends MethodsWithAllure {


  // Tests registration elements in Header
  @Test
  @Description("Checking Login button on page header")
  public void mainPageHeader_ClickOnBtnLogIn_LoginFormWasAppear() throws IOException {
    System.out.println("FirstParallelUnitTest 1() start => " + Thread.currentThread().getName());

  // arrange
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.headerBtnLogIn,0,0);
    waitForElement(Locators.headerBtnLogIn);
    clickOnElement(Locators.headerBtnLogIn);

    // assert
    checkShowingUpLoginForm();
    System.out.println("FirstParallelUnitTest 1() end => " + Thread.currentThread().getName());


  takeScreenshot(Locators.addressOfScreenshotFile_HeaderBtnLogIn);
  }


  @Test
  @Description("Checking Sign up button on page header")
  public void  mainPageHeader_ClickOnBtnTradeNow_SignUpFormWasAppear() throws IOException {
    // arrange
    System.out.println("FirstParallelUnitTest 2() start => " + Thread.currentThread().getName());
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.headerBtnTradeNow,0,0);
    waitForElement(Locators.headerBtnTradeNow);
    clickOnElement(Locators.headerBtnTradeNow);

    // assert
    checkShowingUpSignUpForm();
    System.out.println("FirstParallelUnitTest 2() end => " + Thread.currentThread().getName());

    takeScreenshot(Locators.addressOfScreenshotFile_HeaderBtnTradeNow);
  }


  //Tests registration elements in section Main banner
  @Test
  @Description("Checking Sign up button on Main banner")
  public void mainPageMainBanner_clickOnTabOneAndClickOnLeftBtn_SignUpFormWasAppear() throws IOException {
    // arrange
    System.out.println("FirstParallelUnitTest 3() start => " + Thread.currentThread().getName());
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.locatorMainBannerBtnOne,0,-400);
    waitForElement(Locators.locatorMainBannerBtnOne);
    clickOnElement(Locators.locatorMainBannerBtnOne);
    waitForElement(Locators.locatorMainBannerSlideOneBtnLeft);
    clickOnElement(Locators.locatorMainBannerSlideOneBtnLeft);

    // assert
    checkShowingUpSignUpForm();
    System.out.println("FirstParallelUnitTest 3() end => " + Thread.currentThread().getName());

    takeScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideOneBtnLeft);
  }


  @Test
  @Description("Checking Sign up button on Main banner")
  public void mainPageMainBanner_clickOnTabThreeAndClickOnLeftBtn_SignUpFormWasAppear() throws IOException {
    // arrange
    System.out.println("FirstParallelUnitTest 4() start => " + Thread.currentThread().getName());
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.locatorMainBannerBtnThree,0,-400);
    waitForElement(Locators.locatorMainBannerBtnThree);
    clickOnElement(Locators.locatorMainBannerBtnThree);
    waitForElement(Locators.locatorMainBannerSlideThreeBtnLeft);
    clickOnElement(Locators.locatorMainBannerSlideThreeBtnLeft);

    // assert
    checkShowingUpSignUpForm();
    System.out.println("FirstParallelUnitTest 4() end => " + Thread.currentThread().getName());

    takeScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideThreeBtnLeft);
  }


  @Test
  @Description("Checking Sign up button on Main banner")
  public void mainPageMainBanner_clickOnTabThreeAndClickOnRightBtn_SignUpFormWasAppear() throws IOException {
    // arrange
    System.out.println("FirstParallelUnitTest 5() start => " + Thread.currentThread().getName());
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.locatorMainBannerBtnThree,0,-400);
    waitForElement(Locators.locatorMainBannerBtnThree);
    clickOnElement(Locators.locatorMainBannerBtnThree);
    waitForElement(Locators.locatorMainBannerSlideThreeBtnRight);
    clickOnElement(Locators.locatorMainBannerSlideThreeBtnRight);

    // assert
    checkShowingUpSignUpForm();
    System.out.println("FirstParallelUnitTest 5() end => " + Thread.currentThread().getName());

    takeScreenshot(Locators.addressOfScreenshotFile_MainBannerSlideThreeBtnRight);
  }


  @Test
  @Description("Checking user plus button on module 'Still looking for a broker you can trust?'")
  public void mainPageModuleStillLookingForBrokerYouCanTrust_clickOnBtnUserPlus_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);
    System.out.println("FirstParallelUnitTest 6() start => " + Thread.currentThread().getName());
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus, 0, -400);
    waitForElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    clickOnElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);

    // assert
    checkShowingUpSignUpForm();
    System.out.println("FirstParallelUnitTest 6() end => " + Thread.currentThread().getName());

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleStillLookingForBrokerYouCanTrustBtnUserPlus);
  }


  @Test
  @Description("Checking buttons 'Trade Now' (4 items) on module widget promo market")
  public void mainPageModuleWidgetPromoMarket_clickOnBtnTradeNow_SignUpFormWasAppear() throws IOException {
    // arrange
    System.out.println("FirstParallelUnitTest 7() start => " + Thread.currentThread().getName());
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // act and assert
    checkingModuleWidgetPromoMarketForMainPage();
    System.out.println("FirstParallelUnitTest 7() end => " + Thread.currentThread().getName());

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleWidgetPromoMarket);
  }


  //Tests registration elements in section "Explore our platform"
  @Test
  @Description("Checking button 'Trade Now' on module 'Explore our platform'")
  public void mainPageModuleExploreOurPlatform_clickOnBtnTryNow_SignUpFormWasAppear() throws IOException {
    // arrange
    System.out.println("FirstParallelUnitTest 8() start => " + Thread.currentThread().getName());
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.locatorExploreOurPlatformBtnTryNow, 0, -400);
    waitForElement(Locators.locatorExploreOurPlatformBtnTryNow);
    clickOnElement(Locators.locatorExploreOurPlatformBtnTryNow);

    // assert
    checkShowingUpSignUpForm();
    System.out.println("FirstParallelUnitTest 8() end => " + Thread.currentThread().getName());

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleExploreOurPlatform);
  }


  //Tests registration elements in module "New to trading?"
  @Test
  @Description("Checking button 'Practice for free' on module 'New to trading?'")
  public void mainPageModuleNewToTrading_clickOnBtnPractiseForFree_SignUpFormWasAppear() throws IOException {
    // arrange
    System.out.println("FirstParallelUnitTest 9() start => " + Thread.currentThread().getName());
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.locatorNewToTradingBtnPractiseForFree, 0, -400);
    waitForElement(Locators.locatorNewToTradingBtnPractiseForFree);
    clickOnElement(Locators.locatorNewToTradingBtnPractiseForFree);

    // assert
    checkShowingUpSignUpForm();
    System.out.println("FirstParallelUnitTest 9() end => " + Thread.currentThread().getName());

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleNewToTrading);
  }


  //Tests registration elements in section "Trading calculator"
  @Test
  @Description("Checking button 'Start trading' on module 'Trading calculator'")
  public void mainPageModuleTradingCalculator_clickOnBtnStartTrading_SignUpFormWasAppear() throws IOException {
    // arrange
    System.out.println("FirstParallelUnitTest 10() start => " + Thread.currentThread().getName());
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.moduleTradingCalculatorBtnStartTrading, 0, -400);
    waitForElement(Locators.moduleTradingCalculatorBtnStartTrading);
    clickOnElement(Locators.moduleTradingCalculatorBtnStartTrading);

    // assert
    checkShowingUpSignUpForm();
    System.out.println("FirstParallelUnitTest 10() end => " + Thread.currentThread().getName());

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradingCalculator);
  }


  //Tests registration elements in section "Trader's Dashboard"
  @Test
  @Description("Checking buttons 'Trade' (5 items) on module 'Trader's Dashboard'")
  public void mainPageModuleTradersDashboard_clickOnBtnTrade_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.locatorTradersDashboard, 0, 100);

    // assert
    checkingAllBtnOnTradersDashboard();

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleTradersDashboard);
 }


  //Tests registration elements in section "Why choose Capital.com? Our numbers speak for themselves"
  @Test
  @Description("Checking button 'Try Now' on module 'Why choose Capital.com? Our numbers speak for themselves.'")
  public void mainPageModuleWhyChooseCapitalCom_clickOnBtnTryNow_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(Locators.url);
//    checkLicense(licenseName, licenseLocator);

    // assert
    scrollToElement(Locators.moduleWhyChooseCapitalComBtnTryNow, 0, -400);
    waitForElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
    clickOnElement(Locators.moduleWhyChooseCapitalComBtnTryNow);

    checkShowingUpSignUpForm();

    takeScreenshot(Locators.addressOfScreenshotFile_ModuleWhyChooseCapitalCom);
  }
}