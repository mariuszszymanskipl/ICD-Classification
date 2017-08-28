package api;

import domain.Classification;
import services.ICDBuilder;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Mariusz Szymanski
 */
@Path("/classification")
public class ICDService {

    @Inject
    private ICDBuilder icdBuilder;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClassification() {

        Classification classification = icdBuilder.getAllClassification();
        return Response.status(Response.Status.OK).entity(classification).build();
    }
}
