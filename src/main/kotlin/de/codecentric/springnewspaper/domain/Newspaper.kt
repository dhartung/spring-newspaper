package de.codecentric.springnewspaper.domain

import java.time.Instant

data class Newspaper(
    val id: Int,
    val name: String,
    val publicationDate: Instant,
    val articles: List<Article>,
)
