package controller;

import java.util.List;
import model.Monitoreo;
import services.MonitoreoService;

public class MonitoreoController {
    private MonitoreoService monitoreoService;

    public MonitoreoController() {
        this.monitoreoService = new MonitoreoService();
    }
    
    public List<Monitoreo> obtenerProductoStock(){
        return monitoreoService.obtenerProductoStock();
    }
    
    public List<Monitoreo> obtenerProductoMonitoreo(int umbral){
        return monitoreoService.obtenerProductoMonitoreo(umbral);
    }
}
