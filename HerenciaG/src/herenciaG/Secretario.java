package herenciaG;

public class Secretario extends Empleado {
	private String despacho;
	private int telefEmpresa;

	public Secretario(String nombre, String apellido, String dni, String direccion, int telefono, double salario,int antiguedadS, String despacho,int telefEmpresa) {
		super(nombre, apellido, dni, direccion, telefono, telefEmpresa, salario);
		// TODO Auto-generated constructor stub
		
		this.despacho=despacho;
		this.telefEmpresa=telefEmpresa;
		this.incrementarSalario(5);
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

	public int getTelefEmpresa() {
		return telefEmpresa;
	}

	public void setTelefEmpresa(int telefEmpresa) {
		this.telefEmpresa = telefEmpresa;
	}
	

	@Override
	public String toString() {
		return super.toString()+ " despacho" + despacho + ", telefEmpresa=" + telefEmpresa ;
	}
	
	

}
