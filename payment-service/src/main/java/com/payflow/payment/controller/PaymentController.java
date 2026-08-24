package com.payflow.payment.controller;

import com.payflow.payment.dto.PaymentRequest;
import com.payflow.payment.entity.Payment;
import com.payflow.payment.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Create Payment
    @PostMapping
    public ResponseEntity<Payment> createPayment(
            @Valid @RequestBody PaymentRequest request) {

        Payment payment = paymentService.createPayment(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(payment);
    }

    // Get All Payments
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {

        List<Payment> payments =
                paymentService.getAllPayments();

        return ResponseEntity.ok(payments);
    }

    // Get Payment By ID
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(
            @PathVariable Long id) {

        Payment payment =
                paymentService.getPaymentById(id);

        return ResponseEntity.ok(payment);
    }
}