package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.exceptionMapper.InvalidAgeException;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.Objects;

@Transactional
public class StudentService extends EntityService{

    @PersistenceContext
    EntityManager entityManager;

    public void create(Student student) throws SQLSyntaxErrorException, InvalidAgeException {

        if(student.getEmail().isEmpty() || student.getFirstName().isEmpty() || student.getLastName().isEmpty()){
            throw new SQLSyntaxErrorException();
        }
        else if( Integer.parseInt(student.getAge()) < 14 || Integer.parseInt(student.getAge()) > 18)
            throw new InvalidAgeException("Invalid age for a high school student");

        entityManager.persist(student);
    }

    public void addSubject(Long studentId, Long subjectId){

        Subject foundSubject = entityManager.find(Subject.class, subjectId);
        Student foundStudent = entityManager.find(Student.class, studentId);
        foundStudent.addSubject(foundSubject);
        entityManager.merge(foundStudent);
    }

    public void update(Student student) throws InvalidAgeException {

        if(findById(student.getId()) == null){
            throw new EntityNotFoundException();
        }else if(Integer.parseInt(student.getAge()) < 14 || Integer.parseInt(student.getAge()) > 18)
            throw new InvalidAgeException("Invalid age of a high school student");

        entityManager.merge(student);

    }

    @Override
    public Student findById(Long id){
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> getAll(){
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }


    @Override
    public void delete(Long id){
        Student foundStudent = entityManager.find(Student.class,id);

        if(foundStudent == null){
            throw new EntityNotFoundException();
        }
        entityManager.remove(foundStudent);
    }
    public List<Student> getByLastName(String lastName){
        String query = "SELECT s FROM Student s WHERE s.lastName = :lastName";
        return entityManager.createQuery(query, Student.class).setParameter("lastName", lastName).getResultList();
    }



}
