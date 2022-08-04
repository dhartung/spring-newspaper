package de.codecentric.springnewspaper;

import de.codecentric.springnewspaper.configuration.JacksonConfiguration;
import de.codecentric.springnewspaper.domain.Newspaper;

import java.io.IOException;

class NewspaperStubs {
    public static Newspaper getNewspaper1() throws IOException {
        return JacksonConfiguration.applicationMapper().readValue(
                NewspaperStubs.class.getResource("/softwerker.json"), Newspaper.class
        );
    }
}


