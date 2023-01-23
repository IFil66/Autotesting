package api.ks;

import lombok.Data;

@Data
public class RequestUserInfo3 {
  private String name;
  private int age;
  private int salary;

  public RequestUserInfo3(String name, int age, int salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }
//  public static String request = "{\n"
//          + "\"age\": 32,\n"
//          + "\"salary\": 1000,\n"
//          + "\"name\": \"Vika\"\n"
//          + "}";
}
