package com.learn.test.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("sendMailDelegate")
public class SendMailDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        String email = (String) execution.getVariable("email");
        System.out.println("MAIL SENT TO: " + email);
    }
}
