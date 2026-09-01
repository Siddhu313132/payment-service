package com.payflow.payment.entity;

import com.payflow.payment.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;

    private String merchantId;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;


    private LocalDateTime createdAt;
}