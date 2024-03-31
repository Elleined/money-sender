package com.elleined.atmmachineapi.mapper.transaction;

import com.elleined.atmmachineapi.dto.transaction.PeerToPeerTransactionDTO;
import com.elleined.atmmachineapi.model.transaction.PeerToPeerTransaction;
import com.elleined.atmmachineapi.request.transaction.PeerToPeerTransactionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PeerToPeerTransactionMapper extends TransactionMapper<PeerToPeerTransaction, PeerToPeerTransactionDTO, PeerToPeerTransactionRequest> {

    @Override
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "trn", source = "trn"),
            @Mapping(target = "amount", source = "amount"),
            @Mapping(target = "transactionDate", source = "transactionDate"),
            @Mapping(target = "receiverId", source = "receiver.id"),
            @Mapping(target = "senderId", source = "sender.id")
    })
    PeerToPeerTransactionDTO toDTO(PeerToPeerTransaction peerToPeerTransaction);

}
