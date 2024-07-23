package view;

import controller.ProductoController;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Producto;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import util.ConexionSQL;

public class PanelInventario extends javax.swing.JPanel {

    private ProductoController productoController;

    public PanelInventario() {
        initComponents();
        productoController = new ProductoController();
        ActualizarTabla();

    }

    public void ActualizarTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("idProducto");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        model.addColumn("Descripcion");
        model.addColumn("Almacen");
        List<Producto> listaproducto = productoController.listarProductos();
        for (Producto producto : listaproducto) {
            model.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCantidad(),
                producto.getDescripcion(),
                producto.getIdAlmacen()
            });
        }
        jTable1.setModel(model);
        jTable1.setDefaultEditor(Object.class, null);
    }

    public void LimpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtDescripcion.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnAgregar3 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        txtLimpiar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar3.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregar3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Agregar.png"))); // NOI18N
        btnAgregar3.setToolTipText("");
        btnAgregar3.setBorderPainted(false);
        btnAgregar3.setContentAreaFilled(false);
        btnAgregar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Agregar1.png"))); // NOI18N
        btnAgregar3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Agregar1.png"))); // NOI18N
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });
        jPanel8.add(btnAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 170, 70));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Eliminar1.png"))); // NOI18N
        btnEliminar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Eliminar1.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel8.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 150, -1));

        btnActualizar.setBackground(new java.awt.Color(255, 0, 0));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Actualizar.png"))); // NOI18N
        btnActualizar.setToolTipText("");
        btnActualizar.setBorderPainted(false);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Actualizar1.png"))); // NOI18N
        btnActualizar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Actualizar1.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel8.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 180, -1));
        jPanel8.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 30));
        jPanel8.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad:");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, 20));
        jPanel8.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre:");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        btnConsultar.setBackground(new java.awt.Color(255, 0, 0));
        btnConsultar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Consultar.png"))); // NOI18N
        btnConsultar.setToolTipText("");
        btnConsultar.setBorderPainted(false);
        btnConsultar.setContentAreaFilled(false);
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Consultar1.png"))); // NOI18N
        btnConsultar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Consultar1.png"))); // NOI18N
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel8.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 200, 70));

        txtLimpiar.setBackground(new java.awt.Color(255, 0, 0));
        txtLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Limpiar.png"))); // NOI18N
        txtLimpiar.setToolTipText("");
        txtLimpiar.setBorderPainted(false);
        txtLimpiar.setContentAreaFilled(false);
        txtLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtLimpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Limpiar1.png"))); // NOI18N
        txtLimpiar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Limpiar1.png"))); // NOI18N
        txtLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLimpiarActionPerformed(evt);
            }
        });
        jPanel8.add(txtLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 170, -1));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Relleno.png"))); // NOI18N
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 160, 50));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Relleno.png"))); // NOI18N
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 160, 50));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Gestión de inventario");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, 90));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Código:");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descripción:");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Relleno.png"))); // NOI18N
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 160, 50));
        jPanel8.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 140, 30));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Relleno.png"))); // NOI18N
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 160, 50));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio:");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        jButton4.setToolTipText("");
        jButton4.setActionCommand("");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 50, 40));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 920, 280));

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

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 910, 330));

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

    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed
        int idProducto = Integer.parseInt(txtCodigo.getText());
        String nombre = txtNombre.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        double precio = Double.parseDouble(txtPrecio.getText());
        String descripcion = txtDescripcion.getText();
        String[] fields = {txtCodigo.getText().toString(), txtNombre.getText().toString(), txtCantidad.getText().toString(), txtPrecio.getText().toString(), txtDescripcion.getText().toString()};
        boolean allBlank = Arrays.stream(fields).allMatch(String::isBlank);

        if (allBlank) {
            JOptionPane.showMessageDialog(null, "Completa los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Producto producto = new Producto(idProducto, nombre, precio, cantidad, descripcion);
            boolean success = productoController.registrarProducto(producto);
            if (success) {
                JOptionPane.showMessageDialog(null, "Producto registrado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        LimpiarCampos();
        ActualizarTabla();
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int idProducto = Integer.parseInt(txtCodigo.getText());
        boolean success = productoController.eliminarProducto(idProducto);
        if (success) {
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        ActualizarTabla();
        LimpiarCampos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int idProducto = Integer.parseInt(txtCodigo.getText());
        String nombre = txtNombre.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        double precio = Double.parseDouble(txtPrecio.getText());
        String descripcion = txtDescripcion.getText();

        Producto producto = new Producto(idProducto, nombre, precio, cantidad, descripcion);
        boolean success = productoController.actualizarProducto(producto, idProducto);
        if (success) {
            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        ActualizarTabla();
        LimpiarCampos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        int idProducto = Integer.parseInt(txtCodigo.getText());
        Producto producto = productoController.consultarProducto(idProducto);
        if (producto != null) {
            txtCodigo.setText(String.valueOf(producto.getIdProducto()));
            txtNombre.setText(producto.getNombre());
            txtPrecio.setText(String.valueOf(producto.getPrecio()));
            txtCantidad.setText(String.valueOf(producto.getCantidad()));
            txtDescripcion.setText(producto.getDescripcion());
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLimpiarActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_txtLimpiarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
             // Cargar el reporte
            URL reportUrl = getClass().getResource("/Icons/reporteInventario.jasper");
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JButton txtLimpiar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
