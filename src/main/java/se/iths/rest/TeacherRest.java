package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("")
    @POST
    public Response createTeacher(Teacher teacher) {
        teacherService.create(teacher);
        return Response.ok(teacher).build();
    }

    @Path("")
    @PUT
    public Response updateTeacher(Teacher teacher) {
        teacherService.update(teacher);
        return Response.ok(teacher).build();
    }

    @Path("{teacherId}/subject/{subjectId}")
    @PUT
    public Response addSubject(@PathParam("teacherId") Long teacherId, @PathParam("subjectId")Long subjectId){
        teacherService.addSubject(teacherId, subjectId);
        return Response.ok(teacherId).build();
    }

    @Path("{id}")
    @GET
    public Response getTeacher(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.findById(id);

        return Response.ok(foundTeacher).build();
    }

    @Path("")
    @GET
    public Response getAllTeachers(){
        List<Teacher> foundTeachers = teacherService.getAll();


        return Response.ok(foundTeachers).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id ){
        teacherService.delete(id);

        return Response.ok().build();
    }
}
