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
  String addressOfUrlFileFromSectionCryptocurrencies = "data/TradingInstrumentCards/Url of trading instrument pages/Done page URL/cryptocurrenciesPagesURL.txt";
  String addressOfUrlFileFromSectionShares = "data/TradingInstrumentCards/Url of trading instrument pages/Done page URL/sharesPagesURL.txt";

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
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,addressOfUrlFileFromSectionForex);
    goToPageAndCheckUrl(urlList.get(0));
    cookiesAcceptConsent();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfReportFileSectionForex);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
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
  public void checkingRegistrationBtnInSectionIndices() {
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,addressOfUrlFileFromSectionIndices);
    goToPageAndCheckUrl(urlList.get(0));
    cookiesAcceptConsent();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfReportFileSectionIndices);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
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


  @Test
  public void checkingRegistrationBtnInSectionCommodities() {
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,addressOfUrlFileFromSectionCommodities);
    goToPageAndCheckUrl(urlList.get(0));
    cookiesAcceptConsent();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfReportFileSectionCommodities);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
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

  @Test
  public void checkingRegistrationBtnInSectionCryptocurrencies() {
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,addressOfUrlFileFromSectionCommodities);
    goToPageAndCheckUrl(urlList.get(0));
    cookiesAcceptConsent();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfReportFileSectionCryptocurrencies);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
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

  @Test
  public void checkingRegistrationBtnInSectionShares() {
    ArrayList<String> urlList = new ArrayList<>();
    transferDataFromFileToList(urlList,addressOfUrlFileFromSectionShares);
    goToPageAndCheckUrl(urlList.get(0));
    cookiesAcceptConsent();
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(addressOfReportFileSectionShares);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
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