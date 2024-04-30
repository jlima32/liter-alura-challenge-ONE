package br.com.site.literalurachallengeONE;

import br.com.site.literalurachallengeONE.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraChallengeOneApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(LiterAluraChallengeOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
