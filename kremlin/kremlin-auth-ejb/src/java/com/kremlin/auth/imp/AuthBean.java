
package com.kremlin.auth.imp;

import com.kremlin.auth.persistence.imp.TokenPersistenceLocal;
import com.kremlin.imp.entity.UserKremlin;
import com.kremlin.impl.UserBeanLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;



@Stateless
public class AuthBean implements AuthBeanLocal {

    @EJB
    private UserBeanLocal userBeanLocal;
    @EJB
    private TokenPersistenceLocal tokenPersistenceLocal;

    public AuthBean() {
    }
    
    @Override
    public Token login(String name, String pass) throws LoginUnsusefullException,AuthException {
      try{
        UserKremlin user= userBeanLocal.getUserByName(name);
        if (user!=null && user.getPassword().equals(pass) &&  user.getUsername().equals(name)) {
            Token token=new Token(name);
            token=tokenPersistenceLocal.createToken(token);
            return token;
        }else{
            throw new LoginUnsusefullException("Username or password incorrect");
        }  
      }catch(PersistenceException ex){
          throw new AuthException("Username or password incorrect");
      }
    }

   
}
