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

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public void createSubject(Subject subject) {

        entityManager.persist(subject);
    }

    public void updateSubject(Subject subject){
        entityManager.merge(subject);
    }

    public Subject findSubjectById(Long id){
        return entityManager.find(Subject.class,id);
    }

    public List<Subject> getAllSubject(){
        return entityManager.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

    public void deleteSubject(Long id){
        Subject foundSubject = entityManager.find(Subject.class,id);
        entityManager.remove(foundSubject);
    }
}
