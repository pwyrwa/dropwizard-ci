package org.pio.dropwizard;

import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import org.pio.dropwizard.resource.ByeResource;
import org.pio.dropwizard.resource.HelloResource;

/**
 * User: pwyrwins
 * Date: 2/11/13
 * Time: 8:14 PM
 */
public class DWCIService extends EmbeddableService<DWCIConfiguration> {

    public static void main(String[] args) throws Exception {
        new DWCIService().run(args);
    }

    private final EmbeddedServerCommand<DWCIConfiguration> embeddedServerCommand =
            new EmbeddedServerCommand<DWCIConfiguration>(this);

    @Override
    public void initialize(Bootstrap<DWCIConfiguration> bootstrap) {
        super.initialize(bootstrap);
        bootstrap.setName("CI - embeddable");

    }

    @Override
    public void run(DWCIConfiguration dwciConfiguration, Environment environment) throws Exception {
        environment.addResource(new HelloResource(dwciConfiguration));
        environment.addResource(new ByeResource(dwciConfiguration));
    }
}
