/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bala
 */
public class DBUtil {
    public static Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "biomart", "biomart");
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return null;
	}
}
