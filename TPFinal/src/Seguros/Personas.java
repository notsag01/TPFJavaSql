package Seguros;


public class Personas {
    
    String tipoSeguro, cuit, nombre, telefono, mail,
            incendio,robo,inundacion,
            heladera,lavarropas,cocina,notebook,notebookCantidad,consola,televisor,televisorCantidad;
    String muerte, muerteAccidental,internacion,internacionDias,paralisis;
    String beneficiario1,beneficiario2,beneficiario3,beneficiario4;
    String beneficiario1_parentesco,beneficiario2_parentesco,beneficiario3_parentesco,beneficiario4_parentesco;
    String dominio, marcaSelec,modeloSelec,anio;
    String terceroCompleto,responsabilidadCivil, todoRiesgoCF,todoRiesgoSF,granizo;
    String franquicia;
    
    public Personas(String tipoSeguro,
            String cuit,
            String nombre,
            String telefono,
            String mail,
            String incendio, 
            String robo, 
            String inundacion, 
            String heladera, 
            String lavarropas,
            String cocina,
            String notebook,
            String notebookCantidad,
            String consola,
            String televisor,
            String televisorCantidad
    
    ){
        
        this.tipoSeguro=tipoSeguro;
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
            String cuit,
            String nombre,
            String telefono,
            String mail,
            String muerte, 
            String muerteAccidental, 
            String internacion, 
            String internacionDias,
            String paralisis,
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

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    public String getIncendio() {
        return incendio;
    }

    public String getRobo() {
        return robo;
    }

    public String getInundacion() {
        return inundacion;
    }

    public String getHeladera() {
        return heladera;
    }

    public String getLavarropas() {
        return lavarropas;
    }

    public String getCocina() {
        return cocina;
    }

    public String getNotebook() {
        return notebook;
    }

    public String getNotebookCantidad() {
        return notebookCantidad;
    }

    public String getConsola() {
        return consola;
    }

    public String getTelevisor() {
        return televisor;
    }

    public String getTelevisorCantidad() {
        return televisorCantidad;
    }

    public String getMuerte() {
        return muerte;
    }

    public String getMuerteAccidental() {
        return muerteAccidental;
    }

    public String getInternacion() {
        return internacion;
    }

    public String getInternacionDias() {
        return internacionDias;
    }

    public String getParalisis() {
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
