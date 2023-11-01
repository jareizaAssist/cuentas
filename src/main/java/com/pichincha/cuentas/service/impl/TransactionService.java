package com.pichincha.cuentas.service.impl;

import com.pichincha.cuentas.dto.TransactionDto;
import com.pichincha.cuentas.entity.Transaction;
import com.pichincha.cuentas.mapper.TransactionMapper;
import com.pichincha.cuentas.repository.TransactionRepository;
import com.pichincha.cuentas.service.ITransationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionService implements ITransationService {
    TransactionRepository transactionRepository;
    TransactionMapper transactionMapper;
    @Override
    public List<TransactionDto> getTransactionsByUser(int id) {
        return transactionMapper.toListDto(transactionRepository.findByidCliente(id));
    }

    @Override
    @Transactional
    public TransactionDto saveTransaction(TransactionDto transactionDto) {
        Transaction transaction = transactionRepository
                .save(transactionMapper.toModel(transactionDto));
         return transactionMapper.toDto(transaction);
    }

    @Override
    public void deleteTransaction(int id) {
        Transaction transaction = transactionRepository.findById(id).get();
        transactionRepository.delete(transaction);
    }

    @Override
    public List<TransactionDto> getTransactionsByDate(String id, LocalDate iniDate, LocalDate finishDate) {
        return transactionMapper
                .toListDto(transactionRepository.findByidClienteAndFechaBetween(id, iniDate, finishDate));
    }
}
