package com.learn.test.delegate;

import com.learn.test.service.UserEsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("createUserDelegate")
@RequiredArgsConstructor
@Slf4j
public class CreateUserDelegate implements JavaDelegate {
    private final UserEsService userEsService;

    @Override
    public void execute(DelegateExecution execution) {
        String name = (String) execution.getVariable("name");
        String email = (String) execution.getVariable("email");

        userEsService.createUser(name, email);
        System.out.println("Flowable → ES user created");
    }
}
