package com.learn.test.delegate;

import com.learn.test.service.UserEsService;
import lombok.RequiredArgsConstructor;
import org.flowable.task.service.delegate.DelegateTask;
import org.flowable.task.service.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component("loginListener")
@RequiredArgsConstructor
public class LoginListener implements TaskListener {

    private final UserEsService userEsService;

    @Override
    public void notify(DelegateTask task) {

        String email = (String) task.getVariable("email");
        userEsService.verifyEmail(email);
        System.out.println("LOGIN SUCCESS");
    }
}

