package de.codecentric.springnewspaper.controller;

import de.codecentric.springnewspaper.domain.Newspaper;
import de.codecentric.springnewspaper.service.NewspaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewspaperController {
    private final NewspaperService newspaperService;

    @Autowired
    public NewspaperController(NewspaperService newspaperService) {
        this.newspaperService = newspaperService;
    }

    @GetMapping("/newspaper/{id}")
    public Newspaper newspaper(@PathVariable Integer id) {
        return newspaperService.getNewspaperById(id);
    }
}
