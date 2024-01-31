package com.mpr.s27549_bank.service;

import com.mpr.s27549_bank.exception.ValidationException;
import com.mpr.s27549_bank.model.Account;
import com.mpr.s27549_bank.repository.AccountRepository;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public Account create(Account account) {
        if (StringUtils.isBlank(account.getPesel())) throw new ValidationException("pesel", "Cannot be blank"); //account.GetPesel()  == null || account.getPesel().isBlank()
        if (account.getPesel().length() != 11) throw new ValidationException("pesel", "Must be 11 characters long");
        if (account.getBalance() == null) throw new ValidationException("balance", "Cannot be blank");
        if (account.getBalance() < 0) throw new ValidationException("balance", "Cannot be negative");
        if (account.getCurrency() == null) throw new ValidationException("currency", "Cannot be blank");
        if (StringUtils.isBlank(account.getName())) throw new ValidationException("name", "Cannot be blank");
        if (StringUtils.isBlank(account.getSurname())) throw new ValidationException("surname", "Cannot be blank");

        return AccountRepository.create(account);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.getAll();
    }

    public Account getById(Integer id){
        if (id == null) throw new ValidationException("id", "cannot be null");

        return accountRepository.getById(id)
                .orElseThrow( ()-> new ValidationException("id", "account does not exist"));
    }
}
