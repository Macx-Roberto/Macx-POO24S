/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.dao;

import br.edu.utfpr.pb.util.EntityManagerUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


/**
 *
 * @author macxi
 */
public abstract class GenericDao <T, ID extends Serializable> {
    
    @PersistenceContext(unitName = "AtivPersistense2-h2")
    protected EntityManager em;
    
    private Class<T> persistedClass;
    
    protected GenericDao(){}
    
    public EntityManager getEntityManager(){
        return em;
    }

    public GenericDao(Class<T> persistedClass) {
        this.persistedClass = persistedClass;
        this.em = EntityManagerUtil.getEntityManager();
    }
    
    public void insert(T entity){
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(entity);
        em.flush();
        t.commit();
    }
    
    public void update(T entity){
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(entity);
        em.flush();
        t.commit();
    }
    
    public T findById(ID id){
        return em.find(persistedClass, id);
    }
    
    public void delete(ID id){
        T entity = findById(id);
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(entity);
        em.flush();
        t.commit();
    }
    
    public List<T> findAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        return em.createQuery(query).getResultList();
    }
    
}
