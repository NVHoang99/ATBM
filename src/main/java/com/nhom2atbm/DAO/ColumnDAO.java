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
import java.sql.Statement;
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
            while (resultSet.next()) {
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
            while (resultSet.next()) {

                Column column = new Column();
                column.setColumnName(resultSet.getString("USERNAME"));
                columns.add(column);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColumnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columns;
    }
    
    public List<Column> getAllRoles() {
        List<Column> columns = new ArrayList<>();
        Connection connection = OracleJDBCConnection.getJDBCConnection();

        String sql = "SELECT GRANTED_ROLE FROM user_role_privs where username = 'X_ATBMGK32'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Column column = new Column();
                column.setColumnName(resultSet.getString("GRANTED_ROLE"));
                columns.add(column);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColumnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columns;
    }

    public void CapQuyen(String quyen, String table, String user, int waoVal, List<String> l) {
        Connection connection = OracleJDBCConnection.getJDBCConnection();
        String sql;
        if (l == null) {
            if (waoVal == 0) {
                sql = "GRANT " + quyen + " ON X_ATBMGK32." + table + " TO " + user;
                System.out.println(sql);
            } else {
                sql = "GRANT " + quyen + " ON X_ATBMGK32." + table + " TO " + user + " WITH GRANT OPTION";
                System.out.println(sql);
            }
        } else {
            if (waoVal == 0) {
                String string = "";
                for (int i = 0; i < l.size(); i++) {
                    if (i == l.size()-1) {
                        string +=  l.get(i);
                    } else {
                    string +=  l.get(i) + ",";
                    }
                }
                
                sql = "GRANT " + quyen + "(" + string + ") ON X_ATBMGK32." + table + " TO " + user;
                System.out.println(sql);
            } else {
                String string = "";
                for (int i = 0; i < l.size(); i++) {
                    if (i == l.size()-1) {
                        string +=  l.get(i);
                    } else {
                    string +=  l.get(i) + ",";
                    }
                }
                
                sql = "GRANT " + quyen + "(" + string + ") ON X_ATBMGK32." + table + " TO " + user + " WITH GRANT OPTION";
                System.out.println(sql);
            }
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet);
            JOptionPane.showMessageDialog(null, "Thanh cong!");
        } catch (SQLException ex) {
            Logger.getLogger(ColumnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void capRole(String tenRole, String user, int wgoval){
        Connection connection = OracleJDBCConnection.getJDBCConnection();
        String sql;
        if (wgoval == 0) {
            sql = "GRANT " + tenRole + " TO " + user;
        } else {
            sql = "GRANT " + tenRole + " TO " + user + " WITH ADMIN OPTION"; 
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            boolean resultSet = preparedStatement.execute();
            System.out.println(resultSet);
            JOptionPane.showMessageDialog(null, "Thanh cong!");
        } catch (SQLException ex) {
            Logger.getLogger(ColumnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void thuhoiQuyen(String quyen, String table, String user){
        Connection connection = OracleJDBCConnection.getJDBCConnection();
        String sql = "REVOKE " + quyen + " ON " + table + " FROM " + user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            boolean resultSet = preparedStatement.execute();
            System.out.println(resultSet);
            JOptionPane.showMessageDialog(null, "Thanh cong!");
        } catch (SQLException ex) {
            Logger.getLogger(ColumnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void thuhoiRole(String role,  String user){
        Connection connection = OracleJDBCConnection.getJDBCConnection();
        String sql = "REVOKE " + role + " FROM " + user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            boolean resultSet = preparedStatement.execute();
            System.out.println(resultSet);
            JOptionPane.showMessageDialog(null, "Thanh cong!");
        } catch (SQLException ex) {
            Logger.getLogger(ColumnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
