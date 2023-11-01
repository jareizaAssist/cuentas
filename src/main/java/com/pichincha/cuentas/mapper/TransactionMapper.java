package com.pichincha.cuentas.mapper;

import com.pichincha.cuentas.dto.TransactionDto;
import com.pichincha.cuentas.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    TransactionDto toDto(Transaction transaction);
    List<TransactionDto> toListDto(List<Transaction> transactionList);
    Transaction toModel(TransactionDto transactionDto);
}
