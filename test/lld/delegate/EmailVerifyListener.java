package com.learn.test.delegate;

import com.learn.test.service.UserEsService;
import lombok.RequiredArgsConstructor;
import org.flowable.task.service.delegate.DelegateTask;
import org.flowable.task.service.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component("emailVerifyListener")
@RequiredArgsConstructor
public class EmailVerifyListener implements TaskListener {
    private final UserEsService service;
    @Override
    public void notify(DelegateTask delegateTask) {
        Boolean verified = (Boolean) delegateTask.getVariable("emailVerified");
        String email = (String) delegateTask.getVariable("email");
        if(Boolean.TRUE.equals(verified)) {
            service.verifyEmail(email);
            System.out.println("Email verified in ES");
        }
    }

}
