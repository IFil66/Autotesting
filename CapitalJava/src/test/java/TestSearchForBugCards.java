import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSearchForBugCards {

  static WebDriver driver;

  @BeforeAll
  static void setUP()
  {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @AfterAll
  static void tearDown()
  {
    driver.quit();
  }


  // ������ ����������� ��������
  // �������� �������� ������� �����
  String urlAddress = "https://capital.com/ru/kotirovki-aktsiy";

  // �������� �������� ������� �������
//  String urlAddress = "https://capital.com/ru/mirovyye-fondovyye-indeksy";

  // �������� �������� ������� �������� ������
//  String urlAddress = "https://capital.com/ru/tseny-na-syryo";

  // �������� �������� ������� Forex
  // String urlAddress = "https://capital.com/ru/forex";


  // ����� ����� ��������� ����������
  @Test
  public void printResultBugCards()
  {
    System.out.println(searchCardOnPage());
  }


  // ���������� ��� ����� ���� ����������� �������� �������
  String bagCards = "�������� ��������� �������� ������� ����� �������� �����:";

  // ���������� ��� �������� ����� ����������� ��������
  int totalBugCards = 0;



  //
  // ����� ������ ������ ��������� �������� � ������ �������� �������
  public int searchLastPageNumber()
  {
    // �������� ���������� ������ ��������� �������� � ������
    int lastPageNumber;

    // ������� �� �������� ��������
    driver.navigate().to(urlAddress);

    // ��������� ������ ��������� �������� ������ � ���� �����
    String lastPageNumberString = driver.findElement(By.cssSelector("ul[class='pagination'] li:nth-last-child(2)")).getText();
    lastPageNumber = Integer.parseInt (lastPageNumberString);

    // ������� ������ ��������� �������� � ������
    return lastPageNumber;
  }


    //
    // ����� ��������� ����������� �������� �� ���������
      public String searchCardOnPage()
  {
    // ����������� ����������
    // ����� �������� ������� ��� �SS-���������
    String firstPartOfName = "tbody[data-mob-deep-link] tr:nth-child(";
    String secondPartOfName = ") td p[class='stringEllipsed']";

    // ����� ���������� Sell � ������� ��� �SS-���������
    String firstPartOfAddressSell = "tbody[data-mob-deep-link] tr:nth-child(";
    String secondPartOfAddressSell = ") td[class^='sell'] a";

    // ���������� ��� �������� �������� ������� � 1 �� ��������� � ������
    int number = searchLastPageNumber();

    // ���� �������� ������� � 1 �� ��������� � ������
    for (int n = 1; n <= number; n++)
    {
      // ������� �������� �� ������ �������� ��� ������ ����������� �������� �������
      if (n == 1)
      {
        driver.navigate().to(urlAddress);
      } else {
        driver.navigate().to(urlAddress + "/" + n);
      }

      // ���������� ���������� ����� �� ����������� ��������
      var totalElementsOnPage = driver.findElements(By.cssSelector("tbody[data-mob-deep-link] tr")).size();

      // ���� �������� ����� � �������� � 1 �� ���������
      for (int i = 1; i <= totalElementsOnPage; i++)
      {
        // ��������� �������� ������ �� ������ � DOM-������
        String nameElement = driver.findElement(By.cssSelector(firstPartOfName + i + secondPartOfName)).getText();

        // ��������� ���������� Sell �� ������ � DOM-������
        String sellElement = driver.findElement(By.cssSelector(firstPartOfAddressSell + i + secondPartOfAddressSell)).getText();

        // ������� ���������, ���������� ������ � ������������� ����������� Sell. ��������� ����� ������ � �������������� ����������.
        if (sellElement.length() == 1) {
          bagCards = bagCards + "\n" + "�� �������� " + n + " ������ �������� ������ " + nameElement;
          totalBugCards++;
        }
      }
    }
    if (totalBugCards == 0){
      bagCards = "������������! ����������� �������� �� ����������.";
    } else {
      // ��������� � ����� ������� �����
      bagCards = bagCards + "\n" + "\n" + "����� ��������:  " + totalBugCards + "\n" + "���?! ����� ������ ����������?";
    }

    // ������� ��������� ���������� �� ����������� ��������� �������
    return bagCards;
  }
}
