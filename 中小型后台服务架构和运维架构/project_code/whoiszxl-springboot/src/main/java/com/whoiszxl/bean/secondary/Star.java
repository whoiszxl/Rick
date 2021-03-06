package com.whoiszxl.bean.secondary;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * swoole.whoiszxl.com 数据源的实体类
 * @author whoiszxl
 *
 */
@Entity
public class Star implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String starname;

	public Star() {
		super();
	}
	
	

	public Star(String starname) {
		super();
		this.starname = starname;
	}



	public Star(Integer id, String starname) {
		super();
		this.id = id;
		this.starname = starname;
	}

	@Override
	public String toString() {
		return "Star [id=" + id + ", starname=" + starname + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStarname() {
		return starname;
	}

	public void setStarname(String starname) {
		this.starname = starname;
	}
	
	
	
}
