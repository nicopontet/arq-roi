
package com.kremlin.persistence;


import com.kremlin.imp.entity.Application;
import com.kremlin.imp.entity.ServiceOperation;
import com.kremlin.imp.entity.UserKremlin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Stateless
public class UserPersistence extends AbstractPersistence<UserKremlin> implements UserPersistenceLocal {

    @PersistenceContext(unitName = "kremlin-ejbPU")
    private EntityManager em;

   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserPersistence() {
        super(UserKremlin.class);
    }

    @Override
    public UserKremlin findUserByName(String name) {
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery q = cb.createQuery();
            Root<UserKremlin> root = q.from(UserKremlin.class);
            Join<UserKremlin,Application> p;
            p = root.join("application", JoinType.INNER);
            Predicate prEq = cb.equal(root.get("username"), name);
            q.select(root).where(prEq);
            TypedQuery<UserKremlin> typedQuery = em.createQuery(q);
            return typedQuery.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    } 
}
