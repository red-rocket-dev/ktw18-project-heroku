package pl.sda.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		System.out.println("Ala ma kota.");
		SpringApplication.run(ProjectApplication.class, args);
	}

}
