package br.com.vitor.service;

import br.com.vitor.Discount;
import br.com.vitor.GetDiscountRequest;
import br.com.vitor.GetDiscountResponse;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

@GrpcService
public class DiscountService implements Discount {

    @Override
    public Uni<GetDiscountResponse> getDiscount(GetDiscountRequest request) {
        return Uni.createFrom().item(() -> GetDiscountResponse.newBuilder()
                .setPercentage(1f)
                .build());
    }
}
