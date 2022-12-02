import org.junit.jupiter.api.Test;

public class TestSearchForBugCards extends Methods {

  // Arrange
  // URL of checked section.

  // Section Forex
  String urlForex = "https://capital.com/live-currency-prices";
  // Section Indices
  String urlIndices = "https://capital.com/major-world-indices";
  // Section Commodities
  String urlCommodities = "https://capital.com/live-commodity-prices";
  // Section Cryptocurrencies
  String urlCryptocurrencies = "https://capital.com/live-cryptocurrency-prices";
  // Section Shares
  String urlShares = "https://capital.com/live-share-prices";


  // Assert
  @Test
  public void searchForCardsWithBugsInSectionForex() {
    driver.navigate().to(urlShares);
    searchCardOnPage(urlForex, filesAddressOfReportForSectionForex);
  }

  @Test
  public void searchForCardsWithBugsInSectionIndices() {
    driver.navigate().to(urlShares);
    searchCardOnPage(urlIndices, filesAddressOfReportForSectionIndices);
  }

  @Test
  public void searchForCardsWithBugsInSectionCommodities() {
    driver.navigate().to(urlShares);
    searchCardOnPage(urlCommodities, filesAddressOfReportForSectionCommodities);
  }

  @Test
  public void searchForCardsWithBugsInSectionCryptocurrencies() {
    driver.navigate().to(urlShares);
    searchCardOnPage(urlCryptocurrencies, filesAddressOfReportForSectionCryptocurrencies);
  }

  @Test
  public void searchForCardsWithBugsInSectionShares() {
    driver.navigate().to(urlShares);
    searchCardOnPage(urlShares, filesAddressOfReportForSectionShares);
  }
}