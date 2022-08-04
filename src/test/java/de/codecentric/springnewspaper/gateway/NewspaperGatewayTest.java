package de.codecentric.springnewspaper.gateway;

import de.codecentric.springnewspaper.configuration.JacksonConfiguration;
import de.codecentric.springnewspaper.domain.Article;
import de.codecentric.springnewspaper.domain.Newspaper;
import de.codecentric.springnewspaper.domain.contentblock.Paragraph;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class NewspaperGatewayTest {
    private final NewspaperGateway newspaperGateway = new NewspaperGateway(JacksonConfiguration.applicationMapper());

    @Test
    void entryStoredToNewspaperGatewayCanBeRetrieved() {
        Newspaper newspaper = new Newspaper(
                9,
                "Softwerker",
                Instant.parse("2022-08-01T00:00:00Z"),
                List.of(
                        new Article(
                                "Loblied auf Pommes",
                                "Daniel",
                                List.of(
                                        new Paragraph("Pommes sind eine bemerkenswerte verarbeitung von Pommes. Dadurch ist es pratkisch Gemüse.")
                                )
                        )
                )
        );

        newspaperGateway.put(newspaper);

        Assertions.assertThat(newspaperGateway.get(9))
                .usingRecursiveComparison()
                .isEqualTo(newspaper);
    }

    @Test
    void exampleDataCanBeReadByGateway() throws IOException {
        newspaperGateway.readExamples();
        Assertions.assertThat(newspaperGateway.get(1).getArticles())
                .isNotEmpty();

        Assertions.assertThat(newspaperGateway.get(2).getArticles())
                .isNotEmpty();
    }
}
