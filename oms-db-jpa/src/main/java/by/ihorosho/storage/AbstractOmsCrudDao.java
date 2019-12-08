package by.ihorosho.storage;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository("abstractOmsCrudDao")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public abstract class AbstractOmsCrudDao<T, ID> {
    private static final String ID_FIELD_NAME = "id";

    private EntityManager entityManager;
    private Class<T> clazz;

    public List<T> getAll() {
        return entityManager.createQuery(this.getCriteriaSelectQuery()).getResultList();
    }

    public List<T> getAll(int limit) {
        return entityManager.createQuery(this.getCriteriaSelectQuery()).setMaxResults(limit).getResultList();
    }

    public List<T> getAll(int offset, int limit) {
        return entityManager.createQuery(this.getCriteriaSelectQuery()).setFirstResult(offset)
                .setMaxResults(limit).getResultList();
    }


    public T getById(ID id) {
        return entityManager.find(clazz, id);
    }

    public T save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Argument of Dao save method can not be null. ");
        }
        entityManager.persist(entity);
        return entity;
    }

    public T update(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Argument of Dao update method can not be null. ");
        }
        return entityManager.merge(entity);
    }

    public Boolean deleteById(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("Argument of Dao deleteById method can not be null. ");
        }
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<T> deleteQuery = criteriaBuilder.createCriteriaDelete(clazz);
        Root<T> root = deleteQuery.from(clazz);
        deleteQuery.where(criteriaBuilder.equal(root.get(ID_FIELD_NAME), id));
        return entityManager.createQuery(deleteQuery).executeUpdate() > 0;
    }


    private CriteriaQuery<T> getCriteriaSelectQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        return query.select(root);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected Class<T> getClazz() {
        return clazz;
    }

    protected void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
