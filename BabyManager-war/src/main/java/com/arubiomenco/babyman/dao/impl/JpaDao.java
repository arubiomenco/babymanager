package com.arubiomenco.babyman.dao.impl;

import com.arubiomenco.babyman.dao.IDao;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angel
 */
public abstract class JpaDao<K, E> implements IDao<K, E> {
    protected Class<E> entityClass;

    @PersistenceContext
    protected EntityManager em;

    public JpaDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    public void persist(E entity) {
        em.persist(entity);
    }

    public void remove(E entity) {
        em.remove(entity);
    }

    public E findById(K id) {
        return em.find(entityClass, id);
    }
}
