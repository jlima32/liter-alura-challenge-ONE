package br.com.site.literalurachallengeONE;

import br.com.site.literalurachallengeONE.principal.Principal;
import br.com.site.literalurachallengeONE.repository.AutorRepository;
import br.com.site.literalurachallengeONE.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraChallengeOneApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository repositorioLivro;
	@Autowired
	private AutorRepository repositorioAutor;

	public static void main(String[] args) {

		SpringApplication.run(LiterAluraChallengeOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorioLivro, repositorioAutor);
		principal.exibeMenu();
	}
}
