package com.amryadam.sbms.controller.Security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Demo4ConditionEvaluator {

  public boolean condition() {
    var a = SecurityContextHolder.getContext().getAuthentication();
    return false;  // your complex authorization condition
  }

}
