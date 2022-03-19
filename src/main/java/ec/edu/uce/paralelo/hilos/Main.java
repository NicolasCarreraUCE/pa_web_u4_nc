package ec.edu.uce.paralelo.hilos;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long timepoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("Edison", Arrays.asList(1,2,3,4,5));
		Cajero cajero2 = new Cajero("Carlos", Arrays.asList(2,2,3,1));
		Cajero cajero3 = new Cajero("Paulo", Arrays.asList(1,1,3,2,4));

		GestorAtencion gestor1 = new GestorAtencion();
		GestorAtencion gestor2 = new GestorAtencion();
		GestorAtencion gestor3 = new GestorAtencion();
		
		gestor1.procesar(cajero1,timepoInicial);
		gestor2.procesar(cajero2,timepoInicial);
		gestor3.procesar(cajero3,timepoInicial);
		
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempoFinal - timepoInicial) / 1000;
		
		System.out.println(tiempoTranscurrido + " seg");
	}

}
