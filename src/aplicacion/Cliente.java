package aplicacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Cliente {

	private String nombre;
	private String email;
	private String direcci�n;
	private String numTel;
	private String fechaDeNacimiento;
	private boolean perfilCompleto;
	private String contrase�a;
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
		setDirecci�n(pDir);
		setNumTel(pNumTel);
		setFechaDeNacimiento(pFechaDeNacimiento);
		setPerfilCompleto(pCompleto);
		setContrase�a(pContra);
		setNotificaciones(pNotificaciones);
		setNumCasillero(pNumCasillero);
		
	}
	
	private void agregarPaquete(String trackingID, String tienda, String courier, int valor, String descripcion) {
		Paquete paqueteNuevo = new Paquete(trackingID,tienda,courier,valor,descripcion);
		paquetes.add(paqueteNuevo);
	}
	
	public String toString() {
	 String msg = "Nombre :" + getNombre() + "\n";
	 msg += "Correo :" + getEmail() + "\n";
	 msg += "Direcci�n : " + getDirecci�n() + "\n";
	 msg += "N�mero de Telefono : " + getNumTel() + "\n";
	 msg += "Fecha de Nacimiento : " + getFechaDeNacimiento() + "\n";
	 msg += "Perfil Completo : " + isPerfilCompleto() + "\n";
	 msg += "Contrase�a : " + getContrase�a() + "\n";
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
	public String getDirecci�n() {
		return direcci�n;
	}
	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
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
	
	private String getContrase�a() {
		return contrase�a;
	}
	private void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
	
	
}