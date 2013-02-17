package org.pio.dropwizard.resource;

import org.junit.Before;
import org.junit.Test;
import org.pio.dropwizard.DWCIConfiguration;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * User: pwyrwins
 * Date: 2/16/13
 * Time: 12:18 PM
 */
public class HelloResourceTest {

    DWCIConfiguration configuration;
    HelloResource resource;

    @Before
    public void setup() {
        configuration = mock(DWCIConfiguration.class);
        when(configuration.getHelloTemplate()).thenReturn("hello %s");
        resource = new HelloResource(configuration);
    }

    @Test
    public void when_get_then_return_template() {
        assertThat(resource.getHello("dude").getEntity()).isEqualTo("hello dude");
    }
}
