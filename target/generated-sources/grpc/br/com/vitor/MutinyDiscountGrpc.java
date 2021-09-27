package br.com.vitor;

import static br.com.vitor.DiscountGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated(
value = "by Mutiny Grpc generator",
comments = "Source: discount.proto")
public final class MutinyDiscountGrpc implements io.quarkus.grpc.runtime.MutinyGrpc {
    private MutinyDiscountGrpc() {}

    public static MutinyDiscountStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyDiscountStub(channel);
    }

    /**
     * <pre>
     *  Service that return mocked discount percentage.
     * </pre>
     */
    public static final class MutinyDiscountStub extends io.grpc.stub.AbstractStub<MutinyDiscountStub> implements io.quarkus.grpc.runtime.MutinyStub {
        private DiscountGrpc.DiscountStub delegateStub;

        private MutinyDiscountStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = DiscountGrpc.newStub(channel);
        }

        private MutinyDiscountStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = DiscountGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyDiscountStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyDiscountStub(channel, callOptions);
        }

        
        public io.smallrye.mutiny.Uni<br.com.vitor.GetDiscountResponse> getDiscount(br.com.vitor.GetDiscountRequest request) {
            return io.quarkus.grpc.runtime.ClientCalls.oneToOne(request, delegateStub::getDiscount);
        }

    }

    /**
     * <pre>
     *  Service that return mocked discount percentage.
     * </pre>
     */
    public static abstract class DiscountImplBase implements io.grpc.BindableService {

        private String compression;
        /**
        * Set whether the server will try to use a compressed response.
        *
        * @param compression the compression, e.g {@code gzip}
        */
        public DiscountImplBase withCompression(String compression) {
        this.compression = compression;
        return this;
        }


        
        public io.smallrye.mutiny.Uni<br.com.vitor.GetDiscountResponse> getDiscount(br.com.vitor.GetDiscountRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            br.com.vitor.DiscountGrpc.getGetDiscountMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            br.com.vitor.GetDiscountRequest,
                                            br.com.vitor.GetDiscountResponse>(
                                            this, METHODID_GET_DISCOUNT, compression)))
                    .build();
        }
    }

    private static final int METHODID_GET_DISCOUNT = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final DiscountImplBase serviceImpl;
        private final int methodId;
        private final String compression;

        MethodHandlers(DiscountImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_GET_DISCOUNT:
                    io.quarkus.grpc.runtime.ServerCalls.oneToOne((br.com.vitor.GetDiscountRequest) request,
                            (io.grpc.stub.StreamObserver<br.com.vitor.GetDiscountResponse>) responseObserver,
                            compression,
                            serviceImpl::getDiscount);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}