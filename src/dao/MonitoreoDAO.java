package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Monitoreo;

public class MonitoreoDAO {

    String url = "jdbc:sqlserver://localhost:1433;databaseName=Florinvent;user=sa;password=12345678;encrypt=true;trustServerCertificate=true";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public List<Monitoreo> obtenerProductoStock() {
        List<Monitoreo> monitoreos = new ArrayList<>();
        String query = "SELECT idProducto, nombre, cantidad FROM Producto ";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Monitoreo monitoreo = new Monitoreo(
                        rs.getInt("idProducto"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad")
                );
                monitoreos.add(monitoreo);

            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return monitoreos;
    }
    
    public List<Monitoreo> obtenerProductoMonitoreo(int umbral) {
        List<Monitoreo> monitoreos = new ArrayList<>();
        String query = "EXEC sp_ProductosBajosEnStock ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query);) {
                stmt.setInt(1, umbral);
                ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Monitoreo monitoreo = new Monitoreo(
                        rs.getInt("idProducto"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad")
                );
                monitoreos.add(monitoreo);

            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return monitoreos;
    }
    private void handleSQLException(SQLException e) {
        e.printStackTrace();
    }
}
