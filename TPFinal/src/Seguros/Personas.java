package Seguros;


public class Personas {
    
    String tipoSeguro,clienteId, cuit, nombre, telefono, mail;
    int idUsuario;
    boolean incendio,robo,inundacion,
            heladera,lavarropas,cocina,notebook,consola,televisor;
    int notebookCantidad,televisorCantidad;
    boolean muerte, muerteAccidental,internacion,paralisis;
    String internacionDias,beneficiario1,beneficiario2,beneficiario3,beneficiario4;
    String beneficiario1_parentesco,beneficiario2_parentesco,beneficiario3_parentesco,beneficiario4_parentesco;
    String dominio, marcaSelec,modeloSelec,anio;
    String terceroCompleto,responsabilidadCivil, todoRiesgoCF,todoRiesgoSF,granizo;
    String franquicia;
    
    public Personas(String tipoSeguro,
            int idUsuario,
            String clienteId,
            String cuit,
            String nombre,
            String telefono,
            String mail,
            boolean incendio, 
            boolean robo, 
            boolean inundacion, 
            boolean heladera, 
            boolean lavarropas,
            boolean cocina,
            boolean notebook,
            int notebookCantidad,
            boolean consola,
            boolean televisor,
            int televisorCantidad
    
    ){
        
        this.tipoSeguro=tipoSeguro;
        this.idUsuario=idUsuario;
        this.clienteId=clienteId;
        this.cuit=cuit;
        this.nombre= nombre;
        this.telefono=telefono;
        this.mail=mail;
        this.incendio=incendio;
        this.robo=robo;
        this.inundacion=inundacion;
        this.heladera=heladera;
        this.lavarropas=lavarropas;
        this.cocina=cocina;
        this.notebook=notebook;
        this.notebookCantidad=notebookCantidad;
        this.consola=consola;
        this.televisor=televisor;
        this.televisorCantidad=televisorCantidad;
    }
    
    public Personas(String tipoSeguro,
            int idUsuario,
            String clienteId,
            String cuit,
            String nombre,
            String telefono,
            String mail,
            boolean muerte, 
            boolean muerteAccidental, 
            boolean internacion, 
            String internacionDias,
            boolean paralisis,
            String beneficiario1,            
            String beneficiario2,            
            String beneficiario3,            
            String beneficiario4,
            String beneficiario1_parentesco,
            String beneficiario2_parentesco,
            String beneficiario3_parentesco,
            String beneficiario4_parentesco            
    ){
        
        this.tipoSeguro=tipoSeguro;
        this.idUsuario=idUsuario;
        this.clienteId=clienteId;
        this.cuit=cuit;
        this.nombre=nombre;
        this.telefono=telefono;
        this.mail=mail;
        this.muerte=muerte;
        this.muerteAccidental=muerteAccidental;
        this.internacion=internacion;
        this.internacionDias=internacionDias;
        this.paralisis=paralisis;
        this.beneficiario1=beneficiario1;
        this.beneficiario2=beneficiario2;
        this.beneficiario3=beneficiario3;
        this.beneficiario4=beneficiario4;
        this.beneficiario1_parentesco=beneficiario1_parentesco;
        this.beneficiario2_parentesco=beneficiario2_parentesco;
        this.beneficiario3_parentesco=beneficiario3_parentesco;
        this.beneficiario4_parentesco=beneficiario4_parentesco;
    }
//    String dominio, marcaSelec,modeloSelec,anio;
//    String terceroCompleto,responsabilidadCivil, todoRiesgoCF,todoRiesgoSF,granizo;
//    int franquicia;
    
    public Personas(
            String tipoSeguro,
            String cuit,
            String nombre,
            String telefono,
            String mail,
            String dominio,
            String marcaSelec,
            String modeloSelec,
            String anio,
            String terceroCompleto,
            String responsabilidadCivil,
            String todoRiesgoCF,
            String todoRiesgoSF,
            String granizo,
            String franquicia
    ){
        this.tipoSeguro=tipoSeguro;
        this.cuit=cuit;
        this.nombre=nombre;
        this.telefono=telefono;
        this.mail=mail;
        this.dominio=dominio;
        this.marcaSelec=marcaSelec;
        this.modeloSelec=modeloSelec;
        this.anio=anio;
        this.terceroCompleto=terceroCompleto;
        this.responsabilidadCivil=responsabilidadCivil;
        this.todoRiesgoCF=todoRiesgoCF;
        this.todoRiesgoSF=todoRiesgoSF;
        this.granizo=granizo;
        this.franquicia=franquicia;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public String getCuit() {
        return cuit;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getClienteId() {
        return clienteId;
    }

    public boolean isIncendio() {
        return incendio;
    }

    public boolean isRobo() {
        return robo;
    }

    public boolean isInundacion() {
        return inundacion;
    }

    public boolean isHeladera() {
        return heladera;
    }

    public boolean isLavarropas() {
        return lavarropas;
    }

    public boolean isCocina() {
        return cocina;
    }

    public boolean isNotebook() {
        return notebook;
    }

    public boolean isConsola() {
        return consola;
    }

    public boolean isTelevisor() {
        return televisor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    public boolean getIncendio() {
        return incendio;
    }

    public boolean getRobo() {
        return robo;
    }

    public boolean getInundacion() {
        return inundacion;
    }

    public boolean getHeladera() {
        return heladera;
    }

    public boolean getLavarropas() {
        return lavarropas;
    }

    public boolean getCocina() {
        return cocina;
    }

    public boolean getNotebook() {
        return notebook;
    }

    public int getNotebookCantidad() {
        return notebookCantidad;
    }

    public boolean getConsola() {
        return consola;
    }

    public boolean getTelevisor() {
        return televisor;
    }

    public int getTelevisorCantidad() {
        return televisorCantidad;
    }

    public boolean getMuerte() {
        return muerte;
    }

    public boolean getMuerteAccidental() {
        return muerteAccidental;
    }

    public boolean getInternacion() {
        return internacion;
    }

    public String getInternacionDias() {
        return internacionDias;
    }

    public boolean getParalisis() {
        return paralisis;
    }

    public String getBeneficiario1() {
        return beneficiario1;
    }

    public String getBeneficiario2() {
        return beneficiario2;
    }

    public String getBeneficiario3() {
        return beneficiario3;
    }

    public String getBeneficiario4() {
        return beneficiario4;
    }

    public String getBeneficiario1_parentesco() {
        return beneficiario1_parentesco;
    }

    public String getBeneficiario2_parentesco() {
        return beneficiario2_parentesco;
    }

    public String getBeneficiario3_parentesco() {
        return beneficiario3_parentesco;
    }

    public String getBeneficiario4_parentesco() {
        return beneficiario4_parentesco;
    }

    public String getDominio() {
        return dominio;
    }

    public String getMarcaSelec() {
        return marcaSelec;
    }

    public String getModeloSelec() {
        return modeloSelec;
    }

    public String getAnio() {
        return anio;
    }

    public String getTerceroCompleto() {
        return terceroCompleto;
    }

    public String getResponsabilidadCivil() {
        return responsabilidadCivil;
    }

    public String getTodoRiesgoCF() {
        return todoRiesgoCF;
    }

    public String getTodoRiesgoSF() {
        return todoRiesgoSF;
    }

    public String getGranizo() {
        return granizo;
    }

    public String getFranquicia() {
        return franquicia;
    }
    
}
