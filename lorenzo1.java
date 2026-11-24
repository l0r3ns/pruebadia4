package martinez;
/*
 * Lorenzo Martínez Abelleira
 * 29/10/2026
 * Creaccion de un programa que calcule el valor de la compra aplicando descuentos e impuesots
 */
import java.util.Scanner;

public class lorenzo1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Hola, cual es tu nombre?");
		String nombre = teclado.nextLine();
		System.out.println("Si eres Vip escribe V, si eres frecuente pulsa F y si eres nuevo pulsa N");
		String tipoCliente="";
		final String Vip = "V";
		final String Frecuente = "F";
		final String Nuevo = "N";
		boolean interruptor=false;
		while(interruptor==false) {
			tipoCliente=teclado.nextLine();
			if(tipoCliente.equalsIgnoreCase(Vip) || tipoCliente.equalsIgnoreCase(Frecuente) || tipoCliente.equalsIgnoreCase(Nuevo) ) {
				interruptor=true;
			}else {
				System.out.println("No has indicado que tipo de cliente eres");
			}
		}
		interruptor=false;
		boolean socio=false;
		System.out.println("Es usted socio?, pulse 1 para si y pulse 0 para no");
		int eleccion = teclado.nextInt();
		while(interruptor==false) {
			if(eleccion==1) {
				socio=true;
				interruptor=true;
			}else if(eleccion==0) {
				socio=false;
				interruptor=true;
			}else {
				System.out.println("NO estas respondiendo bien");
				eleccion = teclado.nextInt();
			}
		}
		
		System.out.println("Cuantas unidades has comprado");
		int unidades = teclado.nextInt();
	
		System.out.println("Cual es el precio del producto");
		double precio = teclado.nextDouble();
		
		
		System.out.println("De cuanto es tu iva 4%, 10%, 21% (para responder solo pon el numero)");
		int iva = teclado.nextInt();
		interruptor=false;
		while(interruptor==false) {
			if(iva== 4 || iva == 10 || iva==21) {
				interruptor=true;
			}else {
				System.out.println("NO estas respondiendo bien");
				iva = teclado.nextInt();
			}
		}
		double subtotal =(double) unidades*precio;
		double impuestos = 0,descuento =0;
		if (unidades>10) {
			descuento+=0.05; 
		}
		
		if(socio==true) {
			descuento+=0.1; 
		}
		if(tipoCliente.equalsIgnoreCase(Vip)) {
			descuento+=0.05;
		}else if(tipoCliente.equalsIgnoreCase(Frecuente)) {
			descuento+=0.03;
		}else if(tipoCliente.equalsIgnoreCase(Nuevo)) {
			descuento+=0.02;
		}
		
		if(iva== 4) {
			impuestos=0.04;
		}else if(iva== 10) {
			impuestos=0.1;
		}else if(iva== 21) {
			impuestos=0.21;
		}
		double subtotalfinal=subtotal-(subtotal*descuento)+(subtotal*impuestos);
		
		if(subtotalfinal<50) {
			subtotalfinal+=5;
		}
		System.out.println("----Factura de compra----");
		if(socio==true) {
			System.out.println("Cliente: "+nombre+" socio");
		}else {
			System.out.println("Cliente: "+nombre);
		}
		
		if(tipoCliente.equalsIgnoreCase(Vip)) {
			System.out.println("Categoria: "+Vip);
		}else if(tipoCliente.equalsIgnoreCase(Frecuente)) {
			System.out.println("Categoria: "+Frecuente);
		}else if(tipoCliente.equalsIgnoreCase(Nuevo)) {
			System.out.println("Categoria: "+Nuevo);
		}
		System.out.println("----------------");
		System.out.println("Cantidad de productos: "+unidades);
		System.out.println("Precio unitario: "+precio+" $");
		System.out.println("Subtotal sin descuento: "+subtotal+" $");
		System.out.println("Descuentos: "+(subtotal*descuento)+" $");
		System.out.println("Subtotal con descuento: "+(subtotal-(subtotal*descuento))+" $");
		System.out.println("Impuestos("+iva+"%): "+(subtotal*impuestos)+" $");
		System.out.println("----------------");
		System.out.println("----------------");
		System.out.println("Total a pagar: "+subtotalfinal+" $");
		System.out.println("----------------");
		System.out.println("Gracias por su compra");
		
	}

}
