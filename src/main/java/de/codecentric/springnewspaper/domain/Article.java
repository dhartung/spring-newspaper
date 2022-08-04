package de.codecentric.springnewspaper.domain;

import java.util.List;
import java.util.Objects;

public class Article {
    private String title;
    private String author;
    private List<ContentBlock> content;

    public Article() {
    }

    public Article(String title, String author, List<ContentBlock> content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<ContentBlock> getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) && Objects.equals(author, article.author) && Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, content);
    }
}
