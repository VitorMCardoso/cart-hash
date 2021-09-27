package br.com.vitor;

import io.quarkus.grpc.runtime.MutinyService;

@javax.annotation.Generated(
value = "by Mutiny Grpc generator",
comments = "Source: discount.proto")
public interface Discount extends MutinyService {

    
    io.smallrye.mutiny.Uni<br.com.vitor.GetDiscountResponse> getDiscount(br.com.vitor.GetDiscountRequest request);
    
    
    

}