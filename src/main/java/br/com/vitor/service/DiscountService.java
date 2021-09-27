package br.com.vitor.service;

import br.com.vitor.*;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;

@GrpcService
public class DiscountService extends MutinyDiscountGrpc.DiscountImplBase {

    @Override
    public Uni<GetDiscountResponse> getDiscount(GetDiscountRequest request) {
        return super.getDiscount(request);
    }
}
