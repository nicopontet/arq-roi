
package com.kremlin.auth.imp;

import com.kremlin.auth.persistence.imp.TokenPersistenceLocal;
import com.kremlin.auth.resource.filter.Secured;
import com.kremlin.imp.entity.ServiceOperation;
import com.kremlin.imp.entity.UserKremlin;
import com.kremlin.impl.ServiceBeanLocal;
import com.kremlin.impl.UserBeanLocal;
import java.lang.reflect.AnnotatedElement;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;



@Stateless
public class AuthBean implements AuthBeanLocal {

    @EJB
    private UserBeanLocal userBeanLocal;
    @EJB
    private ServiceBeanLocal serviceBeanLocal;
    @EJB
    private TokenPersistenceLocal tokenPersistenceLocal;

    public AuthBean() {
    }

    @Override
    public Token authentication(String name, String pass) throws LoginUnsusefullException,AuthException {
      try{
        UserKremlin user= userBeanLocal.getUserByName(name);
        if (user!=null && user.getPassword().equals(pass) &&  user.getUsername().equals(name)) {
            Random random = new SecureRandom();
            String tokenNro = new BigInteger(130, random).toString(32);
            Token token=new Token(tokenNro,name);
            token=tokenPersistenceLocal.createToken(token);
            return token;
        }else{
            throw new LoginUnsusefullException("Username or password incorrect");
        }  
      }catch(PersistenceException ex){
          throw new AuthException("Username or password incorrect");
      }
    }
    @Override
    public void validateToken(String tokenNro) throws AuthException{
        Token token=getToken(tokenNro);
        if (token!=null) {
            UserKremlin user=getUser(token.getUserName());
            if (user==null) {
                throw new AuthException();
            }  
        }else{
             throw new AuthException();
        }
    }
    @Override
    public void authorizationByAnnotation(String tokenNro, TypeAccess methodAccess) throws AuthException {
        Token token=getToken(tokenNro);
        if (token!=null) {
            UserKremlin user=getUser(token.getUserName());
            //como soy usuario interno. Pertenezco al ambito de confianza del kremlin
            if (user.isUserExternal() && !isExternalAccess(methodAccess)) {
                throw new AuthException();
            }  
        }else{
             throw new AuthException();
        }
    }
    private boolean isExternalAccess(TypeAccess methodAccess){
        return methodAccess==TypeAccess.EXTERNAL;
    }
    
    @Override
    public void authorizationByOperationName(String tokenNro, String serviceOperationName) throws AuthException,InvalidNameServiceOperationException {
        Token token=getToken(tokenNro);
        if (token!=null) {
            UserKremlin user=getUser(token.getUserName());
            //como soy usuario interno. Pertenezco al ambito de confianza del kremlin
            if (user.isUserExternal()) {
                ServiceOperation service= getService(serviceOperationName);
                if(service!=null){
                    if (!service.isAccessExternal()) {
                            throw new AuthException();
                    }
                }else{
                   throw new InvalidNameServiceOperationException();
                }
            }  
        }else{
             throw new AuthException();
        }
    }
            
    private Token getToken(String tokenNro){
        return tokenPersistenceLocal.findTokenByNro(tokenNro);
    }
    private UserKremlin getUser(String userName){
        return userBeanLocal.getUserByName(userName);
    }
     private ServiceOperation getService(String serviceOperationName){
        return serviceBeanLocal.getServiceOperationByName(serviceOperationName);
    }

   
   
}
