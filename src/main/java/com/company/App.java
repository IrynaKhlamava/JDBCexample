package com.company;

import com.company.dao.GuestDao;

public class App {

    public static void main(String[] args) {

        GuestDao guestDao = new GuestDao();

        System.out.println(guestDao.getAll());

    }

}
