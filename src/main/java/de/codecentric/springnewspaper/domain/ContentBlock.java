package de.codecentric.springnewspaper.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.codecentric.springnewspaper.domain.contentblock.Box;
import de.codecentric.springnewspaper.domain.contentblock.Paragraph;
import de.codecentric.springnewspaper.domain.contentblock.Section;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({@JsonSubTypes.Type(Paragraph.class), @JsonSubTypes.Type(Section.class), @JsonSubTypes.Type(Box.class)})
public interface ContentBlock {
}
