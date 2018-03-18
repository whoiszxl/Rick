package com.whoiszxl.xlorm.bean;

import java.util.Map;

/**
 * 存储表结构信息
 * @author whoiszxl
 *
 */
public class TableInfo {

	/**
	 * 表名
	 */
	private String tname;
	
	/**
	 * 所有字段信息
	 */
	private Map<String, ColumnInfo> columns;
	
	/**
	 * 唯一主键
	 */
	private ColumnInfo onlyPriKey;

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}

	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}

	public TableInfo() {
	
	}
	
	
}
