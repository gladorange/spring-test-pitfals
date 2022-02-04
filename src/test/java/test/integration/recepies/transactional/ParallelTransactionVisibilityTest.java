package test.integration.recepies.transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import test.integration.recepies.transactional.service.HistoricalService;
import test.integration.recepies.transactional.service.HistoricalService.StringDiff;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ParallelTransactionVisibility.class)
@ActiveProfiles("tx")

// никогда не делайте так
@Transactional
class ParallelTransactionVisibilityTest {


	@Autowired
	HistoricalService service;

	@Test
	void testTransactionalTest() {
		service.save("one", "initial value");
		Map<String, StringDiff> diff = service.changeValueAndGetDiff("one", "updated value");
		assertEquals(1, diff.size());

		StringDiff value = diff.get("value");
		assertNotNull(value);
		assertEquals("initial value",value.getOldValue());
		assertEquals("updated value",value.getNewValue());
	}

}
