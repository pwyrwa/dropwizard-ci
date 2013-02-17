package org.pio.dropwizard.resource;

import com.jayway.restassured.response.Response;
import org.junit.ClassRule;
import org.junit.Test;
import org.pio.test.TestContext;

import static com.jayway.restassured.RestAssured.given;
import static org.fest.assertions.Assertions.assertThat;

/**
 * User: pwyrwins
 * Date: 2/16/13
 * Time: 3:39 PM
 */
public class ByeResourceIT {

    @ClassRule
    public static TestContext provider = new TestContext(false);

    @Test
    public void byeResource_ok(){

        Response response = given()
                .expect().response().statusCode(200)
                .when().get("http://localhost:5050/bye?to=foo");
        assertThat(response.getBody().asString()).isEqualToIgnoringCase("bye foo from test");

    }
}
