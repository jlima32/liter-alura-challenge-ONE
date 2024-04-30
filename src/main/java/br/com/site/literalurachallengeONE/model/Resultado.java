package br.com.site.literalurachallengeONE.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resultado {
    @JsonAlias("title") private String titulo;
    @JsonAlias("languages") private List<String> idioma;
    @JsonAlias("authors") private List<Autor> autor;
    @JsonAlias("download_count") private int numeroDownloads;



    public String getTitulo() {
        return titulo;
    }


    public List<String> getIdioma() {
        return idioma;
    }


    public List<Autor> getAutor() {
        return autor;
    }


    public int getNumeroDownloads() {
        return numeroDownloads;
    }



    @Override
    public String toString() {
        return "Resultado{" +
                ", Título: '" + titulo + '\'' +
                ", Idioma: '" + idioma + '\'' +
                ", Autor: '" + autor + '\'' +
                ", Downloads: '" + numeroDownloads + '\'' +
                '}';
    }
}
