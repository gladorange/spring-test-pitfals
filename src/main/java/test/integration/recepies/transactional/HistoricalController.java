package test.integration.recepies.transactional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.integration.recepies.transactional.entity.HistoricalEntity;
import test.integration.recepies.transactional.service.HistoricalService;

@Component
@AllArgsConstructor
public class HistoricalController {

    HistoricalService historicalService;


    public void createAndPrint() {
        historicalService.save("el1", "entity with values",
                "one", "two", "three"
        );

        HistoricalEntity saved = historicalService.find("el1");
        System.out.println(saved.getRelatedEntities());

    }
}
