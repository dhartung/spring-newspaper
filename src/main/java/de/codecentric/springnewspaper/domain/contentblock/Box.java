package de.codecentric.springnewspaper.domain.contentblock;

import de.codecentric.springnewspaper.domain.ContentBlock;

import java.util.List;
import java.util.Objects;

public class Box implements ContentBlock {
    private List<ContentBlock> children;

    public Box(List<ContentBlock> children) {
        this.children = children;
    }

    public List<ContentBlock> getChildren() {
        return children;
    }

    public Box() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Objects.equals(children, box.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children);
    }
}
