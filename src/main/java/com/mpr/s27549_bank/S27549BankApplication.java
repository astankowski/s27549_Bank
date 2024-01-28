package com.mpr.s27549_bank;

import com.mpr.s27549_bank.model.Account;
import com.mpr.s27549_bank.repository.AccountRepository;
import com.mpr.s27549_bank.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

import static com.mpr.s27549_bank.model.Currency.PLN;

@SpringBootApplication
public class S27549BankApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(S27549BankApplication.class, args);

        AccountService accountService = context.getBean("accountService", AccountService.class);

        Account account = new Account(0, "36278462", 2, PLN, "a", "b");
        accountService.create(account);

        List<Account> allAccounts = accountService.getAllAccounts();
        AccountRepository accountRepository = context.getBean("accountRepository", AccountRepository.class);
        Optional<Account> accountById = accountRepository.getById(0);
    }
}
