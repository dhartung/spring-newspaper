package de.codecentric.springnewspaper.controller;

import de.codecentric.springnewspaper.domain.Newspaper;
import de.codecentric.springnewspaper.gateway.NewspaperGateway;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Instant;
import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class UploadControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Autowired
    private NewspaperGateway newspaperGateway;

    @Test
    void uploadedNewspaperShouldBeStoredInGateway() {
        Newspaper newspaper = new Newspaper(
                90,
                "SZ",
                Instant.now(),
                Collections.emptyList()
        );

        Newspaper response = webClient.post()
                .uri("/upload")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(newspaper)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Newspaper.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(newspaper);

        Assertions.assertThat(newspaperGateway.get(90))
                .usingRecursiveComparison()
                .isEqualTo(newspaper);
    }
}
