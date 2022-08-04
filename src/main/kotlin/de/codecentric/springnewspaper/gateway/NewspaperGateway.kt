package de.codecentric.springnewspaper.gateway

import com.fasterxml.jackson.databind.ObjectMapper
import de.codecentric.springnewspaper.domain.Newspaper
import javax.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class NewspaperGateway(val objectMapper: ObjectMapper) {
    private val data = mutableMapOf<Int, Newspaper>()

    fun get(id: Int): Newspaper {
        return data[id] ?: throw NoSuchElementException("Could not find newspaper with id $id")
    }

    fun put(newspaper: Newspaper) {
        data[newspaper.id] = newspaper
    }

    @PostConstruct
    fun readExamples() {
        listOf("/faz.json", "/softwerker.json")
            .map { this.javaClass.getResource(it) }
            .forEach {
                put(objectMapper.readValue(it, Newspaper::class.java))
            }
    }
}
