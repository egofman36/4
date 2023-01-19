package org.evil.service;

import org.evil.domain.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/shop")
public class JerseyRest {
    //store Sport assortment
    private static Sport[] sportData = {
            new Sport("1", "Adidas", "Sports Equipment", "Tennis racquet", "-",8000),
            new Sport("2", "Adidas", "Sports Equipment", "Ball", "-",1500),
            new Sport("3", "Adidas", "Sports Equipment", "Bit", "-",1200),
            new Sport("4", "Nike", "Sports Equipment", "Tennis racquet", "-",1500),
            new Sport("5", "Puma ", "Sport", "Tracksuit", "XXL",7000)
    };
    // the number of products in the store
    private static int[] quantityData = {0, 2, 3, 5, 1};
    private static StoreAssortment storeAssortment = new StoreAssortment(sportData, quantityData);


    @POST
    @Path("/payment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response buySport(UserOrder userOrder) {
        int size = storeAssortment.getSports().length;
        for (int i = 0; i < size; i++) {
            Sport currentSport = storeAssortment.getSports()[i];
            if (currentSport.getId().equals(userOrder.getProductId())) {
                double orderPrice = currentSport.getPrice() * userOrder.getQuantity();
                PaymentResult goodResult = new PaymentResult(
                        currentSport.toString(),
                        userOrder.getQuantity(),
                        orderPrice,
                        "Buy successful!");
                return Response.ok(goodResult).build();
            }
        }
        PaymentResult badResult = new PaymentResult(
                userOrder.getProductId(),
                userOrder.getQuantity(),
                0,
                "Buy failure! Model with id = " + userOrder.getProductId() + " not found");
        return Response.ok(badResult).build();
    }

/*
    @GET
    @Path("/assortment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStoreCatalog() {
        return Response.ok(storeAssortment).build();
    }

 */
}
