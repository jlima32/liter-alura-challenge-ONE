package br.com.site.literalurachallengeONE.repository;

import br.com.site.literalurachallengeONE.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findAllByOrderByTitulo();

    @Query("SELECT livro FROM Livro livro WHERE livro.idioma = :idioma ORDER BY livro.titulo")
    List<Livro> listarLivrosPorIdioma(String idioma);
}
