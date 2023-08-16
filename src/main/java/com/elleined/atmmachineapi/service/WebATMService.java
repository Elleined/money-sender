package com.elleined.atmmachineapi.service;

import com.elleined.atmmachineapi.exception.InsufficientFundException;
import com.elleined.atmmachineapi.exception.ResourceNotFoundException;
import com.elleined.atmmachineapi.service.atm.DepositService;
import com.elleined.atmmachineapi.service.atm.PeerToPeerService;
import com.elleined.atmmachineapi.service.atm.WithdrawService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
@Primary
public class WebATMService implements ATMService {

    private final DepositService depositService;
    private final WithdrawService withdrawService;
    private final PeerToPeerService peerToPeerService;

    @Override
    public void deposit(int userId, @NonNull BigDecimal amount)
            throws ResourceNotFoundException, IllegalArgumentException {

        depositService.deposit(userId, amount);
    }

    @Override
    public void withdraw(int userId, @NonNull BigDecimal amount)
            throws IllegalArgumentException,
            InsufficientFundException,
            ResourceNotFoundException {

        withdrawService.withdraw(userId, amount);
    }

    @Override
    public void peerToPeer(int senderId, @NonNull BigDecimal amount, int recipientId)
            throws IllegalArgumentException,
            InsufficientFundException,
            ResourceNotFoundException {

        peerToPeerService.peerToPeer(senderId, amount, recipientId);
    }
}