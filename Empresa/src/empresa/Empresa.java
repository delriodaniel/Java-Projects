package empresa;

public class Empresa {
	public String nombre;
	public int tamano;
	public Empleado[] empleados;
	
	public Empresa(String nombre, int tamano) {
		super();
		this.nombre = nombre;
		this.tamano = tamano;
		empleados = new Empleado[tamano];
		
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	
	public Empleado[] getEmpleados() {
		return empleados;
	}


	public void setEmpleados(Empleado[] empleados) {
		this.empleados = empleados;
	}


	public void muestraEmpleados() {
		for (int i = 0; i < empleados.length; i++) {
			System.out.println(empleados[i].toString());
		}
	}
	public Empleado getEmpleado(int num) {
		return empleados[num];
	}
	public void despideEmpleado(Empleado empleado) {
		for (int i = 0; i < empleados.length; i++) {
			if(empleados[i].equals(empleado)) {
				empleados[i]=null;
			}
		}
	}

	protected void aumentarSueldo(Empleado empleado,double num) {
		double n=num/100;
		double perc;
		double sum;
		
		perc=n*empleado.getSueldo();
		sum=empleado.getSueldo()+perc;
		empleado.setSueldo(sum);
	}
	public void nuevoEmpleado(Empleado empleado) {
		for (int i = 0; i < empleados.length; i++) {
			if(empleados[i].equals(null)) {
				empleados[i]=empleado;
			}
		}
	}
	public void ascender(Empleado empleado) {
		Ejecutivo ejec=new Ejecutivo(empleado.getNombre(), empleado.getSueldo(), empleado.getNumeroEmpleado());
		for (int i = 0; i < empleados.length; i++) {
			if(empleado.equals(empleados[i])) {
				empleados[i]=ejec;
			}
		}
		
		
	}
	
	
}
