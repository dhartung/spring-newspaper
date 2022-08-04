package de.codecentric.springnewspaper.controller

import de.codecentric.springnewspaper.domain.Newspaper
import de.codecentric.springnewspaper.gateway.NewspaperGateway
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UploadController(val gateway: NewspaperGateway) {
    @PostMapping("/upload")
    fun uploadNewspaper(@RequestBody newspaper: Newspaper): Newspaper {
        gateway.put(newspaper)
        return newspaper
    }
}
