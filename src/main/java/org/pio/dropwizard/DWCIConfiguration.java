package org.pio.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

import javax.validation.constraints.NotNull;

/**
 * User: pwyrwins
 * Date: 2/11/13
 * Time: 8:18 PM
 */
public class DWCIConfiguration extends Configuration {

    @JsonProperty
    @NotNull
    private String helloTemplate;

    @JsonProperty
    @NotNull
    private String byeTemplate;

    public String getHelloTemplate() {
        return helloTemplate;
    }

    public String getByeTemplate() {
        return byeTemplate;
    }
}
