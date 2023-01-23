package api.ks;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiTests {
  private final String URL = "http://162.55.220.72:5005";

  @Test
  public void firstRequest() {
    String response = given()
            .baseUri(URL)
            .basePath("/first")
            .contentType(ContentType.JSON)
            .when().get()
            .then()
            .statusCode(200)
            .extract().body().asPrettyString();
    assertThat(response).contains("This is the first responce from server!ss");
  }

  @Test
  public void userInfo3() {
    RequestUserInfo3 rq = new RequestUserInfo3("Vika", 32, 1000);
//    rq.setAge(32);
//    rq.setSalary(1000);
//    rq.setName("Vika");

//    List<ResponseUserInfo3> rs = given()
//    ResponseUserInfo3 rs =
            given()
            .baseUri(URL)
            .basePath("/user_info_3")
            .contentType(ContentType.JSON)
            .body(rq)
            .when().post()
            .then();
//            .statusCode(200)
//            .extract().as(ResponseUserInfo3.class);
////            .extract().jsonPath().getList("", ResponseUserInfo3.class);
    System.out.println(rq);






  }






}
