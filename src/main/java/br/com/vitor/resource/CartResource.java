package br.com.vitor.resource;

import br.com.vitor.model.Products;
import br.com.vitor.service.CartService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/carrinho")
public class CartResource {

    @Inject
    CartService carService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Products products) throws IOException {
        return Response.ok(carService.checkJsonCart(products)).build();
    }
}
