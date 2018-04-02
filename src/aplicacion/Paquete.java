package aplicacion;

public class Paquete {

	private String trackingID;
	private String tienda;
	private String courier;
	private int valor;
	private int peso;
	private String descripcion;
	private String estado;
	private String categoria;
	
	public Paquete(String pTrackingID, String pTienda, String pCourier, int pValor, String pDescripcion) {
		setTrackingID(pTrackingID);
		setTienda(pTienda);
		setCourier(pCourier);
		setValor(pValor);
		setDescripcion(pDescripcion);
		setEstado("Prealertado");
	}

	public String getTrackingID() {
		return trackingID;
	}

	public void setTrackingID(String trackingID) {
		this.trackingID = trackingID;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
