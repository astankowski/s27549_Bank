package com.mpr.s27549_bank.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mpr.s27549_bank.model.Account;
import com.mpr.s27549_bank.repository.AccountRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Optional;

import static com.mpr.s27549_bank.model.Currency.PLN;
import static org.junit.jupiter.api.Assertions.*;

@Disabled
class accountControllerTest {
}
