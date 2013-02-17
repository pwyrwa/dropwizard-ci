package org.pio.dropwizard.resource;

import org.pio.dropwizard.DWCIConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * User: pwyrwins
 * Date: 2/13/13
 * Time: 7:10 PM
 */
@Path("/hello")
public class HelloResource {

    private static final Logger LOG = LoggerFactory.getLogger(HelloResource.class);
    private final DWCIConfiguration dwciConfiguration;

    public HelloResource(DWCIConfiguration dwciConfiguration) {
        this.dwciConfiguration = dwciConfiguration;
    }

    @GET
   public Response getHello(@QueryParam("to") String to)
   {
       LOG.info("Populating template for template {}, param: {},", dwciConfiguration.getHelloTemplate() ,to);
       return Response.ok(String.format(dwciConfiguration.getHelloTemplate(), to)).build();
   }
}
