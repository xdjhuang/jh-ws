package com.jh.ws.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jh.ws.pojo.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/test")
public class RestResource {
    private static final Logger LOG = LoggerFactory
            .getLogger(RestResource.class);
    private static ObjectMapper mapper = new ObjectMapper();

    @Path("/hello")
    @GET
    public String message() {
        LOG.info("get hello request");
        return "Hello, rest!";
    }

    @Path("/account/{id}")
    @GET
    @Produces("application/json")
    public Account getAccount(@PathParam("id") int id,
            @QueryParam("simplified") boolean simplified) {
        LOG.info("get account request: {}", id);
        LOG.debug("DEBUG: get account request: {}", id);
        Account account = new Account();
        account.setId(id);
        account.setAge(35);
        if (!simplified) { 
            account.setFirstName("David");
            account.setLastName("Brown");
        }
        return account;
    }

    @Path("/account/{id}")
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response putAccount(@PathParam("id") int id,
            Account account) throws JsonProcessingException {
        return Response.status(Status.OK).build();
    }
}