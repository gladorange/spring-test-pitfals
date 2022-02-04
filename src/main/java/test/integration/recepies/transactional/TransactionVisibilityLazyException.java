package test.integration.recepies.transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class TransactionVisibilityLazyException {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TransactionVisibilityLazyException.class, args);
		HistoricalController service = context.getBean(HistoricalController.class);
		service.createAndPrint();
	}

}
