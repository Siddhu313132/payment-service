package com.payflow.payment.dto;

import com.payflow.payment.enums.PaymentStatus;
import jakarta.validation.constraints.NotNull;

public class PaymentStatusRequest {

    @NotNull(message = "Status is required")
    private PaymentStatus status;

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}