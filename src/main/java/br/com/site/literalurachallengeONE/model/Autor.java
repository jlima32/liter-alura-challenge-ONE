package br.com.site.literalurachallengeONE.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonAlias("name") private String nome;
    @JsonAlias("birth_year") private int anoNascimento;
    @JsonAlias("death_year") private int anoFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(Autor autor) {
        this.nome = autor.getNome();
        this.anoNascimento = autor.getAnoNascimento();
        this.anoFalecimento = autor.getAnoFalecimento();

    }


    public String getNome() {
        return nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "name='" + nome + '\'' +
                ", birth_year=" + anoNascimento +
                ", death_year=" + anoFalecimento +

                '}';
    }
}
