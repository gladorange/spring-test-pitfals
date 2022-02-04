package test.integration.recepies.slow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SlowService {

    public SlowService() throws InterruptedException {
        log.error("Сплю 10 секунд");
        Thread.sleep(1000);
        log.error("проснулся");

    }
}
