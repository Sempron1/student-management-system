package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData(){

        Teacher teacher1 = new Teacher("Johan", "Johansson", "Johan@mail.se","40","687923");

        Student student1 = new Student("Luke","Fine","lukas@mail.se","22","12349");
        Student student2 = new Student("Alicia","Johansson","Alicia@mail.se","21","12412");

        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("Biology");
        Subject subject3 = new Subject("English");

        student1.addSubject(subject1);
        student2.addSubject(subject1);
        student1.addSubject(subject2);
        student2.addSubject(subject2);
        student1.addSubject(subject3);
        student2.addSubject(subject3);

        subject1.addStudents(student1);
        subject1.addStudents(student2);
        subject2.addStudents(student1);
        subject2.addStudents(student2);
        subject3.addStudents(student1);
        subject3.addStudents(student2);


        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher1.addSubject(subject3);


        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(subject1);
        entityManager.persist(subject2);
        entityManager.persist(subject3);

        entityManager.persist(teacher1);

    }
}
