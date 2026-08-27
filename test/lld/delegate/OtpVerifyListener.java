package com.learn.test.delegate;

import com.learn.test.service.UserEsService;
import lombok.RequiredArgsConstructor;
import org.flowable.task.service.delegate.DelegateTask;
import org.flowable.task.service.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component("otpVerifyListener")
@RequiredArgsConstructor
public class OtpVerifyListener implements TaskListener {

    private final UserEsService userEsService;

    @Override
    public void notify(DelegateTask task) {
        String email = (String) task.getVariable("email");
        Integer enteredOtp = (Integer) task.getVariable("enteredOtp");
        if(userEsService.verifyOtp(email, enteredOtp)) {
            task.setVariable("otpValid", true);
        } else {
            throw new RuntimeException("Invalid OTP");
        }
    }
}

