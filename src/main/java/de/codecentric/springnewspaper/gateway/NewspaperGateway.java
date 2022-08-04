package de.codecentric.springnewspaper.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.codecentric.springnewspaper.domain.Newspaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Component
public class NewspaperGateway {
    private final ObjectMapper objectMapper;
    private final Map<Integer, Newspaper> data = new HashMap<>();

    public NewspaperGateway(@Autowired ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Newspaper get(Integer id) {
        Newspaper result = data.get(id);
        if (result == null) {
            throw new NoSuchElementException("Could not find newspaper with id " + id);
        }
        return result;
    }

    public void put(Newspaper newspaper) {
        data.put(newspaper.getId(), newspaper);
    }

    @PostConstruct
    public void readExamples() throws IOException {
        for (String x : Arrays.asList("/faz.json", "/softwerker.json")) {
            URL resource = this.getClass().getResource(x);
            put(objectMapper.readValue(resource, Newspaper.class));
        }
    }
}
