package services;

import dao.GestUbicacionDAO;
import java.util.List;
import model.GestUbicacion;

public class GestUbicacionService {
    private GestUbicacionDAO gestUbicacionDAO;

    public GestUbicacionService() {
        this.gestUbicacionDAO = new GestUbicacionDAO();
    }
    
    public List<GestUbicacion> obtenerHistorial() {
        return gestUbicacionDAO.obtenerHistorial();
    }
    
    public boolean actualizarUbicacion(GestUbicacion gestUbicacion){
        return gestUbicacionDAO.actualizarUbicacion(gestUbicacion);
    }

}
