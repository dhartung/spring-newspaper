package de.codecentric.springnewspaper.domain

data class Article(
    val title: String,
    val author: String?,
    val content: List<ContentBlock>,
)
