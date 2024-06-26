package br.com.site.literalurachallengeONE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    String titulo;
    String idioma;
    Integer numeroDownloads;

    @ManyToOne
    private Autor autor;

    public Livro() {
    }


    public Livro(Resultado resultado) {
        this.titulo = resultado.getTitulo();
        this.idioma = String.valueOf(resultado.getIdioma()).replace("[","").replace("]","");
        this.numeroDownloads = resultado.getNumeroDownloads();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", numeroDownloads=" + numeroDownloads +
                ", autor=" + autor +
                '}';
    }
}
