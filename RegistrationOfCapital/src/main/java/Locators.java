import org.openqa.selenium.By;

public class Locators {

  // Login form
  static final By loginFormH1 = By.cssSelector("#l_overlay div.h1");
  static final By loginFormFieldEmail = By.cssSelector("#l_overlay input[type = 'email']");
  static final By loginFormFieldPassword = By.cssSelector("#l_overlay input[type = 'password']");
  static final By loginFormBtnCancel = By.cssSelector("#l_overlay button.button-cleared");

  // Sign up form
  static final By signUpFormH1 = By.cssSelector("#s_overlay div.h1");
  static final By signUpFormFieldEmail = By.cssSelector("#s_overlay input[type = 'email']");
  static final By signUpFormFieldPassword = By.cssSelector("#s_overlay input[type = 'password']");
  static final By signUpFormBtnCancel = By.cssSelector("#s_overlay button.button-cleared");


  // Header of all pages
  static final By headerBtnLogIn = By.cssSelector("#wg_loginBtn");
  static final By headerBtnTradeNow = By.cssSelector("a[data-type = 'btn_header']");

  // License
  static final By licenseBtnMenu = By.cssSelector("button.cc-toggleLicense__btn");
  static final By licenseBtnASIC = By.xpath("//a[contains(@href, 'license')] [contains(., 'ASIC')]");
  static final String licenseNameASIC = "Capital Com Australia Pty Ltd";
  static final By licenseBtnFCA = By.xpath("//a[contains(@href, 'license')] [contains(., 'FCA')]");
  static final String licenseNameFCA = "Capital Com UK Limited";
  static final By licenseBtnCYSEC = By.xpath("//a[contains(@href, 'license')] [contains(., 'CYSEC')]");
  static final String licenseNameCYSEC = "Capital Com SV Investments Limited";
  static final By licenseBtnNBRB = By.xpath("//a[contains(@href, 'license')] [contains(., 'NBRB')]");
  static final String licenseNameNBRB = "Capital Com Bel";
  static final By licenseBtnForex = By.xpath("//a[contains(@href, 'license')] [contains(., 'Forex')]");
  static final String licenseNameForex = "Smart Forex Broker LLC";
  static final By licenseBtnFSA = By.xpath("//a[contains(@href, 'license')] [contains(., 'FSA')]");
  static final String licenseNameFSA = "Capital Com Stock and CFD Investing Ltd";

  // Module Widget “Promo Market”
  static final By moduleWidgetPromoMarketTab = By.cssSelector("div.cc-sliderFade__item");
  static final By moduleWidgetPromoMarketTabName = By.cssSelector("div.cc-sliderFade__item.active strong");
  static final By moduleWidgetPromoMarketBtnTradeNow = By.cssSelector("div.cc-sliderFade__item.active div.hideXs.btn");

  // Module "Trading calculator"
  static final By moduleTradingCalculatorBtnStartTrading = By.cssSelector("div[data-type = 'btn_calculator']");

  // Module "Still looking for a broker you can trust?" - START
  static final By moduleStillLookingForBrokerYouCanTrustIconUserPlus = By.cssSelector("i[data-type = 'banner_with_steps']");

  // Module "Why choose Capital.com? Our numbers speak for themselves."
  static final By moduleWhyChooseCapitalComBtnTryNow = By.cssSelector("a[data-type *= 'banner_with_counter_hor_counter_hor']");
}
