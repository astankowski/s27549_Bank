package com.mpr.s27549_bank.service;

import com.mpr.s27549_bank.exception.ValidationException;
import com.mpr.s27549_bank.model.Account;
import com.mpr.s27549_bank.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.mpr.s27549_bank.model.Currency.PLN;
import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    @Test
    void shouldCreate() {
        AccountRepository accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        Account account = new Account(0, "36278462", 2, PLN, "a", "b");

        assertEquals(account.getId(), assertDoesNotThrow(()->accountService.create(account)));
    }

    @Test
    void shouldNotCreateNegativeBalance() {
        AccountRepository accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        Account account = new Account(0, "36278462", -2, PLN, "a", "b");

        assertEquals("Cannot be negative", assertThrows(ValidationException.class,()->accountService.create(account)).getMessage());
    }
}