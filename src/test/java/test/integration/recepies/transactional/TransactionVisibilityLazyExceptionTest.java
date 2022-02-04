package test.integration.recepies.transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = ParallelTransactionVisibility.class)
@ActiveProfiles("tx")

// никогда не делайте так
@Transactional
class TransactionVisibilityLazyExceptionTest {


	@Autowired
	HistoricalController controller;

	@Test
	void testTransactionalTest() {
		controller.createAndPrint();
	}

}
