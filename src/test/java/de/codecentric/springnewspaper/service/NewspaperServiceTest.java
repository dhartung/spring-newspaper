package de.codecentric.springnewspaper.service;

import de.codecentric.springnewspaper.domain.Newspaper;
import de.codecentric.springnewspaper.gateway.NewspaperGateway;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.Collections;
import java.util.NoSuchElementException;

public class NewspaperServiceTest {
    private final NewspaperGateway newspaperGateway = Mockito.mock(NewspaperGateway.class);
    private final NewspaperService newspaperService = new NewspaperService(newspaperGateway);

    @Test
    void shouldForwardCorrectIdToNewspaperService() {
        Newspaper stub = new Newspaper(
                42,
                "Hello World",
                Instant.parse("2020-12-24T18:00:00Z"),
                Collections.emptyList()
        );

        Mockito.when(newspaperGateway.get(42))
                .thenReturn(stub);

        Assertions.assertThat(newspaperService.getNewspaperById(42))
                .usingRecursiveComparison()
                .isEqualTo(stub);
    }

    @Test
    void shouldThrowExceptionWhenArticleIsPublishedInFuture() {
        Newspaper stub = new Newspaper(
                43,
                "Hello World",
                Instant.now().plusSeconds(60L),
                Collections.emptyList()
        );

        Mockito.when(newspaperGateway.get(43))
                .thenReturn(stub);

        Assertions.assertThatThrownBy(() -> newspaperService.getNewspaperById(43))
                .isInstanceOf(NoSuchElementException.class);
    }
}
