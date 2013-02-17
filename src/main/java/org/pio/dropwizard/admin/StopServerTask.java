package org.pio.dropwizard.admin;

import com.google.common.collect.ImmutableMultimap;
import com.yammer.dropwizard.tasks.Task;
import org.pio.dropwizard.EmbeddedServerCommand;

import java.io.PrintWriter;

/**
 * User: pwyrwins
 * Date: 2/13/13
 * Time: 7:44 PM
 */
public class StopServerTask extends Task {

    private final EmbeddedServerCommand command;

    public StopServerTask(String name, EmbeddedServerCommand command) {
        super(name);
        this.command = command;
    }

    @Override
    public void execute(ImmutableMultimap<String, String> parameters, PrintWriter output) throws Exception {

        command.stop();

    }
}
