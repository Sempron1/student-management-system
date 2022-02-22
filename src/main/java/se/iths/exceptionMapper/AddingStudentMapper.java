package se.iths.exceptionMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.sql.SQLSyntaxErrorException;

@Provider
public class AddingStudentMapper implements ExceptionMapper<SQLSyntaxErrorException> {
    @Override
    public Response toResponse(SQLSyntaxErrorException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new BasicResponse("firstName,lastName and email are all required fields"))
                .type(MediaType.APPLICATION_JSON).build();
    }
}
