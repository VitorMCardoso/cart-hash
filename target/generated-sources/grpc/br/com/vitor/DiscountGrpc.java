package br.com.vitor;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service that return mocked discount percentage.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.38.1)",
    comments = "Source: discount.proto")
public final class DiscountGrpc {

  private DiscountGrpc() {}

  public static final String SERVICE_NAME = "discount.Discount";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.com.vitor.GetDiscountRequest,
      br.com.vitor.GetDiscountResponse> getGetDiscountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDiscount",
      requestType = br.com.vitor.GetDiscountRequest.class,
      responseType = br.com.vitor.GetDiscountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.vitor.GetDiscountRequest,
      br.com.vitor.GetDiscountResponse> getGetDiscountMethod() {
    io.grpc.MethodDescriptor<br.com.vitor.GetDiscountRequest, br.com.vitor.GetDiscountResponse> getGetDiscountMethod;
    if ((getGetDiscountMethod = DiscountGrpc.getGetDiscountMethod) == null) {
      synchronized (DiscountGrpc.class) {
        if ((getGetDiscountMethod = DiscountGrpc.getGetDiscountMethod) == null) {
          DiscountGrpc.getGetDiscountMethod = getGetDiscountMethod =
              io.grpc.MethodDescriptor.<br.com.vitor.GetDiscountRequest, br.com.vitor.GetDiscountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDiscount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.vitor.GetDiscountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.vitor.GetDiscountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DiscountMethodDescriptorSupplier("GetDiscount"))
              .build();
        }
      }
    }
    return getGetDiscountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DiscountStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DiscountStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DiscountStub>() {
        @java.lang.Override
        public DiscountStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DiscountStub(channel, callOptions);
        }
      };
    return DiscountStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DiscountBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DiscountBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DiscountBlockingStub>() {
        @java.lang.Override
        public DiscountBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DiscountBlockingStub(channel, callOptions);
        }
      };
    return DiscountBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DiscountFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DiscountFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DiscountFutureStub>() {
        @java.lang.Override
        public DiscountFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DiscountFutureStub(channel, callOptions);
        }
      };
    return DiscountFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service that return mocked discount percentage.
   * </pre>
   */
  public static abstract class DiscountImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDiscount(br.com.vitor.GetDiscountRequest request,
        io.grpc.stub.StreamObserver<br.com.vitor.GetDiscountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDiscountMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDiscountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                br.com.vitor.GetDiscountRequest,
                br.com.vitor.GetDiscountResponse>(
                  this, METHODID_GET_DISCOUNT)))
          .build();
    }
  }

  /**
   * <pre>
   * Service that return mocked discount percentage.
   * </pre>
   */
  public static final class DiscountStub extends io.grpc.stub.AbstractAsyncStub<DiscountStub> {
    private DiscountStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiscountStub(channel, callOptions);
    }

    /**
     */
    public void getDiscount(br.com.vitor.GetDiscountRequest request,
        io.grpc.stub.StreamObserver<br.com.vitor.GetDiscountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDiscountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service that return mocked discount percentage.
   * </pre>
   */
  public static final class DiscountBlockingStub extends io.grpc.stub.AbstractBlockingStub<DiscountBlockingStub> {
    private DiscountBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiscountBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.vitor.GetDiscountResponse getDiscount(br.com.vitor.GetDiscountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDiscountMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service that return mocked discount percentage.
   * </pre>
   */
  public static final class DiscountFutureStub extends io.grpc.stub.AbstractFutureStub<DiscountFutureStub> {
    private DiscountFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiscountFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.vitor.GetDiscountResponse> getDiscount(
        br.com.vitor.GetDiscountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDiscountMethod(), getCallOptions()), request);
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

    MethodHandlers(DiscountImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DISCOUNT:
          serviceImpl.getDiscount((br.com.vitor.GetDiscountRequest) request,
              (io.grpc.stub.StreamObserver<br.com.vitor.GetDiscountResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DiscountBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DiscountBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.vitor.DiscountProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Discount");
    }
  }

  private static final class DiscountFileDescriptorSupplier
      extends DiscountBaseDescriptorSupplier {
    DiscountFileDescriptorSupplier() {}
  }

  private static final class DiscountMethodDescriptorSupplier
      extends DiscountBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DiscountMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DiscountGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DiscountFileDescriptorSupplier())
              .addMethod(getGetDiscountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
