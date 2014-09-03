package com.ivey.dynamic.datasource;

public class DBContextHolder {
	public static final String DATA_SOURCE_MEMBER = "memberDataSource";

	public static final String DATA_SOURCE_PLATFORM = "platformDataSource";

	private static final ThreadLocal<String> dbHolder = new ThreadLocal<String>();

	public static void setDBType(String dbType) {
		dbHolder.set(dbType);
	}

	public static String getDBType() {
		return dbHolder.get();
	}

	public static void clearDBType() {
		dbHolder.remove();
	}

}
