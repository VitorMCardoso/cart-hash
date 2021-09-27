package br.com.vitor.service;

import br.com.vitor.Discount;
import br.com.vitor.DiscountClient;
import br.com.vitor.GetDiscountRequest;
import br.com.vitor.GetDiscountResponse;
import br.com.vitor.domain.response.CartResponse;
import br.com.vitor.domain.response.ProductsResponse;
import br.com.vitor.model.ProductJson;
import br.com.vitor.model.Products;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped
public class CarService {

    @Inject
    DiscountClient discount;

    public CartResponse checkJsonCart(Products products) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        AtomicReference<Float> percent = new AtomicReference<>(0.0f);
        AtomicReference<ProductsResponse> productsResponse = new AtomicReference<>(new ProductsResponse());
        List<ProductsResponse> productsResponseList = new ArrayList<>();
        File file = new File(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("products.json")).getFile()
        );
        List<ProductJson> productJsonList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, ProductJson.class));
        products.getProducts().forEach(product -> {
            ProductJson productJson = productJsonList.stream().filter(p -> p.getId().equals(product.getId())).findAny().orElse(null);
            if (productJson == null) {
                System.out.println("NOT EXIST");
            } else {
                Uni<GetDiscountResponse> discountProduct = this.discount.getDiscount(GetDiscountRequest.newBuilder().setProductID(product.getId()).build());
                discountProduct.onItem().transform(GetDiscountResponse::getPercentage).subscribe().with(percent::set);
                productsResponse.set(ProductsResponse.builder()
                        .id(product.getId())
                        .quantity(product.getQuantity())
                        .unitAmount(productJson.getAmount())
                        .totalAmount(productJson.getAmount() * product.getQuantity())
                        .discount(percent.get())
                        .isGift(productJson.getIsGift())
                        .build());
                productsResponseList.add(productsResponse.get());
            }
        });
        long sumAmount = productsResponseList.stream().mapToLong(ProductsResponse::getTotalAmount).sum();
        double sumDiscount = productsResponseList.stream().mapToDouble(ProductsResponse::getDiscount).sum();
        return CartResponse.builder()
                .totalAmount(sumAmount)
                .totalAmountWithDiscount((long) (sumAmount-sumDiscount))
                .totalDiscount(sumDiscount)
                .products(productsResponseList)
                .build();
    }
}
