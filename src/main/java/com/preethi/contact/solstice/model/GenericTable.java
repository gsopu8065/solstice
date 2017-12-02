package com.preethi.contact.solstice.model;

/**
 * Created by srujan.gopu on 12/2/17.
 */
public class GenericTable {

    private String tableName;
    private GenericColumn[] columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public GenericColumn[] getColumns() {
        return columns;
    }

    public void setColumns(GenericColumn[] columns) {
        this.columns = columns;
    }

}
