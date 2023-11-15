package Seguros;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Contrataciones extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();

    public Contrataciones(String seguro) {
        initComponents();
        crearTabla(seguro);
    }

    private Contrataciones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void crearTabla(String seguro){
        
        switch(seguro){
            case"seguro hogar": getSeguroHogar();
            break;
            case"seguro vida": getSeguroVida();
            break;
            case"seguro vehiculos": getSeguroVehiculos();
            break;
        }
        
        
    }
    public void getSeguroHogar(){
        
        modelo.addColumn("TIPO SEGURO");
        modelo.addColumn("CUIT");
        modelo.addColumn("NOMBRE Y APELLIDO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MAIL");
        modelo.addColumn("INCENDIO");
        modelo.addColumn("ROBO");
        modelo.addColumn("INUNDACION");
        modelo.addColumn("HELADERA");
        modelo.addColumn("LAVARROPAS");
        modelo.addColumn("COCINA");
        modelo.addColumn("NOTEBOOKS");
        modelo.addColumn("NOTEBOOKS CANT");
        modelo.addColumn("CONSOLAS");
        modelo.addColumn("TELEVISOR");
        modelo.addColumn("TELEVISOR CANT");
        
        jTable_tabla.setModel(modelo);
        
        //cargarFilas();
        
        String fila[];
        String linea;
        try {
            BufferedReader escribir = new BufferedReader(new FileReader("segurosHogar.txt"));            
            try {
                linea=escribir.readLine();
                while(linea!=null){
                    fila=linea.split(",");
                    modelo.addRow(fila);
                    linea=escribir.readLine();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    public void getSeguroVida(){
        
        modelo.addColumn("TIPO SEGURO");
        modelo.addColumn("CUIT");
        modelo.addColumn("NOMBRE Y APELLIDO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MAIL");
        modelo.addColumn("MUERTE");
        modelo.addColumn("MUERTE ACCIDENTAL");
        modelo.addColumn("INTERNACION");
        modelo.addColumn("DIAS INTERNACION");
        modelo.addColumn("PARALISIS");
        modelo.addColumn("BEENFICIARIO 1");
        modelo.addColumn("PARENTESCO");
        modelo.addColumn("BEENFICIARIO 2");
        modelo.addColumn("PARENTESCO");
        modelo.addColumn("BEENFICIARIO 3");
        modelo.addColumn("PARENTESCO");
        modelo.addColumn("BEENFICIARIO 4");
        modelo.addColumn("PARENTESCO");
        
        
        jTable_tabla.setModel(modelo);
        
        //cargarFilas();
        
        String fila[];
        String linea;
        try {
            BufferedReader escribir = new BufferedReader(new FileReader("segurosVida.txt"));            
            try {
                linea=escribir.readLine();
                while(linea!=null){
                    fila=linea.split(",");
                    modelo.addRow(fila);
                    linea=escribir.readLine();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    public void getSeguroVehiculos(){
        
        modelo.addColumn("TIPO SEGURO");
        modelo.addColumn("CUIT");
        modelo.addColumn("NOMBRE Y APELLIDO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MAIL");
        modelo.addColumn("DOMINIO");
        modelo.addColumn("MARCA");
        modelo.addColumn("MODELO");
        modelo.addColumn("AÑO");
        modelo.addColumn("TERCERO COMPLETO");
        modelo.addColumn("RESP. CIVIL");
        modelo.addColumn("TODO RIESGO CF");
        modelo.addColumn("TODO RIESGO SF");
        modelo.addColumn("GRANIZO");
        modelo.addColumn("FRANQUICIA");
        

        jTable_tabla.setModel(modelo);
        
        //cargarFilas();
        
        String fila[];
        String linea;
        try {
            BufferedReader escribir = new BufferedReader(new FileReader("segurosAutomotor.txt"));            
            try {
                linea=escribir.readLine();
                while(linea!=null){
                    fila=linea.split(",");
                    modelo.addRow(fila);
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
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
        jScrollPane1.setViewportView(jTable_tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

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
            java.util.logging.Logger.getLogger(Contrataciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contrataciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contrataciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contrataciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contrataciones().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_tabla;
    // End of variables declaration//GEN-END:variables
}
