package br.com.vitor;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.runtime.MutinyBean;

@javax.annotation.Generated(
value = "by Mutiny Grpc generator",
comments = "Source: discount.proto")
public class DiscountBean extends MutinyDiscountGrpc.DiscountImplBase implements BindableService, MutinyBean {

    private final Discount delegate;

    DiscountBean(@GrpcService Discount delegate) {
       this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<br.com.vitor.GetDiscountResponse> getDiscount(br.com.vitor.GetDiscountRequest request) {
       try {
         return delegate.getDiscount(request);
       } catch (UnsupportedOperationException e) {
          throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
       }
    }

}