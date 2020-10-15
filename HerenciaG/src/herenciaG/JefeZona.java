package herenciaG;

import java.util.ArrayList;
import java.util.Iterator;

public class JefeZona extends Empleado{
	private String despacho;
	private Secretario secretario;
	private ArrayList<Vendedor> alvendedores;
	private Coche coche;

	public JefeZona(String nombre, String apellido, String dni, String direccion,int antiguedad, int telefono, double salario,
			String despacho, Secretario secretario, ArrayList<Vendedor> alvendedores, Coche coche) {
		super(nombre, apellido, dni, direccion, antiguedad, telefono, salario);
		this.despacho = despacho;
		this.secretario = secretario;
		this.alvendedores = alvendedores;
		this.coche = coche;
		this.incrementarSalario(20);
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

	public Secretario getSecretario() {
		return secretario;
	}

	public void setSecretario(Secretario secretario) {
		this.secretario = secretario;
	}

	public ArrayList<Vendedor> getAlvendedores() {
		return alvendedores;
	}

	public void setAlvendedores(ArrayList<Vendedor> alvendedores) {
		this.alvendedores = alvendedores;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	@Override
	public String toString() {
		return super.toString()+ "despacho=" + despacho + ", secretario=" + secretario + ", alvendedores=" + alvendedores
				+ ", coche=" + coche + "";
	}
	
	public void cambiarSecretario(Secretario secretario) {
		this.secretario=secretario;
	}
	public void cambiarCoche(Coche coche) {
		this.coche=coche;
	}
	public void darAltaVendedor(Vendedor vendedor) {
		this.alvendedores.add(vendedor);
	}
	public void darBajaVendedor(Vendedor vendedor) {
		Iterator it= alvendedores.iterator();
		while(it.hasNext()) {
			if(((Empleado) it.next()).getDni().equals(vendedor.getDni())) {
				it.remove();
			}
		}
	}
	

}
