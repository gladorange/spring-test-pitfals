package test.integration.recepies.testinaction.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.integration.recepies.testinaction.entity.SimpleEntity;
import test.integration.recepies.testinaction.repository.SimpleEntityRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleService {

    SimpleEntityRepository repository;


    @Transactional
    public List<SimpleEntity> searchCats() {
        repository.deleteAll();
        SimpleEntity test = new SimpleEntity("cat");
        repository.save(test);
        return repository.search("cats");
    }

}
