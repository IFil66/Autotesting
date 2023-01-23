package api.ks;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//        "age",
//        "family",
//        "name",
//        "salary"
//})
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseUserInfo3 {

  @JsonProperty("age")
  private String age;

//  @JsonProperty("family")
//  private Family family;

  @JsonProperty("name")
  private String name;

  @JsonProperty("salary")
  private int salary;


  public ResponseUserInfo3() {
  }

//  @JsonInclude(JsonInclude.Include.NON_NULL)
//  @JsonPropertyOrder({
//          "children",
//          "u_salary_1_5_year"
//  })
//
//  @Data
//  public class Family {
//
//    @JsonProperty("children")
//    private List<List<String>> children = new ArrayList<>();
//
//    @JsonProperty("u_salary_1_5_year")
//    private int uSalary15Year;
//
//    public Family() {
//    }
//  }
}