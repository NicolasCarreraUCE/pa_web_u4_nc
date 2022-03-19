package ec.edu.uce.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreamsParalelo {

	public static void main(String[] args) {
		
		long timepoInico = System.currentTimeMillis();
		
		List<Integer> lista = new ArrayList<>();
		for(int i = 0; i < 1000; i++) {
			lista.add(i);
		}
		List<String> listas = lista.parallelStream().map(numero -> convertirNumero(numero)).collect(Collectors.toList());
		listas.forEach(System.out::println);
		
		long timepoFin = System.currentTimeMillis();
		long timepo = (timepoFin - timepoInico) / 1000;
		System.out.println("Tiempo Total: " + timepo + " seg");
	}
	
	private static String convertirNumero(Integer numero) {
		System.out.println(Thread.currentThread().getName());
		try {
			TimeUnit.MICROSECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "N: " + numero.toString();
	}
}
