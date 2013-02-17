package org.pio.dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;

/**
 * Extends DropWizard service allowing it to start/stop embedded service
 * User: piotwy01
 * Date: 2/13/13
 * Time: 9:40 AM
 */
public abstract class EmbeddableService <T extends Configuration> extends Service <T>
{

    private final EmbeddedServerCommand<T> embeddedServerCommand =
            new EmbeddedServerCommand<T>(this);

    public void startEmbeddedServer(String configFileName) throws Exception {
        run(new String[] {"embedded-server", configFileName});
    }

    public void stopEmbeddedServer() throws Exception {
        embeddedServerCommand.stop();
    }

    public boolean isEmbeddedServerRunning() {
        return embeddedServerCommand.isRunning();
    }

    @Override
    public void initialize(Bootstrap <T> bootstrap) {
        bootstrap.addCommand(embeddedServerCommand);
    }

}
