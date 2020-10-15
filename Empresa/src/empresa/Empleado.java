package empresa;

import java.util.Random;

public class Empleado {
	protected String nombre;
	protected double sueldo;
	protected int numeroEmpleado;
	public Empleado(String nombre, double sueldo) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		numeroEmpleado=new Random().nextInt()+901;
	}
	public Empleado(String nombre, double sueldo, int numeroEmpleado) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.numeroEmpleado = numeroEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}
	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + ", numeroEmpleado=" + numeroEmpleado + "]";
	}
	
	

}
