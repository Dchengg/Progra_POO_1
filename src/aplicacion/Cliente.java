package aplicacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Cliente {

	private String nombre;
	private String email;
	private String dirección;
	private String numTel;
	private String fechaDeNacimiento;
	private boolean perfilCompleto;
	private String contraseña;
	private boolean notificaciones;
	private String numCasillero;
	private ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
	
	

	public Cliente(String pNombre, String pEmail) {
		setNombre(pNombre);
		setEmail(pEmail);
	}
	
	public Cliente(String pNombre, String pEmail, String pDir, String pNumTel,String pFechaDeNacimiento,boolean pCompleto, String pContra, boolean pNotificaciones, String pNumCasillero) {
		setNombre(pNombre);
		setEmail(pEmail);
		setDirección(pDir);
		setNumTel(pNumTel);
		setFechaDeNacimiento(pFechaDeNacimiento);
		setPerfilCompleto(pCompleto);
		setContraseña(pContra);
		setNotificaciones(pNotificaciones);
		setNumCasillero(pNumCasillero);
		
	}
	
	private void agregarPaquete(String trackingID, String tienda, String courier, int valor, String descripcion) {
		Paquete paqueteNuevo = new Paquete(trackingID,tienda,courier,valor,descripcion);
		paquetes.add(paqueteNuevo);
	}
	
	public boolean logIn(String id, String contra) {
		if(id.equals(getNombre()) && contra.equals(getContraseña())) {
			return true;
		}else {
			return false;
		}
	}
	public String toString() {
	 String msg = "Nombre :" + getNombre() + "\n";
	 msg += "Correo :" + getEmail() + "\n";
	 msg += "Dirección : " + getDirección() + "\n";
	 msg += "Número de Telefono : " + getNumTel() + "\n";
	 msg += "Fecha de Nacimiento : " + getFechaDeNacimiento() + "\n";
	 msg += "Perfil Completo : " + isPerfilCompleto() + "\n";
	 msg += "Contraseña : " + getContraseña() + "\n";
	 msg += "Recibir notificaciones : " + isNotificaciones() + "\n";
	 msg += "Número de Casillero : " + getNumCasillero() + "\n";
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
	public String getContraseña() {
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
}
