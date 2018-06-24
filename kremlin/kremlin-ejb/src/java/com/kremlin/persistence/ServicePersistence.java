
package com.kremlin.persistence;


import com.kremlin.imp.entity.ServiceOperation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Stateless
public class ServicePersistence extends AbstractPersistence<ServiceOperation> implements ServicePersistenceLocal {

    @PersistenceContext(unitName = "kremlin-ejbPU")
    private EntityManager em;

   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicePersistence() {
        super(ServiceOperation.class);
    }

    @Override
    public ServiceOperation findServiceOperationByName(String name) {
        try{
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery q = cb.createQuery();
        Root<ServiceOperation> root = q.from(ServiceOperation.class);
        Predicate prEq = cb.equal(root.get("name"), name);
        q.select(root).where(prEq);
        TypedQuery<ServiceOperation> typedQuery = em.createQuery(q);
        return typedQuery.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }
    
}
