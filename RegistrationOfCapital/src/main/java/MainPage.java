import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.report.AllureReportBuilder;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainPage extends NewMethods{

  // Checking Registration / Authorization form
  // URL
  final static String url = "https://capital.com/?license=NBRB";
  final static String licenseName = Locators.licenseNameNBRB;
  final static By licenseLocator = Locators.licenseBtnNBRB;

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
  // Tab Cryptocurrencies (codeName - cryp, number 7)
  // Tab Shares (codeName - shar, number 7)
  // Tab Forex (codeName - fx, number 7)
  // Tab ETFs (codeName - etf, number 7)

  final static String locatorTradingInstrumentWidgetTab_A1 = "li[data-tab-control = '";
  final static String locatorTradingInstrumentWidgetTab_A2 = "']";

  final static By locatorTradingInstrumentWidgetTabMostTraded1 = By.cssSelector("li[data-tab-control = 'mtr']");

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
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabCryptocurrencies1 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabCryptocurrencies_BtnsTrade1.png";

  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabShares1 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabShares_BtnsTrade1.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabForex1 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabForex_BtnsTrade1.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabETFs1 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabETFs_BtnsTrade1.png";


  // Locators option B
  final static String locatorTradingInstrumentWidgetTabMostTraded_B1 = "a.tab-list__item[data-type = '";
  final static String locatorTradingInstrumentWidgetTabMostTraded_B2 = "']";


  final static String locatorAllButtonsOnWidgetTradingInstrument_B_1 = "div.ihome-";
  final static String locatorAllButtonsOnWidgetTradingInstrument_B_2 = " div.tools__item";

  final static String locatorTradingInstrumentWidgetBtnTrade_B_1 = "div.ihome-";
  final static String locatorTradingInstrumentWidgetBtnTrade_B_2 = " div.tools__item:nth-child(";
  final static String locatorTradingInstrumentWidgetBtnTrade_B_3 = ") a.tools__btn";

  final private String expectedURLResultWidgetMarketBtnTrade =
          "https://capitalcom.onelink.me/700515151?af_dp=https%3A%2F%2Fcapital.com%2Finstrument%3Fid%3D427748677997764&&cp_device_id=";
  final private String expectedLinkForWindowSignUp = "capitalcom.onelink";

  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabMostTraded2 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabMostTraded_BtnsTrade2.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabCommodities2 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabCommodities_BtnsTrade2.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabIndices2 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabIndices_BtnsTrade2.png";
  final private String addressOfScreenshotFile_TradingInstrumentWidgetTabCryptocurrencies2 =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabCryptocurrencies_BtnsTrade2.png";
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
  final private String addressOfScreenshotFile_ModuleExploreOurPlatform =
          "data/screenshots/mainPage/checkingInSection_ExploreOurPlatform_BtnTryNow.png";
  //Section "Explore our platform" - END

  //Section "New to trading" - START
  final private By locatorNewToTradingBtnPractiseForFree = By.cssSelector("a[data-type = 'btn_new_to_trading']");
  final private String addressOfScreenshotFile_ModuleNewToTrading =
          "data/screenshots/mainPage/checkingInSection_NewToTrading_BtnPractiseForFree.png";
 //Section "New to trading" - END


  // Section "Trading calculator"
  // here used locator of button "Start trading" from class "Locators"
  final String addressOfScreenshotFile_ModuleTradingCalculator =
          "data/screenshots/mainPage/checkingInSection_TradingCalculator_BtnStartTrading.png";

  // Section "Trader's Dashboard" - START
  final static By locatorTradersDashboard = By.cssSelector("div.tradersDashboard__item");
  final static String locatorTradersDashboardBtnTrad1 = "div.tradersDashboard__item:nth-child(";
  final static String locatorTradersDashboardBtnTrad2 = ") button";

  final private String addressOfScreenshotFile_ModuleTradersDashboard =
          "data/screenshots/mainPage/checkingInSection_TradersDashboard_BtnsTrade.png";
  // Section "Trader's Dashboard" - END

  // Section "Why choose Capital.com? Our numbers speak for themselves"
  // here used locator of button "Try now" from class "Locators"
  final private String addressOfScreenshotFile_ModuleWhyChooseCapitalCom =
          "data/screenshots/mainPage/checkingInSection_WhyChooseCapitalCom_BtnTryNow.png";



  // assert
  // Tests registration elements in Header
  @Order(1)
  @Test
  @Description("Checking Login button on page header")
  public void mainPageHeader_ClickOnBtnLogIn_LoginFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

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
  @Description("Checking Sign up button on page header")
  public void  mainPageHeader_ClickOnBtnTradeNow_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

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
  @Description("Checking Sign up button on Main banner")
  public void mainPageMainBanner_clickOnTabOneAndClickOnLeftBtn_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

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
  @Description("Checking Sign up button on Main banner")
  public void mainPageMainBanner_clickOnTabThreeAndClickOnLeftBtn_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

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
  @Description("Checking Sign up button on Main banner")
  public void mainPageMainBanner_clickOnTabThreeAndClickOnRightBtn_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

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
  @EnabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  @ParameterizedTest
  @Description("Checking Trade buttons on Trading instrument widget tab Most Trade (option A)")
  @ValueSource(strings = {"mtr", "com", "ind", "ind", "cryp","shar", "fx", "etf"})
  public void mainPageTradingInstrumentWidget_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear_A(String codename) throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

    //act
    waitForElement(By.cssSelector(locatorTradingInstrumentWidgetTab_A1
            + codename + locatorTradingInstrumentWidgetTab_A2));
    clickOnElement(By.cssSelector(locatorTradingInstrumentWidgetTab_A1
            + codename + locatorTradingInstrumentWidgetTab_A2));

    //assert
    checkingAllItemOnTabOption_A(codename);

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabMostTraded1);
  }

  // Tests option B
  @Order(7)
  @DisabledIf("NewMethods#checkingConditionToRunTestGroup_AorB")
  @ParameterizedTest
  @Description("Checking Trade buttons on Trading instrument widget tab Most Traded (option B)")
  @ValueSource(strings = {"Most", "Commodities", "Indices", "Cryptocurrencies", "Shares", "Forex", "ETFs"})
  public void mainPageTradingInstrumentWidget_clickOnTabsAndClickAllBtnTrade_SignUpFormWasAppear_B(String codename) throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    waitForElement(By.cssSelector(locatorTradingInstrumentWidgetTabMostTraded_B1
            + codename + locatorTradingInstrumentWidgetTabMostTraded_B2));
    clickOnElement(By.cssSelector(locatorTradingInstrumentWidgetTabMostTraded_B1
            + codename + locatorTradingInstrumentWidgetTabMostTraded_B2));

    // assert
    checkingAllItemOnTabOption_B(codename);

    takeScreenshot(addressOfScreenshotFile_TradingInstrumentWidgetTabMostTraded2);
  }
  @Order(8)
  @Test
  @Description("Checking user plus button on module 'Still looking for a broker you can trust?'")
  public void mainPageModuleStillLookingForBrokerYouCanTrust_clickOnBtnUserPlus_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus, 0, -400);
    waitForElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    clickOnElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(addressOfScreenshotFile_ModuleStillLookingForBrokerYouCanTrustBtnUserPlus);
  }

  @Order(9)
  @Test
  @Description("Checking buttons 'Trade Now' (4 items) on module widget promo market")
  public void mainPageModuleWidgetPromoMarket_clickOnBtnTradeNow_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

    // act and assert
    checkingModuleWidgetPromoMarketForMainPage();

    takeScreenshot(addressOfScreenshotFile_ModuleWidgetPromoMarket);
  }

  //Tests registration elements in section "Explore our platform"
  @Order(10)
  @Test
  @Description("Checking button 'Trade Now' on module 'Explore our platform'")
  public void mainPageModuleExploreOurPlatform_clickOnBtnTryNow_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(locatorExploreOurPlatformBtnTryNow, 0, -400);
    waitForElement(locatorExploreOurPlatformBtnTryNow);
    clickOnElement(locatorExploreOurPlatformBtnTryNow);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(addressOfScreenshotFile_ModuleExploreOurPlatform);
  }

  //Tests registration elements in module "New to trading?"
  @Order(11)
  @Test
  @Description("Checking button 'Practice for free' on module 'New to trading?'")
  public void mainPageModuleNewToTrading_clickOnBtnPractiseForFree_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(locatorNewToTradingBtnPractiseForFree, 0, -400);
    waitForElement(locatorNewToTradingBtnPractiseForFree);
    clickOnElement(locatorNewToTradingBtnPractiseForFree);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(addressOfScreenshotFile_ModuleNewToTrading);
  }

  //Tests registration elements in section "Trading calculator"
  @Order(12)
  @Test
  @Description("Checking button 'Start trading' on module 'Trading calculator'")
  public void mainPageModuleTradingCalculator_clickOnBtnStartTrading_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(Locators.moduleTradingCalculatorBtnStartTrading, 0, -400);
    waitForElement(Locators.moduleTradingCalculatorBtnStartTrading);
    clickOnElement(Locators.moduleTradingCalculatorBtnStartTrading);

    // assert
    checkShowingUpSignUpForm();

    takeScreenshot(addressOfScreenshotFile_ModuleTradingCalculator);
  }

  //Tests registration elements in section "Trader's Dashboard"
  @Order(13)
  @Test
  @Description("Checking buttons 'Trade' (5 items) on module 'Trader's Dashboard'")
  public void mainPageModuleTradersDashboard_clickOnBtnTrade_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

    // act
    scrollToElement(MainPage.locatorTradersDashboard, 0, -400);

    // assert
    checkingAllBtnOnTradersDashboard();

    takeScreenshot(addressOfScreenshotFile_ModuleTradersDashboard);
 }

  //Tests registration elements in section "Why choose Capital.com? Our numbers speak for themselves"
  @Order(14)
  @Test
  @Description("Checking button 'Try Now' on module 'Why choose Capital.com? Our numbers speak for themselves.'")
  public void mainPageModuleWhyChooseCapitalCom_clickOnBtnTryNow_SignUpFormWasAppear() throws IOException {
    // arrange
    goToPageAndCheckUrl(MainPage.url);
//    checkLicense(licenseName, licenseLocator);

    // assert
    scrollToElement(Locators.moduleWhyChooseCapitalComBtnTryNow, 0, -400);
    waitForElement(Locators.moduleWhyChooseCapitalComBtnTryNow);
    clickOnElement(Locators.moduleWhyChooseCapitalComBtnTryNow);

    checkShowingUpSignUpForm();

    takeScreenshot(addressOfScreenshotFile_ModuleWhyChooseCapitalCom);
  }
}