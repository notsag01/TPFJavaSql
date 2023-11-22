package Cambio;


import Archivo.Archivo;
import Clientes.ArchivoClientes;
import Clientes.Clientes;
import Clientes.EncontrarClientes;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import Cambio.CambioClientes;
import Cambio.ConexionCambio;


public class Cambio extends javax.swing.JInternalFrame {
    double dolarBlue=522, dolarOficial=281.5, euro=297.28, real=55.22,tasaCambio;
    double cantidadPesos, cambio, impPais, impGcias;
    int eleccionMoneda;
    String cuil,cliente,apellido,clienteId,servicioId="1";
    
    private String usuario;
    private int idUsuario;
    
     private double calcularCambio(double cantidadPesos, double tasaCambio){
            return cantidadPesos * tasaCambio;
        }
        private double calcularImpuestoPais(double cantidadPesos, double tasaCambio, double alicuotaImpPais){
            double cantMonedaExtranjera= cantidadPesos * tasaCambio;
            return cantMonedaExtranjera * alicuotaImpPais;
        }
        private double calcularImpuestoGanancias(double cantidadPesos, double tasaCambio, double alicuotaGcias){
            double cantMonedaExtranjera =  cantidadPesos * tasaCambio;
            return cantMonedaExtranjera * alicuotaGcias;
        }
        private void calcularCambio(){
            cuil=jTextField_id.getText();
            try{
                cantidadPesos = Double.parseDouble(jTextField_pesos.getText());
                //System.out.println(cantidadPesos);

                double alicuotaImpPais=0.30;
                double alicuotaGcias=0.35; 
                double tasaCambio= 0.00;

                eleccionMoneda= jComboBox_moneda.getSelectedIndex();

                //System.out.println(eleccionMoneda);
                switch(eleccionMoneda){
                    case(0): JOptionPane.showMessageDialog(null, "Debe ingresar una Opciòn");
                    break;
                    case(1): tasaCambio =  dolarOficial;
                    break;
                    case(2): tasaCambio = euro; 
                    break;
                    case(3): tasaCambio = real;
                    break;
                    case(4): tasaCambio =  dolarBlue;
                             alicuotaImpPais=0.00;
                             alicuotaGcias=0.00;
                    break;

                }
                double impPais = calcularImpuestoPais(cantidadPesos, tasaCambio,alicuotaImpPais);
                double impGcias= calcularImpuestoGanancias(cantidadPesos, tasaCambio, alicuotaGcias);
                double cambio =  calcularCambio(cantidadPesos , tasaCambio) + impPais + impGcias;

                jTextField_impuestoPais.setText(String.format("$%,.2f", impPais));
                jTextField_impuestosGcias.setText(String.format("$%,.2f", impGcias));
                jTextField_cambio.setText(String.format("$%,.2f", cambio));
            }catch(NumberFormatException e){
            
            }
        }

    public Cambio(String usuario, int idUsuario) {
        initComponents();
        
        this.usuario=usuario;
        this.idUsuario=idUsuario;
    }
    
//    public void buscarID(String id){
//        EncontrarClientes encontrarCliente = new EncontrarClientes(id);
//            encontrarCliente.buscarCliente();
//            if(encontrarCliente.isEncontrado()){
//                jTextField_nombreCliente.setText(encontrarCliente.getNombre() + " " + encontrarCliente.getApellido());
//            }else{
//                jTextField_nombreCliente.setText("");
//                jTextField_id.setText("");
//            }
//    }
    public void cambiar(){
        if(jTextField_nombreCliente.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese su Cuit");
        }else{
            impPais=convertir(jTextField_impuestoPais.getText());
            impGcias=convertir(jTextField_impuestosGcias.getText());
            cambio=convertir(jTextField_cambio.getText());
            System.out.println(cambio);
            CambioClientes cc = ConexionCambio.cargar(usuario, idUsuario, clienteId, servicioId, eleccionMoneda, tasaCambio,
                    cantidadPesos, impPais, impGcias, cambio);
            
            
            JOptionPane.showMessageDialog(null, "La transacción fue realizada \n Existosamente");
            
            limpiarInformacion();
        }
    }
    public void limpiarInformacion(){
        jTextField_pesos.setText("");
        jTextField_impuestoPais.setText("");
        jTextField_impuestosGcias.setText("");
        jTextField_cambio.setText("");
        jComboBox_moneda.setSelectedIndex(0);
        jTextField_id.setText("");
        jTextField_nombreCliente.setText("");
    }
    public double convertir(String cant){
        String limpiar = cant.replace("$", "").replace(".", "").replace(",", ".");

        return Double.parseDouble(limpiar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_nombreCliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_pesos = new javax.swing.JTextField();
        jComboBox_moneda = new javax.swing.JComboBox<>();
        jTextField_impuestoPais = new javax.swing.JTextField();
        jTextField_impuestosGcias = new javax.swing.JTextField();
        jTextField_cambio = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton_Cambiar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Calculadora Cambio");
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(540, 646));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Castellar", 0, 80)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("m");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 121, 89));

        jLabel13.setFont(new java.awt.Font("Castellar", 0, 80)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("D");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 121, 89));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel4.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 255))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("CUIT/CUIL");

        jTextField_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_idFocusLost(evt);
            }
        });
        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });
        jTextField_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_idKeyTyped(evt);
            }
        });

        jTextField_nombreCliente.setEditable(false);
        jTextField_nombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_nombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombreClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_nombreCliente)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Cambio en pesos:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Moneda a cambiar:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Impuesto Pais:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Impuestos Gcias:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Cambio:");

        jTextField_pesos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jComboBox_moneda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_moneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "DOLAR OFICIAL", "EUROS", "REALES", "DOLAR BLUE" }));
        jComboBox_moneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_monedaActionPerformed(evt);
            }
        });

        jTextField_impuestoPais.setEditable(false);
        jTextField_impuestoPais.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_impuestoPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_impuestoPaisActionPerformed(evt);
            }
        });

        jTextField_impuestosGcias.setEditable(false);
        jTextField_impuestosGcias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_impuestosGcias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_impuestosGciasActionPerformed(evt);
            }
        });

        jTextField_cambio.setEditable(false);
        jTextField_cambio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_pesos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_impuestoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_impuestosGcias, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pesos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_impuestoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_impuestosGcias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));

        jButton_Cambiar.setBackground(new java.awt.Color(102, 102, 255));
        jButton_Cambiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Cambiar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Cambiar.setText("Cambiar");
        jButton_Cambiar.setPreferredSize(new java.awt.Dimension(90, 25));
        jButton_Cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CambiarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Limpiar");
        jButton2.setPreferredSize(new java.awt.Dimension(90, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("jButton3");
        jButton3.setPreferredSize(new java.awt.Dimension(90, 25));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton_Cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 610));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_impuestoPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_impuestoPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_impuestoPaisActionPerformed

    private void jButton_CambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CambiarActionPerformed
        cambiar();
    }//GEN-LAST:event_jButton_CambiarActionPerformed

    private void jComboBox_monedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_monedaActionPerformed
        calcularCambio();
    }//GEN-LAST:event_jComboBox_monedaActionPerformed

    private void jTextField_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_idKeyTyped
         int key=evt.getKeyChar();
        boolean numeros=key>=48&&key<=57;
        
        if(!numeros){
            evt.consume();
        }
        if(jTextField_id.getText().length()>10){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_idKeyTyped

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
//        if(jTextField_id.getText().length()==11){
//            String id=jTextField_id.getText();
//            buscarID(id);
//        }
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jTextField_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_idFocusLost
        if(jTextField_id.getText().length()==11){
            cliente = ArchivoClientes.buscarCliente(jTextField_id.getText());
            clienteId = ArchivoClientes.buscarIdCliente(jTextField_id.getText());
            jTextField_nombreCliente.setText(cliente);
        }
    }//GEN-LAST:event_jTextField_idFocusLost

    private void jTextField_nombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombreClienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiarInformacion();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField_impuestosGciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_impuestosGciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_impuestosGciasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_Cambiar;
    private javax.swing.JComboBox<String> jComboBox_moneda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField_cambio;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_impuestoPais;
    private javax.swing.JTextField jTextField_impuestosGcias;
    private javax.swing.JTextField jTextField_nombreCliente;
    private javax.swing.JTextField jTextField_pesos;
    // End of variables declaration//GEN-END:variables
}
