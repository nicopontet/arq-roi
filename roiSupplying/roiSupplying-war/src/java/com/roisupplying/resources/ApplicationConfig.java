package com.roisupplying.resources;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.roisupplying.filter.AuthorizeOnlyKremlinFilter.class);
        resources.add(com.roisupplying.resources.OrderResource.class);
    }
    
}
