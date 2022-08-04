package de.codecentric.springnewspaper.domain.contentblock;

import de.codecentric.springnewspaper.domain.ContentBlock;

import java.util.Objects;

public class Section implements ContentBlock {
    private String text;

    public Section(String text) {
        this.text = text;
    }

    public Section() {
    }

    public String getText() {
        return text;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(text, section.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
