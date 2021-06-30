package com.spring.inhertance.inhertanceMerge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Database {

    private String url;
    private String username;
    private String password;
    private List<String> properties;




}
