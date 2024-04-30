package br.com.site.literalurachallengeONE.repository;

import br.com.site.literalurachallengeONE.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
