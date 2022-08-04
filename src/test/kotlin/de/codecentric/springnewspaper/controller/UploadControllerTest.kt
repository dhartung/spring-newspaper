package de.codecentric.springnewspaper.controller

import de.codecentric.springnewspaper.domain.Newspaper
import de.codecentric.springnewspaper.gateway.NewspaperGateway
import java.time.Instant
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
internal class UploadControllerTest(
    @Autowired private val webClient: WebTestClient,
    @Autowired private val newspaperGateway: NewspaperGateway,
) {
    @Test
    fun `uploaded newspaper should be stored in gateway`() {
        val newspaper = Newspaper(
            id = 90,
            name = "SZ",
            publicationDate = Instant.now(),
            articles = listOf()
        )

        val response = webClient.post()
            .uri("/upload")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(newspaper)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .exchange()
            .expectStatus()
            .isOk
            .expectBody<Newspaper>()
            .returnResult()
            .responseBody

        Assertions.assertThat(response)
            .usingRecursiveComparison()
            .isEqualTo(newspaper)

        Assertions.assertThat(newspaperGateway.get(90))
            .usingRecursiveComparison()
            .isEqualTo(newspaper)
    }
}
