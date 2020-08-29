/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom2atbm.service;

import com.nhom2atbm.DAO.ColumnDAO;
import com.nhom2atbm.model.Column;
import java.util.List;

/**
 *
 * @author NGUYỄN HOÀNG
 */
public class ColumnService {
    private final ColumnDAO columnDAO;
    
    public ColumnService(){
       columnDAO = new ColumnDAO();
    }
    
    public List<Column> getAllColumns(String value){
        return columnDAO.getAllColumn(value);
    }
    
    public List<Column> getAllUsers() {
        return columnDAO.getAllUser();
    }
    
    public List<Column> getAllRoles() {
        return columnDAO.getAllRoles();
    }
    
    public void CapQuyen(String quyen, String table, String user, int wgoVal, List<String> l){
        columnDAO.CapQuyen(quyen, table, user, wgoVal, l);
    }
    
    public void capRole(String tenRole, String user, int waoval){
        columnDAO.capRole(tenRole, user, waoval);
    }
    
    public void thuhoiQuyen(String quyen, String table,String user){
        columnDAO.thuhoiQuyen(quyen, table, user);
    }
    
    public void thuhoiRole(String role,  String user){
        columnDAO.thuhoiRole(role, user);
    }
}
