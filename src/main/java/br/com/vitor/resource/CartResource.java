package br.com.vitor.resource;

import br.com.vitor.domain.response.CartResponse;
import br.com.vitor.model.Products;
import br.com.vitor.service.CarService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/carrinho")
public class CartResource {

    @Inject
    CarService carService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CartResponse addProduct(Products products) throws IOException {
        return carService.checkJsonCart(products);
    }
}
