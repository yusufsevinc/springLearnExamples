package com.example.springbank.dto;


import com.example.springbank.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String id;
    private String customerId;
    private Double balance;
    private Currency currency;



}
