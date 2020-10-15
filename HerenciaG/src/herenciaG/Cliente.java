package herenciaG;

import java.util.Comparator;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private String sector;
	private String direccion;
	private int telefono;
	public Cliente(String dni, String nombre, String apellidos, int edad, String sector, String direccion,
			int telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.sector = sector;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Cliente dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", sector=" + sector + ", direccion=" + direccion + ", telefono=" + telefono + "";
	}



}
