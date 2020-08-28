/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom2atbm.model;

/**
 *
 * @author NGUYỄN HOÀNG
 */
public class Column {
    private String columnName; 

    public Column() {
    }

    public Column(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
