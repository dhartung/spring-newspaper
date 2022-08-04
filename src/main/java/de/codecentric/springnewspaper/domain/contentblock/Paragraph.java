package de.codecentric.springnewspaper.domain.contentblock;

import de.codecentric.springnewspaper.domain.ContentBlock;

import java.util.Objects;

public class Paragraph implements ContentBlock {
    private String text;

    public Paragraph() {
    }

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph = (Paragraph) o;
        return Objects.equals(text, paragraph.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
