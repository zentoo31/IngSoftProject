package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GestUbicacion;

public class GestUbicacionDAO {

    String url = "jdbc:sqlserver://localhost:1433;databaseName=Florinvent;user=sa;password=12345678;encrypt=true;trustServerCertificate=true";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public List<GestUbicacion> obtenerHistorial() {
        List<GestUbicacion> gestUbicacions = new ArrayList<>();
        String query = "EXEC sp_ConsultarHistorialUbicaciones";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                GestUbicacion gestUbicacion = new GestUbicacion(
                        rs.getString("nombreProducto"), 
                        rs.getString("nombreAlmacen"));
                gestUbicacion.setFechaRegistro(rs.getString("fechaRegistro"));
                gestUbicacions.add(gestUbicacion);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return gestUbicacions;
    }
    
    public boolean actualizarUbicacion(GestUbicacion gestUbicacion){
        String query = "EXEC sp_ActualizarUbicacionProducto ?, ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, gestUbicacion.getNombre());
            stmt.setString(2, gestUbicacion.getNombreAlmacen());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }catch (SQLException e) {
            handleSQLException(e);
            return false;
        }

    }
    
    private void handleSQLException(SQLException e) {
        e.printStackTrace();
    }
}
