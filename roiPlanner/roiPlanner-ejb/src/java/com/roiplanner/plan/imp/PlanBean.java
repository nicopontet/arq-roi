
package com.roiplanner.plan.imp;

import com.roiplanner.communication.ExternalOperationsHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.roiplanner.communication.CommunicationRouteSupplyErrorException;
import com.roiplanner.dto.RouteDTO;
import com.roiplanner.plan.imp.entity.Plan;
import com.roiplanner.plan.imp.entity.Section;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import java.lang.reflect.Type;

import javax.ejb.Stateless;
import com.roiplanner.plan.persistence.PlanPersistenceLocal;

import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import org.modelmapper.ModelMapper;

@Stateless
public class PlanBean implements PlanBeanLocal {

    @EJB
    private PlanPersistenceLocal planPersistence;
    private final Gson gson;
     private final ModelMapper modelMapper;
    
    public PlanBean() {
        this.gson = new Gson();
         
          this.modelMapper=new ModelMapper();
    }
   
    
    @Override
    public List<Plan> getPlan() {
        return planPersistence.findAll();
    }

    @Override
    public void createPlan(Plan plan) throws PlannerEJBException,CommunicationRouteSupplyErrorException {
        try{
            planPersistence.create(plan);
            Response responseCalc=ExternalOperationsHandler.callOperation("GetRouteSupply", "POST", "");
           if (responseCalc.getStatus() == Response.Status.OK.getStatusCode()) {  
               String routesString =responseCalc.readEntity(String.class);
               RouteDTO routes = gson.fromJson(routesString, RouteDTO.class);
        //mapea y lo convierte a DTO
                Type listType = new TypeToken<List<RouteDTO>>() {}.getType();
                List<Section> sections=modelMapper.map(routesString, listType);
                plan.setSections(sections);
                planPersistence.edit(plan);
           }else{
               String msgError = responseCalc.readEntity(String.class);
               throw new PlannerEJBException(msgError);
           } 
        }catch(PersistenceException ex){
             throw new PlannerEJBException("Error create plan");
        }catch(NullPointerException ex){
              throw new CommunicationRouteSupplyErrorException("Error communication");
        }
       
    }
    
    
}
