package com.moneysender.Money.Sender.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_withdraw_transaction")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "withdraw_transaction_id")
    private int id;

    @Column(name = "transaction_reference_number",
            updatable = false,
            nullable = false,
            unique = true)
    private String trn;

    @Column(name = "withdrawal_date",
            nullable = false,
            updatable = false)
    private LocalDateTime withdrawalDate;

    @Column(name = "withdrawal_amount",
            updatable = false,
            nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id",
            referencedColumnName = "user_id"
    )
    private User user;
}
