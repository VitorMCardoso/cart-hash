package br.com.vitor.service;

import br.com.vitor.Discount;
import br.com.vitor.GetDiscountRequest;
import br.com.vitor.GetDiscountResponse;
import br.com.vitor.domain.response.CartResponse;
import br.com.vitor.domain.response.ProductsResponse;
import br.com.vitor.model.ProductJson;
import br.com.vitor.model.Products;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.BadRequestException;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@ApplicationScoped
public class CartService {

    @GrpcClient
    Discount discount;

    @ConfigProperty(name = "cart.json.file.path")
    String jsonFilePath;

    @ConfigProperty(name = "is.production")
    Boolean isProduction;

    @ConfigProperty(name = "without.grpc")
    Boolean withoutGrpc;

    public CartResponse checkJsonCart(Products products) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        AtomicReference<Float> percent = new AtomicReference<>(0.0f);
        AtomicReference<ProductsResponse> productsResponse = new AtomicReference<>(new ProductsResponse());
        AtomicReference<ProductJson> productGift = new AtomicReference<>(new ProductJson());
        List<ProductsResponse> productsResponseList = new ArrayList<>();
        File file = new File(isProduction ? jsonFilePath :
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("products.json")).getFile()
        );
        List<ProductJson> productJsonList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, ProductJson.class));
        products.getProducts().forEach(product -> {
            ProductJson productJson = productJsonList.stream().filter(p -> p.getId().equals(product.getId())).findAny().orElse(null);
            if (productJson == null) {
                throw new BadRequestException("Produto Inexistente Id: " + product.getId());
            } else {
                try {
                    if (!withoutGrpc) {
                        percent.set(this.discount.getDiscount(GetDiscountRequest.newBuilder().setProductID(product.getId()).build())
                                .onItem()
                                .transform(GetDiscountResponse::getPercentage)
                                .subscribe().asCompletionStage().get() / 100);
                    }

                    productsResponse.set(ProductsResponse.builder()
                            .id(product.getId())
                            .quantity(product.getQuantity())
                            .unitAmount(productJson.getAmount())
                            .totalAmount(productJson.getAmount() * product.getQuantity())
                            .discount((long) (percent.get() * productJson.getAmount()) * product.getQuantity())
                            .isGift(false)
                            .build());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                productsResponseList.add(productsResponse.get());

                List<ProductJson> productsIsGift = productJsonList.stream().filter(p -> p.getIsGift().equals(true)).collect(Collectors.toList());
                productGift.set(productsIsGift.stream().findAny().isPresent() ? productsIsGift.stream().findAny().get() : null);

            }
        });
        long sumAmount = productsResponseList.stream().mapToLong(ProductsResponse::getTotalAmount).sum();
        long sumDiscount = productsResponseList.stream().mapToLong(ProductsResponse::getDiscount).sum();

        checkBlackFriday(productGift, productsResponseList);

        return CartResponse.builder()
                .totalAmount(sumAmount)
                .totalAmountWithDiscount(sumAmount - sumDiscount)
                .totalDiscount(sumDiscount)
                .products(productsResponseList)
                .build();
    }

    private void checkBlackFriday(AtomicReference<ProductJson> productGift, List<ProductsResponse> productsResponseList) {
        Calendar c = Calendar.getInstance();
        Date today = c.getTime();
        c.set(Calendar.getInstance().getWeekYear(), Calendar.NOVEMBER, 22);
        Date dateSpecified = c.getTime();

        if (dateSpecified.equals(today) && productGift.get() != null) {
            productsResponseList.add(ProductsResponse.builder()
                    .id(productGift.get().getId())
                    .quantity(1)
                    .unitAmount(0L)
                    .totalAmount(0L)
                    .discount(0L)
                    .isGift(productGift.get().getIsGift())
                    .build());
        }
    }
}
