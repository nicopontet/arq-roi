
package com.roisupplying.resources;

import com.google.gson.Gson;
import com.roisupplying.order.entity.OrderSupplying;
import com.roisupplying.order.imp.OrderBean;
import com.roisupplying.order.imp.OrderBeanLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("orders")
public class OrderResource {
   
    @EJB
    OrderBeanLocal orderBeanLocal;
    private final Gson gson;
    
    public OrderResource() {
        this.gson = new Gson();
    }
    
    @GET
    @Path("/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrder(@PathParam("orderId") int orderId) {
        OrderSupplying order = orderBeanLocal.getOrder(orderId);

        if (order == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        
        return Response
                .status(Response.Status.OK)
                .entity(gson.toJson(order))
                .build();
    }
    
}
