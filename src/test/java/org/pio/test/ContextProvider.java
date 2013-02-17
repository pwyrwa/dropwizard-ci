package org.pio.test;

import com.google.common.base.Throwables;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.pio.dropwizard.DWCIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: pwyrwins
 * Date: 2/16/13
 * Time: 2:44 PM
 */
public class ContextProvider extends TestWatcher {

    private static final Logger LOG = LoggerFactory.getLogger(ContextProvider.class);

    private static Boolean IN_SUITE = false;
    private DWCIService service;
    private final Boolean forSuite;

    public ContextProvider(Boolean forSuite) {
        this.forSuite = forSuite;
        if (this.forSuite) {
            IN_SUITE = true;
        }
    }

    @Override
    protected void starting(Description description) {
        LOG.info("{} starting for suite: {}.", this.getClass().getSimpleName(), forSuite);
        if (forSuite == IN_SUITE) {
            LOG.info("{} {} calling START dropWizard Server.", this.getClass().getSimpleName());
            startDropWizardServer();
        }
    }

    @Override
    protected void finished(Description description) {
        LOG.info("{} finishing for suite: {}.", this.getClass().getSimpleName(), forSuite);
        if (forSuite == IN_SUITE) {
            LOG.info("{} calling STOP dropWizard Server.", this.getClass().getSimpleName());
            stopDropWizardServer();
        }
    }

    private void startDropWizardServer() {
        service = new DWCIService();
        try {
            service.startEmbeddedServer(this.getClass().getClassLoader()
                    .getResource("drop-wizard-ci-test.yml").getPath());
        } catch (Exception e) {
            LOG.error("Exception starting server {}", e.getMessage());
        }

        if(!service.isEmbeddedServerRunning()) {
            throw new RuntimeException("Server did not start correctly");
        }
    }

    private void stopDropWizardServer() {
        if(service.isEmbeddedServerRunning()) {
            try {
                service.stopEmbeddedServer();
            } catch (Exception e) {
                throw Throwables.propagate(e);
            }
        }
    }

}
