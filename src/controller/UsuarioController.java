
package controller;

import model.Usuario;
import services.UsuarioService;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = new UsuarioService();
    }
    
    public Usuario login(String correo, String contraseña) {
        Usuario usuario = usuarioService.login(correo, contraseña);
        return usuario;
    }
    
    public boolean register(Usuario usuario) {
        boolean registrado = usuarioService.register(usuario);
        return registrado;
    } 
    
}
