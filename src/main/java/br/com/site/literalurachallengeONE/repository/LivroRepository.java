package br.com.site.literalurachallengeONE.repository;

import br.com.site.literalurachallengeONE.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findAllByOrderByTitulo();
}
