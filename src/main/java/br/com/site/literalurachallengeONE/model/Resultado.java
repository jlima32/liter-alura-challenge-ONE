package br.com.site.literalurachallengeONE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resultado {
    private int id;
    private String title;
    private List<String> languages;
    private List<Autor> authors;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "id=" + id +
                ", Título: '" + title + '\'' +
                ", Idioma: '" + languages + '\'' +
                ", Autor: '" + authors + '\'' +
                '}';
    }
}
