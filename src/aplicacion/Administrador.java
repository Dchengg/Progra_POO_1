package aplicacion;


import java.util.ArrayList;
import aplicacion.Paquete;


public class Administrador {

	private String nombre= "administrador";
	private String contraseña= "123Adm";
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Paquete> soloPaquetes = new ArrayList<Paquete>();
	private ArrayList<Soporte> Soportes = new ArrayList<Soporte>();
	
	
	public void creaSoporte(String nombre, String contraseña,String correo)
	{
		new Soporte (nombre,contraseña,correo);
	}
	
	
	// debe acceder el estado, tienda, categoria, compa;ia de paquetes
	// y presentarlo en graficos, se puede hacer desde los gets de estos atributos en Paquete.
	
	
	//falta punto 3
	
	
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
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Paquete> getSoloPaquetes() {
		return soloPaquetes;
	}
	public void setSoloPaquetes(ArrayList<Paquete> soloPaquetes) {
		this.soloPaquetes = soloPaquetes;
	}
	



	
	


}
