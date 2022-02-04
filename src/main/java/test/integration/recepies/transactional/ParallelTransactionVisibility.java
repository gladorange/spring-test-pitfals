package test.integration.recepies.transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import test.integration.recepies.transactional.service.HistoricalService;

@SpringBootApplication
@Slf4j
public class ParallelTransactionVisibility {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ParallelTransactionVisibility.class, args);
		HistoricalService service = context.getBean(HistoricalService.class);
		service.save("one", "initial value");
		System.out.println(service.changeValueAndGetDiff("one", "updated value"));
		System.out.println("value in db:" + service.find("one").getValue());
	}

}
