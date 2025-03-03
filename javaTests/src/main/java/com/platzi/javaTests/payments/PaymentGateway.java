package com.platzi.javaTests.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);

}
