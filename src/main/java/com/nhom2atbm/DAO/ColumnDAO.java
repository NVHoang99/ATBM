/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom2atbm.DAO;

import com.nhom2atbm.model.Column;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NGUYỄN HOÀNG
 */
public class ColumnDAO {

    public List<Column> getAllColumn(String value) {
        List<Column> columns = new ArrayList<>();
        Connection connection = OracleJDBCConnection.getJDBCConnection();
       
        String sql = "SELECT column_name FROM ALL_TAB_COLUMNS WHERE table_name = '" + value + "'"; 
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Column column = new Column();
                column.setColumnName(resultSet.getString("COLUMN_NAME"));
                columns.add(column);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ColumnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columns;
    }
    
    public List<Column> getAllUser() {
        List<Column> columns = new ArrayList<>();
        Connection connection = OracleJDBCConnection.getJDBCConnection();
       
        String sql = "SELECT username FROM all_users where username like '%ATBM%' and username != 'X_ATBMGK32'"; 
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               
                Column column = new Column();
                column.setColumnName(resultSet.getString("USERNAME"));
                columns.add(column);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColumnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columns;
    }
    
    public List<Column> getAllRole() {
        List<Column> columns = new ArrayList<>();
        Connection connection = OracleJDBCConnection.getJDBCConnection();
       
        String sql2 = "SELECT granted_role FROM user_role_privs where username = 'X_ATBMGK32'"; 
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Column column = new Column();
                column.setColumnName(resultSet.getString("GRANTED_ROLE"));
                columns.add(column);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColumnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columns;
    }
}
