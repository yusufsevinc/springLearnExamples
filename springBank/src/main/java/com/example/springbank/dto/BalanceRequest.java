package com.example.springbank.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceRequest {
    private String id;
    private Double amount;

}
