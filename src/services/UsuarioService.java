
package services;

import dao.UsuarioDAO;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioService {
    private UsuarioDAO usuarioDAO;
    
    public UsuarioService(){
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public Usuario login(String correo, String contraseña){
        return usuarioDAO.login(correo, contraseña);
    }
    
    public boolean register(Usuario usuario){
        return usuarioDAO.register(usuario);
    }
}
