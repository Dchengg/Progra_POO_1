package aplicacion;

import java.sql.Date;

public class Soporte extends Administrador{

	//variables
	private String correo;
	private Date creacionDeCuenta;
	
	//constructores
	public Soporte(String nombre, String contraseña,String correo)
	{
		Date creacionCuenta = new java.util.Date();
		super.setNombre(nombre);
		super.setContraseña(contraseña);
		setCreacionDeCuenta(creacionCuenta);
	}
	
	//metodos
	
	
	
	public void cambiarEstadoPaquete(int idPaquete, String pEstado)
	{
		
		//Cliente.getPaquetes().setEstado(pEstado);
		
			
	//enviar correo
	}
	
	public String toString() {
		 String msg = "Nombre :" + super.getNombre() + "\n";
		 msg += "Correo :" + getCorreo() + "\n";
		 msg += "Creacion de Cuenta :" + getCreacionDeCuenta() + "\n";

		 return msg;
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

	public void setCreacionDeCuenta(Date creacionDeCuenta) {
		this.creacionDeCuenta = creacionDeCuenta;
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
