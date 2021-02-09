package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class ThrowableHandler implements ExceptionMapper<Throwable> {
    
    private static final Logger logger = Logger.getLogger(ThrowableHandler.class.getName());
    
    @Context
    HttpServletRequest request;
    
    @Override
    public Response toResponse(Throwable ex){
        logger.log(Level.WARNING, "test2", ex);
        return Response.ok().build();
    }
}