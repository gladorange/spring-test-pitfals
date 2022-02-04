package test.integration.recepies.slow.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.integration.recepies.slow.entity.AnotherSimpleEntity;
import test.integration.recepies.slow.service.AnotherService;

import java.util.List;

@AllArgsConstructor
@Component
public class AnotherController {
    AnotherService anotherService;

    public List<AnotherSimpleEntity> searchCats() {
        return anotherService.searchCats();
    }
}
