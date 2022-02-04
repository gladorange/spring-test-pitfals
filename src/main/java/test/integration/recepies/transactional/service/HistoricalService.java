package test.integration.recepies.transactional.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.integration.recepies.transactional.entity.HistoricalEntity;
import test.integration.recepies.transactional.repository.HistoricalRepository;

import java.util.Arrays;
import java.util.Map;

@Service
@AllArgsConstructor
public class HistoricalService {

    HistoricalRepository repository;
    ChangeDetectionService changeService;


    @Transactional
    public HistoricalEntity save(String id, String value, String ... elements) {
        HistoricalEntity entity = new HistoricalEntity(id, value);
        if (elements.length > 0) {
            entity.getRelatedEntities().addAll(Arrays.asList(elements));
        }
        return repository.save(entity);
    }

    @Transactional
    public HistoricalEntity find(String id) {
        return repository.findById(id).get();
    }


    @AllArgsConstructor
    @ToString
    @Getter
    public static class StringDiff {
        String oldValue;
        String newValue;
    }

    @Transactional
    public Map<String, StringDiff> changeValueAndGetDiff(String id, String newValue) {
        HistoricalEntity byId = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        byId.setValue(newValue);
        return changeService.getDbData(byId);
    }

}
