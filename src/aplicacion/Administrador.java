package aplicacion;


import java.util.ArrayList;
import aplicacion.Paquete;


public class Administrador {

	private String nombre= "administrador";
	private String contrase�a= "123Adm";
	private ArrayList<Soporte> Soportes = new ArrayList<Soporte>();
	private ArrayList<Cliente> clientes = Soporte.getClientes();
	
	
	
	
	public void creaSoporte(String nombre, String contrase�a,String correo)
	{
		Soporte soporteNuevo = new Soporte (nombre,contrase�a,correo);
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
			
		case "Compa�ia":
			break;
			
		default:
			return "Indique: Estado, Tienda, Categoria o Compa�ia";
			
		
		}
		
		
		
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
