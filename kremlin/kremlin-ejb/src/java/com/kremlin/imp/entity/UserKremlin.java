
package com.kremlin.imp.entity;

//import com.kremlin.imp.entity.Application;
//import com.kremlin.imp.entity.Application;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class UserKremlin implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   int id;
   String username;
   String password;
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="application_id")    
   Application application;
   boolean userExternal;

    public UserKremlin() {
    }

    public UserKremlin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public boolean isUserExternal() {
        return userExternal;
    }

    public void setUserExternal(boolean userExternal) {
        this.userExternal = userExternal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   
}
