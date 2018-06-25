
package com.kremlin.auth.persistence.imp;


import com.kremlin.auth.imp.Token;
import com.kremlin.auth.imp.Token;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



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

    
}
