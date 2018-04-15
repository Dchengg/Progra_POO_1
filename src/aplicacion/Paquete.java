package aplicacion;

public class Paquete {

	private String trackingID;
	private String tienda;
	private String courier;
	private double valor;
	private int peso;
	private String descripcion;
	private String estado;
	private String categoria;
	private String duenio;
	
	public Paquete(String pTrackingID, String pTienda, String pCourier, int pValor, String pDescripcion, String duenio) {
		setTrackingID(pTrackingID);
		setTienda(pTienda);
		setCourier(pCourier);
		setValor(pValor);
		setDescripcion(pDescripcion);
		setEstado("Prealertado");
		setDuenio(duenio);
	}

	

	@Override
	public String toString() {
		return "Paquete [trackingID=" + trackingID + ", tienda=" + tienda + ", courier=" + courier + ", valor=" + valor
				+ ", peso=" + peso + ", descripcion=" + descripcion + ", estado=" + estado + ", categoria=" + categoria
				+ ", duenio=" + duenio + "]";
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

	public double getValor() {
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
	
	public String getDuenio() {
		return duenio;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}
	
}
