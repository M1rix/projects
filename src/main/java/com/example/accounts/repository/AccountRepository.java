package com.example.accounts.repository;

import com.example.accounts.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {

}
