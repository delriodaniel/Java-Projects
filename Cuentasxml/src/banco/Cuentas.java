package banco;

public class Cuentas {
	private String numeroCuenta;
	private Titular[] titulares;
	private String fecha;
	private String saldo;
	
	public Cuentas(String numeroCuenta, Titular[] clientes, String fecha, String saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.titulares = clientes;
		this.fecha = fecha;
		this.saldo = saldo;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Titular[] getTitulares() {
		return titulares;
	}

	public void setTitulares(Titular[] titulares) {
		this.titulares = titulares;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	
	
}
