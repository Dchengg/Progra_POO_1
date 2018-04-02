package aplicacion;

import java.util.ArrayList;
import java.util.Date;

public class Cliente {

	private String nombre;
	private String email;
	private String dirección;
	private String numTel;
	private Date fechaDeNacimiento;
	private boolean perfilCompleto;
	private String contraseña;
	private boolean notificaciones;
	private String numCasillero;
	private ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
	
	public Cliente(String pNombre, String pEmail) {
		setNombre(pNombre);
		setEmail(pEmail);
	}
	
	private void agregarPaquete(String trackingID, String tienda, String courier, int valor, String descripcion) {
		Paquete paqueteNuevo = new Paquete(trackingID,tienda,courier,valor,descripcion);
		paquetes.add(paqueteNuevo);
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
	public String getDirección() {
		return dirección;
	}
	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public boolean isPerfilCompleto() {
		return perfilCompleto;
	}
	public void setPerfilCompleto(boolean perfilCompleto) {
		this.perfilCompleto = perfilCompleto;
	}
	
	private String getContraseña() {
		return contraseña;
	}
	private void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public boolean isNotificaciones() {
		return notificaciones;
	}
	public void setNotificaciones(boolean notificaciones) {
		this.notificaciones = notificaciones;
	}
	
	
}
