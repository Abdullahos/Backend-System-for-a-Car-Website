package com.udacirt.price.service;

import com.udacirt.price.service.api.PricingController;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * test class to test the price-microservice
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class PriceMicroserviceTests {

    @LocalServerPort
    private int port;

    @Autowired
    private PricingController pricingController;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * test with asking for the price of a vehicle with a valid id, and the expected response in Ok 200.
     */
    @Test
    public void getVehiclePriceWithValidId(){
        Long id = 1L;
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:"+port+"/services/price?vehicleId="+id,String.class);	//the return type is string
        MatcherAssert.assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }
    /**test with asking for the price of a vehicle with an invalid id, the expected response in not found 404.*/
    @Test
    public void getVehiclePriceWithNotValidId(){
        Long id = -1L;
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:"+port+"/services/price?vehicleId="+id,String.class);	//the return type is string
        MatcherAssert.assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
    }

}
