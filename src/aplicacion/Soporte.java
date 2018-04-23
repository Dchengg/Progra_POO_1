package aplicacion;

import XML.CategoriasXML;
import email.Sender;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;


/**
 * Aqui se desarrolla cada soporte, el cual puede ver todos los paquetes de cada cliente, cambiar los estados de los paquetes, y calcula el costo total de los paqutes
 * @author Aivy
 */

public class Soporte{

	//variables
	private String nombre;
	private String contrasena;
	private String correo;
	private String creacionDeCuenta;
	private static ArrayList<Cliente> clientes;
	//donde se crea cada cliente hay que a;adirlo aqui!!
	
	

	//constructores
        
         /**
        * Crea un Soporte
        * @param nombre es el nombre del soporte
        * @param contrasena contrasena indicada por el usuario
        * @param correo correo del usuario
        */
        
	public Soporte(String nombre, String contrasena,String correo)
	{
		setNombre(nombre);
		setContrasena(contrasena);
		setCorreo(correo);
		setCreacionDeCuenta();	
	}
        
          /**
        * Crea un Soporte
        * @param nombre es el nombre del soporte
        * @param contrasena contrasena indicada por el usuario
        * @param correo correo del usuario
        * @param pFecha indica la fecha de cuando se creo la cuenta
        */
        
        public Soporte(String nombre, String contrasena,String correo, String pFecha)
	{
		setNombre(nombre);
		setContrasena(contrasena);
		setCorreo(correo);
		setCreacionDeCuenta(pFecha);	
	}
	
	//metodos
	
	
	  /**
        * Cambia el estado de un paquete
        * @param paquete es el paquete al que se le cambiara el estado
        * @param pEstado estado al que cambiara
        */
	public void cambiarEstadoPaquete(Paquete paquete, String pEstado)
        {
            paquete.setEstado(pEstado);
            if(paquete.getDueno().isNotificaciones()){
                String subject = "Notificación : El paquete " + paquete.getTrackingID() + "ha cambiado de estado";
                String content = "El paquete " + paquete.getTrackingID() + " ha cambiado al estado " + paquete.getEstado().getDescripcion();
                Sender.sendEmail(paquete.getDueno().getEmail(), subject, content);
            }
	}
        
          /**
        * Verifica el log in del soporte
        * @param id nombre de usuario del soporte
        * @param  contra contrasena indicada por el soporte
        * @return Boolean
        */
        
        public boolean logIn(String id, String contra){
            if(id.equals(getNombre()) && contra.equals(getContrasena())){
                return true;
            }else{
                return false;
            }
        }
        
          /**
        * Calcula los impuestos que se anadiran al precio del paquete
        * @param paquete paquete al que se le aplicaran los impuestos
        * @return Double
        */
        
        public double impuestoAduanal(Paquete paquete){
            double precio = paquete.getValor();
            double porcentaje = CategoriasXML.leerArchivo(paquete.getCategoria());
            return precio*(porcentaje/100);
        }
        
          /**
        * Calcula cuanto se le anadira el precio del paquete por el combustible
        * @param paquete el paquete al que se le calculara el precio
        * @return Double
        */
        
        public double combustible(Paquete paquete){
            double precio = paquete.getValor();
            return precio*(19/100);
        }
          /**
        * @return Double 1.5
        */
        
        public double garantiaRetorno(){
            return 1.5;
        }
        
          /**
        * Calcula el costo del paquete segun su peso
        * @param paquete el paquete al cual se le calculara el costo
        * @return Double
        */
        
        public double flete(Paquete paquete){
            double peso = paquete.getPeso();
            if(peso == 1){
               double costo = 9.00;
               return costo;
            }
            if(peso == 2){
               double costo = 14.50;
               return costo;
            }
            if(peso == 3){
               double costo = 20.00;
               return costo;
            }
            if(peso == 4){
               double costo = 25.50;
               return costo;
            }
            if(peso == 5){
               double costo = 31.50;
               return costo;
            }
            if(peso == 6){
               double costo = 36.50;
               return costo;
            }
            if(peso == 7){
               double costo = 42.00;
               return costo;
            }
            if(peso == 8){
               double costo = 47.50;
               return costo;
            }
            if(peso == 9){
               double costo = 53.00;
               return costo;
            }
            if(peso == 10){
               double costo = 58.50;
               return costo;
            }
            else{
                double extra = peso-10;
                double cant = 0;
                for(int i = 0; i < extra; i++){
                    cant++;
                }
                double costo = 58.50 + (cant*3.50);
                return costo;
            }
        }
        
          /**
        * Calcula el costo final de un paquete
        * @param paquete el paquete al que se le calculara el costo
        * @return Double
        */
        
        public double costoFinal(Paquete paquete){
            double valorTotal = flete(paquete)+ combustible(paquete) + garantiaRetorno() + impuestoAduanal(paquete) + paquete.getValor();
            paquete.setValorTotal(valorTotal);
            paquete.setValor(valorTotal);
            return valorTotal;
        }
 /**
        * Verefica si el paquete existe
        * @param id id del paquete
        * @return Paquete
        */
        
        public Paquete verificarPaquete(String id){
            ArrayList<Paquete> paquetes = listaPaquetes();
            for(Paquete paquete:paquetes){
                if(id.equals(paquete.getTrackingID())){
                    return paquete;
                }
            }
            return null;
        }
        
         /**
        * Crea una lista los paquetes de todos los clientes
        * @return List
        */
        
	public ArrayList<Paquete> listaPaquetes()
	{
            ArrayList<Paquete> paquetesGlobales = new ArrayList<Paquete>();
            for (Cliente cliente : clientes){                
                 ArrayList<Paquete> paquetes = cliente.getPaquetes();
                 for(Paquete paquete : paquetes){
                     paquetesGlobales.add(paquete);
                 }
            }	
            return paquetesGlobales;
	}
	
	@Override
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCreacionDeCuenta() {
		return creacionDeCuenta;
	}

	public void setCreacionDeCuenta() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendario;
            calendario = Calendar.getInstance();
            this.creacionDeCuenta = sdf.format(calendario.getTime());
	}
        public void setCreacionDeCuenta(String pFecha){
            this.creacionDeCuenta = pFecha;
        }

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(ArrayList<Cliente> clientes) {
		Soporte.clientes = clientes;
	}

	
	
}
