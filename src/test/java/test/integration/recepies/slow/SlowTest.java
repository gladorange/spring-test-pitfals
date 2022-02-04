package test.integration.recepies.slow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import test.integration.recepies.slow.controller.AnotherController;
import test.integration.recepies.slow.entity.AnotherSimpleEntity;
import test.integration.recepies.slow.service.AnotherService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SlowApplication.class)
@ActiveProfiles("slow")
class SlowTest {


	@Autowired
	AnotherService service;

	@Test
	void testSearchSlow() {
		List<AnotherSimpleEntity> singleCat = service.searchCats();
		assertEquals(1, singleCat.size());
		assertTrue(singleCat.stream().allMatch(c -> c.getId().equals("dog")));
	}

}
