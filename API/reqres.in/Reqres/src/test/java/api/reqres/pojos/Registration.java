package api.reqres.pojos;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

public class Registration {

  @Data
  public class Request {

    @JsonProperty("email")
    public String email;
    @JsonProperty("password")
    public String password;
  }

  @Data
  public static class Response {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("token")
    public String token;
    @JsonProperty("error")
    public String error;
  }
}
