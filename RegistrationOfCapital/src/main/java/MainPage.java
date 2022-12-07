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

  // License
  By locatorBtnLicenseMenu = By.cssSelector("button.cc-toggleLicense__btn");
  By locatorBtnLicenseOfASIC = By.xpath("//a[contains(@href, 'license')] [contains(., 'ASIC')]");
  String nameLicenseASIC = "Capital Com Australia Pty Ltd";
  By locatorBtnLicenseOfFCA = By.xpath("//a[contains(@href, 'license')] [contains(., 'FCA')]");
  String nameLicenseFCA = "Capital Com UK Limited";
  By locatorBtnLicenseOfCYSEC = By.xpath("//a[contains(@href, 'license')] [contains(., 'CYSEC')]");
  String nameLicenseCYSEC = "Capital Com SV Investments Limited";
  By locatorBtnLicenseOfNBRB = By.xpath("//a[contains(@href, 'license')] [contains(., 'NBRB')]");
  String nameLicenseNBRB = "Capital Com Bel";
  By locatorBtnLicenseOfForex = By.xpath("//a[contains(@href, 'license')] [contains(., 'Forex')]");
  String nameLicenseForex = "Smart Forex Broker LLC";
  By locatorBtnLicenseOfFSA = By.xpath("//a[contains(@href, 'license')] [contains(., 'FSA')]");
  String nameLicenseFSA = "Capital Com Stock and CFD Investing Ltd";

  // Login form
  By locatorLoginFormH1 = Methods.locatorLoginFormH1;
  By locatorLoginFormFieldEmail = By.cssSelector("#l_overlay input[type = 'email']");
  By locatorLoginFormFieldPassword = By.cssSelector("#l_overlay input[type = 'password']");
  By locatorLoginFormBtnCancel = Methods.locatorLoginFormBtnCancel;

  // Sign up form
  By locatorSignUpFormH1 = Methods.locatorSignUpFormH1;
  By locatorSignUpFormFieldEmail = By.cssSelector("#s_overlay input[type = 'email']");
  By locatorSignUpFormFieldPassword = By.cssSelector("#s_overlay input[type = 'password']");
  By locatorSignUpFormBtnCancel = Methods.locatorSignUpFormBtnCancel;


  // Header
  By locatorHeaderBtnLogIn = By.cssSelector("#wg_loginBtn");
  By locatorHeaderBtnTradeNow = By.cssSelector("a[data-type = 'btn_header']");


  //Main banner (English site version) - START
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
  //Main banner (English site version) - END


  // Widget market - START
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
  // Widget market - END

  // Section "Still looking for a broker you can trust?" - START
    By locatorStillLookingForBrokerYouCanTrustIconUserPlus = By.cssSelector("i[data-type = 'banner_with_steps']");
  // Section "Still looking for a broker you can trust?" - END

  // Section Widget “Promo Market” - START
  By locatorWidgetPromoMarketTab = By.cssSelector("div.cc-sliderFade__item");
  By locatorWidgetPromoMarketTabName = By.cssSelector("div.cc-sliderFade__item.active strong");
  By locatorWidgetPromoMarketBtnTradeNow = By.cssSelector("div.cc-sliderFade__item.active div.hideXs.btn");
  // Section Widget “Promo Market” - END

  //Section "Explore our platform" - START
  String expectedURLResultExploreOrPlatform = "";
  By locatorExploreOurPlatformBtnTryNow = By.cssSelector("div[data-type = 'btn_nearby_video'] a:nth-child(2)");
  //Section "Explore our platform" - END

  //Section "New to trading" - START
  By locatorNewToTradingBtnPractiseForFree = By.cssSelector("a[data-type = 'btn_new_to_trading']");
  String expectedUrlResultNewToTradingBtnPractiseForFree = "https://capital.com/trading/signup";
 //Section "New to trading" - END

  // Section "Trading calculator" - START
  By locatorTradingCalculatorBtnStartTrading = By.cssSelector("div[data-type = 'btn_calculator']");
  // Section "Trading calculator" - END

  // Section "Trader's Dashboard" - START
  By locatorTradersDashboard = By.cssSelector("div.tradersDashboard__item");
  String locatorTradersDashboardBtnTrad1 = "div.tradersDashboard__item:nth-child(";
  String locatorTradersDashboardBtnTrad2 = ") button";
  // Section "Trader's Dashboard" - END

  // Section "Why choose Capital.com? Our numbers speak for themselves." - START
  By locatorWhyChooseCapitalComBtnTryNow = By.cssSelector("a[data-type = 'banner_with_counter_hor_counter_hor_newBlack_764']");
  // Section "Why choose Capital.com? Our numbers speak for themselves." - END


  // Tests registration elements in Header
  @Order(1)
  @Test
  public void checkingIn_PageHeader_BtnLogIn() throws IOException {
    // arrange
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    // act
    scrollToElement(locatorHeaderBtnLogIn,0,0);
    checkingVisibilityOfBtnAndClickingIt(locatorHeaderBtnLogIn);
    timeOut(1);
    // assert
    checkingAppearanceLoginForm();

    takeScreenshot("data/screenshots/mainPage/checkingIn_PageHeader_BtnLogIn.png");
  }

  @Order(2)
  @Test
  public void checkingIn_PageHeader_BtnTradeNow() throws IOException {
    // arrange
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    // act
    scrollToElement(locatorHeaderBtnTradeNow,0,0);
    checkingVisibilityOfBtnAndClickingIt(locatorHeaderBtnTradeNow);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);
    // act
    scrollToElement(locatorStillLookingForBrokerYouCanTrustIconUserPlus, 0, -200);
    checkingVisibilityOfBtnAndClickingIt(locatorStillLookingForBrokerYouCanTrustIconUserPlus);
    timeOut(1);
    // assert
    checkingAppearanceSingUpForm();

    takeScreenshot("data/screenshots/mainPage/checkingInSection_StillLookingForBrokerYouCanTrust_BtnTryNow.png");
  }

  @Order(18)
  @Test
  public void checkingInSection_WidgetPromoMarket_BtnTradeNow() throws IOException {
    // arrange
    HashSet tabNamesHashSet = new HashSet<>();
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);
    // act
    int totalTabs = driver.findElements(locatorWidgetPromoMarketTab).size();
    scrollToElement(locatorWidgetPromoMarketTab, 0, -300);
    while(tabNamesHashSet.size() < totalTabs) {
      String tabName = driver.findElement(locatorWidgetPromoMarketTabName).getText();
      if(!tabNamesHashSet.contains(tabName)) {
        tabNamesHashSet.add(tabName);
        checkingVisibilityOfBtnAndClickingIt(locatorWidgetPromoMarketBtnTradeNow);
        timeOut(2);
        // assert
        checkingAppearanceSingUpForm();
    }
      cursorMovementFromElementAndClick(locatorWidgetPromoMarketBtnTradeNow);
      timeOut(1);
      continue;
    }
    takeScreenshot("data/screenshots/mainPage/checkingInSection_WidgetPromoMarket_BtnTradeNow.png");
  }

  //Tests registration elements in section "Explore our platform"
  @Order(19)
  @Test
  public void checkingInSection_ExploreOurPlatform_BtnTryNow() throws IOException {
    // arrange
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);
    // act
    scrollToElement(locatorExploreOurPlatformBtnTryNow, 0, 0);
    checkingVisibilityOfBtnAndClickingIt(locatorTradingCalculatorBtnStartTrading);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
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
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);
    // act
    scrollToElement(locatorWhyChooseCapitalComBtnTryNow, 0, 0);
    checkingVisibilityOfBtnAndClickingIt(locatorWhyChooseCapitalComBtnTryNow);
    timeOut(1);
    // assert
    checkingAppearanceSingUpForm();

    takeScreenshot("data/screenshots/mainPage/checkingInSection_WhyChooseCapitalCom_BtnTryNow.png");
  }
}