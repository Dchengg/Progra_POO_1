package aplicacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import aplicacion.Cliente;



public class Soporte{

	//variables
	private String nombre;
	private String contrasena;
	private String correo;
	private Date creacionDeCuenta;
	private Calendar fecha;
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	//donde se crea cada cliente hay que a;adirlo aqui!!
	
	

	//constructores
	public Soporte(String nombre, String contrasena,String correo)
	{
		setNombre(nombre);
		setContrasena(contrasena);
		setCorreo(correo);
		setCreacionDeCuenta();
		
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

	
	public double costoDeIVI(int peso, double porcentaje)
	{
		double ivi=0;
		//meter porcentajes
		
		return ivi;
	}
	
	public void listaPaquetes()
	{
		ArrayList<ArrayList<Paquete>> ordenUsuarioPaquetes = new ArrayList<ArrayList<Paquete>>();
		
		
		for (int i=0; i <= clientes.size() ;i++)
		{
			ordenUsuarioPaquetes.add(clientes.get(i).getPaquetes());
		}
		
		System.out.println(ordenUsuarioPaquetes.toString());
		
	}
	
	
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

	public Date getCreacionDeCuenta() {
		return creacionDeCuenta;
	}

	public void setCreacionDeCuenta() {
	
		this.creacionDeCuenta = fecha.getTime();
	}

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(ArrayList<Cliente> clientes) {
		Soporte.clientes = clientes;
	}

	
	
}
