package br.com.site.literalurachallengeONE.repository;

import br.com.site.literalurachallengeONE.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNome(String autor);
}
