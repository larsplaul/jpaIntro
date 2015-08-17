/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import facade.JsonAssembler;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author lam
 */
@Path("project")
public class Project {
    
    JsonAssembler ass = new JsonAssembler();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Project
     */
    public Project() {
    }

    /**
     * Retrieves representation of an instance of rest.Project
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("user/{id}")
    public String getJson(@PathParam("id") int id) {
       return ass.getUser(id);
    }

    /**
     * PUT method for updating or creating an instance of Project
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/json")
    public void putJson(String content) {
        System.out.println(content);
    }
}
