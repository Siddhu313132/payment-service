package com.payflow.payment.service;

import com.payflow.payment.dto.PaymentRequest;
import com.payflow.payment.entity.Payment;
import com.payflow.payment.exception.PaymentNotFoundException;
import com.payflow.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Create Payment
    public Payment createPayment(PaymentRequest request) {

        Payment payment = new Payment();

        payment.setCustomerId(request.getCustomerId());
        payment.setMerchantId(request.getMerchantId());
        payment.setAmount(request.getAmount());
        payment.setStatus("SUCCESS");
        payment.setCreatedAt(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    // Get All Payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get Payment By ID
    public Payment getPaymentById(Long id) {

        return paymentRepository.findById(id)
                .orElseThrow(() ->
                        new PaymentNotFoundException(
                                "Payment not found with id: " + id
                        )
                );
    }
}