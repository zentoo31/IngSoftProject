package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {
    public static Connection obtenerConexion() throws SQLException{
        Connection conexion = null; 
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Florinvent;user=sa;password=12345678;encrypt=true;trustServerCertificate=true";
            conexion = DriverManager.getConnection(url);
            return conexion;
    }
}
