package aplicacion;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

    public Cliente(String pNombre, String pEmail) {
            setNombre(pNombre);
            setEmail(pEmail);
    }

    public Cliente(String pNombre, String pEmail, String pDir, String pNumTel,String pFechaDeNacimiento,boolean pCompleto, String pContra, boolean pNotificaciones, String pNumCasillero) {
        setNombre(pNombre);
        setEmail(pEmail);
        setDireccion(pDir);
        setNumTel(pNumTel);
        setFechaDeNacimiento(pFechaDeNacimiento);
        setPerfilCompleto(pCompleto);
        setContrasena(pContra);
        setNotificaciones(pNotificaciones);
        setNumCasillero(pNumCasillero);

    }

    public void agregarPaquete(String trackingID, String tienda, String courier, double valor, String pCategoria, String descripcion) {
        Paquete paqueteNuevo = new Paquete(trackingID,tienda,courier,valor,pCategoria,descripcion,this);
        paquetes.add(paqueteNuevo);
    }

    public void agregarPaquete(String pTrackingID, String pTienda, String pCourier, double pValor, double peso, String pDescripcion,String pEstado, String pCategoria, String pFechaCambio, String pHoraCambio){
        Paquete paqueteNuevo = new Paquete(pTrackingID, pTienda, pCourier, pValor, peso, pDescripcion,pEstado, pCategoria, pFechaCambio, pHoraCambio,this);
        paquetes.add(paqueteNuevo);
    }

    public boolean logIn(String id, String contra) {
        if(id.equals(getNombre()) && contra.equals(getContrasena())) {
                return true;
        }else {
                return false;
        }
    }

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

    public void setNumCasillero(String numCasillero) {
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
    
    
}
