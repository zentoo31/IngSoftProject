package view;

import controller.GestUbicacionController;
import controller.ProductoController;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.GestUbicacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Producto;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import util.ConexionSQL;
public class PanelUbicacion extends javax.swing.JPanel {

    private GestUbicacionController gestUbicacionController;
    private ProductoController productoController;
    private List<GestUbicacion> listagestubicacion;

    public PanelUbicacion() {
        gestUbicacionController = new GestUbicacionController();
        productoController = new ProductoController();
        initComponents();
        ActualizarHistorial();
        inicializarCombo();
    }

    public void ActualizarHistorial() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Almacen");
        model.addColumn("Fecha");
        listagestubicacion = gestUbicacionController.obtenerHistorial();
        for (GestUbicacion gestUbicacion : listagestubicacion) {
            model.addRow(new Object[]{
                gestUbicacion.getNombre(),
                gestUbicacion.getNombreAlmacen(),
                gestUbicacion.getFechaRegistro()
            });
        }
        jTable1.setModel(model);
        jTable1.setDefaultEditor(Object.class, null);

    }
    public void inicializarCombo(){
        List<Producto> listaProducto = productoController.listarProductos();
        List<String> listaNombres = new ArrayList<>();
        List<String> listaUbicaciones = new ArrayList<>();
         for (int i = 1; i <= 6; i++) {
            listaUbicaciones.add("Almacen " + i);
        }
        for (Producto producto : listaProducto) {
            listaNombres.add(producto.getNombre());
        }

        comboProducto.setModel(new DefaultComboBoxModel<String>(listaNombres.toArray(new String[0])));
        AutoCompleteDecorator.decorate(comboProducto);
        comboUbicacion.setModel(new DefaultComboBoxModel<String>(listaUbicaciones.toArray(new String[0])));
        AutoCompleteDecorator.decorate(comboUbicacion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        area6 = new javax.swing.JButton();
        area3 = new javax.swing.JButton();
        area1 = new javax.swing.JButton();
        area2 = new javax.swing.JButton();
        area4 = new javax.swing.JButton();
        area5 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboUbicacion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboProducto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        area6.setBackground(new java.awt.Color(255, 204, 102));
        area6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/marcador-de-posicion.png"))); // NOI18N
        area6.setContentAreaFilled(false);
        area6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                area6ActionPerformed(evt);
            }
        });
        jPanel8.add(area6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 60, 60));

        area3.setBackground(new java.awt.Color(255, 204, 102));
        area3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/marcador-de-posicion.png"))); // NOI18N
        area3.setContentAreaFilled(false);
        area3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                area3ActionPerformed(evt);
            }
        });
        jPanel8.add(area3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 520, 60, 30));

        area1.setBackground(new java.awt.Color(255, 204, 102));
        area1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/marcador-de-posicion.png"))); // NOI18N
        area1.setContentAreaFilled(false);
        area1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                area1ActionPerformed(evt);
            }
        });
        jPanel8.add(area1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 70, 40));

        area2.setBackground(new java.awt.Color(255, 204, 102));
        area2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/marcador-de-posicion.png"))); // NOI18N
        area2.setContentAreaFilled(false);
        area2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                area2ActionPerformed(evt);
            }
        });
        jPanel8.add(area2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, 50, 30));

        area4.setBackground(new java.awt.Color(255, 204, 102));
        area4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/marcador-de-posicion.png"))); // NOI18N
        area4.setContentAreaFilled(false);
        area4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                area4ActionPerformed(evt);
            }
        });
        jPanel8.add(area4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, 40, 30));

        area5.setBackground(new java.awt.Color(255, 204, 102));
        area5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/marcador-de-posicion.png"))); // NOI18N
        area5.setContentAreaFilled(false);
        area5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                area5ActionPerformed(evt);
            }
        });
        jPanel8.add(area5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 580, 40, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Gestionar ubicación");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ubicación:");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Historial:");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Selecciona ubicación;");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/almacen - grande.png"))); // NOI18N
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        comboUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(comboUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 310, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Producto:");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        comboProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(comboProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 310, 40));

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

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 300, 390));

        jButton1.setBackground(new java.awt.Color(255, 204, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 90, 40));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        jButton4.setToolTipText("");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 50, 40));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 930, 640));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fondo-Florinvent-completo.png"))); // NOI18N
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
        String producto = (String) comboProducto.getSelectedItem();
        String ubicacion = (String) comboUbicacion.getSelectedItem();

        GestUbicacion gestUbicacion = new GestUbicacion(producto, ubicacion);
        boolean success = gestUbicacionController.actualizarUbicacion(gestUbicacion);
        if (success) {
            JOptionPane.showMessageDialog(null, "Ubicacion actualizada exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el actualizar ubicación", "Error", JOptionPane.ERROR_MESSAGE);
        }
       ActualizarHistorial();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void area1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_area1ActionPerformed
        comboUbicacion.setSelectedIndex(0);
    }//GEN-LAST:event_area1ActionPerformed

    private void area2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_area2ActionPerformed
        comboUbicacion.setSelectedIndex(1);
    }//GEN-LAST:event_area2ActionPerformed

    private void area3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_area3ActionPerformed
        comboUbicacion.setSelectedIndex(2);
    }//GEN-LAST:event_area3ActionPerformed

    private void area4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_area4ActionPerformed
        comboUbicacion.setSelectedIndex(3);
    }//GEN-LAST:event_area4ActionPerformed

    private void area5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_area5ActionPerformed
        comboUbicacion.setSelectedIndex(4);
    }//GEN-LAST:event_area5ActionPerformed

    private void area6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_area6ActionPerformed
        comboUbicacion.setSelectedIndex(5);
    }//GEN-LAST:event_area6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            // Cargar el reporte
            URL reportUrl = getClass().getResource("/Icons/reporteUbicacion.jasper");
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
    private javax.swing.JButton area1;
    private javax.swing.JButton area2;
    private javax.swing.JButton area3;
    private javax.swing.JButton area4;
    private javax.swing.JButton area5;
    private javax.swing.JButton area6;
    private javax.swing.JComboBox<String> comboProducto;
    private javax.swing.JComboBox<String> comboUbicacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
