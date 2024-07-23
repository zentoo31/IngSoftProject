/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import model.Usuario;

public class UsuarioDAO {

    String url = "jdbc:sqlserver://localhost:1433;databaseName=Florinvent;user=sa;password=12345678;encrypt=true;trustServerCertificate=true";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public Usuario login(String correo, String contraseña) {
        String query = "SELECT * FROM Usuario WHERE correo = ? AND contraseña = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, correo);
            stmt.setString(2, contraseña);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(
                            rs.getString("nombre"),
                            rs.getString("correo"),
                            rs.getString("contraseña"),
                            rs.getString("username"),
                            rs.getString("rol")
                    );
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return null;
    }

    public boolean register(Usuario usuario) {
        String query = "INSERT INTO Usuario (nombre, correo, rol, username, contraseña) VALUES (?, ?, ?, ?,?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getRol());
            stmt.setString(4, usuario.getUsername());
            stmt.setString(5, usuario.getContraseña());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    private void handleSQLException(SQLException e) {
        e.printStackTrace();
    }
}
