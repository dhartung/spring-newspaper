package de.codecentric.springnewspaper.controller;

import de.codecentric.springnewspaper.domain.Newspaper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class NewspaperControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    void canRetrieveDefaultNewspaper() {
        Newspaper actual = webClient.post()
                .uri("/newspaper/1")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Newspaper.class)
                .returnResult()
                .getResponseBody();

        assert actual != null;
        Assertions.assertThat(actual.getName()).isEqualTo("Softwerker");
        Assertions.assertThat(actual.getArticles()).hasSize(3);
    }
}
