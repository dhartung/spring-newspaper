package de.codecentric.springnewspaper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringNewspaperApplication

fun main(args: Array<String>) {
    runApplication<SpringNewspaperApplication>(*args)
}
