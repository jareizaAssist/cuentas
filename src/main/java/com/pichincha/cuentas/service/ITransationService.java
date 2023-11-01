package com.pichincha.cuentas.service;

import com.pichincha.cuentas.dto.TransactionDto;

import java.time.LocalDate;
import java.util.List;

public interface ITransationService {
    List<TransactionDto> getTransactionsByUser(int id);
    TransactionDto saveTransaction(TransactionDto transactionDto);
    void deleteTransaction(int id);
    List<TransactionDto> getTransactionsByDate(String id, LocalDate iniDate, LocalDate finishDate);

}
