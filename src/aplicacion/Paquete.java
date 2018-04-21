package aplicacion;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Paquete {

    private String trackingID;
    private String tienda;
    private String courier;
    private double valor;
    private double peso;
    private String descripcion;
    private String estado;
    private String categoria;
    private String horaCambio;
    private String fechaCambio;
    private String dueno;

    public Paquete(String pTrackingID, String pTienda, String pCourier, double pValor, String pCategoria, String pDescripcion, String pDueno) {
        setTrackingID(pTrackingID);
        setTienda(pTienda);
        setCourier(pCourier);
        setValor(pValor);
        setDescripcion(pDescripcion);
        setPeso(0);
        setCategoria(pCategoria);
        setEstado("Prealertado");
        setFechaCambio();
        setHoraCambio();
        setDueno(pDueno);

    }

    public Paquete(String pTrackingID, String pTienda, String pCourier, double pValor, double peso, String pDescripcion,String pEstado, String pCategoria, String pFechaCambio, String pHoraCambio,String pDueno) {
        setTrackingID(pTrackingID);
        setTienda(pTienda);
        setCourier(pCourier);
        setValor(pValor);
        setDescripcion(pDescripcion);
        setPeso(peso);
        setEstado(pEstado);
        setCategoria(pCategoria);
        setFechaCambio(pFechaCambio);
        setHoraCambio(pHoraCambio);
        setDueno(pDueno);

    }


    public String toString() {
        String msg = "TrackingID :" + getTrackingID() + "\n";
        msg += "Tienda :" + getTienda() + "\n";
        msg += "Courier : " + getCourier() + "\n";
        msg += "Valor : " + getValor() + "\n";
        msg += "Peso : " + getPeso() + "\n";
        msg += "Descripcion : " + getDescripcion() + "\n";
        msg += "Estado : " + getEstado() + "\n";
        msg += "Categoria : " + getCategoria() + "\n";
        return msg;
       }

    public String getTrackingID() {
        return trackingID;
    }

    public void setTrackingID(String trackingID) {
        this.trackingID = trackingID;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
            return descripcion;
    }

    public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
    }

    public String getEstado() {
            return estado;
    }

    public void setEstado(String estado) {
            this.estado = estado;
    }

    public String getCategoria() {
            return categoria;
    }

    public void setCategoria(String categoria) {
            this.categoria = categoria;
    }
    public String getHoraCambio() {
            return horaCambio;
    }
    public void setHoraCambio() {
            Date date = new Date();
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
            this.horaCambio = hourFormat.format(date);
    }
    public void setHoraCambio(String pHoraCambio){
        this.horaCambio = pHoraCambio;
    }
    public String getFechaCambio(){
      return fechaCambio;
    }
    public void setFechaCambio(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaCambio = sdf.format(date);
    }
    public void setFechaCambio(String pFechaCambio){
        this.fechaCambio = pFechaCambio;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }
    
    
}
