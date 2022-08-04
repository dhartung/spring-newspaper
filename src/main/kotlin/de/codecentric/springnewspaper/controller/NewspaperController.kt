package de.codecentric.springnewspaper.controller

import de.codecentric.springnewspaper.domain.Newspaper
import de.codecentric.springnewspaper.service.NewspaperService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NewspaperController(val newspaperService: NewspaperService) {
    @PostMapping("/newspaper/{id}")
    fun newspaper(@PathVariable id: Int): Newspaper {
        return newspaperService.getNewspaperById(id)
    }
}
