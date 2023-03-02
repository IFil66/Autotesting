package com.capital.userAnnotations;

import com.capital.Locators;
import com.capital.testsWithAllure.mainPage_tests.registrationButtons_tests.specific_tests.MethodsOfSpecificTests;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ConditionForOptionAorBTest implements ExecutionCondition {
  MethodsOfSpecificTests methodOfSpecificTests = new MethodsOfSpecificTests();

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

      Boolean isVisibilityOfOption_A = false;
      isVisibilityOfOption_A= methodOfSpecificTests.visibilityOfElement(By.cssSelector(
              Locators.locatorTradingInstrumentWidgetTab_A1 + Locators.codenameForUserAnnotation
                      + Locators.locatorTradingInstrumentWidgetTab_A2));
      Set<String> accessConditions = getConditionsForRunningTests(context);

    if(isVisibilityOfOption_A == true) {
        return accessConditions.contains("Option_A")
                  ? ConditionEvaluationResult.enabled("Test option A is enabled")
                  : ConditionEvaluationResult.disabled("Test option B isn't enabled because the widget option B don't visibility");
        }
      else {
        return accessConditions.contains("Option_B")
                ? ConditionEvaluationResult.enabled("Test option B is enabled")
                : ConditionEvaluationResult.disabled("Test option A isn't enabled because the widget option A don't visibility");
      }
  }

  // Get the dateset put in the annotation
  private Set<String> getConditionsForRunningTests (ExtensionContext context) {
    Set<String> conditionsForRunningTests = new HashSet<>();
    context.getElement().ifPresent(element ->
            AnnotationSupport.findAnnotation(element, UserCondition.class)
                    .map(UserCondition::enabledFor)
                    .ifPresent(array -> conditionsForRunningTests.addAll(Arrays.asList(array))));
    for (String s:conditionsForRunningTests) {
      System.out.println(s);
    }
    return conditionsForRunningTests;
  }
}