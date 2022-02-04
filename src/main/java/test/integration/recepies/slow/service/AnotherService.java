package test.integration.recepies.slow.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.integration.recepies.slow.entity.AnotherSimpleEntity;
import test.integration.recepies.slow.repository.AnotherSimpleEntityRepository;
import test.integration.recepies.testinaction.entity.SimpleEntity;
import test.integration.recepies.testinaction.repository.SimpleEntityRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AnotherService {

    AnotherSimpleEntityRepository repository;


    @Transactional
    public List<AnotherSimpleEntity> searchCats() {
        repository.clear();
        AnotherSimpleEntity test = new AnotherSimpleEntity("dog");
        repository.save(test);
        return repository.search("dogs");
    }

}
