package com.spring.interface2.interface2.db.impl;


import com.spring.interface2.interface2.db.DBConnection;

public class MySql implements DBConnection {

    @Override
    public void openConnection() {
        System.out.println("MySql veritabanına bağlanıldı.");
    }

    @Override
    public void closeConnection() {
        System.out.println("MySql veritabanı bağlantısı kapatıldı.");

    }
}
