package api.reqres.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Create {

  @Data
  public class Request {

    @JsonProperty("name")
    public String name;

    @JsonProperty("job")
    public String job;
  }

  public static class Response {

    @JsonProperty("name")
    public String name;

    @JsonProperty("job")
    public String job;

    @JsonProperty("id")
    public String id;

    @JsonProperty("createdAt")
    public String createdAt;
  }

  // ----------------------------------------------Methods----------------------------------------------------------

  public static class Methods {

    public static String dateAndTimeFormat (String dateAndTime) {
      String newDateAndTime = "";
      for (int i = 0; i < 16; i++) {
        newDateAndTime = newDateAndTime + String.valueOf(dateAndTime.charAt(i));
      }
      return newDateAndTime;
    }


    public static String timeOk() {
      Date dateAndTime = new Date();
      SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm");
      String dateAndTimeNow = formatForDateNow.format(dateAndTime);

      int variable = Integer.parseInt (String.valueOf(dateAndTimeNow.charAt(11))
              + String.valueOf(dateAndTimeNow.charAt(12)));
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

      for (int i = 0; i < dateAndTimeNow.length(); i++ ) {
        switch (i) {
          case (11): {
            newDateAndTime = newDateAndTime + newVariable;
            continue;
          }
          case (12): {
            continue;
          }
        }
        newDateAndTime = newDateAndTime + String.valueOf(dateAndTimeNow.charAt(i));
      }
      return newDateAndTime;
    }
  }


}
