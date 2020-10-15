package herenciaG;

import java.util.ArrayList;
import java.util.Iterator;

public class Metodo {
	public ArrayList<Empleado> altaSecretario(ArrayList<Empleado> alEmpleado, Empleado empleado) {
		boolean existe = false;
		if (alEmpleado.isEmpty()) {
			existe = false;
		} else {
			for (Empleado emple : alEmpleado) {
				if (!emple.getDni().equalsIgnoreCase(empleado.getDni())) {
					existe = false;
				} else {
					existe = true;
				}
			}
		}

		if (existe == false) {
			alEmpleado.add(empleado);
		}

		return alEmpleado;
	}

	public boolean existeSecretario(ArrayList<Empleado> alEpleados) {
		if (alEpleados.isEmpty()) {
			return false;
		} else {
			for (Empleado empleado : alEpleados) {
				if (empleado instanceof Secretario) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public ArrayList<Empleado> darBajaSecretario(ArrayList<Empleado> alEmpleado, Empleado empleado) {
		Iterator it = alEmpleado.iterator();
		while (it.hasNext()) {
			if (((Empleado) it.next()).getDni().equals(empleado.getDni())) {
				it.remove();
			}
		}
		return alEmpleado;

	}

	public ArrayList<Empleado> altaJefeZona(ArrayList<Empleado> alEmpleado, Empleado empleado) {
		boolean existe = false;

		for (Empleado emple : alEmpleado) {
			if (!emple.getDni().equalsIgnoreCase(empleado.getDni())) {
				existe = false;
			} else {
				existe = true;
			}
		}

		if (existe == false)

		{
			alEmpleado.add(empleado);
		}

		return alEmpleado;

	}
	public boolean existeJefe(ArrayList<Empleado> alEpleados) {
		if (alEpleados.isEmpty()) {
			return false;
		} else {
			for (Empleado empleado : alEpleados) {
				if (empleado instanceof JefeZona) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	public ArrayList<Empleado> darBajaJefe(ArrayList<Empleado> alEmpleado, Empleado empleado) {
		Iterator it = alEmpleado.iterator();
		while (it.hasNext()) {
			if (((Empleado) it.next()).getDni().equals(empleado.getDni())) {
				it.remove();
			}
		}
		return alEmpleado;

	}
	public Empleado identificarJefe(ArrayList<Empleado> alEmpleados,String dni ) {
		Empleado e=null;
		for (Empleado empleado : alEmpleados) {
			if(empleado.getDni().equals(dni)) {
				e=empleado;
			}
		}
		return e;
	}
	

	public ArrayList<Coche> altaCoche(ArrayList<Coche> alCoche, Coche coche) {
		boolean existe = false;

		for (Coche coch : alCoche) {
			if (!coch.getMatricula().equalsIgnoreCase(coche.getMatricula())) {
				existe = false;
			} else {
				existe = true;
			}
		}

		if (existe == false)

		{
			alCoche.add(coche);
		}

		return alCoche;

	}
	
	public ArrayList<Coche> darBajaCoche(ArrayList<Coche> alCoches, Coche coche) {
		Iterator it = alCoches.iterator();
		while (it.hasNext()) {
			if (((Coche) it.next()).getMatricula().equals(coche.getMarca())) {
				it.remove();
			}
		}
		return alCoches;

	}
	
	
	public Vendedor identificarVendedor(ArrayList<Vendedor> alvendedores,String dni ) {
		Vendedor v=null;
		for (Vendedor vendedor : alvendedores) {
			if(vendedor.getDni().equals(dni)) {
				v=vendedor;
			}
		}
		return v;
	}
}
