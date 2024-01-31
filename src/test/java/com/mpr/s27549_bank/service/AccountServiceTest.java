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
    private static AccountService accountService;
    private static AccountRepository accountRepository;
    private static Account account;

    @BeforeAll
    static void beforeAll() {
        accountRepository = new AccountRepository();
        accountService = new AccountService(accountRepository);
    }

    @AfterEach
    void tearDown() {
        accountRepository.getAll().clear();
    }

    @Test
    void shouldCreate() {
        account = new Account("36217846211", 200, PLN, "name", "surname");
        assertDoesNotThrow(()->accountService.create(account));
        assertEquals(account.getId(), accountRepository.getAll().size() - 1);
    }

    @Test
    void shouldNotCreateOnNullPesel() {
        assertThrows(NullPointerException.class,()->
                accountService.create(new Account(null, 200, PLN, "name", "surname")));
    }

    @Test
    void shouldNotCreateOnBlankPesel() {
        account = new Account("", 200, PLN, "name", "surname");
        assertThrows(ValidationException.class,()->accountService.create(account));
    }
    @Test
    void shouldNotCreateOnNullData() {
        assertThrows(NullPointerException.class,()->
                accountService.create(new Account(null, null, null, null, null)));
    }

    @Test
    void shouldNotCreateOnNegativeBalance() {
        account = new Account("22323232323", -2, PLN, "name", "surname");
        assertThrows(ValidationException.class,()->accountService.create(account));
    }

    @Test
    void shouldGetAllAccounts() {
        account = new Account("36217846211", 200, PLN, "name", "surname");
        accountService.create(account);
        assertEquals(account.getId(), accountRepository.getAll().size() - 1);
    }

    @Test
    void shouldGetById() {
        account = new Account("36217846211", 200, PLN, "name", "surname");
        accountService.create(account);
        assertEquals(account.getId(), accountService.getById(account.getId()).getId());
    }
}