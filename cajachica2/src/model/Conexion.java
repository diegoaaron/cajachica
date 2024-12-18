package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexion {

	public static Connection conectar() {

		Connection cnn = null;

		try {
			cnn = DriverManager.getConnection("jdbc:sqlite:/home/diego/eclipse-workspace/cajachica2/bd/cajachica.db");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnn;
	}

	public static void cerrar(Connection cnn, Statement stm, PreparedStatement pstm, ResultSet rst) {
		try {
			if (cnn != null) {
				cnn.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (rst != null) {
				rst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
