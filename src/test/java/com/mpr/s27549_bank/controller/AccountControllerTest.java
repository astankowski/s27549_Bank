package com.mpr.s27549_bank.controller;

import com.mpr.s27549_bank.model.Account;
import com.mpr.s27549_bank.repository.AccountRepository;
import com.mpr.s27549_bank.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.mpr.s27549_bank.model.Currency.PLN;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class AccountControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    private Account account;

    @BeforeEach
    void setUp() {
        accountRepository.getAll().clear();
    }
    @Test
    void shouldReturn200WhenAllAccountsReturnedSuccessful() {
        account = new Account("36217846211", 200, PLN, "name", "surname");
        accountService.create(account);
        webTestClient.get().uri("/account/all").exchange()
                .expectStatus().isEqualTo(200)
                .expectBodyList(Account.class).contains(account);
    }

    @Test
    void shouldReturn201WhenCreateAccountSuccessful() {
        account = new Account("36217846211", 200, PLN, "name", "surname");
        webTestClient.post().uri("/account/create").bodyValue(account).exchange().expectStatus().isEqualTo(201);
    }

    @Test
    void shouldReturn400WhenCreateAccountUnsuccessful() {
        account = new Account("36217846211", -200, PLN, "name", "surname");
        webTestClient.post().uri("/account/create").bodyValue(account).exchange().expectStatus().isEqualTo(400);
    }

    @Test
    void shouldReturn404WhenAccountNotFound() {
        webTestClient.get().uri("/account/0").exchange().expectStatus().isEqualTo(404);
    }
}
