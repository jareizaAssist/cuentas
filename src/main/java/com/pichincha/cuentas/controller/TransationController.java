package com.pichincha.cuentas.controller;

import com.pichincha.cuentas.dto.TransactionDto;
import com.pichincha.cuentas.service.ITransationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransationController {
    ITransationService transationService;
    @GetMapping("/{id}")
    public ResponseEntity<List<TransactionDto>> getTransactionsByUser(@PathVariable("id") int id) {
        try {
        List<TransactionDto> transactions = transationService.getTransactionsByUser(id);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<TransactionDto> saveTransaction(@RequestBody TransactionDto transactionDto) {
        try {
        TransactionDto transaction = transationService.saveTransaction(transactionDto);
        return ResponseEntity.ok(transaction);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping("/{idTransaction}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("idTransaction") int id){
        try {
            transationService.deleteTransaction(id);
            return ResponseEntity.ok("Transación eliminada exitosamente");
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al eliminar la transación", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}/{iniDate}/{finishDate}")
    public ResponseEntity<List<TransactionDto>> getTransactionsByDate(
            @PathVariable("id") String id,
            @PathVariable("{iniDate}") LocalDate iniDate,
            @PathVariable("finishDate") LocalDate finishDate) {
        try {
            List<TransactionDto> transactions = transationService.getTransactionsByDate(id, iniDate, finishDate);
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

    }
}
