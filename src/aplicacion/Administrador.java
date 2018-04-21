package aplicacion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Administrador {

	private String nombre= "administrador";
	private String contrasena= "123Adm";
	private static ArrayList<Soporte> soportes;
	private static ArrayList<Cliente> clientes;
	
        public Administrador(){
            
        }
        
	public void creaSoporte(String nombre, String contrasena,String correo)
	{
		Soporte soporteNuevo = new Soporte (nombre,contrasena,correo);
		soportes.add(soporteNuevo);
		
	}
	
        public boolean logIn(String id, String contra){
            if(id.equals(getNombre()) && contra.equals(getContrasena())){
                return true;
            }else{
                return false;
            }
        }
	
        public Map<String, String> getEstados(){
            Map<String, String> estados = new HashMap<String,String>();
            for(Cliente cliente:clientes){
                ArrayList<Paquete> paquetes = cliente.getPaquetes();
                for(Paquete paquete:paquetes){
                    if(estados.containsKey(paquete.getEstado())){
                        String valor = paquete.getEstado();
                        int iValor = Integer.parseInt(valor)+1;
                        estados.put(paquete.getEstado(), String.valueOf(iValor));
                    }else{
                        estados.put(paquete.getEstado(), "1");
                    }
                }
            }
            for(String name: estados.keySet()){
                String key = name;
                String value = estados.get(name);
                System.out.println(key + " = " + value);
            }
            return estados;
        }
        
        public Map<String, String> getTiendas(){
            Map<String, String> tiendas = new HashMap<String,String>();
            for(Cliente cliente:clientes){
                ArrayList<Paquete> paquetes = cliente.getPaquetes();
                for(Paquete paquete:paquetes){
                    if(tiendas.containsKey(paquete.getTienda())){
                        String valor = paquete.getTienda();
                        int iValor = Integer.parseInt(valor)+1;
                        tiendas.put(paquete.getTienda(), String.valueOf(iValor));
                    }else{
                        tiendas.put(paquete.getTienda(), "1");
                    }
                }
            }
            for(String name: tiendas.keySet()){
                String key = name;
                String value = tiendas.get(name);
                System.out.println(key + " = " + value);
            }
            return tiendas;
        }
        
        public Map<String, String> getCategorias(){
            Map<String, String> categorias = new HashMap<String,String>();
            for(Cliente cliente:clientes){
                ArrayList<Paquete> paquetes = cliente.getPaquetes();
                for(Paquete paquete:paquetes){
                    if(categorias.containsKey(paquete.getCategoria())){
                        String valor = paquete.getCategoria();
                        int iValor = Integer.parseInt(valor)+1;
                        categorias.put(paquete.getCategoria(), String.valueOf(iValor));
                    }else{
                        categorias.put(paquete.getCategoria(), "1");
                    }
                }
            }
            for(String name: categorias.keySet()){
                String key = name;
                String value = categorias.get(name);
                System.out.println(key + " = " + value);
            }
            return categorias;
        }
        
	public String dashBoard ()
	{

		Map<String, String> estados = new HashMap<String,String>();
		Map<String, String> tiendas = new HashMap<String,String>();
		Map<String, String> categorias = new HashMap<String,String>();
		Map<String, String> couriers = new HashMap<String,String>();
		
		//estados
		System.out.println(clientes.size());
		for (int i=0; i < clientes.size(); i++)
		{		
                    for (int e = 0; e < clientes.get(i).getPaquetes().size(); e++)
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
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public static void setClientes(ArrayList<Cliente> pClientes) {
		clientes = pClientes;
	}
	
	public static ArrayList<Soporte> getSoportes() {
		return soportes;
	}

	public static void setSoportes(ArrayList<Soporte> pSoportes) {
		soportes = pSoportes;
	}

}
