import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TradingInstrumentCards extends Methods{

  String reportFile = "";

  // Files with URL lists
  String addressOfUrlFileFromSectionForex = "data/TradingInstrumentCards/Url of trading instrument pages/Done page URL/forexPagesURL.txt";
  String addressOfUrlFileFromSectionIndices = "data/TradingInstrumentCards/Url of trading instrument pages/Done page URL/indicesPagesURL.txt";
  String addressOfUrlFileFromSectionCommodities = "data/TradingInstrumentCards/Url of trading instrument pages/Done page URL/commoditiesPagesURL.txt";
  String addressOfUrlFileFromSectionCryptocurrencies = "data/TradingInstrumentCards/Url of trading instrument pages/Done page URL/cryptocurrenciesPagesURL1.txt";
  String addressOfUrlFileFromSectionShares = "data/TradingInstrumentCards/Url of trading instrument pages/Done page URL/sharesPagesURL1.txt";

  // Files with report about checking trading instrument card
  String addressOfReportFileSectionForex = "data/TradingInstrumentCards/Url of trading instrument pages/Result reports/Report (Forex).txt";
  String addressOfReportFileSectionIndices = "data/TradingInstrumentCards/Url of trading instrument pages/Result reports/Report (Indices).txt";
  String addressOfReportFileSectionCommodities = "data/TradingInstrumentCards/Url of trading instrument pages/Result reports/Report (Commodities).txt";
  String addressOfReportFileSectionCryptocurrencies = "data/TradingInstrumentCards/Url of trading instrument pages/Result reports/Report (Cryptocurrencies).txt";
  String addressOfReportFileSectionShares = "data/TradingInstrumentCards/Url of trading instrument pages/Result reports/Report (Shares).txt";

  // --arrange
  // Header
  // here used locators of buttons "Log in" and "Trade now" from class "Locators"

  // Section "Trading instrument name pane"
  static By locatorTradingInstrumentNamePanelBtnAddToFavourite = By.cssSelector("a[data-type = 'add_fav']");

  // Section "Widget"
  static By locatorWidgetBtnBell = By.cssSelector("a[data-type = 'market_alerts']");
  static By locatorWidgetBtnViewDetailedChart = By.cssSelector("a[data-type = 'detailed_chart']");
  static By locatorWidgetBtnSell = By.cssSelector("a[data-type = 'market_sell']");
  static By locatorWidgetBtnBuy = By.cssSelector("a[data-type = 'market_buy']");
  static By locatorWidgetBtnCreateAccount = By.cssSelector("div.sharesName__notTrading a");

  // Section "Why choose Capital.com? Our numbers speak for themselves"
  // here used locator of button "Try now" from class "Locators"

  // Section "Trading calculator"
  // here used locator of button "Start trading" from class "Locators"

  // Section Widget “Promo Market”
  // here used locators of buttons "Trade Now" from class "Locators". Total buttons - 4 item.

  // Section "Still looking for a broker you can trust?"
  // here used locator of button "user plus" from class "Locators"

  // --act

  @Test
  public void checkingRegistrationBtnInSectionForex() {
    driver.navigate().to("https://capital.com/eur-usd-rate");
    timeOut(40000);
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfReportFileSectionForex);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,addressOfUrlFileFromSectionForex);
    for(String urlPage : urlList) {
      goToPageAndCheckUrl(urlPage);
      checkLicense(Locators.licenseNameFCA, Locators.licenseBtnFCA);
      reportFile = reportFile + checkingAllRegistrationBtnOnPage() + "\n";
    }
    writer.write(reportFile);
    writer.flush();
    writer.close();
    System.out.println(reportFile);
  }

  @Test
  public void checkingRegistrationBtnInSectionCryptocurrencies() {
    driver.navigate().to("https://capital.com/btc-usd-chart");
    timeOut(40000);
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfReportFileSectionCryptocurrencies);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,addressOfUrlFileFromSectionCryptocurrencies);
    for(String urlPage : urlList) {
      goToPageAndCheckUrl(urlPage);
      checkLicense(Locators.licenseNameCYSEC, Locators.licenseBtnCYSEC);
      reportFile = reportFile + checkingAllRegistrationBtnOnPage() + "\n";
    }
    writer.write(reportFile);
    writer.flush();
    writer.close();
    System.out.println(reportFile);
  }







}