package com.elleined.atmmachineapi.service;

import com.elleined.atmmachineapi.exception.ResourceNotFoundException;
import com.elleined.atmmachineapi.model.Transaction;
import com.elleined.atmmachineapi.model.User;
import com.elleined.atmmachineapi.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Transactional
    public int save(BigDecimal amount, User sender, User recipient) {
        String UUID = java.util.UUID.randomUUID().toString();

        Transaction transaction = Transaction.builder()
                .amount(amount)
                .sender(sender)
                .recipient(recipient)
                .transactionDate(LocalDateTime.now())
                .transactionNumberReference(UUID)
                .build();

        transactionRepository.save(transaction);
        log.debug("Transaction saved successfully with TRN number of {}", transaction.getTransactionNumberReference());
        return transaction.getId();
    }

    public Transaction getById(int transactionId) {
        return transactionRepository.findById(transactionId).orElseThrow(() -> new ResourceNotFoundException("Transaction with id of " + transactionId + " does not exists!"));
    }

    public Transaction getByTRN(String trn) {
        return transactionRepository.fetchByTRN(trn).orElseThrow(() -> new ResourceNotFoundException("Transaction with TRN of " + trn + " does not exists!"));
    }
}