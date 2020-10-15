package empresa;

import java.util.ArrayList;

public class Metodos {
	public void rankings(ArrayList<Empresa> alEmpresas) {
		Empresa masEmpleados = null;
		Empresa menosEmpleados= null;
		Empleado empleadoMasSueldo= null;
		Empleado empleadoMenosSueldo= null;
		Ejecutivo ejecutivoMasPresupuesto= null;
		Ejecutivo ejecutivoMenosPresupuesto= null;
		
		for (Empresa empresa : alEmpresas) {
			if(masEmpleados.equals(null)) {
				masEmpleados=empresa;
			}else {
				if(masEmpleados.getTamano()<empresa.getTamano()) {
					masEmpleados=empresa;
				}
			}
			
		}
		System.out.println("empresa con mas empleados: "+masEmpleados.getTamano());
		
		for (Empresa empresa : alEmpresas) {
			if(menosEmpleados.equals(null)) {
				menosEmpleados=empresa;
			}else {
				if(menosEmpleados.getTamano()>empresa.getTamano()) {
					menosEmpleados=empresa;
				}
			}
			
		}
		System.out.println("empresa con menos empleados: "+menosEmpleados.getTamano());
		
		
		
		for (Empresa empresa : alEmpresas) {
			for (int i = 0; i < empresa.getEmpleados().length; i++) {
				if(empleadoMasSueldo.equals(null)) {
					empleadoMasSueldo=empresa.getEmpleados()[i];
				}else {
					if(empleadoMasSueldo.getSueldo()<empresa.getEmpleados()[i].getSueldo()) {
						empleadoMasSueldo=empresa.getEmpleados()[i];
					}
				}
				
			}
		}
		System.out.println("empleado con mas sueldo: "+empleadoMasSueldo.getSueldo());
		for (Empresa empresa : alEmpresas) {
			for (int i = 0; i < empresa.getEmpleados().length; i++) {
				if(empleadoMenosSueldo.equals(null)) {
					empleadoMenosSueldo=empresa.getEmpleados()[i];
				}else {
					if(empleadoMenosSueldo.getSueldo()>empresa.getEmpleados()[i].getSueldo()) {
						empleadoMenosSueldo=empresa.getEmpleados()[i];
					}
				}
				
			}
		}
		System.out.println("empleado con menos sueldo: "+empleadoMenosSueldo.getSueldo());
		
		
	}
	

}
