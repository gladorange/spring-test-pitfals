package test.integration.recepies.testinaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import test.integration.recepies.testinaction.controller.SimpleController;

@SpringBootApplication
@Slf4j
public class BootstrapFullText {


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BootstrapFullText.class);
		app.setAdditionalProfiles("bootstrap");
		ConfigurableApplicationContext context = SpringApplication.run(BootstrapFullText.class, args);
		SimpleController controller = context.getBean(SimpleController.class);
		log.error(controller.searchCats().toString());
	}

}
