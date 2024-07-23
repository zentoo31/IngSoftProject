package view;

import controller.MonitoreoController;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.sql.*;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import model.Monitoreo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.ConexionSQL;

public class PanelMonitoreo extends javax.swing.JPanel {
    private MonitoreoController monitoreoController;
    
    public PanelMonitoreo() {
        monitoreoController = new MonitoreoController();
        initComponents();
        ActualizarTabla();
    }
    
    public void ActualizarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("idProducto");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        List<Monitoreo> listamonitoreo = monitoreoController.obtenerProductoStock();
        for(Monitoreo monitoreo : listamonitoreo){
            model.addRow(new Object[]{
                monitoreo.getIdProducto(),
                monitoreo.getNombre(),
                monitoreo.getCantidad()
            });
        }
        jTable2.setModel(model);
        jTable2.setDefaultEditor(Object.class, null);
        
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("idProducto");
        model2.addColumn("Nombre");
        model2.addColumn("Cantidad");
        jTable1.setModel(model2);
        jTable1.setDefaultEditor(Object.class, null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtUmbral = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Monitoreo");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Umbral stock:");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Productos:");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 910, 190));
        jPanel8.add(txtUmbral, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 80, 30));

        jButton1.setBackground(new java.awt.Color(255, 204, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Consultar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 100, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        jButton4.setToolTipText("");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 90, 40, 40));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 930, 370));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 910, 240));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fondo-Florinvent-completo.png"))); // NOI18N
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 951, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int umbral = (int) txtUmbral.getValue();
        List<Monitoreo> listamonitoreo = monitoreoController.obtenerProductoMonitoreo(umbral);
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("idProducto");
        model2.addColumn("Nombre");
        model2.addColumn("Cantidad");
        for(Monitoreo monitoreo : listamonitoreo){
            model2.addRow(new Object[]{
                monitoreo.getIdProducto(),
                monitoreo.getNombre(),
                monitoreo.getCantidad()
            });
        }
        jTable1.setModel(model2);
        jTable1.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            URL reportUrl = getClass().getResource("/Icons/reporteMonitoreo.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObject(reportUrl);
            InputStream logoInputStream = getClass().getResourceAsStream("/Icons/logoFlorinventTransparent.png");
            Connection conn = ConexionSQL.obtenerConexion();
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("REPORT_CONNECTION", conn);
            parameters.put("logoEmpresa", logoInputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException ex) {
            Logger.getLogger(PanelInventario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private javax.swing.JSpinner txtUmbral;
    // End of variables declaration//GEN-END:variables
}
