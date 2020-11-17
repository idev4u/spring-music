package org.cloudfoundry.samples.music;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.springframework.http.HttpStatus;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EndpointTests {
    @LocalServerPort
	private int port;

    @Test
    public void checkIfTheRootPathIsUp() {
        final Response res = RestAssured.get("http://localhost:"+port+"/");
        assertEquals(HttpStatus.OK.value(), res.getStatusCode());
    }

}
