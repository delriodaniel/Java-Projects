package banco;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder db = documentbuilderfactory.newDocumentBuilder();
			Document doc = db.parse(new File("cuentas.xml"));
			Element rootElement = doc.getDocumentElement();
			

			int opcion;
			Scanner sc = new Scanner(System.in);

			System.out.println(
					"1. Crear cuenta. \n2. Eliminar cuenta. \n3. Añadir titular. \n4. Consultar saldo. \n5. Ingresar dinero. \n6. Sacar dinero.");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				Scanner sc2= new Scanner(System.in);
				
				System.out.println(fechaAleatoria());
				System.out.println("¿cuantos titulares son?");
				int cantidad=sc.nextInt();
				
				Titular clientes[]= new Titular[cantidad];
				for (int i = 0; i < clientes.length; i++) {
					System.out.println("Nombre completo: ");
					String nombreCompleto=sc2.nextLine();
					
					System.out.println("DNI: ");
					String dni=sc2.nextLine();
					
					Titular titular = new Titular(nombreCompleto, dni);
					clientes[i]=titular;					
				}
				System.out.println("introduce saldo con simbolo de divisa: ");
				String saldo = sc2.nextLine();
				
				Cuentas cuenta=new Cuentas(generarNumCuenta(), clientes, fechaAleatoria(), saldo);
				
			
				
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;

			default:
				System.out.println("opcion incorrecta");
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
	
	public static String generarNumCuenta() {
		String num = "ES";
		Random ran = new Random();
		int n = ran.nextInt(100);
		if(n<10) {
			num+="0"+n+" ";
		}else {
			num+=n+" ";
		}
		
		for (int i = 0; i < 5; i++) {
			String nAl=numerosAleatorios();
			num+=nAl+" ";
		}
		

		return num;

	}

	public static String numerosAleatorios() {
		String var;
		Random ran = new Random();
		int n = ran.nextInt(10000);
		if (n < 10) {
			var="000"+n;
		}else if (n<100) {
			var="00"+n;
		}else if(n<1000){
			var="0"+n;
		}else {
			var=""+n;
		}
	

		return var;
	}
	
	public static String fechaAleatoria() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date hoy = new Date();
			Date inicio = sdf.parse("01/01/1900");

			ThreadLocalRandom r =ThreadLocalRandom.current();
			Date rnd = new Date(r.nextLong(inicio.getTime(), hoy.getTime()));
			return sdf.format(rnd);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	public static void introXml(Document doc ,Element rootElement,Cuentas cuenta) {
		Element nuevaCuenta= doc.createElement("cuenta");
		nuevaCuenta.setAttribute("numCuenta", cuenta.getNumeroCuenta());
		rootElement.appendChild(nuevaCuenta);
		
		for (int i = 0; i < cuenta.getTitulares().length; i++) {
			Element nuevoTitular= doc.createElement("titular");
			nuevaCuenta.setAttribute("dni",  );
		}
		
	}

}
