
package com.kremlin.auth.persistence.imp;


import com.kremlin.auth.imp.Token;
import com.kremlin.auth.imp.Token;
import com.kremlin.imp.entity.UserKremlin;

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
public class TokenPersistence extends AbstractPersistence<Token> implements TokenPersistenceLocal {

    @PersistenceContext(unitName = "kremlin-auth-ejbPU")
    private EntityManager em;

   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TokenPersistence() {
        super(Token.class);
    }

    @Override
    public Token createToken(Token token) {
        return create(token);
    }
    @Override
    public Token findTokenByNro(String tokenNro) {
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery q = cb.createQuery();
            Root<Token> root = q.from(Token.class);
            Predicate prEq = cb.equal(root.get("token"), tokenNro);
            q.select(root).where(prEq);
            TypedQuery<Token> typedQuery = em.createQuery(q);
            return typedQuery.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    } 
    @Override
    public Token findTokenByUser(String userName) {
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery q = cb.createQuery();
            Root<Token> root = q.from(Token.class);
            Predicate prEq = cb.equal(root.get("userName"), userName);
            q.select(root).where(prEq);
            TypedQuery<Token> typedQuery = em.createQuery(q);
            return typedQuery.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    } 

    
}
