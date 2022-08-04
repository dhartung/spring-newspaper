package de.codecentric.springnewspaper

import de.codecentric.springnewspaper.configuration.applicationMapper
import de.codecentric.springnewspaper.domain.Newspaper

object NewspaperStubs {
    val newspaper1 by lazy {
        applicationMapper().readValue(this.javaClass.getResource("/softwerker.json"), Newspaper::class.java)
    }
}