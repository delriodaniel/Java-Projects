package sqlej;

import java.util.Date;

public class Cuenta {
	private String numeroCuenta;
	private double saldo;
	private Moneda moneda;
	private Date fechaCreacion;
	private Titular titular;
	
	
	public Cuenta(String numeroCuenta, double saldo, Moneda moneda, Date fechaCreacion, Titular titular) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.moneda = moneda;
		this.fechaCreacion = fechaCreacion;
		this.titular = titular;
	}


	public String getNumeroCuenta() {
		return numeroCuenta;
	}


	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public Moneda getMoneda() {
		return moneda;
	}


	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Titular getTitular() {
		return titular;
	}


	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	
	
}
