package api.reqres.pojoFiles;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "support"
})
@Data
public class SingleResource {
  @JsonProperty("data")
  public SingleResource.Data data;
  @JsonProperty("support")
  public SingleResource.Support support;

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

  @lombok.Data
  public class Support {

    @JsonProperty("url")
    public String url;
    @JsonProperty("text")
    public String text;
  }

  // ----------------------------------------------Variables----------------------------------------------------------

  public static class Expected {
    // Data
    public static final int ID = 2;
    public static final String NAME = "fuchsia rose";
    public static final int YEAR = 2001;
    public static final String COLOR = "#C74375";
    public static final String PANTONE_VALUE = "17-2031";

    // Support
    public static final String URL = "https://reqres.in/#support-heading";
    public static final String TEXT = "To keep ReqRes free, contributions towards server costs are appreciated!";
  }

}
