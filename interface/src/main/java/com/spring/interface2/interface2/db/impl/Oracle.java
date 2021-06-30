package com.spring.interface2.interface2.db.impl;


import com.spring.interface2.interface2.db.DBConnection;

public class Oracle implements DBConnection {

    @Override
    public void openConnection() {
        System.out.println("Oracle veritabanına bağlanıldı.");

    }

    @Override
    public void closeConnection() {
        System.out.println("Oracle veritabanı bağlantısı kapatıldı.");

    }
}
