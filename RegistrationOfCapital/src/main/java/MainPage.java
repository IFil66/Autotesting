import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainPage extends NewMethods{

  // Checking Registration / Authorization form
  // URL
  final static String url = "https://capital.com/?license=FCA";

  // Header
  // here used locators of buttons "Log in" and "Trade now" from class "Locators"
  final String addressOfScreenshotFile_HeaderBtnLogIn = "data/screenshots/mainPage/checkingIn_PageHeader_BtnLogIn.png";
  final String addressOfScreenshotFile_HeaderBtnTradeNow =
          "data/screenshots/mainPage/checkingIn_PageHeader_BtnTradeNow.png";


  // Section "Main banner" - START
  // Slide number 1
  final private By locatorMainBannerBtnOne = By.cssSelector("button[type = 'button'][data-slick-index = '0']");
  final private By locatorMainBannerSlideOneBtnLeft =
          By.cssSelector("div[class*='slick-slide'][data-slick-index = '0'] a[href = '/trading/signup']");
  // Transfer to Start Trading page (capital.com/trading/signup?go=demo) - UK Limited doesn't have this button
  final private By locatorMainBannerSlideOneBtnTransferToStartTrading =
          By.cssSelector("div[class*='slick-slide'][data-slick-index = '0'] a[href = '/trading/signup?go=demo']");

  final String addressOfScreenshotFile_MainBannerSlideOneBtnLeft =
          "data/screenshots/mainPage/checkingInSection_MainBannerTabOne_BtnOpenAccount.png";

  // Slide number 2
  final private By locatorMainBannerBtnTwo = By.cssSelector("button[type = 'button'][data-slick-index = '1']");

  // Slide number 3
  final private By locatorMainBannerBtnThree = By.cssSelector("button[type = 'button'][data-slick-index = '2']");
  final private By locatorMainBannerSlideThreeBtnLeft =
          By.cssSelector("div[class*='slick-slide'][data-slick-index = '2'] a[href = '/trading/signup']");
  // Transfer to Start Trading page (capital.com/trading/signup?go=demo) - UK Limited doesn't have this button
  final private By locatorMainBannerSlideThreeBtnRight =
          By.cssSelector("div[class*='slick-slide'][data-slick-index = '2'] a[href = '/trading/signup?go=demo']");

  final String addressOfScreenshotFile_MainBannerSlideThreeBtnLeft =
          "data/screenshots/mainPage/checkingInSection_MainBannerTabThree_BtnStartTrading.png";
  final String addressOfScreenshotFile_MainBannerSlideThreeBtnRight =
          "data/screenshots/mainPage/checkingInSection_MainBannerTabThree_BtnStartTrading.png";

  // Slide number 4
  final private By locatorMainBannerBtnFour = By.cssSelector("button[type = 'button'][data-slick-index = '3']");
  // Section "Main banner" - END


  // Section Widget "Trading instrument" - START
  // Locators option A
  // Tab Most traded (codeName - mtr, number 7)
  // Tab Commodities (codeName - com, number 7)
  // Tab Indices (codeName - ind, number 7)
  // Tab Shares (codeName - shar, number 7)
  // Tab Forex (codeName - fx, number 7)
  // Tab ETFs (codeName - etf, number 7)

  final static By locatorTradingInstrumentWidgetTabMostTraded1 = By.cssSelector("li[data-tab-control = 'mtr']");
  final static By locatorTradingInstrumentWidgetTabCommodities1 = By.cssSelector("li[data-tab-control = 'com']");
  final static By locatorTradingInstrumentWidgetTabIndices1 = By.cssSelector("li[data-tab-control = 'ind']");
  final static By locatorTradingInstrumentWidgetTabShares1 = By.cssSelector("li[data-tab-control = 'shar']");
  final static By locatorTradingInstrumentWidgetTabForex1 = By.cssSelector("li[data-tab-control = 'fx']");
  final static By locatorTradingInstrumentWidgetTabETFs1 = By.cssSelector("li[data-tab-control = 'etf']");

  final static String locatorAllButtonsOnWidgetTradingInstrument_A_1 = "tbody[data-tab-content = '";
  final static String locatorAllButtonsOnWidgetTradingInstrument_A_2 = "'] tr";

  final static String locatorCssWidgetMarketBtnTrade_A_1 = "tbody[data-tab-content = '";
  final static String locatorCssWidgetMarketBtnTrade_A_2 = "'] tr:nth-child(";
  final static String locatorCssWidgetMarketBtnTrade_A_3 = ") a[data-type='wdg_markets']";

  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabMostTraded1 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabMostTraded_BtnsTrade1.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabCommodities1 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabCommodities_BtnsTrade1.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabIndices1 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabIndices_BtnsTrade1.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabShares1 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabShares_BtnsTrade1.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabForex1 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabForex_BtnsTrade1.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabETFs1 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabETFs_BtnsTrade1.png";


  // Locators option B
  final static By locatorTradingInstrumentWidgetTabMostTraded2 = By.cssSelector("a.tab-list__item[data-type = 'Most']");
  final static By locatorTradingInstrumentWidgetTabCommodities2 = By.cssSelector("a.tab-list__item[data-type = 'Commodities']");
  final static By locatorTradingInstrumentWidgetTabIndices2 = By.cssSelector("a.tab-list__item[data-type = 'Indices']");
  final static By locatorTradingInstrumentWidgetTabShares2 = By.cssSelector("a.tab-list__item[data-type = 'Shares']");
  final static By locatorTradingInstrumentWidgetTabForex2 = By.cssSelector("a.tab-list__item[data-type = 'Forex']");
  final static By locatorTradingInstrumentWidgetTabETFs2 = By.cssSelector("a.tab-list__item[data-type = 'ETFs']");



  final static String locatorAllButtonsOnWidgetTradingInstrument_B_1 = "div.ihome-";
  final static String locatorAllButtonsOnWidgetTradingInstrument_B_2 = " div.tools__item";

  final static String locatorTradingInstrumentWidgetBtnTrade_B_1 = "div.ihome-";
  final static String locatorTradingInstrumentWidgetBtnTrade_B_2 = " div.tools__item:nth-child(";
  final static String locatorTradingInstrumentWidgetBtnTrade_B_3 = ") a.tools__btn";

  final private String expectedURLResultWidgetMarketBtnTrade =
          "https://capitalcom.onelink.me/700515151?af_dp=https%3A%2F%2Fcapital.com%2Finstrument%3Fid%3D427748677997764&&cp_device_id=";
  final private String expectedLinkForWindowSingUp = "capitalcom.onelink";

  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabMostTraded2 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabMostTraded_BtnsTrade2.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabCommodities2 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabCommodities_BtnsTrade2.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabIndices2 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabIndices_BtnsTrade2.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabShares2 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabShares_BtnsTrade2.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabForex2 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabForex_BtnsTrade2.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabETFs2 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabETFs_BtnsTrade2.png";
  // Section Widget "Trading instrument" - END

  // Section "Still looking for a broker you can trust?"
  // here used locator of button "user plus" from class "Locators"
  final private String addressOfScreenshotFile_ModuleStillLookingForBrokerYouCanTrustBtnUserPlus =
          "data/screenshots/mainPage/checkingInSection_StillLookingForBrokerYouCanTrust_BtnTryNow.png";

  // Section Widget “Promo Market”
  // here used locator of button "Trade Now" from class "Locators"
  final private String addressOfScreenshotFile_ModuleWidgetPromoMarket =
          "data/screenshots/mainPage/checkingInSection_WidgetPromoMarket_BtnTradeNow.png";

  //Section "Explore our platform" - START
  final private String expectedURLResultExploreOrPlatform = "";
  final private By locatorExploreOurPlatformBtnTryNow = By.cssSelector("div[data-type = 'btn_nearby_video'] a:nth-child(2)");
  //Section "Explore our platform" - END

  //Section "New to trading" - START
  final private By locatorNewToTradingBtnPractiseForFree = By.cssSelector("a[data-type = 'btn_new_to_trading']");
  final private String expectedUrlResultNewToTradingBtnPractiseForFree = "https://capital.com/trading/signup";
 //Section "New to trading" - END

  // Section "Trading calculator"
  // here used locator of button "Start trading" from class "Locators"

  // Section "Trader's Dashboard" - START
  final private By locatorTradersDashboard = By.cssSelector("div.tradersDashboard__item");
  final private String locatorTradersDashboardBtnTrad1 = "div.tradersDashboard__item:nth-child(";
  final private String locatorTradersDashboardBtnTrad2 = ") button";
  // Section "Trader's Dashboard" - END

  // Section "Why choose Capital.com? Our numbers speak for themselves"
  // here used locator of button "Try now" from class "Locators"



  // assert
  // Tests registration elements in Header
  @Order(1)
  @Test
  @Description("Checking Login button on page header")
  public void mainPageHeader_ClickOnBtnLogIn_LoginFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(Locators.headerBtnLogIn,0,0);
    waitForElement(Locators.headerBtnLogIn);
    clickOnElement(Locators.headerBtnLogIn);
    // assert
    checkShowingUpLoginForm();

    takeScreenshot(addressOfScreenshotFile_HeaderBtnLogIn);
  }

  @Order(2)
  @Test
  @Description("Checking Sing up button on page header")
  public void  mainPageHeader_ClickOnBtnTradeNow_SingUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(Locators.headerBtnTradeNow,0,0);
    waitForElement(Locators.headerBtnTradeNow);
    clickOnElement(Locators.headerBtnTradeNow);
    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(addressOfScreenshotFile_HeaderBtnTradeNow);
  }

  //Tests registration elements in section Main banner
  @Order(3)
  @Test
  @Description("Checking Sing up button on Main banner")
  public void mainPageMainBanner_clickOnTabOneAndClickOnLeftBtn_SingUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act
    scrollToElement(locatorMainBannerBtnOne,0,-400);
    waitForElement(locatorMainBannerBtnOne);
    clickOnElement(locatorMainBannerBtnOne);
    waitForElement(locatorMainBannerSlideOneBtnLeft);
    clickOnElement(locatorMainBannerSlideOneBtnLeft);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(addressOfScreenshotFile_MainBannerSlideOneBtnLeft);
  }

  @Order(4)
  @Test
  @Description("Checking Sing up button on Main banner")
  public void mainPageMainBanner_clickOnTabThreeAndClickOnLeftBtn_SingUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act
    scrollToElement(locatorMainBannerBtnThree,0,-400);
    waitForElement(locatorMainBannerBtnThree);
    clickOnElement(locatorMainBannerBtnThree);
    waitForElement(locatorMainBannerSlideThreeBtnLeft);
    clickOnElement(locatorMainBannerSlideThreeBtnLeft);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(addressOfScreenshotFile_MainBannerSlideThreeBtnLeft);
  }

  @Order(5)
  @Test
  @Description("Checking Sing up button on Main banner")
  public void mainPageMainBanner_clickOnTabThreeAndClickOnRightBtn_SingUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act
    scrollToElement(locatorMainBannerBtnThree,0,-400);
    waitForElement(locatorMainBannerBtnThree);
    clickOnElement(locatorMainBannerBtnThree);
    waitForElement(locatorMainBannerSlideThreeBtnRight);
    clickOnElement(locatorMainBannerSlideThreeBtnRight);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(addressOfScreenshotFile_MainBannerSlideThreeBtnRight);
  }

  //Tests registration elements in section "Trading instrument widget"
  // Tests option A
  @Order(6)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option A)")
  @EnabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabMostTradedAndClickAllBtnTrade_SingUpFormWasAppear_A() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    //act
    waitForElement(locatorTradingInstrumentWidgetTabMostTraded1);
    clickOnElement(locatorTradingInstrumentWidgetTabMostTraded1);

    //assert
    checkingAllItemOnTabOption_A("mtr");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabMostTraded1);
  }
  @Order(7)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option A)")
  @EnabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabCommoditiesAndClickAllBtnTrade_SingUpFormWasAppear_A() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    //act
    waitForElement(locatorTradingInstrumentWidgetTabCommodities1);
    clickOnElement(locatorTradingInstrumentWidgetTabCommodities1);

    //assert
    checkingAllItemOnTabOption_A("com");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabCommodities1);  }
  @Order(8)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option A)")
  @EnabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabIndicesAndClickAllBtnTrade_SingUpFormWasAppear_A() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    //act
    waitForElement(locatorTradingInstrumentWidgetTabIndices1);
    clickOnElement(locatorTradingInstrumentWidgetTabIndices1);

    //assert
    checkingAllItemOnTabOption_A("ind");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabIndices1);
  }
  @Order(9)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option A)")
  @EnabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabSharesAndClickAllBtnTrade_SingUpFormWasAppear_A() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    //act
    waitForElement(locatorTradingInstrumentWidgetTabShares1);
    clickOnElement(locatorTradingInstrumentWidgetTabShares1);

    //assert
    checkingAllItemOnTabOption_A("shar");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabShares1);
  }
  @Order(10)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option A)")
  @EnabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabForexAndClickAllBtnTrade_SingUpFormWasAppear_A() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    //act
    waitForElement(locatorTradingInstrumentWidgetTabForex1);
    clickOnElement(locatorTradingInstrumentWidgetTabForex1);

    //assert
    checkingAllItemOnTabOption_A("fx");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabForex1);
  }
  @Order(11)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option A)")
  @EnabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabETFsAndClickAllBtnTrade_SingUpFormWasAppear_A() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    //act
    waitForElement(locatorTradingInstrumentWidgetTabETFs1);
    clickOnElement(locatorTradingInstrumentWidgetTabETFs1);

    //assert
    checkingAllItemOnTabOption_A("etf");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabETFs1);
  }

  // Tests second option
  @Order(12)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option B)")
  @DisabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabMostTradedAndClickAllBtnTrade_SingUpFormWasAppear_B() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act
    waitForElement(locatorTradingInstrumentWidgetTabMostTraded2);
    clickOnElement(locatorTradingInstrumentWidgetTabMostTraded2);

    // assert
    checkingAllItemOnTabOption_B("Most");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabMostTraded2);
  }
  @Order(13)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option B)")
  @DisabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabCommoditiesAndClickAllBtnTrade_SingUpFormWasAppear_B() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act
    waitForElement(locatorTradingInstrumentWidgetTabCommodities2);
    clickOnElement(locatorTradingInstrumentWidgetTabCommodities2);
    // assert
    checkingAllItemOnTabOption_B("Commodities");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabCommodities2);
  }
  @Order(14)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option B)")
  @DisabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabIndicesAndClickAllBtnTrade_SingUpFormWasAppear_B() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act
    waitForElement(locatorTradingInstrumentWidgetTabIndices2);
    clickOnElement(locatorTradingInstrumentWidgetTabIndices2);

    // assert
    checkingAllItemOnTabOption_B("Indices");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabIndices2);
  }
  @Order(15)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option B)")
  @DisabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabSharesAndClickAllBtnTrade_SingUpFormWasAppear_B() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act
    waitForElement(locatorTradingInstrumentWidgetTabShares2);
    clickOnElement(locatorTradingInstrumentWidgetTabShares2);

    // assert
    checkingAllItemOnTabOption_B("Shares");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabShares2);

  }
  @Order(16)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option B)")
  @DisabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabForexAndClickAllBtnTrade_SingUpFormWasAppear_B() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act
    waitForElement(locatorTradingInstrumentWidgetTabForex2);
    clickOnElement(locatorTradingInstrumentWidgetTabForex2);

    // assert
    checkingAllItemOnTabOption_B("Forex");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabForex2);
  }
  @Order(17)
  @Test
  @Description("Checking Sing up button on Trading instrument widget (option B)")
  @DisabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  public void mainPageTradingInstrumentWidget_clickOnTabETFsAndClickAllBtnTrade_SingUpFormWasAppear_B() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act
    waitForElement(locatorTradingInstrumentWidgetTabETFs2);
    clickOnElement(locatorTradingInstrumentWidgetTabETFs2);

    // assert
    checkingAllItemOnTabOption_B("ETFs");

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabETFs1);
  }

  @Order(18)
  @Test
  public void mainPageModuleStillLookingForBrokerYouCanTrust_clickOnBtnUserPlus_SingUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act
    scrollToElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus, 0, -400);
    waitForElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    clickOnElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(addressOfScreenshotFile_ModuleStillLookingForBrokerYouCanTrustBtnUserPlus);
  }

  @Order(19)
  @Test
  public void mainPageModuleWidgetPromoMarket_clickOnBtnTradeNow_SingUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);

    // act and assert
    checkingModuleWidgetPromoMarketForMainPage();

    takeScreenshot(addressOfScreenshotFile_ModuleWidgetPromoMarket);
  }

//  //Tests registration elements in section "Explore our platform"
//  @Order(20)
//  @Test
//  public void checkingInSection_ExploreOurPlatform_BtnTryNow() throws IOException {
//    // arrange
//    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);
//    Methods.timeOut(1000);
//    // act
//    scrollToElement(locatorExploreOurPlatformBtnTryNow, 0, 0);
//    checkingVisibilityOfBtnAndClickingIt(locatorExploreOurPlatformBtnTryNow);
//    Methods.timeOut(1000);
//    // assert
//    checkingAppearanceSingUpForm();
//
//    takeScreenshot("data/screenshots/mainPage/checkingInSection_ExploreOurPlatform_BtnTryNow.png");
//  }
//
//  //Tests registration elements in section "New to trading?"
//  @Order(21)
//  @Test
//  public void checkingInSection_NewToTrading_BtnPractiseForFree() throws IOException {
//    // arrange
//    goToPageAndCheckUrl(MainPage.url);
//    // act
//    scrollToElement(locatorNewToTradingBtnPractiseForFree,0,0);
//    //assert
//    Assertions.assertEquals(expectedUrlResultNewToTradingBtnPractiseForFree,
//            getUrlOfLink(locatorNewToTradingBtnPractiseForFree), "URL doesn't match expected result");
//
//    takeScreenshot("data/screenshots/mainPage/checkingInSection_NewToTrading_BtnPractiseForFree.png");
//
//  }
//
//  //Tests registration elements in section "Trading calculator"
//  @Order(22)
//  @Test
//  public void checkingInSection_TradingCalculator_BtnStartTrading() throws IOException {
//    // arrange
//    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);
//    Methods.timeOut(1000);
//    // act
//    scrollToElement(locatorExploreOurPlatformBtnTryNow, 0, 0);
//    checkingVisibilityOfBtnAndClickingIt(Locators.moduleTradingCalculatorBtnStartTrading);
//    Methods.timeOut(1000);
//    // assert
//    checkingAppearanceSingUpForm();
//
//    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingCalculator_BtnStartTrading.png");
//  }
//
//  //Tests registration elements in section "Trader's Dashboard"
//  @Order(23)
//  @Test
//  public void checkingInSection_TradersDashboard_BtnsTrade() throws IOException {
//    // arrange
//    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);
//    Methods.timeOut(1000);
//    // act
//    scrollToElement(locatorTradersDashboard, 0, -200);
//    int numberOfElements = Methods.driver.findElements(locatorTradersDashboard).size();
//    for (int i = 1; i <= numberOfElements; i++) {
//      checkingVisibilityOfBtnAndClickingIt(By.cssSelector(locatorTradersDashboardBtnTrad1 + i + locatorTradersDashboardBtnTrad2));
//      Methods.timeOut(1000);
//      // assert
//      checkingAppearanceSingUpForm();
//
//      takeScreenshot("data/screenshots/mainPage/checkingInSection_TradersDashboard_BtnsTrade.png");
//    }
//  }
//
//  //Tests registration elements in section "Why choose Capital.com? Our numbers speak for themselves"
//  @Order(24)
//  @Test
//  public void checkingInSection_WhyChooseCapitalCom_BtnTryNow() throws IOException {
//    // arrange
//    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);
//    Methods.timeOut(1000);
//    // act
//    scrollToElement(Locators.moduleWhyChooseCapitalComBtnTryNow, 0, 0);
//    checkingVisibilityOfBtnAndClickingIt(Locators.moduleWhyChooseCapitalComBtnTryNow);
//    Methods.timeOut(1000);
//    // assert
//    checkingAppearanceSingUpForm();
//
//    takeScreenshot("data/screenshots/mainPage/checkingInSection_WhyChooseCapitalCom_BtnTryNow.png");
//  }
}