package com.restwebservice.restwebservice.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbManager {


    public static DataSource getDataSource(){
        try{
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/postgresql");
            return dataSource;
        } catch (NamingException e) {
            return null;
        }
    }
}
