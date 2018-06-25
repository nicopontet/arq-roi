
package com.kremlin.auth.imp;

import javax.ejb.Local;

@Local
public interface AuthBeanLocal {
   Token authentication(String name, String pass) throws LoginUnsusefullException,AuthException;
   void validateToken(String tokenNro) throws AuthException;
   void authorizationByAnnotation(String tokenNro, TypeAccess methodAccess)throws AuthException;
   void authorizationByOperationName(String tokenNro, String serviceOperationName) throws AuthException,InvalidNameServiceOperationException;
   
}
