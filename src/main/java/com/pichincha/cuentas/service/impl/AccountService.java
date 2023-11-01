package com.pichincha.cuentas.service.impl;

import com.pichincha.cuentas.dto.AccountDto;
import com.pichincha.cuentas.entity.Account;
import com.pichincha.cuentas.mapper.AccountMapper;
import com.pichincha.cuentas.repository.AccountRepository;
import com.pichincha.cuentas.service.IAccountService;
import org.springframework.stereotype.Service;


@Service
public class AccountService implements IAccountService {
    AccountRepository accountRepository;
    AccountMapper accountMapper;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        return accountMapper
                .toDto(accountRepository.save(accountMapper.toModel(accountDto)));
    }

    @Override
    public AccountDto getAccountById(String id) {
        return accountMapper.toDto(accountRepository.findById(id).get());
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        accountRepository.findById(accountDto.getId()).get();
        accountRepository.save(accountMapper.toModel(accountDto));
        return accountDto;
    }

    @Override
    public void deleteAccount(String id) {
        Account account = accountRepository.findById(id).get();
        accountRepository.delete(account);
    }
}
