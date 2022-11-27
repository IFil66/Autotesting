import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;


public class SearchUrl extends Methods {

  // Variables
  final String urlMainPage = "https://capital.com";

  By baseLinksLocator = By.xpath("//body//a[starts-with(@href, 'https://capital.com')]");
  By baseLinksLocator2 = By.cssSelector("body a[href^='https://capital.com']");

  By shortLinksLocator = By.xpath("//body//a[starts-with(@href, '/')]");
  By shortLinksLocator2 = By.cssSelector("body a[href^='/");

//  By locatorBtnTradeNow = By.xpath("//*[text()[contains(.,'Trade Now')]]");


  // Локаторы кнопок и их счётчики (видимых кнопок на странице / всего кнопок на странице с таким названием)
  By cavyaLocatorBtnCreateAndVerifyYourAccount = By.xpath("//*[.='Create & verify your account']");
  By caLocatorBtnCreateAccount = By.xpath("//*[.='Create account']");
  By opLocatorBtnOpenAccount = By.xpath("//*[.='Open account']");
  By tnLocatorBtnTradeNow = By.xpath("//*[.='Trade Now']");
  By liLocatorBtnLogIn = By.xpath("//a[contains(., 'Log')]");
  By suvgLocatorBtnSignUpViaGoogle = By.xpath("//*[.='Sign up via Google']");
  By suvfLocatorBtnSignUpViaFacebook = By.xpath("//*[.='Sign up via Facebook']");
  By suvaLocatorBtnSignUpViaApple = By.xpath("//*[.='Sign up via Apple']");
  By tLocatorBtnTrade = By.xpath("//*[.='Trade']");
  By sLocatorBtnSell = By.xpath("//*[.='sell']");
  By bLocatorBtnBuy = By.xpath("//*[.='buy']");
  By stnLocatorBtnStartTradingNow = By.xpath("//*[.='Start Trading Now']");
  By stLocatorBtnStartTrading = By.xpath("//*[.=' Start trading']");
  By trynfLocatorBtnTryNow = By.xpath("//*[.='Try now']");
  By pffLocatorBtnPractiseForFree = By.xpath("//*[.='Practise for free']");
  By tfdLocatorBtnTryFreeDemo = By.xpath("//*[.='Try free demo']");
  By tdLocatorBtnTryDemo = By.xpath("//*[.='Try demo']");
  By gsLocatorBtnGetStarted = By.xpath("//*[.='Get started']");
  By aLocatorBtnApply = By.xpath("//*[.='Apply']");
  By anLocatorBtnApplyNow = By.xpath("//*[.='Apply Now']");
  By gqLocatorBtnGotQuestion = By.xpath("//*[.='Got a question?']");
  By ewpLocatorBtnExploreWebPlatform = By.xpath("//*[.='Explore Web Platform']");
  By iconUserPlusLocator = By.cssSelector("i[data-type='banner_with_steps']");
  By atfLocatorBtnAddToFavourite = By.xpath("//*[@data-type='add_fav']");

  int numberOfCircle = 1;

  @Test
  public void searchUrl() {
    driver.navigate().to(urlMainPage);
    if (urlMainPage != getCurrentUrl()) {
      driver.navigate().to(urlMainPage);
    }
    parsingElementsAndCreateUniqueElementsInList2(hashUniqueLinksFromWebElements, baseLinksLocator2, shortLinksLocator2);
    updateUrlList(listUrl,hashUniqueLinksFromWebElements);
    System.out.println("На главной странице найдено уникальных ссылок: " + listUrl.size());


    // Открытие редактора файла
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(fileWithFinalUrls);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }


    // Для снижения количества итерациий основным циклом
    for (int n = 0; n <= 1; n++) {
      // Основной цикл
      for (int i = 0; i < listUrl.size(); i++) {

          if (!hashUrlDone.contains(listUrl.get(i))) {
            driver.navigate().to(listUrl.get(i));
            timeOut(3);
            parsingElementsAndCreateUniqueElementsInList2(hashUniqueLinksFromWebElements, baseLinksLocator2, shortLinksLocator2);

            // Для снижения количества итераций основного цикла
            if (n >= 1) {
            updateUrlList(listUrl,hashUniqueLinksFromWebElements);
            }

            amount = amount + 1;
            hashUrlDone.add(listUrl.get(i));
          }
          System.out.println("Всего найдено уникальных ссылок: " + hashUniqueLinksFromWebElements.size() + "\n" + "Количество итераций: " + amount);
          continue;
        }
      }
    updateUrlList(listUrl,hashUniqueLinksFromWebElements);

    // Записть URL в файл
    Iterator itr = hashUniqueLinksFromWebElements.iterator();
    while (itr.hasNext()) {
      writer.write(itr.next() + "\n");
    }
    writer.flush();
    writer.close();

    System.out.println("Всего найдено уникальных ссылок: " + hashUniqueLinksFromWebElements.size());
  }

  // -----------------------------------------------------------------------------------------------------------------

  // Обход страниц по списку
//  @Test
//  public void searchButton() throws FileNotFoundException {
//    transferDataFromFileToList(listUrl, fileAddressWithUrls);
//
//    int cavyaVisible;
//    int cavyaTotal;
//    int caVisible;
//    int caTotal;
//    int opVisible;
//    int opTotal = 0;
//    int tnVisible = 0;
//    int tnTotal = 0;
//    int liVisible = 0;
//    int liTotal = 0;
//    int suvgVisible = 0;
//    int suvgTotal = 0;
//    int suvfVisible = 0;
//    int suvfTotal = 0;
//    int suvaVisible = 0;
//    int suvaTotal = 0;
//    int tVisible = 0;
//    int tTotal = 0;
//    int sVisible = 0;
//    int sTotal = 0;
//    int bVisible = 0;
//    int bTotal;
//    int stnVisible = 0;
//    int stnTotal = 0;
//    int stVisible = 0;
//    int stTotal = 0;
//    int trynfVisible = 0;
//    int trynfTotal = 0;
//    int pffVisible = 0;
//    int pffTotal = 0;
//    int tfdVisible = 0;
//    int tfdTotal = 0;
//    int tdVisible = 0;
//    int tdTotal = 0;
//    int gsVisible = 0;
//    int gsTotal = 0;
//    int aVisible = 0;
//    int aTotal = 0;
//    int anVisible = 0;
//    int anTotal = 0;
//    int gqVisible = 0;
//    int gqTotal = 0;
//    int ewpVisible = 0;
//    int ewpTotal = 0;
//    int iupVisible = 0;
//    int iupTotal = 0;
//    int atfVisible = 0;
//    int atfTotal = 0;
//
//
//    PrintWriter writer = new PrintWriter(fileHasFinalResult);
//    for(String url : listUrl) {
//      driver.navigate().to(url);
//      if (url != getCurrentUrl()) {
//        driver.navigate().to(url);
//      }
//      timeOut(3);
//
//      // Выявление кнопок видимых / всего
//      // 1.Create & verify your account
//      cavyaVisible = findButtonThatISVisible(cavyaLocatorBtnCreateAndVerifyYourAccount);
//      cavyaTotal = findTotalButtonOnPage(cavyaLocatorBtnCreateAndVerifyYourAccount);
//
//      // 2.Create account
//      caVisible = findButtonThatISVisible(caLocatorBtnCreateAccount);
//      caTotal = findTotalButtonOnPage(caLocatorBtnCreateAccount);
//
//      // 3.Open account
//      opVisible = findButtonThatISVisible(opLocatorBtnOpenAccount);
//      opTotal = findTotalButtonOnPage(opLocatorBtnOpenAccount);
//
//      // 4.Trade Now
//      tnVisible = findButtonThatISVisible(tnLocatorBtnTradeNow);
//      tnTotal = findTotalButtonOnPage(tnLocatorBtnTradeNow);
//
//      // 5.Log in
//      liVisible = findButtonThatISVisible(liLocatorBtnLogIn);
//      liTotal = findButtonThatISVisible(liLocatorBtnLogIn);
//
//      // 6.Log in/ Sign up via Google (в форме регистрации/авторизации)
//      suvgVisible= findButtonThatISVisible(suvgLocatorBtnSignUpViaGoogle);
//      suvgTotal = findTotalButtonOnPage(suvgLocatorBtnSignUpViaGoogle);
//
//      // 7.Log in/ Sign up via Facebook  (в форме регистрации/авторизации)
//      suvfVisible = findButtonThatISVisible(suvfLocatorBtnSignUpViaFacebook);
//      suvfTotal = findTotalButtonOnPage(suvfLocatorBtnSignUpViaFacebook);
//
//      // 8.Log in/ Sign up via Apple  (в форме регистрации/авторизации)
//      suvaVisible = findButtonThatISVisible(suvaLocatorBtnSignUpViaApple);
//      suvaTotal = findTotalButtonOnPage(suvaLocatorBtnSignUpViaApple);
//
//      // 9.Trade
//      tVisible = findButtonThatISVisible(tLocatorBtnTrade);
//      tTotal = findTotalButtonOnPage(tLocatorBtnTrade);
//
//      // 10.Sell
//      sVisible = findButtonThatISVisible(sLocatorBtnSell);
//      sTotal = findTotalButtonOnPage(sLocatorBtnSell);
//
//      // 11.Buy
//      bVisible = findButtonThatISVisible(bLocatorBtnBuy);
//      bTotal = findTotalButtonOnPage(bLocatorBtnBuy);
//
//      // 12.Start Trading Now
//      stnVisible = findButtonThatISVisible(stnLocatorBtnStartTradingNow);
//      stnTotal = findTotalButtonOnPage(stnLocatorBtnStartTradingNow);
//
//      // 13.Start trading
//     stVisible = findButtonThatISVisible(stLocatorBtnStartTrading);
//      stTotal = findTotalButtonOnPage(stLocatorBtnStartTrading);
//
//      // 14.Try now
//      trynfVisible = findButtonThatISVisible(trynfLocatorBtnTryNow);
//      trynfTotal = findTotalButtonOnPage(trynfLocatorBtnTryNow);
//
//      // 15.Practise for free
//      pffVisible = findButtonThatISVisible(pffLocatorBtnPractiseForFree);
//      pffTotal = findTotalButtonOnPage(pffLocatorBtnPractiseForFree);
//
//      // 16.Try free demo
//      tfdVisible = findButtonThatISVisible(tfdLocatorBtnTryFreeDemo);
//      tfdTotal = findTotalButtonOnPage(tfdLocatorBtnTryFreeDemo);
//
//      // 17.Try demo
//      tdVisible = findButtonThatISVisible(tdLocatorBtnTryDemo);
//      tdTotal = findTotalButtonOnPage(tdLocatorBtnTryDemo);
//
//      // 18.Get started
//      gsVisible = findButtonThatISVisible(gsLocatorBtnGetStarted);
//      gsTotal = findTotalButtonOnPage(gsLocatorBtnGetStarted);
//
//      // 19.Apply
//      aVisible = findButtonThatISVisible(aLocatorBtnApply);
//      aTotal = findTotalButtonOnPage(aLocatorBtnApply);
//
//      // 20.Apply Now
//      anVisible = findButtonThatISVisible(anLocatorBtnApplyNow);
//      anTotal = findTotalButtonOnPage(anLocatorBtnApplyNow);
//
//      // 21.Got a question?
//      gqVisible = findButtonThatISVisible(gqLocatorBtnGotQuestion);
//      gqTotal = findTotalButtonOnPage(gqLocatorBtnGotQuestion);
//
//      // 22.Explore Web Platform
//      ewpVisible = findButtonThatISVisible(ewpLocatorBtnExploreWebPlatform);
//      ewpTotal = findTotalButtonOnPage(ewpLocatorBtnExploreWebPlatform);
//
//      // 23. icon User Plus
//      iupVisible = findButtonThatISVisible(iconUserPlusLocator);
//      iupTotal = findTotalButtonOnPage(iconUserPlusLocator);
//
//      // 24. Add to favourite
//      atfVisible = findButtonThatISVisible(atfLocatorBtnAddToFavourite);
//      atfTotal = findTotalButtonOnPage(atfLocatorBtnAddToFavourite);
//
//      System.out.println("Поиск элементов в цикле номер " + numberOfCircle + " окончен");
//
//      String lineText = "\n"
//              + numberOfCircle + "\t" + url + "\t" + " " + cavyaVisible + "/" + cavyaTotal
//              + "\t" + " " + caVisible + "/" + caTotal + "\t" + " " + opVisible + "/" + opTotal
//              + "\t" + " " + tnVisible + "/" + tnTotal + "\t" + " " + liVisible + "/" + liTotal
//              + "\t" + " " + suvgVisible + "/" + suvgTotal +"\t" + " " + suvfVisible + "/" + suvfTotal
//              + "\t" + " " + suvaVisible + "/" + suvaTotal +"\t" + " " + tVisible + "/" + tTotal
//              + "\t" + " " + sVisible + "/" + sTotal +"\t" + " " + bVisible + "/" + bTotal
//              + "\t" + " " + stnVisible + "/" + stnTotal +"\t" + " " + stVisible + "/" + stTotal
//              + "\t" + " " + trynfVisible + "/" + trynfTotal +"\t" + " " + pffVisible + "/" + pffTotal
//              + "\t" + " " + tfdVisible + "/" + tfdTotal +"\t" + " " + tdVisible + "/" + tdTotal
//              + "\t" + " " + gsVisible + "/" + gsTotal +"\t" + " " + aVisible + "/" + aTotal
//              + "\t" + " " + anVisible + "/" + anTotal +"\t" + " " + gqVisible + "/" + gqTotal
//              + "\t" + " " + ewpVisible + "/" + ewpTotal +"\t" + " " + iupVisible + "/" + iupTotal
//              + "\t" + " " + atfVisible + "/" + atfTotal;
//      System.out.println(lineText);
//      writer.write(lineText + "\n");
//
//      System.out.println("Цикл номер " + numberOfCircle + " окончен");
//
//      numberOfCircle = numberOfCircle + 1;
//    }
//    writer.flush();
//    writer.close();
//  }
}