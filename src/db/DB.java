package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection connec = null;

	public static Connection getConnection() {
		if (connec == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				connec = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return connec;
	}
	
	public static void closeConnection() {
		if (connec != null) {
			try {
				connec.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResult(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;

		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
}
