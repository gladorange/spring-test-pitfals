package test.integration.recepies.testinaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import test.integration.recepies.testinaction.controller.SimpleController;
import test.integration.recepies.testinaction.entity.SimpleEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = BootstrapFullText.class)
@ActiveProfiles("h2-test")
class BootstrapFullTextH2Test {


	@Autowired
	SimpleController controller;

	@Test
	void testSearch() {
		List<SimpleEntity> singleCat = controller.searchCats();
		assertEquals(1, singleCat.size());
		assertTrue(singleCat.stream().allMatch(c -> c.getId().equals("cat")));	}

}
