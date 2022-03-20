package ec.edu.uce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.service.IProcesamientoFacultadServi;

// Matriculacion
@SpringBootApplication
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
		long inicio = System.currentTimeMillis();
		
		Integer valor1 = this.procesamientoFacultadServi.calcularDeuda("123123", 4);
		Integer valor2 = this.procesamientoFacultadServi.calcularDeuda("234567", 4);
		Integer valor3 = this.procesamientoFacultadServi.calcularDeuda("123098", 4);
		Integer valor4 = this.procesamientoFacultadServi.calcularDeuda("098643", 4);
	
		LOG.info("Total: " + (valor1 + valor2 + valor3 + valor4));
	
		long tFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tFinal - inicio) / 1000;
		
		LOG.info(tiempoTranscurrido + " seg");
	
	}

}
