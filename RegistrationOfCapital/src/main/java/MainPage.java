import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.HashSet;

public class MainPage extends Methods{

  // Checking Registration / Authorization form
  // URL
  String urlMainPage = "https://capital.com";

  // Header
  // here used locators of buttons "Log in" and "Trade now" from class "Locators"

  // Section "Main banner" - START
  // Slide number 1
  By locatorMainBannerBtnOne = By.cssSelector("button[type = 'button'][data-slick-index = '0']");
  By locatorMainBannerSlideOneBtnToSignUp = By.cssSelector("div[class*='slick-slide'][data-slick-index = '0'] a[href = '/trading/signup']");
  // Transfer to Start Trading page (capital.com/trading/signup?go=demo) - UK Limited doesn't have this button
  By locatorMainBannerSlideOneBtnTransferToStartTrading = By.cssSelector("div[class*='slick-slide'][data-slick-index = '0'] a[href = '/trading/signup?go=demo']");

  // Slide number 2
  By locatorMainBannerBtnTwo = By.cssSelector("button[type = 'button'][data-slick-index = '1']");

  // Slide number 3
  By locatorMainBannerBtnThree = By.cssSelector("button[type = 'button'][data-slick-index = '2']");
  By locatorMainBannersSlideThreeBtnStartTrading = By.cssSelector("div[class*='slick-slide'][data-slick-index = '2'] a[href = '/trading/signup']");
  // Transfer to Start Trading page (capital.com/trading/signup?go=demo) - UK Limited doesn't have this button
  By locatorMainBannerSlideThreeBtnTransferToStartTrading = By.cssSelector("div[class*='slick-slide'][data-slick-index = '2'] a[href = '/trading/signup?go=demo']");

  // Slide number 4
  By locatorMainBannerBtnFour = By.cssSelector("button[type = 'button'][data-slick-index = '3']");
  // Section "Main banner" - END


  // Section Widget "Trading instrument" - START
  // Locators first option
  // Tab Most traded (codeName - mtr, number 7)
  // Tab Commodities (codeName - com, number 7)
  // Tab Indices (codeName - ind, number 7)
  // Tab Shares (codeName - shar, number 7)
  // Tab Forex (codeName - fx, number 7)
  // Tab ETFs (codeName - etf, number 7)

  By locatorTradingInstrumentWidgetTabMostTraded1 = By.cssSelector("li[data-tab-control = 'mtr']");
  By locatorTradingInstrumentWidgetTabCommodities1 = By.cssSelector("li[data-tab-control = 'com']");
  By locatorTradingInstrumentWidgetTabIndices1 = By.cssSelector("li[data-tab-control = 'ind']");
  By locatorTradingInstrumentWidgetTabShares1 = By.cssSelector("li[data-tab-control = 'shar']");
  By locatorTradingInstrumentWidgetTabForex1 = By.cssSelector("li[data-tab-control = 'fx']");
  By locatorTradingInstrumentWidgetTabETFs1 = By.cssSelector("li[data-tab-control = 'etf']");
  String locatorXPathWidgetMarketBtnTrade1_1 = "tbody[data-tab-content = '";
  String locatorXPathWidgetMarketBtnTrade1_2 = "'] tr:nth-child(";
  String locatorXPathWidgetMarketBtnTrade1_3 = ") a[data-type='wdg_markets']";

  public void checkingAllItemOnTabOption1 (String codeName) {
    int numberOfElements = driver.findElements(By.cssSelector("tbody[data-tab-content = '" + codeName + "'] tr")).size();
    for (int number = 1; number <= numberOfElements; number++) {
      checkingVisibilityOfBtnAndClickingIt(By.cssSelector(
              locatorXPathWidgetMarketBtnTrade1_1 + codeName
                      + locatorXPathWidgetMarketBtnTrade1_2 + number + locatorXPathWidgetMarketBtnTrade1_3));
      scrollToElement(By.cssSelector(locatorXPathWidgetMarketBtnTrade1_1 + codeName
              + locatorXPathWidgetMarketBtnTrade1_2 + number + locatorXPathWidgetMarketBtnTrade1_3), 0, -100);
      checkingAppearanceSingUpForm();
    }
  }

  // Locators second option
  String codeName = "";
  String locatorNumberOfElements1 = "div.ihome-";
  String locatorNumberOfElements2 = " div.tools__item";
  String locatorTradingInstrumentWidgetTabs2_1 = "a.tab-list__item[data-type = '";
  String locatorTradingInstrumentWidgetTabs2_2 = "']";
  String locatorTradingInstrumentWidgetBtnTrade2_1 = "div.ihome-";
  String locatorTradingInstrumentWidgetBtnTrade2_2 = " div.tools__item:nth-child(";
  String locatorTradingInstrumentWidgetBtnTrade2_3 = ") a.tools__btn";

  String expectedURLResultWidgetMarketBtnTrade = "https://capitalcom.onelink.me/700515151?af_dp=https%3A%2F%2Fcapital.com%2Finstrument%3Fid%3D427748677997764&&cp_device_id=";
  String expectedLinkForWindowSingUp = "capitalcom.onelink";

  public void checkingAllItemOnTab2 (String codeName) {
    for (int number = 1; number <= countNumberOfElements(codeName); number++) {
      By currentLocator = By.cssSelector(
              locatorTradingInstrumentWidgetBtnTrade2_1 + codeName
                      + locatorTradingInstrumentWidgetBtnTrade2_2 + number
                      + locatorTradingInstrumentWidgetBtnTrade2_3);
      scrollToElement(currentLocator,0,0);

      String link = driver.findElement(currentLocator).getAttribute("href");

      if (link.toLowerCase().indexOf(expectedLinkForWindowSingUp.toLowerCase()) != -1) {
        Assertions.assertEquals(expectedURLResultWidgetMarketBtnTrade,
                getUrlOfLink(currentLocator),
                "URL doesn't match expected result");
      }
      else {
        checkingVisibilityOfBtnAndClickingIt(currentLocator);
        timeOut(2);
        checkingAppearanceSingUpForm();
      }
    }
  }

  public int countNumberOfElements(String codeName) {
    return driver.findElements(By.cssSelector(locatorNumberOfElements1
            + codeName + locatorNumberOfElements2)).size();
  }
  // Section Widget "Trading instrument" - END

  // Section "Still looking for a broker you can trust?"
  // here used locator of button "user plus" from class "Locators"

  // Section Widget “Promo Market”
  // here used locator of button "Trade Now" from class "Locators"

  //Section "Explore our platform" - START
  String expectedURLResultExploreOrPlatform = "";
  By locatorExploreOurPlatformBtnTryNow = By.cssSelector("div[data-type = 'btn_nearby_video'] a:nth-child(2)");
  //Section "Explore our platform" - END

  //Section "New to trading" - START
  By locatorNewToTradingBtnPractiseForFree = By.cssSelector("a[data-type = 'btn_new_to_trading']");
  String expectedUrlResultNewToTradingBtnPractiseForFree = "https://capital.com/trading/signup";
 //Section "New to trading" - END

  // Section "Trading calculator"
  // here used locator of button "Start trading" from class "Locators"

  // Section "Trader's Dashboard" - START
  By locatorTradersDashboard = By.cssSelector("div.tradersDashboard__item");
  String locatorTradersDashboardBtnTrad1 = "div.tradersDashboard__item:nth-child(";
  String locatorTradersDashboardBtnTrad2 = ") button";
  // Section "Trader's Dashboard" - END

  // Section "Why choose Capital.com? Our numbers speak for themselves"
  // here used locator of button "Try now" from class "Locators"

  // assert
  // Tests registration elements in Header
  @Order(1)
  @Test
  public void checkingIn_PageHeader_BtnLogIn() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(Locators.headerBtnLogIn,0,0);
    checkingVisibilityOfBtnAndClickingIt(Locators.headerBtnLogIn);
    timeOut(1);
    // assert
    checkingAppearanceLoginForm();

    takeScreenshot("data/screenshots/mainPage/checkingIn_PageHeader_BtnLogIn.png");
  }

  @Order(2)
  @Test
  public void checkingIn_PageHeader_BtnTradeNow() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(Locators.headerBtnTradeNow,0,0);
    checkingVisibilityOfBtnAndClickingIt(Locators.headerBtnTradeNow);
    timeOut(1);
    // assert
    checkingAppearanceSingUpForm();

    takeScreenshot("data/screenshots/mainPage/checkingIn_PageHeader_BtnTradeNow.png");
  }

  //Tests registration elements in section Main banner
  @Order(3)
  @Test
  public void checkingInSection_MainBannerTabOne_BtnOpenAccount() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(locatorMainBannerBtnOne,0,-200);
    driver.findElement(locatorMainBannerBtnOne).click();
    scrollToElement(locatorMainBannerSlideOneBtnToSignUp,0,-200);
    checkingVisibilityOfBtnAndClickingIt(locatorMainBannerSlideOneBtnToSignUp);
    timeOut(1);
    // assert
    checkingAppearanceSingUpForm();

    takeScreenshot("data/screenshots/mainPage/checkingInSection_MainBannerTabOne_BtnOpenAccount.png");
  }

  @Order(4)
  @Test
  public void checkingInSection_MainBannerTabThree_BtnStartTrading() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(locatorMainBannerBtnThree,0,-300);
    timeOut(5);
    driver.findElement(locatorMainBannerBtnThree).click();
    timeOut(1);
//    scrollToElement(locatorMainBannersSlideThreeBtnStartTrading,0,-200);
    checkingVisibilityOfBtnAndClickingIt(locatorMainBannersSlideThreeBtnStartTrading);
    timeOut(1);
    // assert
    checkingAppearanceSingUpForm();

    takeScreenshot("data/screenshots/mainPage/checkingInSection_MainBannerTabThree_BtnStartTrading.png");
  }

  //Tests registration elements in section "Trading instrument widget"
  // Tests first option
  @Order(5)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabMostTraded_BtnsTrade1() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(locatorTradingInstrumentWidgetTabMostTraded1,0,-300);
    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabMostTraded1);
    // assert
    checkingAllItemOnTabOption1("mtr");

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabMostTraded_BtnsTrade1.png");
  }
  @Order(6)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabCommodities_BtnsTrade1() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(locatorTradingInstrumentWidgetTabCommodities1,0,-300);
    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabCommodities1);
    // assert
    checkingAllItemOnTabOption1("com");

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabCommodities_BtnsTrade1.png");  }
  @Order(7)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabIndices_BtnsTrade1() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(locatorTradingInstrumentWidgetTabIndices1,0,-300);
    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabIndices1);
    // assert
    checkingAllItemOnTabOption1("ind");

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabIndices_BtnsTrade1.png");
  }
  @Order(8)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabShares_BtnsTrade1() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(locatorTradingInstrumentWidgetTabShares1,0,-300);
    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabShares1);
    // assert
    checkingAllItemOnTabOption1("shar");

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabShares_BtnsTrade1.png");
  }
  @Order(9)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabForex_BtnsTrade1() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(locatorTradingInstrumentWidgetTabForex1,0,-300);
    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabForex1);
    // assert
    checkingAllItemOnTabOption1("fx");

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabForex_BtnsTrade1.png");
  }
  @Order(10)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabETFs_BtnsTrade1() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    // act
    scrollToElement(locatorTradingInstrumentWidgetTabETFs1,0,-300);
    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabETFs1);
    // assert
    checkingAllItemOnTabOption1("etf");

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabETFs_BtnsTrade1.png");
  }

  // Tests second option
  @Order(11)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabMostTraded_BtnsTrade2() throws IOException {
    // arrange
    codeName = "Most";
    By localLocator = By.cssSelector(locatorTradingInstrumentWidgetTabs2_1 + codeName
            + locatorTradingInstrumentWidgetTabs2_2);
    countNumberOfElements(codeName);
    // act
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    scrollToElement(localLocator,0,-300);
    checkingVisibilityOfBtnAndClickingIt(localLocator);
    //assert
    checkingAllItemOnTab2(codeName);

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabMostTraded_BtnsTrade2.png");
  }
  @Order(12)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabCommodities_BtnsTrade2() throws IOException {
    // arrange
    codeName = "Commodities";
    By localLocator = By.cssSelector(locatorTradingInstrumentWidgetTabs2_1 + codeName
            + locatorTradingInstrumentWidgetTabs2_2);
    countNumberOfElements(codeName);
    // act
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    scrollToElement(localLocator,0,-300);
    checkingVisibilityOfBtnAndClickingIt(localLocator);
    //assert
    checkingAllItemOnTab2(codeName);

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabCommodities_BtnsTrade2.png");
  }
  @Order(13)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabIndices_BtnsTrade2() throws IOException {
    // arrange
    codeName = "Indices";
    By localLocator = By.cssSelector(locatorTradingInstrumentWidgetTabs2_1 + codeName
            + locatorTradingInstrumentWidgetTabs2_2);
    countNumberOfElements(codeName);
    // act
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    scrollToElement(localLocator,0,-300);
    checkingVisibilityOfBtnAndClickingIt(localLocator);
    //assert
    checkingAllItemOnTab2(codeName);

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabIndices_BtnsTrade2.png");
  }
  @Order(14)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabShares_BtnsTrade2() throws IOException {
    // arrange
    codeName = "Shares";
    By localLocator = By.cssSelector(locatorTradingInstrumentWidgetTabs2_1 + codeName
            + locatorTradingInstrumentWidgetTabs2_2);
    countNumberOfElements(codeName);
    // act
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    scrollToElement(localLocator,0,-300);
    checkingVisibilityOfBtnAndClickingIt(localLocator);
    //assert
    checkingAllItemOnTab2(codeName);

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabShares_BtnsTrade2.png");
  }
  @Order(15)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabForex_BtnsTrade2() throws IOException {
    // arrange
    codeName = "Forex";
    By localLocator = By.cssSelector(locatorTradingInstrumentWidgetTabs2_1 + codeName
            + locatorTradingInstrumentWidgetTabs2_2);
    countNumberOfElements(codeName);
    // act
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    scrollToElement(localLocator,0,-300);
    checkingVisibilityOfBtnAndClickingIt(localLocator);
    //assert
    checkingAllItemOnTab2(codeName);

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabForex_BtnsTrade2.png");
  }
  @Order(16)
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabETFs_BtnsTrade2() throws IOException {
    // arrange
    codeName = "ETFs";
    By localLocator = By.cssSelector(locatorTradingInstrumentWidgetTabs2_1 + codeName
            + locatorTradingInstrumentWidgetTabs2_2);
    countNumberOfElements(codeName);
    // act
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    scrollToElement(localLocator,0,-300);
    checkingVisibilityOfBtnAndClickingIt(localLocator);
    //assert
    checkingAllItemOnTab2(codeName);

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingInstrumentWidgetTabETFs_BtnsTrade2.png");
  }

  @Order(17)
  @Test
  public void checkingInSection_StillLookingForBrokerYouCanTrust_BtnTryNow() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    // act
    scrollToElement(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus, 0, -200);
    checkingVisibilityOfBtnAndClickingIt(Locators.moduleStillLookingForBrokerYouCanTrustIconUserPlus);
    timeOut(1);
    // assert
    checkingAppearanceSingUpForm();

    takeScreenshot("data/screenshots/mainPage/checkingInSection_StillLookingForBrokerYouCanTrust_BtnTryNow.png");
  }

  @Order(18)
  @Test
  public void checkingInSection_WidgetPromoMarket_BtnTradeNow() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    // act
    checkingModuleWidgetPromoMarket();
    takeScreenshot("data/screenshots/mainPage/checkingInSection_WidgetPromoMarket_BtnTradeNow.png");
  }

  //Tests registration elements in section "Explore our platform"
  @Order(19)
  @Test
  public void checkingInSection_ExploreOurPlatform_BtnTryNow() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    // act
    scrollToElement(locatorExploreOurPlatformBtnTryNow, 0, 0);
    checkingVisibilityOfBtnAndClickingIt(locatorExploreOurPlatformBtnTryNow);
    timeOut(1);
    // assert
    checkingAppearanceSingUpForm();

    takeScreenshot("data/screenshots/mainPage/checkingInSection_ExploreOurPlatform_BtnTryNow.png");
  }

  //Tests registration elements in section "New to trading?"
  @Order(20)
  @Test
  public void checkingInSection_NewToTrading_BtnPractiseForFree() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    // act
    scrollToElement(locatorNewToTradingBtnPractiseForFree,0,0);
    //assert
    Assertions.assertEquals(expectedUrlResultNewToTradingBtnPractiseForFree,
            getUrlOfLink(locatorNewToTradingBtnPractiseForFree), "URL doesn't match expected result");

    takeScreenshot("data/screenshots/mainPage/checkingInSection_NewToTrading_BtnPractiseForFree.png");

  }

  //Tests registration elements in section "Trading calculator"
  @Order(21)
  @Test
  public void checkingInSection_TradingCalculator_BtnStartTrading() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    // act
    scrollToElement(locatorExploreOurPlatformBtnTryNow, 0, 0);
    checkingVisibilityOfBtnAndClickingIt(Locators.moduleTradingCalculatorBtnStartTrading);
    timeOut(1);
    // assert
    checkingAppearanceSingUpForm();

    takeScreenshot("data/screenshots/mainPage/checkingInSection_TradingCalculator_BtnStartTrading.png");
  }

  //Tests registration elements in section "Trader's Dashboard"
  @Order(22)
  @Test
  public void checkingInSection_TradersDashboard_BtnsTrade() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    // act
    scrollToElement(locatorTradersDashboard, 0, -200);
    int numberOfElements = driver.findElements(locatorTradersDashboard).size();
    for (int i = 1; i <= numberOfElements; i++) {
      checkingVisibilityOfBtnAndClickingIt(By.cssSelector(locatorTradersDashboardBtnTrad1 + i + locatorTradersDashboardBtnTrad2));
      timeOut(1);
      // assert
      checkingAppearanceSingUpForm();

      takeScreenshot("data/screenshots/mainPage/checkingInSection_TradersDashboard_BtnsTrade.png");
    }
  }

  //Tests registration elements in section "Why choose Capital.com? Our numbers speak for themselves"
  @Order(23)
  @Test
  public void checkingInSection_WhyChooseCapitalCom_BtnTryNow() throws IOException {
    // arrange
    goToPageAndCheckUrl(urlMainPage);
    checkLicense(Locators.licenseBtnMenu, Locators.licenseNameFCA, Locators.licenseBtnFCA);
    timeOut(1);
    // act
    scrollToElement(Locators.moduleWhyChooseCapitalComBtnTryNow, 0, 0);
    checkingVisibilityOfBtnAndClickingIt(Locators.moduleWhyChooseCapitalComBtnTryNow);
    timeOut(1);
    // assert
    checkingAppearanceSingUpForm();

    takeScreenshot("data/screenshots/mainPage/checkingInSection_WhyChooseCapitalCom_BtnTryNow.png");
  }
}