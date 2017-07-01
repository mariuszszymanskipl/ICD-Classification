package api;

import domain.Classification;
import domain.Section;
import services.ICDBuilder;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
        List<Section> sections = classification.getSections();
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for (Section section : sections) {
            jsonArrayBuilder.add(section.toJsonObject());
        }
//        return Response.status(Response.Status.OK).entity(classification).build();
        return Response.status(Response.Status.OK).entity(jsonArrayBuilder.build()).build();
    }
}
