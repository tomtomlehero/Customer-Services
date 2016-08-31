package fr.mla.customer.service;


import fr.mla.customer.api.swagger.model.Card;
import fr.mla.customer.api.swagger.model.Customer;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@WebService
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CustomerService {


/**
     searchCustomers
     GET         http://127.0.0.1:10210/customerRep/v1/customers/

     createCustomer
     POST        http://127.0.0.1:10210/customerRep/v1/customers/

     deleteCustomer
     DELETE      http://127.0.0.1:10210/customerRep/v1/customers/f12c9c4b-9e31-4ef2-ae9e-41a2de918978

     viewCustomer
     GET         http://127.0.0.1:10210/customerRep/v1/customers/f12c9c4b-9e31-4ef2-ae9e-41a2de918978

     updateCustomer
     PUT         http://127.0.0.1:10210/customerRep/v1/customers/f12c9c4b-9e31-4ef2-ae9e-41a2de918978

     createCustomerCard
     POST        http://127.0.0.1:10210/customerRep/v1/customers/f12c9c4b-9e31-4ef2-ae9e-41a2de918978/cards

     deleteCustomerCard
     DELETE      http://127.0.0.1:10210/customerRep/v1/customers/f12c9c4b-9e31-4ef2-ae9e-41a2de918978/cards/123456

     updateCustomerCard
     PUT         http://127.0.0.1:10210/customerRep/v1/customers/f12c9c4b-9e31-4ef2-ae9e-41a2de918978/cards/123456
*/




    @GET
    @Path("/")
    Response searchCustomers(
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName,
            @QueryParam("phone") String phone,
            @QueryParam("email") String email,
            @QueryParam("extId") String extId,
            @QueryParam("soundex") Boolean soundex,
            @QueryParam("algo") Integer algo,
            @QueryParam("view") String view);

    @POST
    @Path("/")
    Response createCustomer(
            Customer customer);

    @DELETE
    @Path("/{id}")
    Response deleteCustomer(
            @PathParam("id") String id);

    @GET
    @Path("/{id}")
    Response viewCustomer(
            @PathParam("id") String id,
            @QueryParam("view") String view);

    @PUT
    @Path("/{id}")
    Response updateCustomer(
            @PathParam("id") String id,
            Customer customer);

    @POST
    @Path("/{id}/cards")
    Response createCustomerCard(
            @PathParam("id") String id,
            Card card);

    @DELETE
    @Path("/{id}/cards/{cardId}")
    Response deleteCustomerCard(
            @PathParam("id") String id,
            @PathParam("cardId") String cardId);

    @PUT
    @Path("/{id}/cards/{cardId}")
    Response updateCustomerCard(
            @PathParam("id") String id,
            @PathParam("cardId") String cardId,
            Card card);

}
