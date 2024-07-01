package com.elleined.atmmachineapi.hateoas.transaction;

import com.elleined.atmmachineapi.dto.transaction.DepositTransactionDTO;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositTransactionHateoasAssembler extends TransactionHateoasAssembler<DepositTransactionDTO> {
    private final Faker faker;

    @Override
    protected List<Link> getAllRelatedLinks(DepositTransactionDTO dto, boolean doInclude) {
        return List.of();
    }

    @Override
    protected List<Link> getAllSelfLinks(DepositTransactionDTO dto, boolean doInclude) {
        return List.of();
    }
}
