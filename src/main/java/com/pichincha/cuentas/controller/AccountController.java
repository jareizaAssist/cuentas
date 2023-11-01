package com.pichincha.cuentas.controller;

import com.pichincha.cuentas.dto.AccountDto;
import com.pichincha.cuentas.entity.Account;
import com.pichincha.cuentas.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {
    IAccountService accountService;
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        try {
            AccountDto account = accountService.createAccount(accountDto);
            return new ResponseEntity<>(account, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") String id) {
        try {
            AccountDto account = accountService.getAccountById(id);
            return ResponseEntity.ok(account);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto) {
        try {
            AccountDto account = accountService.updateAccount(accountDto);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable("id") String id) {
        try {
            accountService.deleteAccount(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
