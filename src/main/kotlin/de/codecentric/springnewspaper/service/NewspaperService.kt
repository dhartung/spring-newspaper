package de.codecentric.springnewspaper.service

import de.codecentric.springnewspaper.domain.Newspaper
import de.codecentric.springnewspaper.gateway.NewspaperGateway
import java.time.Instant
import org.springframework.stereotype.Component

@Component
class NewspaperService(val gateway: NewspaperGateway) {

    fun getNewspaperById(id: Int): Newspaper {
        val newspaper = gateway.get(id)

        // Forbid access to newspapers that will be published in the future
        if (newspaper.publicationDate > Instant.now()) {
            throw NoSuchElementException("Newspaper is not yet published.")
        }

        return newspaper
    }
}
