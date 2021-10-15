package br.com.vitor.resource;

import br.com.vitor.Discount;
import br.com.vitor.GetDiscountRequest;
import br.com.vitor.GetDiscountResponse;
import br.com.vitor.model.Product;
import br.com.vitor.model.Products;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class CartResourceTest {

    @Test
    public void addProduct() {

        given()
                .body(Products.builder()
                        .products(List.of(Product.builder()
                                .id(1)
                                .quantity(2)
                                .build())).build())
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/carrinho")
                .then()
                .statusCode(200)
                .body("totalAmount", is(30314));
    }
}
