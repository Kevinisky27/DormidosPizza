/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.edu.dormidos_Pizzagt;

import com.gt.edu.dominos_Pizzagt.conection.MySQLSconexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevinalexanderlimarecinos
 */
public class administracionDominos extends javax.swing.JFrame {
    MySQLSconexion ConectorDB = new MySQLSconexion();
    Connection conexiondb = ConectorDB.Conectar();
    
    /**
     * Creates new form administracionDominos
     */
    public administracionDominos() {
        initComponents();
        MostrarDatosDB();
        sucursales();
        pizzas();
        
       this.setLocationRelativeTo(null);
    }
    
    private void Limpiar(){
        cboPizzas.addItem("-- Pizzas --");
        cboSucursal.addItem("-- Sucursal");
        txtCantidad.setText("");
        txtPrecio.setText("");
        TaDes.setText("");
    }
    
    private void CrearPizza(){
        String sql =  "INSERT INTO sql10413110.new_table (`Pizza`, `Descripcion`, `Cantidad`, `Precio`, `Sucursal`)"
                    + "VALUES(?, ?, ?, ?, ?);";
        try {
            
            PreparedStatement ppt = conexiondb.prepareStatement(sql);
            
            ppt.setString(1, cboPizzas.getItemAt(cboPizzas.getSelectedIndex()));
            ppt.setString(2, TaDes.getText().trim());
            ppt.setString(3, txtCantidad.getText().trim());
            ppt.setString(4, txtPrecio.getText().trim());
            ppt.setString(5, cboSucursal.getItemAt(cboSucursal.getSelectedIndex()));
            ppt.executeUpdate();
            ppt.close();
            
            Limpiar();
            MostrarDatosDB();
            //mensaje exitoso :) 
            JOptionPane.showMessageDialog(null, "Preparando la Pizza, en un momento está lista...");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }      
    }
    
    private void MostrarDatosDB(){
        DefaultTableModel Diseñodb = new DefaultTableModel();
        
        Diseñodb.addColumn("id");
        Diseñodb.addColumn("Pizza");
        Diseñodb.addColumn("Descripción");
        Diseñodb.addColumn("Cantidad");
        Diseñodb.addColumn("Precio");
        Diseñodb.addColumn("Sucursal");
        
        tblPizza.setModel(Diseñodb);
        
        String Consultadb = "SELECT * FROM sql10413110.new_table";
        String Datos[] = new String [7];
        
        try{     
            Statement Datosdb = conexiondb.createStatement(); 
            ResultSet result = Datosdb.executeQuery(Consultadb);
            
            while (result.next()){
                Datos[0] = result.getString(1);
                Datos[1] = result.getString(2);
                Datos[2] = result.getString(3);
                Datos[3] = result.getString(4);
                Datos[4] = result.getString(5); 
                Datos[5] = result.getString(6); 
                Diseñodb.addRow(Datos);
            }
            tblPizza.setModel(Diseñodb);
            
        } catch(Exception e){
           
            JOptionPane.showMessageDialog(null, "Error al momento de mostrar los datos.");
        }
    }
    
    private void sucursales(){
        cboSucursal.addItem("Alta Verapaz");
        cboSucursal.addItem("Baja Verapaz");
        cboSucursal.addItem("Chimaltenago");
        cboSucursal.addItem("Chiquimula");
        cboSucursal.addItem("Guatemala");
        cboSucursal.addItem("El Progreso");
        cboSucursal.addItem("Escuintla");
        cboSucursal.addItem("Huehuetenango");
        cboSucursal.addItem("Izabal");
        cboSucursal.addItem("Jalapa");
        cboSucursal.addItem("Jutiapa");
        cboSucursal.addItem("Petén");
        cboSucursal.addItem("Quiché");
        cboSucursal.addItem("Retalhuleu");
        cboSucursal.addItem("Sacatepequez");
        cboSucursal.addItem("San Marcos");
        cboSucursal.addItem("Santa Rosa");
        cboSucursal.addItem("Sololá");
        cboSucursal.addItem("Suchitepequez");
        cboSucursal.addItem("Totonicapán");
        cboSucursal.addItem("Zacapa"); 
    }
    
    private void pizzas(){
        cboPizzas.addItem("Personalizar Pizza");
        cboPizzas.addItem("5 Carnes");
        cboPizzas.addItem("Hawaiana");
        cboPizzas.addItem("Americana");
        cboPizzas.addItem("Deluxe");
        cboPizzas.addItem("Veggy");
        cboPizzas.addItem("Margarita Especial");
        cboPizzas.addItem("Carne y Tocino");
        cboPizzas.addItem("Extravaganzza");
        cboPizzas.addItem("Margarita");
        cboPizzas.addItem("Churrasco");
        cboPizzas.addItem("Carne Molida");
        cboPizzas.addItem("Jamón");
        
    }
    
    private void PreciosPizzas(){
        String Pizzas = (String) cboPizzas.getSelectedItem();
        
        if (Pizzas.equals("-Pizzas-")){
            txtPrecio.setText("");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Personalizar Pizza")){
            txtPrecio.setText("Q  100.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("5 Carnes")){
            txtPrecio.setText("Q  95.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Hawaiana")){
            txtPrecio.setText("Q  80.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Americana")){
            txtPrecio.setText("Q  130.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Deluxe")){
            txtPrecio.setText("Q   90.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Veggy")){
            txtPrecio.setText("Q  140.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Margarita Especial")){
            txtPrecio.setText("Q   160.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Carne y Tocino")){
            txtPrecio.setText("Q   90.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Extravaganzza")){
            txtPrecio.setText("Q  100.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Margarita")){
            txtPrecio.setText("Q   90.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Churrasco")){
            txtPrecio.setText("Q   130.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Carne Molida")){
            txtPrecio.setText("Q  80.00");
            DescripcionPizzas();
        }
        
        if (Pizzas.equals("Jamón")){
            txtPrecio.setText("Q   90.00");
            DescripcionPizzas();
        }
    }
    
    
    private void DescripcionPizzas(){
        String Pizzas = (String) cboPizzas.getSelectedItem();
        
        if (Pizzas.equals("-Pizzas-")){
            TaDes.setText("");
        }
        
        if (Pizzas.equals("Personalizar Pizza")){
            TaDes.setText("-- Escoge tus ingredientes -- \n "
                    + "");
          
        }
        
        if (Pizzas.equals("5 Carnes")){
            TaDes.setText("-- Ingresa alguna observación -- \n "
                    + "");
          
        }
        
        if (Pizzas.equals("Hawaiana")){
            TaDes.setText("-- Ingresa alguna observación -- \n "
                    + "");
        }
        
        if (Pizzas.equals("Americana")){
            TaDes.setText("-- Ingresa alguna observación -- \n"
                    + "");
        }
        
        if (Pizzas.equals("Deluxe")){
            TaDes.setText("-- Ingresa alguna observación -- \n"
                    + "");
        }
        
        if (Pizzas.equals("Veggy")){
            TaDes.setText("-- Ingresa alguna observación -- \n"
                    + "");
        }
        
        if (Pizzas.equals("Margarita Especial")){
            TaDes.setText("-- Ingresa alguna observación -- \n"
                    + "");
        }
        
        if (Pizzas.equals("Carne y Tocino")){
            TaDes.setText("-- Ingresa alguna observación -- \n"
                    + "");
        }
        
        if (Pizzas.equals("Extravaganzza")){
            TaDes.setText("-- Ingresa alguna observación -- \n"
                    + "");
        }
        
        if (Pizzas.equals("Margarita")){
            TaDes.setText("-- Ingresa alguna observación -- \n"
                    + "");
        }
        
        if (Pizzas.equals("Churrasco")){
            TaDes.setText("-- Ingresa alguna observación -- \n"
                    + "");
        }
        
        if (Pizzas.equals("Carne Molida")){
            TaDes.setText("-- Ingresa alguna observación -- \n"
                    + "");
        }
        
        if (Pizzas.equals("Jamón")){
            TaDes.setText("-- Ingresa alguna observación -- \n"
                    + "");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        btnOrdenar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnOrdenar = new javax.swing.JButton();
        btnOrdenar2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboSucursal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboPizzas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPizza = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TaDes = new javax.swing.JTextArea();
        txtCantidad = new javax.swing.JTextField();

        jLabel5.setText("Cantidad");

        jButton1.setText("jButton1");

        btnOrdenar1.setBackground(new java.awt.Color(255, 255, 255));
        btnOrdenar1.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        btnOrdenar1.setForeground(new java.awt.Color(227, 24, 55));
        btnOrdenar1.setText("Crear Pizza");
        btnOrdenar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdenar1MouseClicked(evt);
            }
        });
        btnOrdenar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenar1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dormidos Pizza - Administración");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 100, 145));

        btnOrdenar.setBackground(new java.awt.Color(255, 255, 255));
        btnOrdenar.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        btnOrdenar.setForeground(new java.awt.Color(0, 100, 145));
        btnOrdenar.setText("Ordenes");
        btnOrdenar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdenarMouseClicked(evt);
            }
        });
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        btnOrdenar2.setBackground(new java.awt.Color(255, 255, 255));
        btnOrdenar2.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        btnOrdenar2.setForeground(new java.awt.Color(227, 24, 55));
        btnOrdenar2.setText("Crear Pizza");
        btnOrdenar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdenar2MouseClicked(evt);
            }
        });
        btnOrdenar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOrdenar)
                .addGap(131, 131, 131))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(699, Short.MAX_VALUE)
                    .addComponent(btnOrdenar2)
                    .addGap(4, 4, 4)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addComponent(btnOrdenar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jLabel2.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel2.setText("Sucursal");

        cboSucursal.setBackground(new java.awt.Color(153, 153, 153));
        cboSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Sucursal-" }));
        cboSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSucursalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel3.setText("Pizzas");

        cboPizzas.setBackground(new java.awt.Color(153, 153, 153));
        cboPizzas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pizzas-" }));
        cboPizzas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPizzasItemStateChanged(evt);
            }
        });
        cboPizzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPizzasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad");

        jLabel6.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel6.setText("Precio");

        jLabel1.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel1.setText("Descripción");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 100, 145));
        jLabel7.setText("ADMINISTRACIÓN");

        tblPizza.setFont(new java.awt.Font("ITF Devanagari Marathi", 0, 14)); // NOI18N
        tblPizza.setForeground(new java.awt.Color(0, 100, 145));
        tblPizza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPizza);

        TaDes.setColumns(20);
        TaDes.setFont(new java.awt.Font("Mishafi", 0, 12)); // NOI18N
        TaDes.setRows(5);
        jScrollPane2.setViewportView(TaDes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cboPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 35, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(cboPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSucursalActionPerformed

    private void cboPizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPizzasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPizzasActionPerformed

    private void cboPizzasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPizzasItemStateChanged
        // TODO add your handling code here:
        PreciosPizzas();  
    }//GEN-LAST:event_cboPizzasItemStateChanged

    private void btnOrdenarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenarMouseClicked
        // TODO add your handling code here:
        ordenes or = new ordenes();
        or.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOrdenarMouseClicked

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnOrdenar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrdenar1MouseClicked

    private void btnOrdenar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrdenar1ActionPerformed

    private void btnOrdenar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenar2MouseClicked
        // TODO add your handling code here:
        CrearPizza();
    }//GEN-LAST:event_btnOrdenar2MouseClicked

    private void btnOrdenar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrdenar2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(administracionDominos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(administracionDominos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(administracionDominos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(administracionDominos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new administracionDominos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TaDes;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnOrdenar1;
    private javax.swing.JButton btnOrdenar2;
    private javax.swing.JComboBox<String> cboPizzas;
    private javax.swing.JComboBox<String> cboSucursal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblPizza;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
