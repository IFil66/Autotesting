import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
              + locatorXPathWidgetMarketBtnTrade1_2 + number + locatorXPathWidgetMarketBtnTrade1_3), 0, 0);
      checkingAppearanceSingUpForm();
    }
  }

  // Locators second option
  String codeName = "";
  String locatorNumberOfElements1 = "div.ihome-";
  String locatorNumberOfElements2 = " div.tools__item";
  String locatorTradingInstrumentWidgetTabs2_1 = "a[data-type = '";
  String locatorTradingInstrumentWidgetTabs2_2 = "']";
  String locatorTradingInstrumentWidgetBtnTrade2_1 = "div.ihome-";
  String locatorTradingInstrumentWidgetBtnTrade2_2 = " div.tools__item:nth-child(";
  String locatorTradingInstrumentWidgetBtnTrade2_3 = ") a.tools__btn";

  String expectedURLResultWidgetMarketBtnTrade = "https://capitalcom.onelink.me/700515151?af_dp=https%3A%2F%2Fcapital.com%2Finstrument%3Fid%3D427748677997764&&cp_device_id=";

  public void checkingAllItemOnTab2 (String codeName) {
    for (int number = 1; number <= countNumberOfElements(codeName); number++) {
      checkingVisibilityOfBtnAndClickingIt(By.cssSelector(
              locatorTradingInstrumentWidgetBtnTrade2_1 + codeName
                      + locatorTradingInstrumentWidgetBtnTrade2_2 + number + locatorTradingInstrumentWidgetBtnTrade2_3));
      Assertions.assertEquals(expectedURLResultWidgetMarketBtnTrade,
              getUrlOfLink(locatorNewToTradingBtnPractiseForFree), "URL doesn't match expected result");
    }
  }

  public int countNumberOfElements(String codeName) {
    return driver.findElements(By.cssSelector(locatorNumberOfElements1
            + codeName + locatorNumberOfElements2)).size();
  }
  // Widget market - END

  // Section "Still looking for a broker you can trust?" - START
    By locatorIconUserPlus = By.cssSelector("i[data-type = 'banner_with_steps']");
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
  @Test
  public void checkingIn_PageHeader_BtnLogIn() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);

    checkingVisibilityOfBtnAndClickingIt(locatorHeaderBtnLogIn);
    timeOut(1);

    checkingAppearanceLoginForm();
  }

  @Test
  public void checkingIn_PageHeader_BtnTradeNow() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);

    checkingVisibilityOfBtnAndClickingIt(locatorHeaderBtnTradeNow);
    timeOut(1);

    checkingAppearanceSingUpForm();
  }

  //Tests registration elements in section Main banner
  @Test
  public void checkingInSection_MainBannerTabOne_BtnOpenAccount() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);

    driver.findElement(locatorMainBannerBtnOne).click();
    checkingVisibilityOfBtnAndClickingIt(locatorMainBannerSlideOneBtnToSignUp);
    timeOut(1);

    checkingAppearanceSingUpForm();
  }

  @Test
  public void checkingInSection_MainBannerTabThree_BtnStartTrading() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);

    driver.findElement(locatorMainBannerBtnThree).click();
    checkingVisibilityOfBtnAndClickingIt(locatorMainBannersSlideThreeBtnStartTrading);
    timeOut(1);

    checkingAppearanceSingUpForm();
  }

  //Tests registration elements in section "Trading instrument widget"
  // Tests first option
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabMostTraded_BtnsTrade1() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabMostTraded1);
    checkingAllItemOnTabOption1("mtr");
  }

  @Test
  public void checkingInSection_TradingInstrumentWidgetTabCommodities_BtnsTrade1() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabCommodities1);
    checkingAllItemOnTabOption1("com");
  }

  @Test
  public void checkingInSection_TradingInstrumentWidgetTabIndices_BtnsTrade1() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabIndices1);
    checkingAllItemOnTabOption1("ind");
  }

  @Test
  public void checkingInSection_TradingInstrumentWidgetTabShares_BtnsTrade1() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabShares1);
    checkingAllItemOnTabOption1("shar");
  }

  @Test
  public void checkingInSection_TradingInstrumentWidgetTabForex_BtnsTrade1() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabForex1);
    checkingAllItemOnTabOption1("fx");
  }

  @Test
  public void checkingInSection_TradingInstrumentWidgetTabETFs_BtnsTrade1() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingVisibilityOfBtnAndClickingIt(locatorTradingInstrumentWidgetTabETFs1);
    checkingAllItemOnTabOption1("etf");
  }

  // Tests second option
  @Test
  public void checkingInSection_TradingInstrumentWidgetTabMostTraded_BtnsTrade2() {
    codeName = "Most";
    countNumberOfElements(codeName);

    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingAllItemOnTab2(codeName);
  }

  @Test
  public void checkingInSection_TradingInstrumentWidgetTabCommodities_BtnsTrade2() {
    codeName = "com";
    countNumberOfElements(codeName);

    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingAllItemOnTab2(codeName);
  }

  @Test
  public void checkingInSection_TradingInstrumentWidgetTabIndices_BtnsTrade2() {
    codeName = "com";
    countNumberOfElements(codeName);

    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingAllItemOnTab2(codeName);
  }

  @Test
  public void checkingInSection_TradingInstrumentWidgetTabShares_BtnsTrade2() {
    codeName = "com";
    countNumberOfElements(codeName);

    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingAllItemOnTab2(codeName);
  }

  @Test
  public void checkingInSection_TradingInstrumentWidgetTabForex_BtnsTrade2() {
    codeName = "com";
    countNumberOfElements(codeName);

    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingAllItemOnTab2(codeName);
  }

  @Test
  public void checkingInSection_TradingInstrumentWidgetTabETFs_BtnsTrade2() {
    codeName = "com";
    countNumberOfElements(codeName);

    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    checkingAllItemOnTab2(codeName);
  }

  //Tests registration elements in section "Widget promo market"
  @Test
  public void checkingInSection_WidgetPromoMarket_BtnTradeNow() {
    HashSet tabNamesHashSet = new HashSet<>();
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);

    int totalTabs = driver.findElements(locatorWidgetPromoMarketTab).size();
    scrollToElement(locatorWidgetPromoMarketBtnTradeNow, 0, -300);
    while(tabNamesHashSet.size() < totalTabs) {
      String tabName = driver.findElement(locatorWidgetPromoMarketTabName).getText();
      if(!tabNamesHashSet.contains(tabName)) {
        tabNamesHashSet.add(tabName);
        checkingVisibilityOfBtnAndClickingIt(locatorWidgetPromoMarketBtnTradeNow);
        timeOut(1);
        checkingAppearanceSingUpForm();
    }
      cursorMovementFromElementAndClick(locatorWidgetPromoMarketBtnTradeNow);
      timeOut(1);
      continue;
    }
  }

  //Tests registration elements in section "Explore our platform"
  @Test
  public void checkingInSection_ExploreOurPlatform_BtnTryNow() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);
    scrollToElement(locatorExploreOurPlatformBtnTryNow, 0, 0);

    checkingVisibilityOfBtnAndClickingIt(locatorExploreOurPlatformBtnTryNow);
    timeOut(1);
    checkingAppearanceSingUpForm();
//    Assertions.assertEquals(getUrlOfLink(locatorExploreOurPlatformBtnTryNow), "URL doesn't match expected result");
  }

  //Tests registration elements in section "New to trading?"
  @Test
  public void checkingInSection_NewToTrading_BtnPractiseForFree() {
    goToPageAndCheckingUrl(urlMainPage);
    Assertions.assertEquals(expectedUrlResultNewToTradingBtnPractiseForFree,
            getUrlOfLink(locatorNewToTradingBtnPractiseForFree), "URL doesn't match expected result");
  }

  //Tests registration elements in section "Trading calculator"
  @Test
  public void checkingInSection_TradingCalculator_BtnStartTrading() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);
    scrollToElement(locatorExploreOurPlatformBtnTryNow, 0, 0);
    checkingVisibilityOfBtnAndClickingIt(locatorTradingCalculatorBtnStartTrading);
    checkingAppearanceSingUpForm();
  }

  //Tests registration elements in section "Trader's Dashboard"
  @Test
  public void checkingInSection_TradersDashboard_BtnsTrade() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);
    scrollToElement(locatorTradersDashboard, 0, 0);
    int numberOfElements = driver.findElements(locatorTradersDashboard).size();
    for (int i = 1; i <= numberOfElements; i++) {
      checkingVisibilityOfBtnAndClickingIt(By.cssSelector(locatorTradersDashboardBtnTrad1 + i + locatorTradersDashboardBtnTrad2));
      timeOut(1);
      checkingAppearanceSingUpForm();
    }
  }

  //Tests registration elements in section "Why choose Capital.com? Our numbers speak for themselves"
  @Test
  public void checkingInSection_WhyChooseCapitalCom_BtnTryNow() {
    goToPageAndCheckingUrl(urlMainPage);
    checkLicense(locatorBtnLicenseMenu, nameLicenseFCA, locatorBtnLicenseOfFCA);
    timeOut(1);
    scrollToElement(locatorWhyChooseCapitalComBtnTryNow, 0, 0);
    checkingVisibilityOfBtnAndClickingIt(locatorWhyChooseCapitalComBtnTryNow);
    timeOut(1);
    checkingAppearanceSingUpForm();
  }
}
