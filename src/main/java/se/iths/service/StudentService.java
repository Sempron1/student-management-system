package se.iths.service;

import se.iths.entity.Student;
import se.iths.exceptionMapper.InvalidAgeException;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public void createStudent(Student student) throws SQLSyntaxErrorException, InvalidAgeException {

        if(student.getEmail().isEmpty() || student.getFirstName().isEmpty() || student.getLastName().isEmpty()){
            throw new SQLSyntaxErrorException();
        }
        else if( Integer.parseInt(student.getAge()) < 14 || Integer.parseInt(student.getAge()) > 18)
            throw new InvalidAgeException("Invalid age for a high school student");

        entityManager.persist(student);
    }

    public void updateStudent(Student student){

        if(findStudentById(student.getId()) != null){
            entityManager.merge(student);
        } else
            throw new EntityNotFoundException();

    }

    public Student findStudentById(Long id){
        return entityManager.find(Student.class,id);
    }

    public List<Student> getAllStudents(){
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public void deleteStudent(Long id){
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
