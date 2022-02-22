package se.iths.exceptionMapper;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityNotFoundMapper implements ExceptionMapper<EntityNotFoundException> {
    @Override
    public Response toResponse(EntityNotFoundException e) {

        return Response.status(Response.Status.NOT_FOUND)
                .entity(new BasicResponse("Empty... Please add students to the database"))
                .type(MediaType.APPLICATION_JSON).build();
    }
}
