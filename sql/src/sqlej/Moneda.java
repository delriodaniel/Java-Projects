package sqlej;

public class Moneda {
	private String codMoneda;
	private String nombre;
	
	public Moneda(String codMoneda, String nombre) {
		super();
		this.codMoneda = codMoneda;
		this.nombre = nombre;
	}
	
	public String getCodMoneda() {
		return codMoneda;
	}
	public void setCodMoneda(String codMoneda) {
		this.codMoneda = codMoneda;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
