package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService extends EntityService{

    @PersistenceContext
    EntityManager entityManager;


    public void create(Teacher teacher) {

        entityManager.persist(teacher);
    }

    public void update(Teacher teacher){
        entityManager.merge(teacher);
    }

    public void addSubject(Long teacherId, Long subjectId){
        Subject foundSubject = entityManager.find(Subject.class, subjectId);
        Teacher foundTeacher = entityManager.find(Teacher.class, teacherId);
        foundTeacher.addSubject(foundSubject);
        entityManager.merge(foundTeacher);
    }

    @Override
    public Teacher findById(Long id){
        return entityManager.find(Teacher.class,id);
    }
    @Override
    public List<Teacher> getAll(){
        return entityManager.createQuery("SELECT s FROM Teacher s", Teacher.class).getResultList();
    }
    @Override
    public void delete(Long id){
        Teacher foundTeacher = entityManager.find(Teacher.class,id);
        entityManager.remove(foundTeacher);
    }
}
