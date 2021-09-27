package br.com.vitor;

import java.util.function.BiFunction;

import io.quarkus.grpc.runtime.MutinyClient;

@javax.annotation.Generated(
value = "by Mutiny Grpc generator",
comments = "Source: discount.proto")
public class DiscountClient implements Discount, MutinyClient<MutinyDiscountGrpc.MutinyDiscountStub> {

    private final MutinyDiscountGrpc.MutinyDiscountStub stub;

    public DiscountClient(String name, io.grpc.Channel channel, BiFunction<String, MutinyDiscountGrpc.MutinyDiscountStub, MutinyDiscountGrpc.MutinyDiscountStub> stubConfigurator) {
       this.stub = stubConfigurator.apply(name,MutinyDiscountGrpc.newMutinyStub(channel));
    }

    @Override
    public MutinyDiscountGrpc.MutinyDiscountStub getStub() {
       return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<br.com.vitor.GetDiscountResponse> getDiscount(br.com.vitor.GetDiscountRequest request) {
       return stub.getDiscount(request);
    }

}