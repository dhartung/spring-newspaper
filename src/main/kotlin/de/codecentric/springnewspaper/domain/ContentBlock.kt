package de.codecentric.springnewspaper.domain

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes(
    JsonSubTypes.Type(Paragraph::class),
    JsonSubTypes.Type(Section::class),
    JsonSubTypes.Type(Box::class),
)
interface ContentBlock

data class Paragraph(val text: String) : ContentBlock

data class Section(val text: String) : ContentBlock

data class Box(val children: List<ContentBlock>) : ContentBlock
