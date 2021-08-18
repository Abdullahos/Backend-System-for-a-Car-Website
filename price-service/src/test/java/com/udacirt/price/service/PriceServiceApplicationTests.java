package com.udacirt.price.service;

import com.udacirt.price.service.api.PricingController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
/**
* test class to test the price-microservice
*/
@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
class PriceServiceApplicationTests {

	@Autowired
	private PricingController pricingController;
	/**
	 *  test that will fail if the application context cannot start.
	 */
	@Test
	void contextLoads() {
		assertThat(pricingController).isNotNull();
	}

}
