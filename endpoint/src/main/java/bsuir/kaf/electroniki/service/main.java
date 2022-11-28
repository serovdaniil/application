package bsuir.kaf.electroniki.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bsuir.kaf.electroniki.dao.connection.ApplicationConnectionDatabase;

public class main {

    public static void main(String[] args) {
        CurSysServiceImpl.getInstance().findCurStatusBySystem(1).forEach(it -> System.out.println(it));
    }
}
