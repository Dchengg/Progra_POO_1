package aplicacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import aplicacion.Cliente;
import aplicacion.Categoria;
import java.text.SimpleDateFormat;

public class Soporte{

	//variables
	private String nombre;
	private String contrasena;
	private String correo;
	private String creacionDeCuenta;
	private static ArrayList<Cliente> clientes;
	//donde se crea cada cliente hay que a;adirlo aqui!!
	
	

	//constructores
	public Soporte(String nombre, String contrasena,String correo)
	{
		setNombre(nombre);
		setContrasena(contrasena);
		setCorreo(correo);
		setCreacionDeCuenta();	
	}
        
        public Soporte(String nombre, String contrasena,String correo, String pFecha)
	{
		setNombre(nombre);
		setContrasena(contrasena);
		setCorreo(correo);
		setCreacionDeCuenta(pFecha);	
	}
	
	//metodos
	
	
	
	public void cambiarEstadoPaquete(Paquete paquete, String pEstado)
	{
		
		switch (pEstado)
		{
		case "PREALERTADO":
			paquete.setEstado("RECIBIDO_EN_MIAMI");
			break;
			
		case "RECIBIDO_EN_MIAMI":
			paquete.setEstado("EN_TRANSITO_A_PAIS_DESTIN0");
			break;
			
		case "EN_TRANSITO_A_PAIS_DESTIN0":
			paquete.setEstado("EN_ADUANAS");
			break;
			
		case "EN_ADUANAS":
			paquete.setEstado("EN_TRANSITO_A_COUNTER_LOCAL");
			break;
			
		case "EN_TRANSITO_A_COUNTER_LOCAL":
			paquete.setEstado("RECIBIDO_EN_PAIS_DESTINO");
			break;
			
		case "RECIBIDO_EN_PAIS_DESTINO":
			paquete.setEstado("ENTREGADO");
			break;
			
		default:
			paquete.setEstado("EL_PAQUETE_YA_A_SIDO_ENTREGADO");
			break;
		}
			
	//enviar correo
	}
        
        public boolean logIn(String id, String contra){
            if(id.equals(getNombre()) && contra.equals(getContrasena())){
                return true;
            }else{
                return false;
            }
        }
        
        public double impuestoAduanal(Paquete paquete, Categoria categoria){
            double precio = paquete.getValor();
            double porcentaje = categoria.getPorcentaje();
            return precio*(porcentaje/100);
        }
        
        public double combustible(Paquete paquete){
            double precio = paquete.getValor();
            return precio*(19/100);
        }
        public double garantiaRetorno(){
            return 1.5;
        }
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
        
        public double costoFinal(Paquete paquete, Categoria categoria){
            return flete(paquete)+ combustible(paquete) + garantiaRetorno() + impuestoAduanal(paquete,categoria);
        }

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
