package com.mpr.s27549_bank.repository;

import com.mpr.s27549_bank.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AccountRepository {
    private static List<Account> accountList = new ArrayList<>();

    public static Account create(Account account) {
        account.setId(accountList.size());
        accountList.add(account);
        return account;
    }

    public List<Account> getAll() {
        return accountList;
    }

    public Optional<Account> getById(Integer id){
        return accountList
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }
}
