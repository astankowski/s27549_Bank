package com.mpr.s27549_bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private Integer id;
    private String pesel;
    private Integer balance;
    private Curency currency;
    private String name;
    private String surname;
}
