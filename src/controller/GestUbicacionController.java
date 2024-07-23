package controller;

import java.util.List;
import model.GestUbicacion;
import services.GestUbicacionService;

public class GestUbicacionController {
    private GestUbicacionService gestUbicacionService;

    public GestUbicacionController() {
        this.gestUbicacionService = new GestUbicacionService();
    }
    
    public List<GestUbicacion> obtenerHistorial() {
        return gestUbicacionService.obtenerHistorial();
    }
    
    public boolean actualizarUbicacion(GestUbicacion gestUbicacion){
        return gestUbicacionService.actualizarUbicacion(gestUbicacion);
    }
   
}
