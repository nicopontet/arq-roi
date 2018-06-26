package com.kremlin.resources;

import java.util.Set;
import javax.ws.rs.core.Application;
import com.kremlin.auth.resource.filter.AuthorizeFilter;

@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.kremlin.resources.LoginResource.class);
        resources.add(com.kremlin.resources.ServiceResource.class);
        resources.add(com.kremlin.auth.resource.filter.AuthorizeFilter.class); 
    }
    
}
