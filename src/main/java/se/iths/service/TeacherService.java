package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;


    public void createTeacher(Teacher teacher) {

        entityManager.persist(teacher);
    }

    public void updateTeacher(Teacher teacher){
        entityManager.merge(teacher);
    }

    public void addSubject(Long teacherId, Long subjectId){
        Subject foundSubject = entityManager.find(Subject.class, subjectId);
        Teacher foundTeacher = entityManager.find(Teacher.class, teacherId);
        foundTeacher.addSubject(foundSubject);
        entityManager.merge(foundTeacher);
    }


    public Teacher findTeacherById(Long id){
        return entityManager.find(Teacher.class,id);
    }

    public List<Teacher> getAllTeacher(){
        return entityManager.createQuery("SELECT s FROM Teacher s", Teacher.class).getResultList();
    }

    public void deleteTeacher(Long id){
        Teacher foundTeacher = entityManager.find(Teacher.class,id);
        entityManager.remove(foundTeacher);
    }
}
