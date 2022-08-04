package de.codecentric.springnewspaper.controller;

import de.codecentric.springnewspaper.domain.Newspaper;
import de.codecentric.springnewspaper.gateway.NewspaperGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UploadController {
    private final NewspaperGateway newspaperGateway;

    public UploadController(@Autowired NewspaperGateway newspaperGateway) {
        this.newspaperGateway = newspaperGateway;
    }

    @PostMapping("/upload")
    public Newspaper uploadNewspaper(@RequestBody Newspaper newspaper) {
        newspaperGateway.put(newspaper);
        return newspaper;
    }
}
