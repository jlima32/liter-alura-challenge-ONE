package br.com.site.literalurachallengeONE.repository;

import br.com.site.literalurachallengeONE.model.Autor;
import br.com.site.literalurachallengeONE.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNome(String autor);

    @Query("SELECT l FROM Autor a JOIN a.livros l WHERE a.nome ILIKE %:nome%")
    List<Livro> livroPorAutor(String nome);

    List<Autor> findAllByOrderByNome();

    @Query("SELECT autor FROM Autor autor WHERE autor.anoFalecimento >= :ano ORDER BY autor.anoFalecimento")
    List<Autor> listarAutoresAno(int ano);
}
