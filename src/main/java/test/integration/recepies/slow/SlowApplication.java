package test.integration.recepies.slow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import test.integration.recepies.slow.controller.AnotherController;
import test.integration.recepies.testinaction.BootstrapFullText;

@SpringBootApplication
@Slf4j
public class SlowApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SlowApplication.class, args);
		AnotherController controller = context.getBean(AnotherController.class);
		log.error(controller.searchCats().toString());
	}

}
