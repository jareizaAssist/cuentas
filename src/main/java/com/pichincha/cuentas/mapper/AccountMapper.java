package com.pichincha.cuentas.mapper;

import com.pichincha.cuentas.dto.AccountDto;
import com.pichincha.cuentas.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto toDto(Account account);
    List<AccountDto> toListDto(List<Account> accountList);
    Account toModel(AccountDto accountDto);
}
