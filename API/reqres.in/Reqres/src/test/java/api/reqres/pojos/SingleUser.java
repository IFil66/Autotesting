package api.reqres.pojos;

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
public class SingleUser {

  @JsonProperty("data")
  public Data data;
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
  public class Data {

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
    // Data
    public static final int ID = 2;
    public static final String EMAIL = "janet.weaver@reqres.in";
    public static final String FIRST_NAM = "Janet";
    public static final String LAST_NAME = "Weaver";
    public static final String AVATAR = "https://reqres.in/img/faces/2-image.jpg";

    // Support
    public static final String URL = "https://reqres.in/#support-heading";
    public static final String TEXT = "To keep ReqRes free, contributions towards server costs are appreciated!";
  }

}