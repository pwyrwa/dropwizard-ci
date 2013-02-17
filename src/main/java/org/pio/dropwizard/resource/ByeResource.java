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
@Path("/bye")
public class ByeResource {

    private static final Logger LOG = LoggerFactory.getLogger(ByeResource.class);
    private final DWCIConfiguration dwciConfiguration;

    public ByeResource(DWCIConfiguration dwciConfiguration) {
        this.dwciConfiguration =  dwciConfiguration;
    }

    @GET
    public Response getBye(@QueryParam("to") String to) {
        LOG.info("Populating template for template {}, param: {},", dwciConfiguration.getByeTemplate() ,to);
        return Response.ok(String.format(dwciConfiguration.getByeTemplate(), to)).build();    }
}
