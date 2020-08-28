/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom2atbm.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGUYỄN HOÀNG
 */
public class OracleJDBCConnection {
    public static Connection getJDBCConnection(){
        final String url="jdbc:oracle:thin:@//localhost:1521/db11g";
        final String user="SYS as SYSDBA";
        final String password="123456kk";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            try {
                return DriverManager.getConnection(url,user,password);
            } catch (SQLException ex) {
                Logger.getLogger(OracleJDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection Failed! Check output console");
            Logger.getLogger(OracleJDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
}
