package aplicacion;


import java.util.ArrayList;
import aplicacion.Paquete;


public class Administrador {

	private String nombre= "administrador";
	private String contraseña= "123Adm";
	private ArrayList<Soporte> Soportes = new ArrayList<Soporte>();
	private ArrayList<Cliente> clientes = Soporte.getClientes();
	
	
	
	
	public void creaSoporte(String nombre, String contraseña,String correo)
	{
		Soporte soporteNuevo = new Soporte (nombre,contraseña,correo);
		Soportes.add(soporteNuevo);
		
	}
	
	
	public String dashBoard (String indicador)
	{

		
		switch(indicador)
		{
		case "Estado":
			
			for (int i=0; i <= clientes.size(); i++)
			{
				
				
			}
			
			
			break;
		
		case "Tienda":
			break;
			
		case "Categoria":
			break;
			
		case "Compañia":
			break;
			
		default:
			return "Indique: Estado, Tienda, Categoria o Compañia";
			
		
		}
		
		
		
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
