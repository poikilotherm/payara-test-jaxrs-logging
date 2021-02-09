package com.example;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.ws.rs.core.Response.ok;

@Path("greeting")
@RequestScoped
public class GreetingResource {

    private final static Logger logger = Logger.getLogger(GreetingResource.class.getName());
    
    @Inject
    private GreetingService greetingService;

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greeting(@PathParam("name") String name) {
        return ok(this.greetingService.buildGreetingMessage(name)).build();
    }
    
    @GET
    @Path("fail")
    @Produces(MediaType.APPLICATION_JSON)
    public Response failing() {
        try {
            throw new NullPointerException("test1");
        } catch (Exception e) {
            logger.log(Level.WARNING, "test1", e);
        }
        throw new NullPointerException("test2");
    }
}
