package com.capital.userAnnotations;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ExtendWith(ConditionForOptionAorBTest.class)
@Retention(RUNTIME)
public @interface UserCondition {
  String enabledFor();
}
