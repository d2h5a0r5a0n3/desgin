package com.learn.test.delegate;

import com.learn.test.service.UserEsService;
import lombok.RequiredArgsConstructor;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("activateUserDelegate")
@RequiredArgsConstructor
public class ActivateUserDelegate implements JavaDelegate {

    private final UserEsService userEsService;

    @Override
    public void execute(DelegateExecution execution) {

        String email = (String) execution.getVariable("email");

        userEsService.activate(email);

        System.out.println("USER ACTIVATED IN ES");
    }
}

