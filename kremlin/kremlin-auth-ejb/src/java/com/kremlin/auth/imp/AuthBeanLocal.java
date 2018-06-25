
package com.kremlin.auth.imp;

import javax.ejb.Local;

@Local
public interface AuthBeanLocal {
   Token login(String name, String pass) throws LoginUnsusefullException,AuthException;
}
