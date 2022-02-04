package test.integration.recepies.slow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test.integration.recepies.slow.controller.AnotherController;
import test.integration.recepies.slow.entity.AnotherSimpleEntity;
import test.integration.recepies.slow.repository.AnotherSimpleEntityRepository;
import test.integration.recepies.slow.service.AnotherService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest(classes = SlowApplication.class)
@ActiveProfiles("slow")
@DataJpaTest

// мы же хотим настоящую БД?
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class SlowManuallyTest {


	@Autowired
	AnotherSimpleEntityRepository anotherRepository;

	@Autowired
	AutowireCapableBeanFactory beanFactory;

	@Test
	void testSearchSlow() {
		AnotherService svc = new AnotherService(anotherRepository);

		svc = (AnotherService) beanFactory.applyBeanPostProcessorsBeforeInitialization(svc,"anotherService");
		svc = (AnotherService) beanFactory.applyBeanPostProcessorsAfterInitialization(svc, "anotherService");

		List<AnotherSimpleEntity> singleCat = svc.searchCats();
		assertEquals(1, singleCat.size());
		assertTrue(singleCat.stream().allMatch(c -> c.getId().equals("dog")));
	}

}
