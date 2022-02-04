package test.integration.recepies.transactional.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test.integration.recepies.transactional.entity.HistoricalEntity;
import test.integration.recepies.transactional.repository.HistoricalRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ChangeDetectionService {

    HistoricalRepository repository;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Map<String, HistoricalService.StringDiff> getDbData(HistoricalEntity entity) {

        HistoricalEntity inDb = repository
                .findById(entity.getId())
                .orElseThrow(() -> new RuntimeException("entity not found in DB:" + entity.getId()));

        Map<String, HistoricalService.StringDiff> result = new HashMap<>();

        if (!Objects.equals(entity.getValue(),inDb.getValue())) {
            result.put("value", new HistoricalService.StringDiff(inDb.getValue(), entity.getValue()));
        }

        return result;
    }

}
