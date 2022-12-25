import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;


public class SearchUrl extends SearchUrlMethods {
  SearchUrl searchUrlTests = new SearchUrl();

  // Variables
  // Search unique URL of capital.com pages - START (arrange)
  final String urlMainPage = "https://capital.com";

  By baseLinksLocator = By.xpath("//body//a[starts-with(@href, 'https://capital.com')]");
  By baseLinksLocator2 = By.cssSelector("body a[href^='https://capital.com']");

  By shortLinksLocator = By.xpath("//body//a[starts-with(@href, '/')]");
  By shortLinksLocator2 = By.cssSelector("body a[href^='/");
  // Search unique URL of capital.com pages - END


  // Search unique URL of Trade instrument pages - START (arrange)
  String fileAddressUrlForexSectionPages = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/urlForexSectionPages.txt";
  String fileAddressUrlIndicesSectionPages = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/urlIndicesSectionPages.txt";
  String fileAddressUrlCommoditiesSectionPages = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/urlCommoditiesSectionPages.txt";
  String fileAddressUrlCryptocurrenciesSectionPages = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/urlCryptocurrenciesSectionPages.txt";
  String fileAddressUrlSharesSectionPages = "data/com.capital_tests.testsWithCustomReport.tradingInstrumentCards_tests.registrationButtons_tests.TradingInstrumentCards/Url of trading instrument pages/urlSharesSectionPages.txt";

  String urlSectionForex = "https://capital.com/live-currency-prices";
  String urlSectionIndices = "https://capital.com/major-world-indices";
  String urlSectionCommodities = "https://capital.com/live-commodity-prices";
  String urlSectionCryptocurrencies = "https://capital.com/live-cryptocurrency-prices";
  String urlSectionShares = "https://capital.com/live-share-prices";

  static By locatorNumberOfLastPage = By.cssSelector("ul.pagination li:nth-last-child(2) a");
  static String locatorOfTableRow1 = "tr:nth-child(";
  static String locatorOfTableRow2 = ") a[data-type = 'wdg_markets_deep']";

  private int amount;


  // Search unique URL of Trade instrument pages - END


  // Search unique URL of capital.com pages - START (act)
  @Test
  public void searchUniqueUrl() {
    driver.navigate().to(urlMainPage);
    if (urlMainPage != getCurrentUrl()) {
      driver.navigate().to(urlMainPage);
    }
    parsingElementsAndCreateUniqueElementsInList2(hashUniqueLinksFromWebElements, baseLinksLocator2, shortLinksLocator2);
    updateUrlList(listUrl, hashUniqueLinksFromWebElements);
    System.out.println("На главной странице найдено уникальных ссылок: " + listUrl.size());


    // Открытие редактора файла
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(fileWithFinalUrls);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    // Для снижения количества итераций основным циклом
    for (int n = 0; n <= 1; n++) {
      // Основной цикл
      for (int i = 0; i < listUrl.size(); i++) {

          if (!hashUrlDone.contains(listUrl.get(i))) {
            driver.navigate().to(listUrl.get(i));
            timeOut(3000);
            parsingElementsAndCreateUniqueElementsInList2(hashUniqueLinksFromWebElements, baseLinksLocator2, shortLinksLocator2);

            // Для снижения количества итераций основного цикла
            if (n >= 1) {
            updateUrlList(listUrl, hashUniqueLinksFromWebElements);
            }

            amount = amount + 1;
            hashUrlDone.add(listUrl.get(i));
          }
          System.out.println("Всего найдено уникальных ссылок: " + hashUniqueLinksFromWebElements.size() + "\n" + "Количество итераций: " + amount);
          continue;
        }
      }
    updateUrlList(listUrl, hashUniqueLinksFromWebElements);

    // Записть URL в файл
    Iterator itr = hashUniqueLinksFromWebElements.iterator();
    while (itr.hasNext()) {
      writer.write(itr.next() + "\n");
    }
    writer.flush();
    writer.close();

    System.out.println("Всего найдено уникальных ссылок: " + hashUniqueLinksFromWebElements.size());
  }
  // Search unique URL of capital.com pages - END

  // Search unique URL of Trade instrument pages - START (act)
  @Test
  public void searchAllUrlTradingInstrumentCardsOfSection() {
    getUrlOfTradingInstrumentCardsAndWriteItToFile(fileAddressUrlForexSectionPages, urlSectionForex);
    getUrlOfTradingInstrumentCardsAndWriteItToFile(fileAddressUrlIndicesSectionPages, urlSectionIndices);
    getUrlOfTradingInstrumentCardsAndWriteItToFile(fileAddressUrlCommoditiesSectionPages, urlSectionCommodities);
    getUrlOfTradingInstrumentCardsAndWriteItToFile(fileAddressUrlCryptocurrenciesSectionPages, urlSectionCryptocurrencies);
    getUrlOfTradingInstrumentCardsAndWriteItToFile(fileAddressUrlSharesSectionPages, urlSectionShares);
  }
  // Search unique URL of Trade instrument pages - END
}