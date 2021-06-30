package com.spring.inhertance.model;

import lombok.Data;


@Data
public class Database {

    private String url;
    private String username;
    private String password;

    public Database() {


    }

    public Database(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


}
