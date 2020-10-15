package herenciaG;

public class Empleado {
	private String nombre;
	private String apellido;
	private String dni;
	private String direccion;
	private int antiguedad;
	private int telefono;
	private double salario;
	private Empleado supervisor;
	public Empleado(String nombre, String apellido, String dni, String direccion,int antiguedad, int telefono, double salario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.salario = salario;
		this.antiguedad=antiguedad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Empleado getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}
	@Override

public String toString() {
		return "nombre=" + this.nombre + ", apellido=" + this.apellido + ", dni=" + this.dni + ", direccion=" + this.direccion
				+ ", antiguedad=" + this.antiguedad + ", telefono=" + this.telefono + ", salaraio=" + this.salario;
	}
	
	public void cambiarSupervisor(Empleado supervisor) {
		this.supervisor=supervisor;
	}
	public void incrementarSalario(double subida) {
		double percent=subida/100;
		this.salario+=this.salario*percent;
	}
	
}
