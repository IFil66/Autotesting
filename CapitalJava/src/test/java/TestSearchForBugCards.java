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


  // Адреса проверяемых разделов
  // Страница проверки раздела Акции
  String urlAddress = "https://capital.com/ru/kotirovki-aktsiy";

  // Страница проверки раздела Индексы
//  String urlAddress = "https://capital.com/ru/mirovyye-fondovyye-indeksy";

  // Страница проверки раздела Сырьевые товары
//  String urlAddress = "https://capital.com/ru/tseny-na-syryo";

  // Страница проверки раздела Forex
  // String urlAddress = "https://capital.com/ru/forex";


  // Метод вывод итогового результата
  @Test
  public void printResultBugCards()
  {
    System.out.println(searchCardOnPage());
  }


  // Переменная для сбора всех бракованных карточек товаров
  String bagCards = "Карточки следующих биржевых товаров имеют признаки брака:";

  // Переменная для подсчёта Итого бракованных карточек
  int totalBugCards = 0;



  //
  // Метод поиска номера последней страницы в выдаче биржевых товаров
  public int searchLastPageNumber()
  {
    // Создание переменной номера последней страницы в выдаче
    int lastPageNumber;

    // Переход на страницу проверки
    driver.navigate().to(urlAddress);

    // Получение номера последней страницы выдаче в виде цифры
    String lastPageNumberString = driver.findElement(By.cssSelector("ul[class='pagination'] li:nth-last-child(2)")).getText();
    lastPageNumber = Integer.parseInt (lastPageNumberString);

    // Возврат номера последней страницы в выдаче
    return lastPageNumber;
  }


    //
    // Метод выявления бракованных карточек на страницах
      public String searchCardOnPage()
  {
    // Технические переменные
    // Адрес названий товаров для СSS-селектора
    String firstPartOfName = "tbody[data-mob-deep-link] tr:nth-child(";
    String secondPartOfName = ") td p[class='stringEllipsed']";

    // Адрес показателя Sell у товаров для СSS-селектора
    String firstPartOfAddressSell = "tbody[data-mob-deep-link] tr:nth-child(";
    String secondPartOfAddressSell = ") td[class^='sell'] a";

    // Переменная для счётчика перебора страниц с 1 до последней в выдаче
    int number = searchLastPageNumber();

    // Цикл перебора страниц с 1 до последней в выдаче
    for (int n = 1; n <= number; n++)
    {
      // Условие перехода на нужную страницу для поиска бракованных карточек товаров
      if (n == 1)
      {
        driver.navigate().to(urlAddress);
      } else {
        driver.navigate().to(urlAddress + "/" + n);
      }

      // Вычисление количества строк на исследуемой странице
      var totalElementsOnPage = driver.findElements(By.cssSelector("tbody[data-mob-deep-link] tr")).size();

      // Цикл перебора строк с товарами с 1 по последнюю
      for (int i = 1; i <= totalElementsOnPage; i++)
      {
        // Получение названия товара из ячейки в DOM-дереве
        String nameElement = driver.findElement(By.cssSelector(firstPartOfName + i + secondPartOfName)).getText();

        // Получение показателя Sell из ячейки в DOM-дереве
        String sellElement = driver.findElement(By.cssSelector(firstPartOfAddressSell + i + secondPartOfAddressSell)).getText();

        // Условие сравнения, выявляющее товары с отсутствующим показателем Sell. Добавляет такие товары в результирующую переменную.
        if (sellElement.length() == 1) {
          bagCards = bagCards + "\n" + "На странице " + n + " выдачи карточка товара " + nameElement;
          totalBugCards++;
        }
      }
    }
    if (totalBugCards == 0){
      bagCards = "Замечательно! Бракованных карточек не обнаружено.";
    } else {
      // Включение в отчёт стороки Итого
      bagCards = bagCards + "\n" + "\n" + "Итого карточек:  " + totalBugCards + "\n" + "Как?! Опять писать багрепорты?";
    }

    // Возврат итогового результата по бракованным карточкам товаров
    return bagCards;
  }
}
