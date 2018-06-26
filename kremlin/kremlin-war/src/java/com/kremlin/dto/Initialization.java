
package com.kremlin.dto;

import com.kremlin.auth.imp.AuthBeanLocal;
import com.kremlin.auth.imp.AuthException;
import com.kremlin.auth.imp.LoginUnsusefullException;
import com.kremlin.auth.imp.Token;
import com.kremlin.impl.InitializationBean;
import static com.kremlin.impl.InitializationBean.TOKEN;
import com.kremlin.impl.ServiceBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
 
@WebListener
public class Initialization implements ServletContextListener {
 
    @EJB
    private AuthBeanLocal authBeanLocal;
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            System.out.println("The application started");
            Token token=authBeanLocal.authentication("kremlin", "kremlin");
            InitializationBean.TOKEN=token.getToken();
        } catch (LoginUnsusefullException ex) {
            Logger.getLogger(Initialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AuthException ex) {
            Logger.getLogger(Initialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("The application stopped");
    }
}