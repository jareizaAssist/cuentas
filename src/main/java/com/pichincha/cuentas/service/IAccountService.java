package com.pichincha.cuentas.service;

import com.pichincha.cuentas.dto.AccountDto;

import java.util.List;

public interface IAccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(String id);
    AccountDto updateAccount(AccountDto accountDto);
    void deleteAccount(String id);
}
