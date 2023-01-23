package api.reqres.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.HashSet;
import java.util.List;

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
public class ListResource {

  @JsonProperty("page")
  public Integer page;
  @JsonProperty("per_page")
  public Integer perPage;
  @JsonProperty("total")
  public Integer total;
  @JsonProperty("total_pages")
  public Integer totalPages;
  @JsonProperty("data")
  public List<ListResource.Data> data;
  @JsonProperty("support")
  public ListResource.Support support;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonPropertyOrder({
          "id",
          "name",
          "year",
          "color",
          "pantone_value"
  })
  @lombok.Data
  public static class Data {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("year")
    public Integer year;
    @JsonProperty("color")
    public String color;
    @JsonProperty("pantone_value")
    public String pantoneValue;

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
    public static final int PAGE = 1;
    public static final int PER_PAGE = 6;
    public static final int TOTAL = 12;
    public static final int TOTAL_PAGES = 2;

    // Data
    public static final Integer[] ID = {1, 2, 3, 4, 5, 6};
    public static final String[] NAME = {"cerulean", "fuchsia rose", "true red", "aqua sky",
            "tigerlily", "blue turquoise"};
    public static final Integer[] YEAR = {2000, 2001, 2002, 2003, 2004, 2005};
    public static final String[] COLOR = {"#98B2D1", "#C74375", "#BF1932", "#7BC4C4",
            "#E2583E", "#53B0AE"};
    public static final String[] PANTONE_VALUE = {"15-4020", "17-2031", "19-1664",
            "14-4811", "17-1456" ,"15-5217"};

    // Support
    public static final String URL = "https://reqres.in/#support-heading";
    public static final String TEXT = "To keep ReqRes free, contributions towards server costs are appreciated!";
  }

  // ----------------------------------------------Methods----------------------------------------------------------

  public static class Methods {

    public static boolean checkId (ListResource actualResult) {
      HashSet<Integer> checkedSet = new HashSet<>();
      for (int i = 0; i < actualResult.data.size(); i++) {
        System.out.println("AR - " + actualResult.data.get(i).id + " ER - " + Expected.ID[i]);
        if (actualResult.data.get(i).id == Expected.ID[i]) {
          checkedSet.add(actualResult.data.get(i).id);
        }
      }
      return checkedSet.size() == Expected.ID.length? true : false;
    }

    public static boolean checkName(ListResource actualResult) {
      HashSet<String> checkedSet = new HashSet<>();
      for (int i = 0; i < actualResult.data.size(); i++) {
        String actual = actualResult.data.get(i).name;
        System.out.println("AR - " + actualResult.data.get(i).name + " ER - " + Expected.NAME[i]);
        if (actual.toLowerCase().indexOf(Expected.NAME[i].toLowerCase()) >= 0) {
          checkedSet.add(actual);
        }
      }
      return checkedSet.size() == Expected.NAME.length? true : false;
    }

    public static boolean checkYear (ListResource actualResult) {
      HashSet<Integer> checkedSet = new HashSet<>();
      for (int i = 0; i < actualResult.data.size(); i++) {
        System.out.println("AR - " + actualResult.data.get(i).year + " ER1 - " + Expected.YEAR[i]);
        if ((String.valueOf(actualResult.data.get(i).year).indexOf(String.valueOf(Expected.YEAR[i])) >= 0)) {
          checkedSet.add(actualResult.data.get(i).year);
        }
      }
      return checkedSet.size() == Expected.YEAR.length? true : false;
    }

    public static boolean checkColor(ListResource actualResult) {
      HashSet<String> checkedSet = new HashSet<>();
      for (int i = 0; i < actualResult.data.size(); i++) {
        String actual = actualResult.data.get(i).color;
        System.out.println("AR - " + actualResult.data.get(i).color + " ER - " + Expected.COLOR[i]);
        if (actual.toLowerCase().indexOf(Expected.COLOR[i].toLowerCase()) >= 0) {
          checkedSet.add(actual);
        }
      }
      return checkedSet.size() == Expected.COLOR.length? true : false;
    }

    public static boolean checkPantoneValue(ListResource actualResult) {
      HashSet<String> checkedSet = new HashSet<>();
      for (int i = 0; i < actualResult.data.size(); i++) {
        String actual = actualResult.data.get(i).pantoneValue;
        System.out.println("AR - " + actualResult.data.get(i).pantoneValue + " ER - " + Expected.PANTONE_VALUE[i]);
        if (actual.toLowerCase().indexOf(Expected.PANTONE_VALUE[i].toLowerCase()) >= 0) {
          checkedSet.add(actual);
        }
      }
      return checkedSet.size() == Expected.PANTONE_VALUE.length? true : false;
    }
  }

}
