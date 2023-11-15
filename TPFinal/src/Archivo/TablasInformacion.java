
package Archivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class TablasInformacion extends javax.swing.JFrame {
    DefaultTableModel dtm = new DefaultTableModel();
    String tipoTabla;


    public TablasInformacion(String tipoTabla) {
        initComponents();
        tablas(tipoTabla);
        
    }

   private TablasInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   private void tablas(String tabla){ 
        switch(tabla){
            case "clientes": tablaClientes();
            break;
            case "Seguro Vida": tablaSegVida();
            break;
            case "Seguro Automotor": tablaSegAuto() ;
            break;
            case "Seguro Hogar": tablaSegHogar();
            break;
        }
   }
    //id,nombre,apellido,mail,fechaNacimiento,genero,domicilio,localidad,provincia,estadoCivil,hijos
    public void tablaClientes(){
        dtm.addColumn("CUIT");
        dtm.addColumn("NOMBRE");
        dtm.addColumn("APELLIDO");
        dtm.addColumn("MAIL");
        dtm.addColumn("FECHA NAC.");
        dtm.addColumn("GENERO");
        dtm.addColumn("DOMICILIO");
        dtm.addColumn("LOCALIDA");
        dtm.addColumn("PROVINCIA");
        dtm.addColumn("ESTADO CIVIL");
        dtm.addColumn("HIJOS");
        
        jTable_tabla.setModel(dtm);
        
        String fila[];
        String linea;
        
        try {
            BufferedReader escribir = new BufferedReader(new FileReader("archivoClientes.txt"));
            try {
                linea=escribir.readLine();
                while(linea!=null){
                    fila=linea.split(",");
                    dtm.addRow(fila);
                    linea=escribir.readLine();
                }
            } catch (IOException ex) {
                Logger.getLogger(TablasInformacion.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TablasInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void tablaSegVida(){
        dtm.addColumn("TIPO SEGURO");
        dtm.addColumn("CUIT");
        dtm.addColumn("NOMBRE Y APELLIDO");
        dtm.addColumn("TELEFONO");
        dtm.addColumn("MAIL");
        dtm.addColumn("INCENDIO");
        dtm.addColumn("ROBO");
        dtm.addColumn("INUNDACION");
        dtm.addColumn("HELADERA");
        dtm.addColumn("LAVARROPAS");
        dtm.addColumn("COCINA");
        dtm.addColumn("NOTEBOOKS");
        dtm.addColumn("NOTEBOOKS CANT");
        dtm.addColumn("CONSOLAS");
        dtm.addColumn("TELEVISOR");
        dtm.addColumn("TELEVISOR CANT");
        
        jTable_tabla.setModel(dtm);
        
        String fila[];
        String linea;
        try {
            BufferedReader escribir = new BufferedReader(new FileReader("segurosHogar.txt"));            
            try {
                linea=escribir.readLine();
                while(linea!=null){
                    fila=linea.split(",");
                    dtm.addRow(fila);
                    linea=escribir.readLine();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    private void tablaSegAuto(){
        dtm.addColumn("TIPO SEGURO");
        dtm.addColumn("CUIT");
        dtm.addColumn("NOMBRE Y APELLIDO");
        dtm.addColumn("TELEFONO");
        dtm.addColumn("MAIL");
        dtm.addColumn("DOMINIO");
        dtm.addColumn("MARCA");
        dtm.addColumn("dtm");
        dtm.addColumn("AÑO");
        dtm.addColumn("TERCERO COMPLETO");
        dtm.addColumn("RESP. CIVIL");
        dtm.addColumn("TODO RIESGO CF");
        dtm.addColumn("TODO RIESGO SF");
        dtm.addColumn("GRANIZO");
        dtm.addColumn("FRANQUICIA");
        

        jTable_tabla.setModel(dtm);
        
        //cargarFilas();
        
        String fila[];
        String linea;
        try {
            BufferedReader escribir = new BufferedReader(new FileReader("segurosAutomotor.txt"));            
            try {
                linea=escribir.readLine();
                while(linea!=null){
                    fila=linea.split(",");
                    dtm.addRow(fila);
                    linea=escribir.readLine();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
    private void tablaSegHogar(){
        dtm.addColumn("TIPO SEGURO");
        dtm.addColumn("CUIT");
        dtm.addColumn("NOMBRE Y APELLIDO");
        dtm.addColumn("TELEFONO");
        dtm.addColumn("MAIL");
        dtm.addColumn("INCENDIO");
        dtm.addColumn("ROBO");
        dtm.addColumn("INUNDACION");
        dtm.addColumn("HELADERA");
        dtm.addColumn("LAVARROPAS");
        dtm.addColumn("COCINA");
        dtm.addColumn("NOTEBOOKS");
        dtm.addColumn("NOTEBOOKS CANT");
        dtm.addColumn("CONSOLAS");
        dtm.addColumn("TELEVISOR");
        dtm.addColumn("TELEVISOR CANT");
        
        jTable_tabla.setModel(dtm);
        
        //cargarFilas();
        
        String fila[];
        String linea;
        try {
            BufferedReader escribir = new BufferedReader(new FileReader("segurosHogar.txt"));            
            try {
                linea=escribir.readLine();
                while(linea!=null){
                    fila=linea.split(",");
                    dtm.addRow(fila);
                    linea=escribir.readLine();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
        
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_tabla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);

        jTable_tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_tabla.setOpaque(false);
        jScrollPane1.setViewportView(jTable_tabla);

        jPanel3.setOpaque(false);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 255));
        jButton1.setText("Cerrar");
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTADOS ");
        jPanel4.add(jLabel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 600));

        jLabel4.setFont(new java.awt.Font("Castellar", 0, 100)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("m");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 110, 90));

        jLabel3.setFont(new java.awt.Font("Castellar", 0, 100)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("D");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 90, 90));

        jLabel1.setBackground(new java.awt.Color(110, 110, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TablasInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablasInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablasInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablasInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablasInformacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_tabla;
    // End of variables declaration//GEN-END:variables
}
