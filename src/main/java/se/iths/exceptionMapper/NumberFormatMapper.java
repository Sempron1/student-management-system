package se.iths.exceptionMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NumberFormatMapper implements ExceptionMapper<NumberFormatException> {
    @Override
    public Response toResponse(NumberFormatException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new BasicResponse("Please use numbers for an age...."))
                .type(MediaType.APPLICATION_JSON).build();
    }
}
