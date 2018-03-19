package com.whoiszxl.xlorm.bean;

/**
 * Java属性 和 get set方法的源代码
 * @author whoiszxl
 *
 */
public class JavaFieldGetSet {

	/**
	 * 属性的源码信息 . 例:private int id;
	 */
	private String fieldInfo;
	
	/**
	 * get源码信息 . 例:public int getId() { return this.id; }
	 */
	private String getInfo;
	
	/**
	 * set源码信息 . 例:public void setId(int id) { this.id = id; }
	 */
	private String setInfo;

	public JavaFieldGetSet() {
	}

	public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
		super();
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}

	public String getFieldInfo() {
		return fieldInfo;
	}

	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}

	public String getGetInfo() {
		return getInfo;
	}

	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}

	public String getSetInfo() {
		return setInfo;
	}

	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	
}
