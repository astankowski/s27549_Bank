package com.mpr.s27549_bank;

import com.mpr.s27549_bank.model.Account;
import com.mpr.s27549_bank.model.Currency;
import com.mpr.s27549_bank.repository.AccountRepository;
import com.mpr.s27549_bank.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

import static com.mpr.s27549_bank.model.Currency.*;

@SpringBootApplication
public class S27549BankApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(S27549BankApplication.class, args);

        AccountService accountService = context.getBean("accountService", AccountService.class);

        accountService.create(new Account("12345678901", 1000, PLN, "Jan", "Kowalski"));
        accountService.create(new Account("98765432109", 2200, USD, "Anna", "Nowak"));
        accountService.create(new Account("11112222333", 3333, EUR, "Adam", "Wiśniewski"));
        accountService.create(new Account("55556666777", 112, PLN, "Ewa", "Dąbrowska"));
        accountService.create(new Account("99990000111", 2138, PLN, "Piotr", "Zieliński"));

        List<Account> allAccounts = accountService.getAllAccounts();
        AccountRepository accountRepository = context.getBean("accountRepository", AccountRepository.class);
        Optional<Account> accountById = accountRepository.getById(0);
    }
}
