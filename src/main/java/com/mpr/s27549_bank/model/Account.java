package com.mpr.s27549_bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Account {
    private Integer id;
    @NonNull
    private String pesel;
    @NonNull
    private Integer balance;
    @NonNull
    private Currency currency;
    @NonNull
    private String name;
    @NonNull
    private String surname;
}
