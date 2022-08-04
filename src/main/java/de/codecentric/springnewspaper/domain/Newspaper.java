package de.codecentric.springnewspaper.domain;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Newspaper {
    private Integer id;
    private String name;
    private Instant publicationDate;
    private List<Article> articles;

    public Newspaper() {
    }

    public Newspaper(Integer id, String name, Instant publicationDate, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.publicationDate = publicationDate;
        this.articles = articles;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getPublicationDate() {
        return publicationDate;
    }

    public List<Article> getArticles() {
        return articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(id, newspaper.id) && Objects.equals(name, newspaper.name) && Objects.equals(publicationDate, newspaper.publicationDate) && Objects.equals(articles, newspaper.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, publicationDate, articles);
    }
}
