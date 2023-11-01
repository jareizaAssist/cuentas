package com.pichincha.cuentas.repository;

import com.pichincha.cuentas.entity.Account;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
@EnableScan
public interface AccountRepository extends CrudRepository<Account, String> {

}
