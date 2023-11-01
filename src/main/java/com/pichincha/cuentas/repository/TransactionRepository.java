package com.pichincha.cuentas.repository;

import com.pichincha.cuentas.entity.Transaction;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

@EnableScan
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findByidCliente(int id);
    List<Transaction> findByidClienteAndFechaBetween(String id, LocalDate fechaInicio, LocalDate fechaFin);
}
