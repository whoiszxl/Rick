package com.whoiszxl.xlorm.bean;

/**
 * 管理配置信息
 * @author whoiszxl
 *
 */
public class Configuration {
	
	/**
	 * 驱动名称
	 */
	private String driver;
	
	/**
	 * 数据库连接url
	 */
	private String url;
	
	/**
	 * 数据库用户名
	 */
	private String username;
	
	/**
	 * 数据库密码
	 */
	private String password;
	
	/**
	 * 数据库名称
	 */
	private String useDB;
	
	/**
	 * 项目源代码路径
	 */
	private String srcPath;
	
	/**
	 * po类包名
	 */
	private String poPackage;
	
	/**
	 * 当前使用查询类的路径
	 */
	private String queryClass;
	
	/**
	 * 连接池最大连接数
	 */
	private int poolMaxSize;
	
	/**
	 * 连接池最小连接数
	 */
	private int poolMinSize;
	
	
	
	
	public Configuration() {
	}

	public Configuration(String driver, String url, String username, String password, String useDB, String srcPath,
			String poPackage, String queryClass, int poolMaxSize, int poolMinSize) {
		super();
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		this.useDB = useDB;
		this.srcPath = srcPath;
		this.poPackage = poPackage;
		this.queryClass = queryClass;
		this.poolMaxSize = poolMaxSize;
		this.poolMinSize = poolMinSize;
	}

	public int getPoolMaxSize() {
		return poolMaxSize;
	}

	public void setPoolMaxSize(int poolMaxSize) {
		this.poolMaxSize = poolMaxSize;
	}

	public int getPoolMinSize() {
		return poolMinSize;
	}

	public void setPoolMinSize(int poolMinSize) {
		this.poolMinSize = poolMinSize;
	}

	public String getQueryClass() {
		return queryClass;
	}

	public void setQueryClass(String queryClass) {
		this.queryClass = queryClass;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUseDB() {
		return useDB;
	}

	public void setUseDB(String useDB) {
		this.useDB = useDB;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getPoPackage() {
		return poPackage;
	}

	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}	
	
}
