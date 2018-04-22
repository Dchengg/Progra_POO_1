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
        
        
        /** 
     * Crea un Soporte
     * @param nombre nombre del soporte
     * @param contrasena contrasena indicada por el soporte
     * @param correo correo del soporte
     */
        
	public void creaSoporte(String nombre, String contrasena,String correo)
	{
		Soporte soporteNuevo = new Soporte (nombre,contrasena,correo);
		soportes.add(soporteNuevo);
		
	}
	
        /**
        * verifica si los datos ingresados en el Log in de un usuario son correctos
        * @param id es el nombre del usuario
        * @param contra es la contrasena guardada en la "Base de datos"
        */
        
        public boolean logIn(String id, String contra){
            if(id.equals(getNombre()) && contra.equals(getContrasena())){
                return true;
            }else{
                return false;
            }
        }
	
        /**
        * crea un map para los estados en los que se encuentran los paquetes
        */
        
        public Map<String, String> getEstados(){
            Map<String, String> estados = new HashMap<String,String>();
            for(Cliente cliente:clientes){
                ArrayList<Paquete> paquetes = cliente.getPaquetes();
                for(Paquete paquete:paquetes){
                    if(estados.containsKey(paquete.getEstado())){
                        String valor = paquete.getEstado().getDescripcion();
                        int iValor = Integer.parseInt(valor)+1;
                        estados.put(paquete.getEstado().getDescripcion(), String.valueOf(iValor));
                    }else{
                        estados.put(paquete.getEstado().getDescripcion(), "1");
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
        
        /**
        * crea un map para las tiendas en los que se encuentran los paquetes
        */
        
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
        /**
        * crea un map para las categorias de las que provienen los paquetes
        */
        
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
