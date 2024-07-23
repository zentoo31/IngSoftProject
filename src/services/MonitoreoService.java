package services;

import dao.MonitoreoDAO;
import java.util.List;
import model.Monitoreo;

public class MonitoreoService {
    private MonitoreoDAO monitoreoDAO;

    public MonitoreoService() {
        this.monitoreoDAO = new MonitoreoDAO();
    }
    
    public List<Monitoreo> obtenerProductoStock(){
        return monitoreoDAO.obtenerProductoStock();
    }
    
    public List<Monitoreo> obtenerProductoMonitoreo(int umbral){
        return monitoreoDAO.obtenerProductoMonitoreo(umbral);
    }
}
