package empresa;

public class Ejecutivo extends Empleado {
	protected double presupuesto;

	
	public Ejecutivo(String nombre, double sueldo) {
		super(nombre, sueldo);
		// TODO Auto-generated constructor stub
	}
	public Ejecutivo(String nombre, double sueldo, int numeroEmpleado) {
		super(nombre,sueldo,numeroEmpleado);

	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	@Override
	public String toString() {
		return super.toString()+"Ejecutivo [presupuesto=" + presupuesto + "]";
	}
	

}
