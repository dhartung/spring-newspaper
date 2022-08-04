package de.codecentric.springnewspaper.gateway

import de.codecentric.springnewspaper.configuration.applicationMapper
import de.codecentric.springnewspaper.domain.Article
import de.codecentric.springnewspaper.domain.Newspaper
import de.codecentric.springnewspaper.domain.Paragraph
import java.time.Instant
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class NewspaperGatewayTest {
    private val newspaperGateway = NewspaperGateway(applicationMapper())

    @Test
    fun `entry stored to newspaperGateway can be retrieved`() {
        val newspaper = Newspaper(
            id = 9,
            name = "Softwerker",
            publicationDate = Instant.parse("2022-08-01T00:00:00Z"),
            articles = listOf(
                Article(
                    title = "Loblied auf Pommes",
                    author = "Daniel",
                    content = listOf(
                        Paragraph(text = "Pommes sind eine bemerkenswerte verarbeitung von Pommes. Dadurch ist es pratkisch Gemüse.")
                    )
                )
            )
        )

        newspaperGateway.put(newspaper)

        Assertions.assertThat(newspaperGateway.get(9))
            .usingRecursiveComparison()
            .isEqualTo(newspaper)
    }

    @Test
    fun `example data can be read by gateway`() {
        newspaperGateway.readExamples()
        Assertions.assertThat(newspaperGateway.get(1).articles)
            .isNotEmpty

        Assertions.assertThat(newspaperGateway.get(2).articles)
            .isNotEmpty
    }
}
