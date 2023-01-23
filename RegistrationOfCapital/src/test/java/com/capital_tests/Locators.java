package com.capital_tests;

import org.openqa.selenium.By;

public class Locators {

  // License
  public static final By licenseBtnMenu = By.cssSelector("button.cc-toggleLicense__btn");
  public static final By licenseBtnASIC = By.xpath("//a[contains(@href, 'license')] [contains(., 'ASIC')]");
  public static final String licenseNameASIC = "Capital Com Australia Pty Ltd";
  public static final By licenseBtnFCA = By.xpath("//a[contains(@href, 'license')] [contains(., 'FCA')]");
  public static final String licenseNameFCA = "Capital Com UK Limited";
  public static final By licenseBtnCYSEC = By.xpath("//a[contains(@href, 'license')] [contains(., 'CYSEC')]");
  public static final String licenseNameCYSEC = "Capital Com SV Investments Limited";
  public static final By licenseBtnNBRB = By.xpath("//a[contains(@href, 'license')] [contains(., 'NBRB')]");
  public static final String licenseNameNBRB = "Сlosed Joint Stock Company «FinTech Solutions»";
  public static final By licenseBtnForex = By.xpath("//a[contains(@href, 'license')] [contains(., 'Forex')]");
  public static final String licenseNameForex = "Smart Forex Broker LLC";
  public static final By licenseBtnFSA = By.xpath("//a[contains(@href, 'license')] [contains(., 'FSA')]");
  public static final String licenseNameFSA = "Capital Com Stock and CFD Investing Ltd";


  // Login form
  public static final By loginFormH1 = By.cssSelector("#l_overlay div.h1");
  public static final By loginFormFieldEmail = By.cssSelector("#l_overlay input[type = 'email']");
  public static final By loginFormFieldPassword = By.cssSelector("#l_overlay input[type = 'password']");
  public static final By loginFormBtnCancel = By.cssSelector("#l_overlay button.button-cleared");


  // Sign up form
  public static final By signUpFormH1 = By.cssSelector("#s_overlay div.h1");
  public static final By signUpFormFieldEmail = By.cssSelector("#s_overlay input[type = 'email']");
  public static final By signUpFormFieldPassword = By.cssSelector("#s_overlay input[type = 'password']");
  public static final By signUpFormBtnCancel = By.cssSelector("#s_overlay button.button-cleared");


  // Sign up form on new page
  public static final By signUpFormH1_onNewPage = By.cssSelector("#testwrap div.h1");
  public static final By signUpFormFieldEmail_onNewPage = By.cssSelector("#testwrap input[type = 'email']");
  public static final By signUpFormFieldPassword_onNewPage = By.cssSelector("#testwrap input[type = 'password']");


  // Modules ---------- START

  // Header of all pages
  public static final By headerBtnLogIn = By.cssSelector("#wg_loginBtn");
  public static final By headerBtnTradeNow = By.cssSelector("a[data-type = 'btn_header']");


  // Module Widget “Promo Market”
  public static final By moduleWidgetPromoMarketTab = By.cssSelector("div.cc-sliderFade__item");
  public static final By moduleWidgetPromoMarketTabName = By.cssSelector("div.cc-sliderFade__item.active strong");
  public static final By moduleWidgetPromoMarketBtnTradeNow = By.cssSelector("div.cc-sliderFade__item.active div.hideXs.btn");


  // Module "Trading calculator"
  public static final By moduleTradingCalculatorBtnStartTrading = By.cssSelector("div[data-type = 'btn_calculator']");


  // Module "Still looking for a broker you can trust?" - START
  public static final By moduleStillLookingForBrokerYouCanTrustIconUserPlus = By.cssSelector("i[data-type = 'banner_with_steps']");


  // Module "Why choose Capital.com? Our numbers speak for themselves."
  public static final By moduleWhyChooseCapitalComBtnTryNow = By.cssSelector("a[data-type *= 'banner_with_counter_hor_counter_hor']");

  // Modules ---------- END


// --------------------------------------------------------------------------------------------------------------------


  // Main page ---------- START
  // Checking Registration / Authorization form
  // URL
  public static final  String url = "https://capital.com";


  // Header
  // here used locators of buttons "Log in" and "Trade now" from class "com.capital_tests.Locators"
  public static final String addressOfScreenshotFile_HeaderBtnLogIn = "data/screenshots/mainPage/checkingIn_PageHeader_BtnLogIn.png";
  public static final String addressOfScreenshotFile_HeaderBtnTradeNow =
          "data/screenshots/mainPage/checkingIn_PageHeader_BtnTradeNow.png";


  // Section "Main banner" - START
  // Slide number 1
  public static final By locatorMainBannerBtnOne = By.cssSelector("button[type = 'button'][data-slick-index = '0']");
  public static final By locatorMainBannerSlideOneBtnLeft =
          By.cssSelector("div[class*='slick-slide'][data-slick-index = '0'] a[href = '/trading/signup']");
  public static final By locatorMainBannerSlideOneBtnRight =
          By.cssSelector("div[class*='slick-slide'][data-slick-index = '0'] a[href = '/trading/signup?go=demo']");
  // Transfer to Start Trading page (capital.com/trading/signup?go=demo) - UK Limited doesn't have this button
  public static final By locatorMainBannerSlideOneBtnTransferToStartTrading =
          By.cssSelector("div[class*='slick-slide'][data-slick-index = '0'] a[href = '/trading/signup?go=demo']");
  public static final String addressOfScreenshotFile_MainBannerSlideOneBtnLeft =
          "data/screenshots/mainPage/checkingInSection_MainBannerTabOne_BtnOpenAccount.png";

  // Slide number 2
  public static final By locatorMainBannerBtnTwo = By.cssSelector("button[type = 'button'][data-slick-index = '1']");

  // Slide number 3
  public static final By locatorMainBannerBtnThree = By.cssSelector("button[type = 'button'][data-slick-index = '2']");
  public static final By locatorMainBannerSlideThreeBtnLeft =
          By.cssSelector("div[class*='slick-slide'][data-slick-index = '2'] a[href = '/trading/signup']");
  // Transfer to Start Trading page (capital.com/trading/signup?go=demo) - UK Limited doesn't have this button
  public static final By locatorMainBannerSlideThreeBtnRight =
          By.cssSelector("div[class*='slick-slide'][data-slick-index = '2'] a[href = '/trading/signup?go=demo']");

  public static final String addressOfScreenshotFile_MainBannerSlideThreeBtnLeft =
          "data/screenshots/mainPage/checkingInSection_MainBannerTabThree_BtnStartTrading.png";
  public static final String addressOfScreenshotFile_MainBannerSlideThreeBtnRight =
          "data/screenshots/mainPage/checkingInSection_MainBannerTabThree_BtnStartTrading.png";

  // Slide number 4
  public static final By locatorMainBannerBtnFour = By.cssSelector("button[type = 'button'][data-slick-index = '3']");
  // Section "Main banner" - END


  // Section Widget "Trading instrument" - START

  // Option A
  // Tab Most traded (codeName - mtr, number 7)
  // Tab Commodities (codeName - com, number 7)
  // Tab Indices (codeName - ind, number 7)
  // Tab Cryptocurrencies (codeName - cryp, number 7)
  // Tab Shares (codeName - shar, number 7)
  // Tab Forex (codeName - fx, number 7)
  // Tab ETFs (codeName - etf, number 7)

  public static final String locatorTradingInstrumentWidgetTab_A1 = "li[data-tab-control = '";
  public static final String locatorTradingInstrumentWidgetTab_A2 = "']";
  public static final String codenameForUserAnnotation = "mtr";

  public static final By locatorTradingInstrumentWidgetTabMostTraded1 = By.cssSelector("li[data-tab-control = 'mtr']");

  public static final String locatorAllButtonsOnWidgetTradingInstrument_A_1 = "tbody[data-tab-content = '";
  public static final String locatorAllButtonsOnWidgetTradingInstrument_A_2 = "'] tr";

  public static final String locatorCssWidgetMarketBtnTrade_A_1 = "tbody[data-tab-content = '";
  public static final String locatorCssWidgetMarketBtnTrade_A_2 = "'] tr:nth-child(";
  public static final String locatorCssWidgetMarketBtnTrade_A_3 = ") a[data-type='wdg_markets']";


  // Option B
  public static final String locatorTradingInstrumentWidgetTab_B1 = "a.tab-list__item[data-type = '";
  public static final String locatorTradingInstrumentWidgetTab_B2 = "']";


  public static final String locatorAllButtonsOnWidgetTradingInstrument_B_1 = "div.ihome-";
  public static final String locatorAllButtonsOnWidgetTradingInstrument_B_2 = " div.tools__item";

  public static final String locatorTradingInstrumentWidgetBtnTrade_B_1 = "div.ihome-";
  public static final String locatorTradingInstrumentWidgetBtnTrade_B_2 = " div.tools__item:nth-child(";
  public static final String locatorTradingInstrumentWidgetBtnTrade_B_3 = ") a.tools__btn";

  public static final String expectedURLResultWidgetMarketBtnTrade =
          "https://capitalcom.onelink.me/700515151?af_dp=https%3A%2F%2Fcapital.com%2Finstrument%3Fid%3D427748677997764&&cp_device_id=";
  public static final String expectedLinkForWindowSignUp = "capitalcom.onelink";


  // Screenshots
  public static final String addressOfScreenshotFile_ModuleTradingInstrumentWidget_MostTraded =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabMostTraded.png";
  public static final String addressOfScreenshotFile_ModuleTradingInstrumentWidget_Commodities =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabCommodities.png";
  public static final String addressOfScreenshotFile_ModuleTradingInstrumentWidget_Indices =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabIndices.png";
  public static final String addressOfScreenshotFile_ModuleTradingInstrumentWidget_Crypto =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabCrypto.png";
  public static final String addressOfScreenshotFile_ModuleTradingInstrumentWidget_Shares =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabShares.png";
  public static final String addressOfScreenshotFile_ModuleTradingInstrumentWidget_Forex =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabForex.png";
  public static final String addressOfScreenshotFile_ModuleTradingInstrumentWidget_ETFs =
          "data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabETFs.png";
  // Section Widget "Trading instrument" - END


  // Section "Still looking for a broker you can trust?"
  // here used locator of button "user plus" from class "com.capital_tests.Locators"
  public static final String addressOfScreenshotFile_ModuleStillLookingForBrokerYouCanTrustBtnUserPlus =
          "data/screenshots/mainPage/checkingInSection_StillLookingForBrokerYouCanTrust_BtnTryNow.png";

  // Section Widget “Promo Market”
  // here used locator of button "Trade Now" from class "com.capital_tests.Locators"
  public static final String addressOfScreenshotFile_ModuleWidgetPromoMarket =
          "data/screenshots/mainPage/checkingInSection_WidgetPromoMarket_BtnTradeNow.png";

  //Section "Explore our platform" - START
  public static final String expectedURLResultExploreOrPlatform = "";
  public static final By locatorExploreOurPlatformBtnTryNow = By.cssSelector("div[data-type = 'btn_nearby_video'] a:nth-child(2)");
  public static final String addressOfScreenshotFile_ModuleExploreOurPlatform =
          "data/screenshots/mainPage/checkingInSection_ExploreOurPlatform_BtnTryNow.png";
  //Section "Explore our platform" - END

  //Section "New to trading" - START
  public static final By locatorNewToTradingBtnPractiseForFree = By.cssSelector("a[data-type = 'btn_new_to_trading']");
  public static final String addressOfScreenshotFile_ModuleNewToTrading =
          "data/screenshots/mainPage/checkingInSection_NewToTrading_BtnPractiseForFree.png";
  //Section "New to trading" - END


  // Section "Trading calculator"
  // here used locator of button "Start trading" from class "com.capital_tests.Locators"
  public static final String addressOfScreenshotFile_ModuleTradingCalculator =
          "data/screenshots/mainPage/checkingInSection_TradingCalculator_BtnStartTrading.png";

  // Section "Trader's Dashboard" - START
  public static final By locatorTradersDashboard = By.cssSelector("div.tradersDashboard__item");
  public static final String locatorTradersDashboardBtnTrad1 = "div.tradersDashboard__item:nth-child(";
  public static final String locatorTradersDashboardBtnTrad2 = ") button";

  public static final String addressOfScreenshotFile_ModuleTradersDashboard =
          "data/screenshots/mainPage/checkingInSection_TradersDashboard_BtnsTrade.png";
  // Section "Trader's Dashboard" - END

  // Section "Why choose Capital.com? Our numbers speak for themselves"
  // here used locator of button "Try now" from class "com.capital_tests.Locators"
  public static final String addressOfScreenshotFile_ModuleWhyChooseCapitalCom =
          "data/screenshots/mainPage/checkingInSection_WhyChooseCapitalCom_BtnTryNow.png";

  // Main page ---------- END

// --------------------------------------------------------------------------------------------------------------------

  // Trading instrument cards ---------- START
  // Files with URL lists
  public static final String addressOfUrlFileFromSectionForex = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/Done page URL/forexPagesURL.txt";
  public static final String addressOfUrlFileFromSectionIndices = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/Done page URL/indicesPagesURL.txt";
  public static final String addressOfUrlFileFromSectionCommodities = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/Done page URL/commoditiesPagesURL.txt";
  public static final String addressOfUrlFileFromSectionCryptocurrencies = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/Done page URL/cryptocurrenciesPagesURL-1.txt";
  public static final String addressOfUrlFileFromSectionShares = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/Done page URL/sharesPagesURL.txt";

  // Files with report about checking trading instrument card
  public static final String addressOfReportFileSectionForex = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/Result reports/Report (Forex).txt";
  public static final String addressOfReportFileSectionIndices = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/Result reports/Report (Indices).txt";
  public static final String addressOfReportFileSectionCommodities = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/Result reports/Report (Commodities).txt";
  public static final String addressOfReportFileSectionCryptocurrencies = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/Result reports/Report (Cryptocurrencies)-1.txt";
  public static final String addressOfReportFileSectionShares = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/Result reports/Report (Shares).txt";

  // --arrange
  // Header
  // here used locators of buttons "Log in" and "Trade now" from class "com.capital_tests.testsWithAllure.Locators"

  // Section "Trading instrument name pane"
  public static final By locatorTradingInstrumentNamePanelBtnAddToFavourite = By.cssSelector("a[data-type = 'add_fav']");

  // Section "Widget"
  public static final By locatorWidgetBtnBell = By.cssSelector("a[data-type = 'market_alerts']");
  public static final By locatorWidgetBtnViewDetailedChart = By.cssSelector("a[data-type = 'detailed_chart']");
  public static final By locatorWidgetBtnSell = By.cssSelector("a[data-type = 'market_sell']");
  public static final By locatorWidgetBtnBuy = By.cssSelector("a[data-type = 'market_buy']");
  public static final By locatorWidgetBtnCreateAccount = By.cssSelector("div.sharesName__notTrading a");

  // Section "Why choose Capital.com? Our numbers speak for themselves"
  // here used locator of button "Try now" from class "com.capital_tests.testsWithAllure.Locators"

  // Section "Trading calculator"
  // here used locator of button "Start trading" from class "com.capital_tests.testsWithAllure.Locators"

  // Section Widget “Promo Market”
  // here used locators of buttons "Trade Now" from class "com.capital_tests.testsWithAllure.Locators". Total buttons - 4 item.

  // Section "Still looking for a broker you can trust?"
  // here used locator of button "user plus" from class "com.capital_tests.testsWithAllure.Locators"


  // Trading instrument cards ---------- END
}
