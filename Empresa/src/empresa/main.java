package empresa;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		ArrayList<Empresa> alEmpresas = new ArrayList<>();
		Empleado empleado;
		Empleado[] empleados;
		Empresa empresa;
		System.out.println("Selecciona opcion");

		System.out.println(
				"1. Crear empresa. \n2. Crear empleado. \n3. Despedir empleado \n4. Ascender empleado \n5. Aumentar sueldo \n6. Rankings");
		int opcion = sc.nextInt();
		do {

			switch (opcion) {
			case 1:
				System.out.println("indique el nombre de la empresa: ");
				String nombre = scString.nextLine();
				System.out.println("indique el tamaño de la empresa: ");
				int tamano = sc.nextInt();

				empresa = new Empresa(nombre, tamano);
				alEmpresas.add(empresa);
				System.out.println("Se ha creado la empresa: " + nombre + " con tamaño para " + tamano + " empleados");
				break;
			case 2:
				System.out.println("Nombre del empleado: ");
				String nombreEmpleado = scString.nextLine();
				System.out.println("Sueldo mensual: ");
				double sueldo = sc.nextDouble();

				empleado = new Empleado(nombreEmpleado, sueldo);

				System.out.println("indique en la empresa en la que trabaja: ");
				for (int i = 0; i < alEmpresas.size(); i++) {
					System.out.println((i + 1) + "- " + alEmpresas.get(i).getNombre());
				}
				int opcionEmpresa = sc.nextInt();
				alEmpresas.get(opcionEmpresa).nuevoEmpleado(empleado);
				System.out.println("se ha creado " + nombreEmpleado + " que trabaja en "
						+ alEmpresas.get(opcionEmpresa).getNombre() + " por un sueldo de " + sueldo);
				break;
			case 3:
				System.out.println("indique en la empresa en la que trabaja: ");
				for (int i = 0; i < alEmpresas.size(); i++) {
					System.out.println((i + 1) + "- " + alEmpresas.get(i).getNombre());
				}
				int opcionEmpresaDesp = sc.nextInt();
				System.out.println("¿Que empleado desea despedir? ");

				empresa = alEmpresas.get(opcionEmpresaDesp);
				empleados = empresa.getEmpleados();
				empresa.muestraEmpleados();
				int opcionEmpleadoDes = sc.nextInt();
				System.out.println("Seguro que quiere despedir a " + empleados[opcionEmpleadoDes].toString()
						+ " ? \n1. Si \n2. No");
				int opcionBorrado = sc.nextInt();
				if (opcionBorrado == 1) {
					empresa.despideEmpleado(empleados[opcionEmpleadoDes]);
					System.out.println("Se ha despedido al trabajador");
				}

				break;
			case 4:
				System.out.println("indique en la empresa en la que trabaja: ");
				for (int i = 0; i < alEmpresas.size(); i++) {
					System.out.println((i + 1) + "- " + alEmpresas.get(i).getNombre());
				}
				int opcionEmpresaAsc = sc.nextInt();
				System.out.println("¿Que empleado desea ascender? ");

				empresa = alEmpresas.get(opcionEmpresaAsc);
				empleados = empresa.getEmpleados();
				empresa.muestraEmpleados();
				int opcionEmpleadoAsc = sc.nextInt();
				System.out.println("Seguro que quiere ascender a " + empleados[opcionEmpleadoAsc].toString()
						+ " ? \n1. Si \n2. No");
				int opcionAscenso = sc.nextInt();
				if(opcionAscenso==1) {
					System.out.println("indique su presupuesto: ");
					double presupuesto=sc.nextDouble();
					empresa.ascender(empleados[opcionEmpleadoAsc]);
					System.out.println("se ha ascendido a " +empleados[opcionEmpleadoAsc].toString());
				}

				break;
			case 5:
				System.out.println("indique en la empresa en la que trabaja: ");
				for (int i = 0; i < alEmpresas.size(); i++) {	
					System.out.println((i + 1) + "- " + alEmpresas.get(i).getNombre());
				}
				int opcionEmpresaAumentoSueldo = sc.nextInt();
				System.out.println("¿A que empleado desea aumentar el sueldo? ");

				empresa = alEmpresas.get(opcionEmpresaAumentoSueldo);
				empleados = empresa.getEmpleados();
				empresa.muestraEmpleados();
				int opcionEmpleadoAumentoSueldo = sc.nextInt();
				System.out.println("Que porcentaje quiere aumentarselo  ? ");
				int ascSueldo= sc.nextInt();
				empresa.aumentarSueldo(empleados[opcionEmpleadoAumentoSueldo], ascSueldo);
				System.out.println("se ha aumentado el sueldo en un "+ascSueldo+ " a "+empleados[opcionEmpleadoAumentoSueldo].toString());

				break;
			case 6:
				Metodos metodo= new Metodos();
				metodo.rankings(alEmpresas);
				
				break;

			default:
				break;
			}

			System.out.println("Selecciona opcion");

			System.out.println(
					"1. Crear empresa. \n2. Crear empleado. \n3. Despedir empleado \n4. Ascender empleado \n5. Aumentar sueldo \n6. Rankings");
			opcion = sc.nextInt();
		} while (opcion < 7);
		
	}

}
