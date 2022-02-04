package test.integration.recepies.testinaction.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.integration.recepies.testinaction.entity.SimpleEntity;
import test.integration.recepies.testinaction.repository.SimpleEntityRepository;
import test.integration.recepies.testinaction.service.SimpleService;

import java.util.List;

@AllArgsConstructor
@Component
public class SimpleController {
    SimpleService service;

    public List<SimpleEntity> searchCats() {
        return service.searchCats();
    }
}
