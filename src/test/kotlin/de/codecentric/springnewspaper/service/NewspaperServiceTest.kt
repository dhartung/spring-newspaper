package de.codecentric.springnewspaper.service

import de.codecentric.springnewspaper.domain.Newspaper
import de.codecentric.springnewspaper.gateway.NewspaperGateway
import io.mockk.every
import io.mockk.mockk
import java.time.Instant
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class NewspaperServiceTest {
    private val newspaperGateway = mockk<NewspaperGateway>()
    private val newspaperService = NewspaperService(newspaperGateway)

    @Test
    fun `should forward correct id to newspaper service`() {
        val stub = Newspaper(
            id = 42,
            name = "Hello World",
            publicationDate = Instant.parse("2020-12-24T18:00:00Z"),
            articles = listOf()
        )
        every { newspaperGateway.get(42) } returns stub

        Assertions.assertThat(newspaperService.getNewspaperById(42))
            .usingRecursiveComparison()
            .isEqualTo(stub)
    }

    @Test
    fun `should throw exception when article is published in future`() {
        val stub = Newspaper(
            id = 43,
            name = "Hello World",
            publicationDate = Instant.now().plusSeconds(60L),
            articles = listOf()
        )
        every { newspaperGateway.get(43) } returns stub

        Assertions.assertThatThrownBy { newspaperService.getNewspaperById(43) }
            .isInstanceOf(NoSuchElementException::class.java)
    }
}
