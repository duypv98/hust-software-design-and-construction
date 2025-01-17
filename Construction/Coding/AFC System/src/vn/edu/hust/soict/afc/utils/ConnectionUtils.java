package vn.edu.hust.soict.afc.utils;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * connection ultils
 * @author duycv
 * @date Dec 6, 2019
 * @project AFC System
 * @lecturer Nguyen Thi Thu Trang
 * @class 111589
 */
public class ConnectionUtils {
	/**
	 * get my connection
	 * @return connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return MySQLConnUtils.getMySQLConnection();
	}
}
