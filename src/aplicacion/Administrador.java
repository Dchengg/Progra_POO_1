package aplicacion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	
	public String dashBoard ()
	{

		Map<String, String> estados = new HashMap<String,String>();
		Map<String, String> tiendas = new HashMap<String,String>();
		Map<String, String> categorias = new HashMap<String,String>();
		Map<String, String> compa�ias = new HashMap<String,String>();
		
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
				
				if (compa�ias.containsKey(clientes.get(i).getPaquetes().get(e).getCompa�ia()))
				{
					String valor = compa�ias.get(clientes.get(i).getPaquetes().get(e).getCompa�ia());
					int iValor = Integer.parseInt(valor)+1;
					compa�ias.put(clientes.get(i).getPaquetes().get(e).getCompa�ia(), String.valueOf(iValor));
				}
				
				else
				{
					compa�ias.put(clientes.get(i).getPaquetes().get(e).getCompa�ia(), "1");
				} 
				
			}	
		}
		
		return ("Estados: " + estados.toString() + " " + "Tiendas: " + tiendas.toString() + " " + "Categorias: " + categorias.toString()+ " " + "Compa�ias: " + compa�ias.toString());
		
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
	
	public ArrayList<Soporte> getSoportes() {
		return Soportes;
	}

	public void setSoportes(ArrayList<Soporte> soportes) {
		Soportes = soportes;
	}

}
