package Clientes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class BajasModifi extends javax.swing.JInternalFrame {
    boolean arroba=false,punto=false;       
    String id, nombre,apellido,fechaNacimiento,genero,cuil,domicilio,localidad,provincia,estadoCivil,hijos,mail;
    private String usuario;
    
    SimpleDateFormat formatoEntrada = new SimpleDateFormat("ddMMyy");
    SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
    
    public BajasModifi(String usuario) {
        initComponents();
        this.setTitle("Modificar Cliente");
        String[] provincias = new String[]{
               "", 
               "Capital Federal",
               "Buenos Aires",
               "Catamarca",
               "Chaco",
               "Chubut",
               "Córdoba",
               "Corrientes",
               "Entre Ríos",
               "Formosa",
               "Jujuy",
               "La Pampa",
               "La Rioja",
               "Mendoza",
               "Misiones",
               "Neuquén",
               "Río Negro",
               "Salta",
               "San Juan",
               "San Luis",
               "Santa Cruz",
               "Santa Fe",
               "Santiago del Estero",
               "Tierra del Fuego",
               "Tucumán"
           };
        

        for(String provincia : provincias){
           jComboBox_provincias.addItem(provincia);
        }
        
        this.usuario = usuario;
    }

    private BajasModifi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void validarFormulario(){
        if(jTextField_nombre.getText().equals("")||
            jTextField_apellido.getText().equals(" ")||
            jTextField_fechaNacimiento.getText().equals(" ")||
            jTextField_cuil.getText().equals(" ")||
            jTextField_domicilio.getText().equals(" ")||
            jTextField_localidad.getText().equals(" ")||
            jTextField_hijos.getText().equals(" ")||
            jTextField_mail.getText().equals(" ")||
            jComboBox_genero.getSelectedIndex()==0||
            jComboBox_provincias.getSelectedIndex()==0||
            jComboBox_estadoCivil.getSelectedIndex()==0
                ){
        JOptionPane.showMessageDialog(null, "Todos los campos del formulario \n debes ser completados",
                "ERROR DE VALIDACION", HEIGHT);
        }else{
            validarMail();
        }
    }
    
    public void validarMail(){
        mail=jTextField_mail.getText();
        
        for(int i=0; i<mail.length();i++){
            char caracter=mail.charAt(i);
            
            if(caracter=='@'){
                arroba=true;
            }else if(caracter=='.'){
                punto=true;
            }
            
        }
        if(arroba&&punto){
            JOptionPane.showMessageDialog(null, "El formularioa fue ingresado correctamente",
                    "Validacion Confirmada",JOptionPane.INFORMATION_MESSAGE);
                    getDatosClientes();
                    arroba=false;
                    punto=false;
                    limpiarFormulario();
        }else{
            JOptionPane.showMessageDialog(null, "El mail ingresado no es correcto. \n Ingrese un nuevo mail",
                    "Validacion Incorrecta", HEIGHT);
        }
    }
    
    public void limpiarFormulario(){
        jTextField_nombre.setText("");
        jTextField_apellido.setText("");
        jTextField_fechaNacimiento.setText("");
        jTextField_cuil.setText("");
        jTextField_domicilio.setText("");
        jTextField_localidad.setText("");
        jTextField_hijos.setText("");
        jTextField_mail.setText("");
        //jComboBox_genero.setSelectedIndex(0);
        jComboBox_provincias.setSelectedIndex(0);
        jComboBox_estadoCivil.setSelectedIndex(0);
        jTextField_id.setText("");
    }
    private void getDatosClientes(){
        id=jTextField_cuil.getText();        
        nombre=jTextField_nombre.getText();        
        apellido=jTextField_apellido.getText();        
        String fecha=jTextField_fechaNacimiento.getText();    
        Date fechaEntrada;
        try {
            fechaEntrada = formatoEntrada.parse(fecha);
            fechaNacimiento= formatoSalida.format(fechaEntrada);
        } catch (ParseException ex) {
            Logger.getLogger(BajasModifi.class.getName()).log(Level.SEVERE, null, ex);
        }
        genero=(String)jComboBox_genero.getSelectedItem();
        cuil=jTextField_cuil.getText();
        domicilio=jTextField_domicilio.getText();        
        localidad=jTextField_localidad.getText();        
        localidad=jTextField_localidad.getText();        
        provincia=(String)jComboBox_provincias.getSelectedItem();
        estadoCivil=(String)jComboBox_estadoCivil.getSelectedItem();
        hijos=jTextField_hijos.getText();        
        mail=jTextField_mail.getText();        
        
        guardarCliente();
    }
    //    String id, nombre,apellido,mail,fechaNacimiento,domicilio,localidad,provincia,estadoCivil,hijos;
    private void guardarCliente(){
        Clientes cliente = ArchivoClientes.nuevoCliente(
                id,
                nombre,
                apellido,
                fechaNacimiento,
                genero,
                cuil,
                domicilio,
                localidad,
                provincia,
                estadoCivil,
                hijos,
                mail
        );
    }
    
    private void buscarCliente(){
        String cuil = jTextField_cuil.getText();
        Clientes cliente =ArchivoClientes.obtenerDatosCliente(cuil);        
        
        if(cliente!=null){      
            jTextField_id.setText(cliente.getId());
            jTextField_nombre.setText(cliente.getNombre());
            jTextField_apellido.setText(cliente.getApellido());
            jTextField_fechaNacimiento.setText(cliente.getFechaNacimiento());
            jTextField_domicilio.setText(cliente.getDomicilio());
            jTextField_localidad.setText(cliente.getLocalidad());
            jTextField_hijos.setText(cliente.getHijos());
            jTextField_mail.setText(cliente.getMail());
            
        }
    }
    private void modificarCliente(
            String id,
            String nombre,
            String apellido,
            String fechaNacimiento,
            String genero,
            String cuil,
            String domicilio,
            String localidad,
            String provincia,
            String estadoCivil,
            String hijos,
            String mail
    ){
        Clientes cliente = ArchivoClientes.modificarCliente(id, nombre, apellido, fechaNacimiento, genero, cuil, domicilio, localidad, provincia, estadoCivil, hijos, mail);
        limpiarFormulario();
    }
    private void confirmarEliminar(){
        int respuesta = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el registro?");
        
        
        if(respuesta==JOptionPane.YES_OPTION){
            eliminarDato();
        }else{
            JOptionPane.showMessageDialog(null, "Eliminarción Cancelada");
        }
    }
    
    private void eliminarDato(){
        cuil= jTextField_cuil.getText();
        
        Clientes cliente = ArchivoClientes.elimiarDato(cuil);
        limpiarFormulario();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField_nombre = new javax.swing.JTextField();
        jTextField_apellido = new javax.swing.JTextField();
        jTextField_fechaNacimiento = new javax.swing.JTextField();
        jComboBox_genero = new javax.swing.JComboBox<>();
        jTextField_cuil = new javax.swing.JTextField();
        jTextField_domicilio = new javax.swing.JTextField();
        jTextField_localidad = new javax.swing.JTextField();
        jComboBox_provincias = new javax.swing.JComboBox<>();
        jComboBox_estadoCivil = new javax.swing.JComboBox<>();
        jTextField_hijos = new javax.swing.JTextField();
        jTextField_mail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton_buscar = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jTextField_id = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alta Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(543, 645));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("NOMBRE");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("APELLIDO");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("FECHA DE NACIMIENTO");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("GENERO");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("CUIT/CUIL");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("DOMICILIO");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("LOCALIDAD");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("PROVINCIA");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("ESTADO CIVIL");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("HIJOS");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("MAIL");

        jTextField_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_nombreKeyTyped(evt);
            }
        });

        jTextField_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_apellidoKeyTyped(evt);
            }
        });

        jTextField_fechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_fechaNacimientoKeyTyped(evt);
            }
        });

        jComboBox_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Masculino", "Femenino", "Otro" }));

        jTextField_cuil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cuilActionPerformed(evt);
            }
        });
        jTextField_cuil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_cuilKeyTyped(evt);
            }
        });

        jComboBox_estadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Soltero", "Casado", "Otro" }));
        jComboBox_estadoCivil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox_estadoCivilKeyTyped(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        jButton_buscar.setBackground(new java.awt.Color(102, 102, 255));
        jButton_buscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_buscar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_buscar.setText("BUSCAR");
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });

        jButton_modificar.setBackground(new java.awt.Color(102, 102, 255));
        jButton_modificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_modificar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_modificar.setText("MODIFICAR");
        jButton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarActionPerformed(evt);
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

        jButton_eliminar.setText("ELIMINIAR");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(27, 27, 27)
                .addComponent(jButton_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_modificar)
                .addGap(18, 18, 18)
                .addComponent(jButton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_eliminar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTextField_id.setEditable(false);

        jLabel14.setText("id:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_hijos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_provincias, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_localidad, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_cuil)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_cuil, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_localidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_provincias, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_estadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_hijos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 610));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));

        jLabel12.setFont(new java.awt.Font("Castellar", 0, 80)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("m");

        jLabel13.setFont(new java.awt.Font("Castellar", 0, 80)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("D");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(258, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(167, 167, 167)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(344, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        //validarFormulario();
        buscarCliente();
    }//GEN-LAST:event_jButton_buscarActionPerformed

    private void jTextField_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nombreKeyTyped
        int key=evt.getKeyChar();
        boolean letras=key>=65&&key<=122;
        
        if(!letras){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_nombreKeyTyped

    private void jTextField_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_apellidoKeyTyped
        int key=evt.getKeyChar();
        boolean letras=key>=65&&key<=122;
        
        if(!letras){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_apellidoKeyTyped

    private void jTextField_fechaNacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_fechaNacimientoKeyTyped
        int key=evt.getKeyChar();
        boolean numeros=key>=48&&key<=57;
        
        if(!numeros){
            evt.consume();
        }        
    }//GEN-LAST:event_jTextField_fechaNacimientoKeyTyped

    private void jTextField_cuilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_cuilKeyTyped
        int key=evt.getKeyChar();
        boolean numeros=key>=48&&key<=57;
        
        if(!numeros){
            evt.consume();
        }
        if(jTextField_cuil.getText().length()>10){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_cuilKeyTyped

    private void jComboBox_estadoCivilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_estadoCivilKeyTyped
        int key=evt.getKeyChar();
        boolean numeros=key>=48&&key<=57;
        
        if(!numeros){
            evt.consume();
        }
        if(jTextField_hijos.getText().length()>1){
            evt.consume();
        }
    }//GEN-LAST:event_jComboBox_estadoCivilKeyTyped

    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed
        id=jTextField_id.getText();
        cuil=jTextField_cuil.getText();        
        nombre=jTextField_nombre.getText();        
        apellido=jTextField_apellido.getText();        
        String fecha=jTextField_fechaNacimiento.getText();    
        Date fechaEntrada;
        try {
            fechaEntrada = formatoEntrada.parse(fecha);
            fechaNacimiento= formatoSalida.format(fechaEntrada);
        } catch (ParseException ex) {
            Logger.getLogger(BajasModifi.class.getName()).log(Level.SEVERE, null, ex);
        }
        genero=(String)jComboBox_genero.getSelectedItem();
        cuil=jTextField_cuil.getText();
        domicilio=jTextField_domicilio.getText();        
        localidad=jTextField_localidad.getText();        
        localidad=jTextField_localidad.getText();        
        provincia=(String)jComboBox_provincias.getSelectedItem();
        estadoCivil=(String)jComboBox_estadoCivil.getSelectedItem();
        hijos=jTextField_hijos.getText();        
        mail=jTextField_mail.getText();   
        System.out.println(id);
        modificarCliente(id,nombre,apellido,fechaNacimiento,genero,cuil,domicilio,localidad,provincia,estadoCivil,hijos,mail);
    }//GEN-LAST:event_jButton_modificarActionPerformed

    private void jTextField_cuilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cuilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_cuilActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        confirmarEliminar();
    }//GEN-LAST:event_jButton_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(BajasModifi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajasModifi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajasModifi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajasModifi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BajasModifi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JComboBox<String> jComboBox_estadoCivil;
    private javax.swing.JComboBox<String> jComboBox_genero;
    private javax.swing.JComboBox<String> jComboBox_provincias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField_apellido;
    private javax.swing.JTextField jTextField_cuil;
    private javax.swing.JTextField jTextField_domicilio;
    private javax.swing.JTextField jTextField_fechaNacimiento;
    private javax.swing.JTextField jTextField_hijos;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_localidad;
    private javax.swing.JTextField jTextField_mail;
    private javax.swing.JTextField jTextField_nombre;
    // End of variables declaration//GEN-END:variables

    private Date formatoEntrada(String fechaNacimiento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String formatoSalida(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
