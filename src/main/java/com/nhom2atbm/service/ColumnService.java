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
        return columnDAO.getAllRole();
    }
}
