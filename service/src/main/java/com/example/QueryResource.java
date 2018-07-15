package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/query")
public class QueryResource {

    @GET
    public String healthcheck() {
        return "heartbeat";
    }

    @POST
    public String post() {
        return "post";
    }

    @PUT
    public String put() {
        return "put";
    }
}
