package aplicacion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Administrador {

	private String nombre= "administrador";
	private String contrasena= "123Adm";
	private ArrayList<Soporte> Soportes = new ArrayList<Soporte>();
	private ArrayList<Cliente> clientes = Soporte.getClientes();
	


	public void creaSoporte(String nombre, String contrasena,String correo)
	{
		Soporte soporteNuevo = new Soporte (nombre,contrasena,correo);
		Soportes.add(soporteNuevo);
		
	}
	
	
	public String dashBoard ()
	{

		Map<String, String> estados = new HashMap<String,String>();
		Map<String, String> tiendas = new HashMap<String,String>();
		Map<String, String> categorias = new HashMap<String,String>();
		Map<String, String> couriers = new HashMap<String,String>();
		
		//estados
		
		for (int i=0; i <= clientes.size(); i++)
		{
			
			for (int e = 0; e <= clientes.get(i).getPaquetes().size(); e++)
			{
				//estados
				
				if (estados.containsKey(clientes.get(i).getPaquetes().get(e).getEstado()))
				{
					String valor = estados.get(clientes.get(i).getPaquetes().get(e).getEstado());
					int iValor = Integer.parseInt(valor)+1;
					estados.put(clientes.get(i).getPaquetes().get(e).getEstado(), String.valueOf(iValor));
				}
				
				else
				{
					estados.put(clientes.get(i).getPaquetes().get(e).getEstado(), "1");
				}
				
				
				//tiendas
				
				if (tiendas.containsKey(clientes.get(i).getPaquetes().get(e).getTienda()))
				{
					String valor = tiendas.get(clientes.get(i).getPaquetes().get(e).getTienda());
					int iValor = Integer.parseInt(valor)+1;
					tiendas.put(clientes.get(i).getPaquetes().get(e).getTienda(), String.valueOf(iValor));
				}
				
				else
				{
					tiendas.put(clientes.get(i).getPaquetes().get(e).getTienda(), "1");
				}
				
				
				//categorias
				
				if (categorias.containsKey(clientes.get(i).getPaquetes().get(e).getCategoria()))
				{
					String valor = categorias.get(clientes.get(i).getPaquetes().get(e).getCategoria());
					int iValor = Integer.parseInt(valor)+1;
					categorias.put(clientes.get(i).getPaquetes().get(e).getCategoria(), String.valueOf(iValor));
				}
				
				else
				{
					categorias.put(clientes.get(i).getPaquetes().get(e).getCategoria(), "1");
				}
				
				
				//compa�ias
				
				if (couriers.containsKey(clientes.get(i).getPaquetes().get(e).getCourier()))
				{
					String valor = couriers.get(clientes.get(i).getPaquetes().get(e).getCourier());
					int iValor = Integer.parseInt(valor)+1;
					couriers.put(clientes.get(i).getPaquetes().get(e).getCourier(), String.valueOf(iValor));
				}
				
				else
				{
					couriers.put(clientes.get(i).getPaquetes().get(e).getCourier(), "1");
				} 
				
			}	
		}
		
		return ("Estados: " + estados.toString() + " " + "Tiendas: " + tiendas.toString() + " " + "Categorias: " + categorias.toString()+ " " + "Compañias: " + couriers.toString());
		
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public ArrayList<Soporte> getSoportes() {
		return Soportes;
	}

	public void setSoportes(ArrayList<Soporte> soportes) {
		Soportes = soportes;
	}

}
