package se.iths.exceptionMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidAgeMapper implements ExceptionMapper<InvalidAgeException> {
    @Override
    public Response toResponse(InvalidAgeException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new BasicResponse("Invalid age of a high school student"))
                .type(MediaType.APPLICATION_JSON).build();
    }
}
