package com.spring.autowired.model;

import com.spring.autowired.db.DBConnection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Database {

    private String url;
    private String username;
    private String password;




}
