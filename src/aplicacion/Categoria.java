package aplicacion;

public class Categoria {
	private String tipo;
	private double porcentaje;
	
	public Categoria (String pTipo, double pPorcentaje) {
		this.tipo = pTipo;
		this.porcentaje = pPorcentaje;
	}

	@Override
	public String toString() {
		return "Categoria [tipo=" + tipo + ", porcentaje=" + porcentaje + "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
