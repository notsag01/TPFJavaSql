package Prestamos;


import Clientes.ArchivoClientes;
import javax.swing.JOptionPane;


public class Prestamos extends javax.swing.JInternalFrame {
    int interesMinimo=80,interesMedio=100,interesMaximo=150,capital, meses,intereses,idUsuario; 
    double cuota,monto;
    String nombre,apellido,clienteId,servicioId="2";
    String usuario;
    
    
    public Prestamos(String usuario, int idUsuario) {
        initComponents();
        this.setTitle("Prestamos");                

        
        this.usuario = usuario;
        this.idUsuario=idUsuario;
        jTextField_intereses.setText("80");
    }

    private Prestamos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  
    
    private void valorarIntereses(){
        int time = jComboBox_tiempo.getSelectedIndex();
        if(time==0){
            jTextField_intereses.setText(String.valueOf(interesMinimo));
        }else if(time==1||time==2){
            jTextField_intereses.setText(String.valueOf(interesMedio));            
        }else{
            jTextField_intereses.setText(String.valueOf(interesMaximo));            
        }
    }
    
    private double calcularFinal(double capital, double interes){
        double finalCapital = capital + (capital * (interes / 100));
        return finalCapital;
    }
    private double calcularCuotas(double calcularFinal,int meses){
        cuota=calcularFinal/meses;
        return cuota;
    }

    
    private void calcularMonto(){
        capital=(int) Double.parseDouble(jTextField_capital.getText());
        int time = jComboBox_tiempo.getSelectedIndex();
        
        switch(time){
            case 0: meses=12;
            break;
            case 1: meses=24;
            break;
            case 2: meses=36;
            break;
            case 3: meses=48;
            break;
            case 4: meses=9;
            break;
        }
        
        intereses=(int)Double.parseDouble(jTextField_intereses.getText());
        
        double capitalFinal=calcularFinal(capital,intereses);
        double cuotas=calcularCuotas(capitalFinal,meses);
        
        jTextField_deuda.setText(String.format("$%,.2f", capitalFinal));
        jTextField_cuota.setText(String.format("$%,.2f", cuotas));
    }
    public void buscarID(String id){
//        EncontrarClientes encontrarCliente = new EncontrarClientes(id);
//            encontrarCliente.buscarCliente();
//            if(encontrarCliente.isEncontrado()){
//                jTextField_idCliente.setText( encontrarCliente.getId());
//                jTextField_nombreCliente.setText(encontrarCliente.getNombre() + " " + encontrarCliente.getApellido());
//            }else{
//                jTextField_nombreCliente.setText("");
//                jTextField_id.setText("");
//            }
    }
    
    private void solicitarPrestamo(){
        clienteId=jTextField_idCliente.getText();
        idUsuario=this.idUsuario;
        capital=Integer.parseInt(jTextField_capital.getText());
        meses=this.meses;
        intereses=Integer.parseInt(jTextField_intereses.getText());
        monto=convertir(jTextField_deuda.getText());
        cuota=convertir(jTextField_cuota.getText());

        PrestamoCliente pc = PrestamosConexion.solicitarPrestamo(clienteId, servicioId, idUsuario, capital, meses, intereses, monto, cuota);
    }
        public double convertir(String cant){
        String limpiar = cant.replace("$", "").replace(".", "").replace(",", ".");

        return Double.parseDouble(limpiar);
    }
        
    private void validarFormulario(){
        if(
                jTextField_id.getText().equals("")||
                jTextField_nombreCliente.getText().equals("")||
                jTextField_nombreCliente.getText().equals("")||
                jTextField_capital.getText().equals("")||
                jTextField_intereses.getText().equals("")||        
                jTextField_deuda.getText().equals("")        
                ){
            JOptionPane.showMessageDialog(null, "Todos los Campos deben estar completos");
        }else{
            solicitarPrestamo();
            limpiarFormulario();
        }
        
    }
    private void limpiarFormulario(){
        jTextField_id.setText("");
        jTextField_idCliente.setText("");
        jTextField_nombreCliente.setText("");
        jComboBox_tiempo.setSelectedIndex(0);
        jTextField_capital.setText("");
        jTextField_intereses.setText("");
        jTextField_cuota.setText("");
        jTextField_deuda.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_capital = new javax.swing.JTextField();
        jComboBox_tiempo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jButton_calcualar = new javax.swing.JButton();
        jButton_limpiar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton_guardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField_intereses = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField_deuda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_cuota = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_nombreCliente = new javax.swing.JTextField();
        jTextField_idCliente = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Alta Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Castellar", 0, 80)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("m");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 121, 89));

        jLabel13.setFont(new java.awt.Font("Castellar", 0, 80)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("D");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 121, 89));

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(543, 645));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("CAPITAL");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("TIEMPO");

        jTextField_capital.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_capitalKeyTyped(evt);
            }
        });

        jComboBox_tiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "24", "36", "48", "96" }));
        jComboBox_tiempo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_tiempoItemStateChanged(evt);
            }
        });
        jComboBox_tiempo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jComboBox_tiempoComponentShown(evt);
            }
        });
        jComboBox_tiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tiempoActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        jButton_calcualar.setBackground(new java.awt.Color(102, 102, 255));
        jButton_calcualar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_calcualar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_calcualar.setText("CALCULAR");
        jButton_calcualar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcualarActionPerformed(evt);
            }
        });

        jButton_limpiar.setBackground(new java.awt.Color(102, 102, 255));
        jButton_limpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_limpiar.setText("LIMPIAR");
        jButton_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_limpiarActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("SALIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton_guardar.setBackground(new java.awt.Color(102, 102, 255));
        jButton_guardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_guardar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_guardar.setText("GUARDAR");
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_calcualar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_calcualar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("INTERESES");

        jTextField_intereses.setEditable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cuota");

        jTextField_deuda.setEditable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Monto a devolver");

        jTextField_cuota.setEditable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 255))); // NOI18N

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

        jTextField_idCliente.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_nombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jTextField_id))
                .addGap(18, 18, 18)
                .addComponent(jTextField_idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField_capital, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox_tiempo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField_intereses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField_cuota)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField_deuda, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_capital, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_intereses, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_deuda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_cuota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton_calcualarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcualarActionPerformed
        calcularMonto();
    }//GEN-LAST:event_jButton_calcualarActionPerformed

    private void jButton_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_limpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_jButton_limpiarActionPerformed

    private void jComboBox_tiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_tiempoActionPerformed

    private void jTextField_capitalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_capitalKeyTyped
        int key=evt.getKeyChar();
        boolean numeros=key>=48&&key<=57;
        
        if(!numeros){
            evt.consume();
        }
        if(jTextField_capital.getText().length()>6){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_capitalKeyTyped

    private void jComboBox_tiempoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jComboBox_tiempoComponentShown
        
    }//GEN-LAST:event_jComboBox_tiempoComponentShown

    private void jComboBox_tiempoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_tiempoItemStateChanged
        valorarIntereses();
    }//GEN-LAST:event_jComboBox_tiempoItemStateChanged

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

    private void jTextField_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_idFocusLost
        if(jTextField_id.getText().length()==11){
            String cliente = ArchivoClientes.buscarCliente(jTextField_id.getText());
            String clienteId = ArchivoClientes.buscarIdCliente(jTextField_id.getText());
            jTextField_nombreCliente.setText(cliente);
            jTextField_idCliente.setText(clienteId);
        }
    }//GEN-LAST:event_jTextField_idFocusLost

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
        validarFormulario();
    }//GEN-LAST:event_jButton_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_calcualar;
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JButton jButton_limpiar;
    private javax.swing.JComboBox<String> jComboBox_tiempo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField_capital;
    private javax.swing.JTextField jTextField_cuota;
    private javax.swing.JTextField jTextField_deuda;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_idCliente;
    private javax.swing.JTextField jTextField_intereses;
    private javax.swing.JTextField jTextField_nombreCliente;
    // End of variables declaration//GEN-END:variables
}
