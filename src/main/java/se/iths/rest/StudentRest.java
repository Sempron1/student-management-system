package se.iths.rest;

import se.iths.entity.Student;
import se.iths.exceptionMapper.InvalidAgeException;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createStudent(Student student) throws SQLSyntaxErrorException, InvalidAgeException {
        studentService.create(student);
        return Response.ok(student).build();
    }

    @Path("")
    @PUT
    public Response updateStudent(Student student) throws InvalidAgeException {
        studentService.update(student);
        return Response.ok(student).build();
    }

    @Path("{studentId}/subject/{subjectId}")
    @PUT
    public Response addSubject(@PathParam("studentId") Long studentId, @PathParam("subjectId") Long subjectId){
        studentService.addSubject(studentId, subjectId);
        return Response.ok(studentId).build();
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findById(id);

        if(foundStudent == null){
            throw new EntityNotFoundException();
        }

        return Response.ok(foundStudent).build();
    }

    @Path("")
    @GET
    public Response getAllStudents(){
        List<Student> foundStudents = studentService.getAll();

        if(foundStudents.isEmpty()){
            throw new EntityNotFoundException();
        }

        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id ){
        studentService.delete(id);

        return Response.ok().build();
    }

    @Path("getbylastname")
    @GET
    public Response getByLastName(@QueryParam("lastName") String lastName){

        List<Student> foundStudent = studentService.getByLastName(lastName);

        if(foundStudent.isEmpty()){
            throw new EntityNotFoundException();
        }

        return Response.ok(foundStudent).build();
    }

}
