package se.iths.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class EntityService {

    @PersistenceContext
    EntityManager entityManager;


    public <T> void create(T entity){
        entityManager.persist(entity);
    }

    public <T> void update(T entity){
        entityManager.merge(entity);
    }

    public abstract <T> T findById(Long id);

    public abstract <T> List<T> getAll();

    public abstract void delete(Long id);

}
