package api.reqres.pojoFiles;

import java.util.HashSet;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

// ----------------------------------------------POJO----------------------------------------------------------

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "per_page",
        "total",
        "total_pages",
        "data",
        "support"
})
@Data
public class ListUsers {

  @JsonProperty("page")
  public Integer page;
  @JsonProperty("per_page")
  public Integer perPage;
  @JsonProperty("total")
  public Integer total;
  @JsonProperty("total_pages")
  public Integer totalPages;
  @JsonProperty("data")
  public List<ListUsers.Data> data;
  @JsonProperty("support")
  public Support support;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonPropertyOrder({
          "id",
          "email",
          "first_name",
          "last_name",
          "avatar"
  })
  @lombok.Data
  public static class Data {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("email")
    public String email;
    @JsonProperty("first_name")
    public String firstName;
    @JsonProperty("last_name")
    public String lastName;
    @JsonProperty("avatar")
    public String avatar;
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonPropertyOrder({
          "url",
          "text"
  })
  @lombok.Data
  public class Support {

    @JsonProperty("url")
    public String url;
    @JsonProperty("text")
    public String text;
  }

  // ----------------------------------------------Variables----------------------------------------------------------

  public static class Expected {
    // Header
    public static final int PAGE = 2;
    public static final int DR_PAGE = 1;
    public static final int PER_PAGE = 6;
    public static final int TOTAL = 12;
    public static final int TOTAL_PAGES = 2;

    // Data
    public static final Integer[] ID = {7, 8, 9, 10, 11, 12};
    public static final Integer[] DR_ID = {1, 2, 3, 4, 5, 6};
    public static final String[] EMAIL = {"michael.lawson@reqres.in", "lindsay.ferguson@reqres.in",
            "tobias.funke@reqres.in", "byron.fields@reqres.in", "george.edwards@reqres.in",
            "rachel.howell@reqres.in"};
    public static final String[] DR_EMAIL = {"george.bluth@reqres.in", "janet.weaver@reqres.in",
            "emma.wong@reqres.in", "eve.holt@reqres.in", "charles.morris@reqres.in",
            "tracey.ramos@reqres.in"};

    public static final String[] FIRST_NAME = {"Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"};
    public static final String[] DR_FIRST_NAME = {"George", "Janet", "Emma", "Eve", "Charles", "Tracey"};
    public static final String[] LAST_NAME = {"Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell"};
    public static final String[] DR_LAST_NAME = {"Bluth", "Weaver", "Wong", "Holt", "Morris", "Ramos"};
    public static final String[] AVATAR = {"https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/8-image.jpg",
            "https://reqres.in/img/faces/9-image.jpg", "https://reqres.in/img/faces/10-image.jpg",
            "https://reqres.in/img/faces/11-image.jpg" ,"https://reqres.in/img/faces/12-image.jpg"};
    public static final String[] DR_AVATAR = {"https://reqres.in/img/faces/1-image.jpg", "https://reqres.in/img/faces/2-image.jpg",
            "https://reqres.in/img/faces/3-image.jpg", "https://reqres.in/img/faces/4-image.jpg",
            "https://reqres.in/img/faces/5-image.jpg" ,"https://reqres.in/img/faces/6-image.jpg"};

    // Support
    public static final String URL = "https://reqres.in/#support-heading";
    public static final String TEXT = "To keep ReqRes free, contributions towards server costs are appreciated!";
  }

  // ----------------------------------------------Methods----------------------------------------------------------

  public static class Methods {

    public static boolean checkId (ListUsers actualResult, Integer[] id) {
      HashSet<Integer> checkedSet = new HashSet<>();
      for (int i = 0; i < actualResult.data.size(); i++) {
        for (Integer number : id) {
          if (actualResult.data.get(i).id == number) {
            checkedSet.add(actualResult.data.get(i).id);
            break;
          }
        }
      }
      return checkedSet.size() == id.length? true : false;
    }

    public static boolean checkEmail(ListUsers actualResult, String[] array) {
      HashSet<String> checkedSet = new HashSet<>();
      for (int i = 0; i < actualResult.data.size(); i++) {
        String actual = actualResult.data.get(i).email;
        for (String expected : array) {
          if (actual.toLowerCase().indexOf(expected.toLowerCase()) >= 0) {
            checkedSet.add(actual);
            break;
          }
        }
      }
      return checkedSet.size() == array.length? true : false;
    }

    public static boolean checkFirstName(ListUsers actualResult, String[] array) {
      HashSet<String> checkedSet = new HashSet<>();
      for (int i = 0; i < actualResult.data.size(); i++) {
        String actual = actualResult.data.get(i).firstName;
        for (String expected : array) {
          if (actual.toLowerCase().indexOf(expected.toLowerCase()) >= 0) {
            checkedSet.add(actual);
            break;
          }
        }
      }
      return checkedSet.size() == array.length? true : false;
    }

    public static boolean checkLastName(ListUsers actualResult, String[] array) {
      HashSet<String> checkedSet = new HashSet<>();
      for (int i = 0; i < actualResult.data.size(); i++) {
        String actual = actualResult.data.get(i).lastName;
        for (String expected : array) {
          if (actual.toLowerCase().indexOf(expected.toLowerCase()) >= 0) {
            checkedSet.add(actual);
            break;
          }
        }
      }
      return checkedSet.size() == array.length? true : false;
    }

    public static boolean checkAvatar(ListUsers actualResult, String[] array) {
      HashSet<String> checkedSet = new HashSet<>();
      for (int i = 0; i < actualResult.data.size(); i++) {
        String actual = actualResult.data.get(i).avatar;
        for (String expected : array) {
          if (actual.toLowerCase().indexOf(expected.toLowerCase()) >= 0) {
            checkedSet.add(actual);
            break;
          }
        }
      }
      return checkedSet.size() == array.length? true : false;
    }
  }

}
