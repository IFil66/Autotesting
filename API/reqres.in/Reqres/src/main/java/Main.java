import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
  public static void main(String[] args) {
    Cat cat = new Cat("Vasia");



//    System.out.println("Текущая дата - " + Cat.checkDateAndTime());

    System.out.println("Old - 2023-01-23T08:56:27.551Z" + " New - " + Cat.timeOk("2023-01-23T05:56:27.551Z"));

  }
}
