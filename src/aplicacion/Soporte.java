package aplicacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import XML.ClienteXML;
import aplicacion.Cliente;


public class Soporte{

	//variables
	private String nombre;
	private String contraseña;
	private String correo;
	private Date creacionDeCuenta;
	private Calendar fecha;
	
	//constructores
	public Soporte(String nombre, String contraseña,String correo)
	{
		setNombre(nombre);
		setContraseña(contraseña);
		setCorreo(correo);
		setCreacionDeCuenta();
		
	}
	
	//metodos
	
	
	
	public void cambiarEstadoPaquete(Paquete paquete, String pEstado)
	{
		
		switch (pEstado)
		{
		case "PREALERTADO":
			paquete.setEstado("RECIBIDO_EN_MIAMI");
			break;
			
		case "RECIBIDO_EN_MIAMI":
			paquete.setEstado("EN_TRANSITO_A_PAIS_DESTIN0");
			break;
			
		case "EN_TRANSITO_A_PAIS_DESTIN0":
			paquete.setEstado("EN_ADUANAS");
			break;
			
		case "EN_ADUANAS":
			paquete.setEstado("EN_TRANSITO_A_COUNTER_LOCAL");
			break;
			
		case "EN_TRANSITO_A_COUNTER_LOCAL":
			paquete.setEstado("RECIBIDO_EN_PAIS_DESTINO");
			break;
			
		case "RECIBIDO_EN_PAIS_DESTINO":
			paquete.setEstado("ENTREGADO");
			break;
			
		default:
			paquete.setEstado("EL_PAQUETE_YA_A_SIDO_ENTREGADO");
			break;
		}
		
			
	//enviar correo
	}

	
	public double costoDeIVI(int peso, double porcentaje)
	{
		double ivi=0;
		return ivi;
	}
	
	public void listaPaquetes()
	{
		ArrayList<Paquete> ordenEstadoPaquetes = new ArrayList<Paquete>();
		
		ArrayList<Paquete> soloPaquetes = Cliente.getPaquetes();
		
	
		
		
	}
	
	
	public String toString() {
		 String msg = "Nombre :" + getNombre() + "\n";
		 msg += "Correo :" + getCorreo() + "\n";
		 msg += "Creacion de Cuenta :" + getCreacionDeCuenta() + "\n";

		 return msg;
		}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getCreacionDeCuenta() {
		return creacionDeCuenta;
	}

	public void setCreacionDeCuenta() {
	
		this.creacionDeCuenta = fecha.getTime();
	}

	

	
	
}
