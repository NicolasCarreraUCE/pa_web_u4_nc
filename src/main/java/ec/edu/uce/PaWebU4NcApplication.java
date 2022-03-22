package ec.edu.uce;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import ec.edu.uce.service.IProcesamientoFacultadServi;

// Matriculacion
@SpringBootApplication
@EnableAsync
public class PaWebU4NcApplication implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(PaWebU4NcApplication.class);
	
	@Autowired
	private IProcesamientoFacultadServi procesamientoFacultadServi;
	
	public static void main(String[] args) {
		SpringApplication.run(PaWebU4NcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		long inicio = System.currentTimeMillis();
//		
//		// Procesamiento asincrono sin manejo de respuesto por hilo
////		Integer valor1 = this.procesamientoFacultadServi.calcularDeuda("123123", 4);
////		Integer valor2 = this.procesamientoFacultadServi.calcularDeuda("234567", 4);
////		Integer valor3 = this.procesamientoFacultadServi.calcularDeuda("123098", 4);
////		Integer valor4 = this.procesamientoFacultadServi.calcularDeuda("098643", 4);
//	
//		// Procesamiento asincrono con manejo de respuesto por hilo
//		CompletableFuture<Integer> valor1 = this.procesamientoFacultadServi.calcularDeudaFuture("123123", 4);
//		CompletableFuture<Integer> valor2 = this.procesamientoFacultadServi.calcularDeudaFuture("234567", 4);
//		CompletableFuture<Integer> valor3 = this.procesamientoFacultadServi.calcularDeudaFuture("123098", 4);
//		CompletableFuture<Integer> valor4 = this.procesamientoFacultadServi.calcularDeudaFuture("098643", 4);
//	
//		// Sentencia que espera que terminen de procesar todos los hijos
//		CompletableFuture.allOf(valor1, valor2, valor3, valor4).join();
//		
//		
//		LOG.info("Total: " + (valor1.get() + valor2.get() + valor3.get() + valor4.get()));
//	
//		long tFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (tFinal - inicio) / 1000;
//		
//		LOG.info(tiempoTranscurrido + " seg");
	
	}

}
