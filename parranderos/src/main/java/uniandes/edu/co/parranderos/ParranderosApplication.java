package uniandes.edu.co.parranderos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.parranderos.modelo.Bar;
import uniandes.edu.co.parranderos.repositorio.BarRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ParranderosApplication implements CommandLineRunner {

	@Autowired
    private BarRepository barRepository;
	public static void main(String[] args) {
		SpringApplication.run(ParranderosApplication.class, args);
	}

	@Override
    public void run(String... args) {
        Collection<Bar> bares = barRepository.darBares();
        for(Bar b: bares)
        {
            System.out.println(b);
        }
	}

}
