package api.reqres;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import api.reqres.pojoFiles.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;


public class ReqrestApiTests {

  private final static String URL = "https://reqres.in";

  @Test
  public void userList() {
    // Arrange is done in ListUsers.class
    // Act
    ListUsers actualResult = given().log().all()
            .baseUri(URL)
            .contentType(ContentType.JSON)
            .when().get("/api/users?page=2")
            .then().statusCode(200)
            .extract().as(ListUsers.class);
    // Assert
    assertThat(actualResult.page).isEqualTo(ListUsers.Expected.PAGE);
    assertThat(actualResult.perPage).isEqualTo(ListUsers.Expected.PER_PAGE);
    assertThat(actualResult.total).isEqualTo(ListUsers.Expected.TOTAL);
    assertThat(actualResult.totalPages).isEqualTo(ListUsers.Expected.TOTAL_PAGES);

    assertThat(ListUsers.Methods.checkId(actualResult, ListUsers.Expected.ID)).isEqualTo(true);
    assertThat(ListUsers.Methods.checkEmail(actualResult, ListUsers.Expected.EMAIL)).isEqualTo(true);
    assertThat(ListUsers.Methods.checkFirstName(actualResult, ListUsers.Expected.FIRST_NAME)).isEqualTo(true);
    assertThat(ListUsers.Methods.checkLastName(actualResult, ListUsers.Expected.LAST_NAME)).isEqualTo(true);
    assertThat(ListUsers.Methods.checkAvatar(actualResult, ListUsers.Expected.AVATAR)).isEqualTo(true);

    assertThat(actualResult.support.url).isEqualTo(ListUsers.Expected.URL);
    assertThat(actualResult.support.text).isEqualTo(ListUsers.Expected.TEXT);
  }

  @Test
  public void checkSingleUser() {
    // Arrange is done in SingleUser.class
    // Act
    SingleUser actualResult = given().log().all()
            .baseUri(URL)
            .contentType(ContentType.JSON)
            .when().get("/api/users/2")
            .then().statusCode(200)
            .extract().as(SingleUser.class);
    // Assert
    assertThat(actualResult.data.id).isEqualTo(SingleUser.Expected.ID);
    assertThat(actualResult.data.email).isEqualTo(SingleUser.Expected.EMAIL);
    assertThat(actualResult.data.firstName).isEqualTo(SingleUser.Expected.FIRST_NAM);
    assertThat(actualResult.data.lastName).isEqualTo(SingleUser.Expected.LAST_NAME);
    assertThat(actualResult.data.avatar).isEqualTo(SingleUser.Expected.AVATAR);
    assertThat(actualResult.support.url).isEqualTo(SingleUser.Expected.URL);
    assertThat(actualResult.support.text).isEqualTo(SingleUser.Expected.TEXT);
  }

  @Test
  public void checkSingleUserNotFound() {
    // Act and Assert
    given().log().all()
            .baseUri(URL)
            .when().get("/api/users/23")
            .then().statusCode(404);
  }

  @Test
  public void checkListResource() {
    // Arrange is done in ListResource.class
    // Act
    ListResource actualResult = given().log().all()
            .baseUri(URL)
            .contentType(ContentType.JSON)
            .when().get("/api/unknown")
            .then().statusCode(200)
            .extract().as(ListResource.class);
    // Assert
    assertThat(actualResult.page).isEqualTo(ListResource.Expected.PAGE);
    assertThat(actualResult.perPage).isEqualTo(ListResource.Expected.PER_PAGE);
    assertThat(actualResult.total).isEqualTo(ListResource.Expected.TOTAL);
    assertThat(actualResult.totalPages).isEqualTo(ListResource.Expected.TOTAL_PAGES);

    assertThat(ListResource.Methods.checkId(actualResult)).isEqualTo(true);
    assertThat(ListResource.Methods.checkName(actualResult)).isEqualTo(true);
    assertThat(ListResource.Methods.checkYear(actualResult)).isEqualTo(true);
    assertThat(ListResource.Methods.checkColor(actualResult)).isEqualTo(true);
    assertThat(ListResource.Methods.checkPantoneValue(actualResult)).isEqualTo(true);

    assertThat(actualResult.support.url).isEqualTo(ListResource.Expected.URL);
    assertThat(actualResult.support.text).isEqualTo(ListResource.Expected.TEXT);
  }

  @Test
  public void checkSingleResource() {
    // Arrange is done in SingleResource.class
    // Act
    SingleResource actualResult = given().log().all()
            .baseUri(URL)
            .contentType(ContentType.JSON)
            .when().get("/api/unknown/2")
            .then().statusCode(200)
            .extract().as(SingleResource.class);
    // Assert
    assertThat(actualResult.data.id).isEqualTo(SingleResource.Expected.ID);
    assertThat(actualResult.data.name).isEqualTo(SingleResource.Expected.NAME);
    assertThat(actualResult.data.year).isEqualTo(SingleResource.Expected.YEAR);
    assertThat(actualResult.data.color).isEqualTo(SingleResource.Expected.COLOR);
    assertThat(actualResult.data.pantoneValue).isEqualTo(SingleResource.Expected.PANTONE_VALUE);
    assertThat(actualResult.support.url).isEqualTo(SingleResource.Expected.URL);
    assertThat(actualResult.support.text).isEqualTo(SingleResource.Expected.TEXT);
  }

  @Test
  public void checkSingleResourceNotFound() {
    // Act and Assert
    given().log().all()
            .baseUri(URL)
            .when().get("/api/unknown/23")
            .then().statusCode(404);
  }

  @Test
  public void checkCreate() {
    // Arrange
    Create create = new Create();
    Create.Request rq = create.new Request();
    rq.name = "morpheus";
    rq.job = "leader";

    // Act
    Create.Response actualResult = given().log().all()
            .baseUri(URL)
            .contentType(ContentType.JSON)
            .body(rq)
            .when().post("/api/user")
            .then().statusCode(201)
            .extract().as(Create.Response.class);
    // Assert
    assertThat(actualResult.name).isEqualTo(rq.name);
    assertThat(actualResult.job).isEqualTo(rq.job);
    assertThat(actualResult.id).isNotNull();
    assertThat(Create.Methods.dateAndTimeFormat(actualResult.createdAt))
            .isEqualTo(Create.Methods.timeOk());
  }

  @Test
  public void checkUpdate() {
    // Arrange
    Update update = new Update();
    Update.Request rq = update.new Request();
    rq.name = "morpheus";
    rq.job = "zion resident";

    // Act
    Update.Response actualResult = given().log().all()
            .baseUri(URL)
            .contentType(ContentType.JSON)
            .body(rq)
            .when().put("/api/users/2")
            .then().statusCode(200)
            .extract().as(Update.Response.class);
    // Assert
    assertThat(actualResult.name).isEqualTo(rq.name);
    assertThat(actualResult.job).isEqualTo(rq.job);
    assertThat(Update.Methods.dateAndTimeFormat(actualResult.updatedAt))
            .isEqualTo(Update.Methods.timeOk());
  }

  @Test
  public void checkDelete() {
    // Act and Assert
    given().log().all()
            .baseUri(URL)
            .when().delete("/api/users/2")
            .then().statusCode(204);
  }

  @Test
  public void checkRegisterSuccessful() {
    // Arrange
    Registration reg = new Registration();
    Registration.Request rq = reg.new Request();
    rq.email = "eve.holt@reqres.in";
    rq.password = "pistol";

    // Expected result
    int id = 4;
    String token = "QpwL5tke4Pnpja7X4";

    // Act
    Registration.Response actualResult = given().log().all()
            .baseUri(URL)
            .contentType(ContentType.JSON)
            .body(rq)
            .when().post("/api/register")
            .then().statusCode(200)
            .log().all()
            .extract().as(Registration.Response.class);
    // Assert
    assertThat(actualResult.id).isEqualTo(id);
    assertThat(actualResult.token).isEqualTo(token);
  }

  @Test
  public void checkRegisterUnsuccessful() {
    // Arrange
    Registration reg = new Registration();
    Registration.Request rq = reg.new Request();
    rq.email = "sydney@fife";

    // Expected result
    String error = "Missing password";

    // Act
    Registration.Response actualResult = given().log().all()
            .baseUri(URL)
            .contentType(ContentType.JSON)
            .body(rq)
            .when().post("/api/register")
            .then().statusCode(400)
            .log().all()
            .extract().as(Registration.Response.class);
    // Assert
    assertThat(actualResult.error).isEqualTo(error);
  }

  @Test
  public void loginSuccessful() {
    // Arrange
    Login login = new Login();
    Login.Request rq = login.new Request();
    rq.email = "peter@klaven";
    rq.password = "cityslicka";
    // Expected result
    String token = "QpwL5tke4Pnpja7X4";

    // Act
    Login.Response actualResult = given().log().all()
            .baseUri(URL)
            .contentType(ContentType.JSON)
            .body(rq)
            .when().post("/api/login")
            .then().statusCode(200)
            .extract().as(Login.Response.class);
    // Assert
    assertThat(actualResult.token).isEqualTo(token);
  }

  @Test
  public void loginUnsuccessful() {
    // Arrange
    Login login = new Login();
    Login.Request rq = login.new Request();
    rq.email = "peter@klaven";
    // Expected result
    String error = "Missing password";

    // Act
    Login.Response actualResult = given().log().all()
            .baseUri(URL)
            .contentType(ContentType.JSON)
            .when().post("/api/login")
            .then().statusCode(400)
            .extract().as(Login.Response.class);
    // Assert
    assertThat(actualResult.error).isEqualTo(error);
  }

  @Test
  public void delayedResponse() {
    // Arrange is done in ListUsers.class (variables - DR_*)

    // Act
    ListUsers actualResult = given().log().all()
            .baseUri(URL)
            .when().get("/api/users?delay=3")
            .then().statusCode(200)
            .extract().as(ListUsers.class);
    // Assert
    assertThat(actualResult.page).isEqualTo(ListUsers.Expected.DR_PAGE);
    assertThat(actualResult.perPage).isEqualTo(ListUsers.Expected.PER_PAGE);
    assertThat(actualResult.total).isEqualTo(ListUsers.Expected.TOTAL);
    assertThat(actualResult.totalPages).isEqualTo(ListUsers.Expected.TOTAL_PAGES);

    assertThat(ListUsers.Methods.checkId(actualResult, ListUsers.Expected.DR_ID)).isEqualTo(true);
    assertThat(ListUsers.Methods.checkEmail(actualResult, ListUsers.Expected.DR_EMAIL)).isEqualTo(true);
    assertThat(ListUsers.Methods.checkFirstName(actualResult, ListUsers.Expected.DR_FIRST_NAME)).isEqualTo(true);
    assertThat(ListUsers.Methods.checkLastName(actualResult, ListUsers.Expected.DR_LAST_NAME)).isEqualTo(true);
    assertThat(ListUsers.Methods.checkAvatar(actualResult, ListUsers.Expected.DR_AVATAR)).isEqualTo(true);

    assertThat(actualResult.support.url).isEqualTo(ListUsers.Expected.URL);
    assertThat(actualResult.support.text).isEqualTo(ListUsers.Expected.TEXT);
  }

}