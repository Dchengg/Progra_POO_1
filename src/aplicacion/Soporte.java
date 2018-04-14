package aplicacion;

import java.util.Calendar;
import java.util.Date;
import aplicacion.estadoPaquete;

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
		//Date creacionCuenta = new java.util.Date();
		setNombre(nombre);
		setContraseña(contraseña);
		setCorreo(correo);
		setCreacionDeCuenta();
	}
	
	//metodos
	
	
	
	public void cambiarEstadoPaquete(Paquete paquete, String pEstado)
	{
		
		//HACER CON FUCKIN STRING NO ENUM
		
		/*switch (pEstado.)
		{
		case estadoPaquete.:
			
			
			
		case "RECIBIDO_EN_MIAMI":
			
		case "EN_TRANSITO_A_PAIS_DESTIN0":
			
		case "EN_ADUANAS":
			
		case "EN_TRANSITO_A_COUNTER_LOCAL":
			
		case "RECIBIDO_EN_PAIS_DESTINO":
			
		default:
			;*/
		}
		
		
		//Cliente.getPaquetes().setEstado(pEstado);
		
			
	//enviar correo
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

	public double costoDeIVI(int peso)
	{
		double ivi=0;
		//hay que meter los porcentajes de categoria
		return ivi;
	}
	
	public void listaPaquetes()
	{
		//crear la lista desde admin 
		
	}
	

	
	
}
