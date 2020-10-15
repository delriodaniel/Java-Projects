package herenciaG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		Scanner scString2 = new Scanner(System.in);
		ArrayList<Empleado> alEmpleado = new ArrayList<>();
		ArrayList<Vendedor> alVendedores = new ArrayList<>();
		ArrayList<Coche> alCoches = new ArrayList<>();
		Metodo metodo = new Metodo();
		Coche coche;
		Cliente cliente;
		Empleado empleado;
		JefeZona jefe;
		Vendedor vendedor;
		System.out.println(
				"Elige opcion: \n1- Gestion de empleados\n2- Gestion de clientes\n3- Gestion de vendedores y secretarios\n4- salir");
		int opcion = sc.nextInt();
		do {
			switch (opcion) {
			case 1:
				System.out.println(
						"1- a- Dar alta a un Secretario\n1- b- Dar alta a un Jefe de zona\n1- c- Dar baja a un Secretario\n1- d- Dar baja a un Jefe de zona\n1- e- Dar alta un Coche\n1- f- Dar baja un Coche");
				String opSub = scString.nextLine();
				switch (opSub) {
				case "a":
					System.out.println("Dni del empleado: ");
					String dniS = scString.nextLine();

					System.out.println("Nombre del empleado: ");
					String nombreS = scString.nextLine();

					System.out.println("Apellidos del empleado: ");
					String apellidosS = scString.nextLine();

					System.out.println("Direccion del empleado: ");
					String direccionS = scString.nextLine();

					System.out.println("Años de antigüedad del empleado: ");
					int antiguedadS = sc.nextInt();

					System.out.println("Telefono de contacto: ");
					int telefonoS = sc.nextInt();

					System.out.println("Salario anual: ");
					double salarioS = sc.nextDouble();

					System.out.println("Numero de despacho: ");
					String despachoS = scString.nextLine();

					System.out.println("Telefono de empleado: ");
					int telefonoEmpleadoS = sc.nextInt();

					empleado = new Secretario(nombreS, apellidosS, dniS, direccionS, antiguedadS, salarioS, telefonoS,
							despachoS, telefonoEmpleadoS);

					alEmpleado = metodo.altaSecretario(alEmpleado, empleado);
					System.out.println("se ha creado el " + empleado.toString());

					break;
				case "b":
					if (metodo.existeSecretario(alEmpleado) == true) {
						System.out.println("Dni del empleado: ");
						String dniJ = scString2.nextLine();

						System.out.println("Nombre del empleado: ");
						String nombreJ = scString2.nextLine();

						System.out.println("Apellidos del empleado: ");
						String apellidosJ = scString2.nextLine();

						System.out.println("Direccion del empleado: ");
						String direccionJ = scString2.nextLine();

						System.out.println("Años de antigüedad del empleado: ");
						int antiguedadJ = sc.nextInt();

						System.out.println("Telefono de contacto: ");
						int telefonoJ = sc.nextInt();

						System.out.println("Salario anual: ");
						double salarioJ = sc.nextDouble();

						System.out.println("Numero de despacho: ");
						String despachoJ = scString2.nextLine();

						System.out.println("Quien es su Secretario? ");
						for (int i = 0; i < alEmpleado.size(); i++) {
							if (alEmpleado.get(i) instanceof Secretario) {
								System.out.print(i + " - " + alEmpleado.get(i).toString());

							}
						}
						int x = sc.nextInt();

						System.out.println("Coche asignado: ");
						System.out.println("Matricula: ");
						String matriculaJ = scString.nextLine();

						System.out.println("Marca: ");
						String marcaJ = scString.nextLine();

						System.out.println("Modelo: ");
						String modeloJ = scString.nextLine();

						coche = new Coche(matriculaJ, marcaJ, modeloJ);

						empleado = new JefeZona(nombreJ, apellidosJ, dniJ, direccionJ, antiguedadJ, telefonoJ, salarioJ,
								despachoJ, (Secretario) alEmpleado.get(x), alVendedores, coche);

						alEmpleado = metodo.altaJefeZona(alEmpleado, empleado);
						System.out.println("se ha creado el " + empleado.toString());

					}

					break;
				case "c":
					System.out.println("Que secretario vas a dar de baja: ");
					for (int i = 0; i < alEmpleado.size(); i++) {
						System.out.println(i + " - " + alEmpleado.get(i).toString());
					}
					int n = sc.nextInt();
					empleado = alEmpleado.get(n);
					alEmpleado = metodo.darBajaSecretario(alEmpleado, empleado);
					System.out.println("se ha dado de baja a " + empleado.toString());

					break;
				case "d":
					System.out.println("Que jefe de zona vas a dar de baja: ");
					for (int i = 0; i < alEmpleado.size(); i++) {
						System.out.println(i + " - " + alEmpleado.get(i).toString());
					}
					int j = sc.nextInt();
					empleado = alEmpleado.get(j);
					alEmpleado = metodo.darBajaSecretario(alEmpleado, empleado);
					System.out.println("se ha dado de baja a " + empleado.toString());

					break;
				case "e":
					System.out.println("Dar alta coche ");
					System.out.println("Matricula: ");
					String matricula = scString.nextLine();

					System.out.println("Marca: ");
					String marca = scString.nextLine();

					System.out.println("Modelo: ");
					String modelo = scString.nextLine();

					coche = new Coche(matricula, marca, modelo);
					metodo.altaCoche(alCoches, coche);
					System.out.println("se ha creado el coche " + coche.toString());

					break;
				case "f":
					System.out.println("Que coche vas a dar de baja: ");
					for (int i = 0; i < alCoches.size(); i++) {
						System.out.println(i + " - " + alCoches.get(i).toString());
					}
					int op = sc.nextInt();
					coche = alCoches.get(op);
					alCoches = metodo.darBajaCoche(alCoches, coche);
					System.out.println("se ha dado de baja a " + coche.toString());

					break;

				default:
					break;
				}
				break;
			case 2:
				System.out.println("introduzca dni de vendedor: ");
				String dni = scString.nextLine();
				empleado = metodo.identificarVendedor(alVendedores, dni);
				System.out.println("has sido identificado como: " + empleado.toString());
				System.out.println("2- a- dar alta un Cliente \n2- b- dar baja un cliente");
				String opSub2 = scString.nextLine();
				switch (opSub2) {
				case "a":
					System.out.println("Dni: ");
					String dniCl = scString.nextLine();

					System.out.println("Nombre: ");
					String nombreCl = scString.nextLine();

					System.out.println("Apellidos: ");
					String apellidosCl = scString.nextLine();
					
					System.out.println("Edad: ");
					int edadCl = sc.nextInt();

					System.out.println("Sector: ");
					String sectorCl = scString.nextLine();

					System.out.println("Direccion: ");
					String direccionCl = scString.nextLine();
					
					System.out.println("telefono: ");
					int telefonoCl = sc.nextInt();
					
					cliente = new Cliente(dniCl, nombreCl, apellidosCl, edadCl, sectorCl, direccionCl, telefonoCl);
					for (Vendedor vend : alVendedores) {
						if(empleado.getDni().equals(vend.getDni())) {
							vend.darAltaCliente(cliente);
						}
					}
					break;
				case "b":
					System.out.println("dni del cliente: ");
					String dniCl2=scString.nextLine();
					for (Vendedor vend : alVendedores) {
						if(empleado.getDni().equals(vend.getDni())) {
							for (int i = 0; i < vend.getAlClientes().size(); i++) {
								if (vend.getAlClientes().get(i).getDni().equals(dniCl2)){
									cliente=vend.getAlClientes().get(i);
									vend.darBajaCliente(cliente);	
								}
							}
							
						}
					}
					
					break;
				}
				break;
			case 3:
				System.out.println("introduzca dni de Jefe de zona: ");
				String dni2 = scString.nextLine();
				empleado = metodo.identificarJefe(alEmpleado, dni2);
				System.out.println("has sido identificado como: " + empleado.toString());
				System.out.println("3- a- cambio de secretario \n3- b- alta de vendedor \n3- c- baja de vendedor \n3- d-cambio de coche");
				String op=scString.nextLine();
				switch (op) {
				case "a":
					System.out.println("Quien es su nuevo Secretario? ");
					for (int i = 0; i < alEmpleado.size(); i++) {
						if (alEmpleado.get(i) instanceof Secretario) {
							System.out.print(i + " - " + alEmpleado.get(i).toString());

						}
					}
					int x = sc.nextInt();
					jefe=(JefeZona) empleado;
					jefe.cambiarSecretario((Secretario) alEmpleado.get(x));

					break;
				case "b":
					System.out.println("Dni: ");
					String dniV = scString.nextLine();

					System.out.println("Nombre: ");
					String nombreV = scString.nextLine();

					System.out.println("Apellidos: ");
					String apellidoV = scString.nextLine();
					
					System.out.println("Telefono: ");
					int telefonoV = sc.nextInt();

					System.out.println("Salario: ");
					double salarioV = sc.nextDouble();

					System.out.println("Direccion: ");
					String direccionV = scString.nextLine();
					
					System.out.println("Area: ");
					String areaV = scString.nextLine();
					
					System.out.println("Movil: ");
					int movilV = sc.nextInt();
					
					System.out.println("Comision: ");
					int comisionV = sc.nextInt();
					
					
					ArrayList<Cliente> alClientes= new ArrayList<Cliente>();
					
					System.out.println("elige coche: ");
					for (int i = 0; i < alCoches.size(); i++) {
						System.out.println(i+" - "+alCoches.get(i).toString());
						
					}
					int opCoche=sc.nextInt();
					coche=alCoches.get(opCoche);
					vendedor = new Vendedor(nombreV, apellidoV, dniV, direccionV, telefonoV, salarioV, coche, movilV, areaV, alClientes, comisionV);
					System.out.println("se ha daado de alta a " + vendedor.toString());
					break;
				case "c":
					System.out.println("a quien das de baja: ");
					for (int i = 0; i < alVendedores.size(); i++) {
						System.out.println(i+" - "+alVendedores.get(i).toString());
					}
					int opVen=sc.nextInt();
					jefe=(JefeZona) empleado;
					jefe.darBajaVendedor(alVendedores.get(opVen));
					break;
				case "d":
					
					break;
					

				default:
					break;
				}
				
				
				break;

			default:
				break;
			}
			System.out.println(
					"Elige opcion: \n1- Gestion de empleados\n2- Gestion de clientes\n3- Gestion de vendedores y secretarios\n4- salir");
			opcion = sc.nextInt();
		} while (opcion != 4);
	}

}
