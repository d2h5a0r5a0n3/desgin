package com.learn.test.delegate;

import com.learn.test.service.UserEsService;
import lombok.RequiredArgsConstructor;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("sendOtpDelegate")
@RequiredArgsConstructor
public class SendOtpDelegate implements JavaDelegate {
    private final UserEsService service;
    @Override
    public void execute(DelegateExecution delegateExecution) {
        String email = (String) delegateExecution.getVariable("email");
        int otp = 1234;
        service.saveOtp(email, otp);
        System.out.println("OTP SENT: " + otp);
    }

    public static void main(String[] args) {
        String s = "{}{}{}";
        var isValid = s.chars()
                .mapToObj(c->(char) c);
    }
}
