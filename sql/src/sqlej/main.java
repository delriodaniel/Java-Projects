package sqlej;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import sqlej.Cuenta;
import sqlej.Titular;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = null;
		Scanner sc = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		try {

			final String url = "jdbc:mysql://localhost:3306/";
			final String dbName = "cuentas";
			final String driver = "com.mysql.cj.jdbc.Driver";
			final String userName = "root";
			final String password = "931996";

			c = DriverManager.getConnection(url + dbName, userName, password);

			boolean cerrar = false;
			int opcion;

			System.out.println(
					"1. Crear cuenta. \n2. Eliminar cuenta. \n3. Añadir titular. \n4. Consultar saldo. \n5. Ingresar dinero. \n6. Sacar dinero.");
			opcion = sc.nextInt();
			while (true) {
				switch (opcion) {
				case 1:
					
					System.out.println("introduce dni: ");
					///////////////////////////////////
					String dni = scStr.nextLine();

					Titular tit = consultaTitular(c, dni);

					if (tit == null) {
						System.out.println("DNI no encontrado");
						break;
					}

					System.out.println("elegir moneda: \n1. EURO. \n2. DOLAR. \n3. LIBRA. \n4. YEN. \n5. PESO MEXICANO.");
					int opMoneda = sc.nextInt();
					Moneda mon = null;

					switch (opMoneda) {
					case 1:
						mon = consultarMoneda(c, "EU");
						break;

					case 2:
						mon = consultarMoneda(c, "UDS");
						break;
					case 3:
						mon = consultarMoneda(c, "LIB");
						break;
					case 4:
						mon = consultarMoneda(c, "YEN");
						break;
					case 5:
						mon = consultarMoneda(c, "PES");
						break;
					default:
						break;
					}
					System.out.println("Introducir Saldo de la cuenta: ");
					double saldo = 56985.99;

					Date fechaCreacion = new Date();

					Cuenta cuenta = new Cuenta(generarNumCuenta(), saldo, mon, fechaCreacion, tit);
					crearCuenta(c, cuenta);
					System.exit(0);
					break;
				case 2:
					System.out.println("introduce el numero de cuenta y el dni del titular \n");
					System.out.println("numero de cuenta: ");
					String nCuenta = "ES73 5184 9365 4208 2387 0773";
					System.out.println("DNI: ");
					String titular = "27297443F";
					eliminarCuenta(c, nCuenta, titular);
					break;
				case 3:
					System.out.println("DNI: ");
					String titDni = "27297443F";
					System.out.println("nombre: ");
					String nombre = "Peter";
					System.out.println("apellidos: ");
					String apellidos = "Mendez Gonzalez";
					System.out.println("fecha de nacimiento: ");
					Date fechaN = new Date(1978 - 06 - 25);
					Titular titu = new Titular(titDni, nombre, apellidos, fechaN);
					annadirTitular(c, titu);

					break;
				case 4:
					System.out.println("introduce el numero de cuenta y el dni del titular \n");
					System.out.println("numero de cuenta: ");
					String nuCuenta = "ES97 2178 4374 5628 7548 8420";
					System.out.println("DNI: ");
					String titul = "58838241T";
					consultarSaldo(c, nuCuenta, titul);

					break;
				case 5:
					System.out.println("introduce el numero de cuenta y el dni del titular \n");
					System.out.println("numero de cuenta: ");
					String numerCuenta = "ES97 2178 4374 5628 7548 8420";
					System.out.println("DNI: ");
					String tiDNI = "58838241T";
					System.out.println("dinero a ingresar: ");
					Double din=2456.03;
					ingresarDinero(c, numerCuenta, tiDNI, din);
					break;
				case 6:
					System.out.println("introduce el numero de cuenta y el dni del titular \n");
					System.out.println("numero de cuenta: ");
					String numeroCuenta = "ES97 2178 4374 5628 7548 8420";
					System.out.println("DNI: ");
					String tDNI = "58838241T";
					System.out.println("dinero a retirar: ");
					Double dinero=240.00;
					ingresarDinero(c, numeroCuenta, tDNI, dinero);
					break;

				default:
					System.out.println("opcion incorrecta");
					break;
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			try {
				if (c != null) {
					c.close();
				}

			} catch (Exception ex) {
			}
		}
	}

	public static String generarNumCuenta() {
		String num = "ES";
		Random ran = new Random();
		int n = ran.nextInt(100);
		if (n < 10) {
			num += "0" + n + " ";
		} else {
			num += n + " ";
		}

		for (int i = 0; i < 5; i++) {
			String nAl = numerosAleatorios();
			num += nAl + " ";
		}

		return num;

	}

	public static String numerosAleatorios() {
		String var;
		Random ran = new Random();
		int n = ran.nextInt(10000);
		if (n < 10) {
			var = "000" + n;
		} else if (n < 100) {
			var = "00" + n;
		} else if (n < 1000) {
			var = "0" + n;
		} else {
			var = "" + n;
		}

		return var;
	}

	public static Titular consultaTitular(Connection c, String dni) {
		Scanner sc = new Scanner(System.in);

		String query = "SELECT * FROM titular WHERE dni_titular = \'" + dni + "\'";
		Statement st;
		Titular titular = null;
		try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				titular = new Titular(rs.getString("dni_titular"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getDate("fechaNacimiento"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();

		return titular;
	}

	public static Moneda consultarMoneda(Connection c, String cod) {
		Scanner sc = new Scanner(System.in);
		String query = "SELECT * FROM moneda WHERE codMoneda=\'" + cod + "\'";
		Statement st;
		Moneda moneda = null;
		try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				moneda = new Moneda(rs.getString("codMoneda"), rs.getString("nombre"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();

		return moneda;

	}

	public static void crearCuenta(Connection c, Cuenta cuenta) {
		try {
			String query = "INSERT INTO cuenta VALUES (?,?,?,?,?)";
			PreparedStatement prep = c.prepareStatement(query);
			prep.setString(1, cuenta.getNumeroCuenta());
			prep.setDouble(2, cuenta.getSaldo());
			prep.setString(3, cuenta.getMoneda().getCodMoneda());
			prep.setDate(4, new java.sql.Date(cuenta.getFechaCreacion().getTime()));
			prep.setString(5, cuenta.getTitular().getDni());
			prep.executeUpdate();
			prep.close();

			System.out.println("Cuenta creada correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void eliminarCuenta(Connection c, String numeroC, String tit) {
		try {
			String query = "DELETE FROM cuenta WHERE (numCuenta = \'" + numeroC + "\') AND (titular = \'" + tit + "\')";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Cuenta eliminada ");
		} catch (SQLException e) {
			System.out.println("No se ha borrado correctamente ");
		}
	} 

	public static void annadirTitular(Connection c, Titular titular) {
		try {
			String query = "INSERT INTO titular VALUES (?,?,?,?)";
			PreparedStatement prep = c.prepareStatement(query);
			prep.setString(1, titular.getDni());
			prep.setString(2, titular.getNombre());
			prep.setString(3, titular.getApellidos());
			prep.setDate(4, new java.sql.Date(titular.getFechaNacimiento().getTime()));
			prep.executeUpdate();
			prep.close();
			System.out.println("Se ha annadido el titular ");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("no se ha podido annadir el titular ");
		}
	}

	public static Double consultarSaldo(Connection c, String numeroC, String tit) {
		String query = "SELECT saldo FROM cuenta WHERE (numCuenta = \'" + numeroC + "\') AND (titular = \'" + tit
				+ "\')";
		Statement st;
		Double saldo = 0d;
		try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery(query);

			saldo = (rs.getDouble("saldo"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return saldo;

	}

	public static void ingresarDinero(Connection c, String numeroC, String tit, Double dinero) {
		String query = "SELECT saldo FROM cuenta WHERE (numCuenta = \'" + numeroC + "\') AND (titular = \'" + tit
				+ "\')";
		Statement st;
		Double saldo = 0d;
		try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery(query);

			saldo = (rs.getDouble("saldo"));
			saldo += dinero;

			String query2 = "UPDATE INTO cuenta SET saldo = ?  WHERE (numCuenta= ?) AND (titular=?)";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setDouble(1, saldo);
			pst.setString(2, numeroC);
			pst.setString(3, tit);
			pst.executeUpdate();
			pst.close();
			System.out.println("cuenta actualizada correctamente");
		} catch (Exception e) {
			System.out.println("Error con la actualización");
		}
	}

	public static void sacarDinero(Connection c, String numeroC, String tit, Double dinero) {
		String query = "SELECT saldo FROM cuenta WHERE (numCuenta = \'" + numeroC + "\') AND (titular = \'" + tit
				+ "\')";
		Statement st;
		Double saldo = 0d;
		try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery(query);

			saldo = (rs.getDouble("saldo"));
			if(saldo>dinero) {
				saldo -= dinero;
			}
			

			String query2 = "UPDATE INTO cuenta SET saldo = ?  WHERE (numCuenta= ?) AND (titular=?)";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setDouble(1, saldo);
			pst.setString(2, numeroC);
			pst.setString(3, tit);
			pst.executeUpdate();
			pst.close();
			System.out.println("cuenta actualizada correctamente");
		} catch (Exception e) {
			System.out.println("Error con la actualización");
		}
	}

}
