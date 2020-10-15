package herenciaG;

import java.util.ArrayList;
import java.util.Iterator;

public class Vendedor extends Empleado {
	private Coche coche;
	private int movil;
	private String area;
	private ArrayList<Cliente> alClientes;
	private double comision;
	public Vendedor(String nombre, String apellido, String dni, String direccion, int telefono, double salario, Coche coche,int movil,String area,ArrayList<Cliente> alClientes,double comision) {
		super(nombre, apellido, dni, direccion, telefono, movil, salario);
		// TODO Auto-generated constructor stub
		this.coche=coche;
		this.movil=movil;
		this.area=area;
		this.alClientes=alClientes;
		this.comision=comision;
		this.incrementarSalario(10);
		
	}
	public Coche getCoche() {
		return coche;
	}
	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	public int getMovil() {
		return movil;
	}
	public void setMovil(int movil) {
		this.movil = movil;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public ArrayList<Cliente> getAlClientes() {
		return alClientes;
	}
	public void setAlClientes(ArrayList<Cliente> alClientes) {
		this.alClientes = alClientes;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	@Override
	public String toString() {
		return super.toString()+" coche=" + coche + ", movil=" + movil + ", area=" + area + ", comision=" + comision + "";
	}
	
	public void darAltaCliente(Cliente cliente) {
		this.alClientes.add(cliente);
	}
	public void darBajaCliente(Cliente cliente) {
		Iterator it= alClientes.iterator();
		while(it.hasNext()) {
			if(((Empleado) it.next()).getDni().equals(cliente.getDni())) {
				it.remove();
			}
		}
	}
	public void cambiarCoche(Coche coche) {
		this.coche=coche;
	}
	

}
