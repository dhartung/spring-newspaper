package de.codecentric.springnewspaper.controller

import de.codecentric.springnewspaper.domain.Newspaper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
internal class NewspaperControllerTest(@Autowired private val webClient: WebTestClient) {
    @Test
    fun `can retrieve default newspaper`() {
        val response = webClient.post()
            .uri("/newspaper/1")
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .exchange()
            .expectStatus()
            .isOk
            .expectBody<Newspaper>()
            .returnResult()
            .responseBody

        Assertions.assertThat(response?.name)
            .isEqualTo("Softwerker")

        Assertions.assertThat(response?.articles)
            .hasSize(3)
    }
}
