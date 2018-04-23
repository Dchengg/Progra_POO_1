package aplicacion;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Aqui se desarrola el Cliente, donde se puede añadir paquetes
 * @author Diego
 */

public class Cliente {

    private String nombre;
    private String email;
    private String direccion;
    private String numTel;
    private String fechaDeNacimiento;
    private boolean perfilCompleto;
    private String contrasena;
    private boolean notificaciones;
    private String numCasillero;
    private String codigo;
    private ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
    private static int cantCasilleros ;
    
     /**
        * Crea un cliente
        * @param pNombre se indica el nombre del cliente como String
        * @param pEmail se indica el email como String
        */
    
    
    
    public Cliente(String pNombre, String pEmail) {
            setNombre(pNombre);
            setEmail(pEmail);
            setPerfilCompleto(false);
    }

     /**
        * Crea el perfil completo del Cliente
        * @param pNombre es el nombre del cliente como String
        * @param pEmail es el email en forma de String
        * @param pDir la direccion como String
        * @param pNumTel numero de telefono como String
        * @param pFechaDeNacimiento indicada como String
        * @param pCompleto indica si el perfil del cliente esta completo definido por un boolean
        * @param pContra contrasena definida en un String
        * @param pNotificaciones indica si el cliente quiere notificaciones al correo indicada por un boolean
        * @param pCasillero numero del casillero indicada por un String
        */
    public Cliente(String pNombre, String pEmail, String pDir, String pNumTel,String pFechaDeNacimiento,boolean pCompleto, String pContra, boolean pNotificaciones,String pCasillero) {
        setNombre(pNombre);
        setEmail(pEmail);
        setDireccion(pDir);
        setNumTel(pNumTel);
        setFechaDeNacimiento(pFechaDeNacimiento);
        setPerfilCompleto(pCompleto);
        setContrasena(pContra);
        setNotificaciones(pNotificaciones);
        setNumCasillero(pCasillero);

    }

    /**
        * Se agrega un paquete al cliente
        * @param trackingID es el id del paquete indicado como String
        * @param tienda de donde proviene el paquete, es un String
        * @param courier la campania de donde viene, String
        * @param valor precio del paquete, double
        * @param pCategoria tipo de paquete, String
        * @param descripcion descripcion breve del paquete, String
        */
    
    public void agregarPaquete(String trackingID, String tienda, String courier, double valor, String pCategoria, String descripcion) {
        Paquete paqueteNuevo = new Paquete(trackingID,tienda,courier,valor,pCategoria,descripcion,this);
        paquetes.add(paqueteNuevo);
    }

    /**
        * Se agrega un paquete al cliente
        * @param pTrackingID es el id del paquete
        * @param pTienda de donde proviene el paquete
        * @param pCourier la campania de donde viene
        * @param pValor precio del paquete
        * @param pCategoria tipo de paquete
        * @param pDescripcion descripcion breve del paquete
        * @param peso el peso del paquete
        * @param pEstado el estado en el que se encuentra el paquete
        * @param pFechaCambio la fecha en la que se realizo el cambio de estado
        * @param pHoraCambio la hora en la que fue el cambio de estado
        */
    
    public void agregarPaquete(String pTrackingID, String pTienda, String pCourier, double pValor, double peso, String pDescripcion,String pEstado, String pCategoria, String pFechaCambio, String pHoraCambio){
        Paquete paqueteNuevo = new Paquete(pTrackingID, pTienda, pCourier, pValor, peso, pDescripcion,pEstado, pCategoria, pFechaCambio, pHoraCambio,this);
        paquetes.add(paqueteNuevo);
    }

    /**
        * Verifica el log in del cliente
        * @param id es el nombre de usuario
        * @param contra contrasena indicada por el clliente
        * @return Boolean
        */
    
    public boolean logIn(String id, String contra) {
        if(id.equals(getNombre()) && contra.equals(getContrasena())) {
                return true;
        }else {
                return false;
        }
    }
/**
        * Genera una contrasena random temporal
        * @return String
        */
    
    
    public String generarContrasena() {	
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder builder = new StringBuilder();
        Random rand = new Random();
        while(builder.length() < 3) {
                int index = (int) (rand.nextFloat() * chars.length());
                builder.append(chars.charAt(index));
        }
        String contra = builder.toString();
        System.out.print(contra);
        setContrasena(contra);
        return contra;
    }

    /**
        * Verifica el codigo reicibido de telegram del cliente
        * @return Boolean
        */
    
    public boolean verificarCodigo(String pCodigo) {
        if(codigo == null){
           return false;
        }
        else if(codigo.equals(pCodigo)) {
            return true;
        }else {
            return false;
        }

    }
    /**
     * Genera el numero de casillero del cliente
     */
    public void generarNumCasillero() {
        this.numCasillero = "CAS-" + cantCasilleros;
        cantCasilleros++;
    }

    
    
    public String toString() {
        String msg = "Nombre :" + getNombre() + "\n";
        msg += "Correo :" + getEmail() + "\n";
        msg += "Direccion : " + getDireccion() + "\n";
        msg += "N�mero de Telefono : " + getNumTel() + "\n";
        msg += "Fecha de Nacimiento : " + getFechaDeNacimiento() + "\n";
        msg += "Perfil Completo : " + isPerfilCompleto() + "\n";
        msg += "Contrasena : " + getContrasena() + "\n";
        msg += "Recibir notificaciones : " + isNotificaciones() + "\n";
        msg += "N�mero de Casillero : " + getNumCasillero() + "\n";
     return msg;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNumTel() {
        return numTel;
    }
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public boolean isPerfilCompleto() {
        return perfilCompleto;
    }
    public void setPerfilCompleto(boolean perfilCompleto) {
        this.perfilCompleto = perfilCompleto;
    }

    //Tiene que ser privada pero por unos problemas en Writer se necesita public **HAY QUE ARREGLAR
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public boolean isNotificaciones() {
        return notificaciones;
    }
    public void setNotificaciones(boolean notificaciones) {
        this.notificaciones = notificaciones;
    }

    public String getNumCasillero() {
        return numCasillero;
    }

    public void setNumCasillero(String numCasillero){
        this.numCasillero = numCasillero;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static int getCantCasilleros() {
        return cantCasilleros;
    }

    public static void setCantCasilleros(int cantCasilleros) {
        Cliente.cantCasilleros = cantCasilleros;
    }
    
    
    
}
