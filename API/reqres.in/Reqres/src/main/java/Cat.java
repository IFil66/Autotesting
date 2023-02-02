import java.text.SimpleDateFormat;
import java.util.Date;

public class Cat {
  private String name;
  public static int catCount;

  public Cat(String name) {
    this.name = name;
    Cat.catCount++;
  }

  public static String multiply(String text) {
    String result = "";
    int i = 0;
    while (i <= 5) {
      result = result + text;
      i++;
    }
    return result;
  }

  public static String multiply(String text, int count) {
    String result = "";
    for (int i = 0; i <= count; i++) {
      result = result + text;
    }
    return result;
  }

  public static String checkDateAndTime() {
    String message = "Ok";
    String updatedAt = "2023-01-23T08:56:27.551Z";
    Date dateNow = new Date();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm");
    String dateAndTime = formatForDateNow.format(dateNow);




    for (int i = 0; i < dateAndTime.length(); i++) {
      System.out.println("Actual - " + updatedAt + " Expected - " + dateAndTime);
      System.out.println("Actual - " + updatedAt.charAt(i) + " Expected - " + dateAndTime.charAt(i));
      if (updatedAt.charAt(i) != dateAndTime.charAt(i)) {
        message = "Bad";
        return message;
      }
    }
    return message;
  }

  public static String timeOk(String dateAndTime) {

    int variable = Integer.parseInt (String.valueOf(dateAndTime.charAt(11))
            + String.valueOf(dateAndTime.charAt(12)));
    int timeDifferenceWithServer = 5;
    String newVariable;
    String newDateAndTime = "";

    variable = variable - timeDifferenceWithServer;
    if (variable < 0) {
      variable = variable + 24;

    }
    if (variable < 10) {
      newVariable = "0" + String.valueOf(variable);
    }
    else {
      newVariable = String.valueOf(variable);
    }

    for (int i = 0; i < dateAndTime.length(); i++ ) {
      switch (i) {
        case (11): {
          newDateAndTime = newDateAndTime + newVariable;
          continue;
        }
        case (12): {
          continue;
        }
      }
      newDateAndTime = newDateAndTime + String.valueOf(dateAndTime.charAt(i));
    }
    return newDateAndTime;
  }




}
