package de.codecentric.springnewspaper.service;

import de.codecentric.springnewspaper.domain.Newspaper;
import de.codecentric.springnewspaper.gateway.NewspaperGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.NoSuchElementException;

@Component
public class NewspaperService {
    private final NewspaperGateway newspaperGateway;

    public NewspaperService(@Autowired NewspaperGateway newspaperGateway) {
        this.newspaperGateway = newspaperGateway;
    }

    public Newspaper getNewspaperById(Integer id) {
        Newspaper newspaper = newspaperGateway.get(id);

        if (newspaper.getPublicationDate().isAfter(Instant.now())) {
            throw new NoSuchElementException("Newspaper is not yet published.");
        }

        return newspaper;
    }
}
