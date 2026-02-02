package com.trupti.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection {

	private static Connection connection;

	static {
		try {
			Properties p = new Properties();
			InputStream is = ClassLoader.getSystemResourceAsStream("mysql_config.properties");
			p.load(is);
			connection = DriverManager.getConnection(p.getProperty("url"), p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Connection Established");
	}

	public static Connection getConnection() {
		return connection;
	}
}
