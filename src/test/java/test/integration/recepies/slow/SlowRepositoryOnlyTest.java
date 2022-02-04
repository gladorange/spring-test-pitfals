package test.integration.recepies.slow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import test.integration.recepies.slow.controller.AnotherController;
import test.integration.recepies.slow.entity.AnotherSimpleEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest(classes = SlowApplication.class)
@ActiveProfiles("slow")
@DataJpaTest
class SlowRepositoryOnlyTest {


	@Autowired
	AnotherController controller;

	@Test
	void testSearchSlow() {
		List<AnotherSimpleEntity> singleCat = controller.searchCats();
		assertEquals(1, singleCat.size());
		assertTrue(singleCat.stream().allMatch(c -> c.getId().equals("dog")));
		// тест не работает, т.к. доступны только репозитории
	}

}
