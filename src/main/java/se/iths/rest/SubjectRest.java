package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.exceptionMapper.InvalidAgeException;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {
    
    @Inject
    SubjectService subjectService;

    @Path("")
    @POST
    public Response createSubject(Subject subject) {
        subjectService.create(subject);
        return Response.ok(subject).build();
    }

    @Path("")
    @PUT
    public Response updateSubject(Subject subject) {
        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("{id}")
    @GET
    public Response getSubject(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findById(id);

        return Response.ok(foundSubject).build();
    }

    @Path("")
    @GET
    public Response getAllSubjects(){
        List<Subject> foundSubjects = subjectService.getAll();


        return Response.ok(foundSubjects).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteSubject(@PathParam("id") Long id ){
        subjectService.delete(id);

        return Response.ok().build();
    }

    @Path("/all/{id}")
    @GET
    public Response getAllBySubject(@PathParam("id") Long subjectId ){
        List<Subject> foundSubject = subjectService.getAllBySubject(subjectId);
        return Response.ok(foundSubject).build();
    }

    @Path("{subjectId}/student/{studentId}")
    @GET
    public Response getAllSubjectAndStudents(@PathParam("subjectId") Long subjectId, @PathParam("studentId") Long studentId){
        List<Subject> foundSubject = subjectService.getBySubjectAndStudent(subjectId, studentId);
        return Response.ok(foundSubject).build();
    }

    
}
