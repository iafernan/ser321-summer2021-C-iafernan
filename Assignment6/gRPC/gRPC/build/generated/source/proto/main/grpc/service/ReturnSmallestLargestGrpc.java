package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.1)",
    comments = "Source: services/returnsmallestlargest.proto")
public final class ReturnSmallestLargestGrpc {

  private ReturnSmallestLargestGrpc() {}

  public static final String SERVICE_NAME = "services.ReturnSmallestLargest";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.NumberRequest,
      service.NumberResponse> getSmallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "small",
      requestType = service.NumberRequest.class,
      responseType = service.NumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.NumberRequest,
      service.NumberResponse> getSmallMethod() {
    io.grpc.MethodDescriptor<service.NumberRequest, service.NumberResponse> getSmallMethod;
    if ((getSmallMethod = ReturnSmallestLargestGrpc.getSmallMethod) == null) {
      synchronized (ReturnSmallestLargestGrpc.class) {
        if ((getSmallMethod = ReturnSmallestLargestGrpc.getSmallMethod) == null) {
          ReturnSmallestLargestGrpc.getSmallMethod = getSmallMethod =
              io.grpc.MethodDescriptor.<service.NumberRequest, service.NumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "small"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.NumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.NumberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReturnSmallestLargestMethodDescriptorSupplier("small"))
              .build();
        }
      }
    }
    return getSmallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.NumberRequest,
      service.NumberResponse> getLargeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "large",
      requestType = service.NumberRequest.class,
      responseType = service.NumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.NumberRequest,
      service.NumberResponse> getLargeMethod() {
    io.grpc.MethodDescriptor<service.NumberRequest, service.NumberResponse> getLargeMethod;
    if ((getLargeMethod = ReturnSmallestLargestGrpc.getLargeMethod) == null) {
      synchronized (ReturnSmallestLargestGrpc.class) {
        if ((getLargeMethod = ReturnSmallestLargestGrpc.getLargeMethod) == null) {
          ReturnSmallestLargestGrpc.getLargeMethod = getLargeMethod =
              io.grpc.MethodDescriptor.<service.NumberRequest, service.NumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "large"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.NumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.NumberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReturnSmallestLargestMethodDescriptorSupplier("large"))
              .build();
        }
      }
    }
    return getLargeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReturnSmallestLargestStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReturnSmallestLargestStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReturnSmallestLargestStub>() {
        @java.lang.Override
        public ReturnSmallestLargestStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReturnSmallestLargestStub(channel, callOptions);
        }
      };
    return ReturnSmallestLargestStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReturnSmallestLargestBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReturnSmallestLargestBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReturnSmallestLargestBlockingStub>() {
        @java.lang.Override
        public ReturnSmallestLargestBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReturnSmallestLargestBlockingStub(channel, callOptions);
        }
      };
    return ReturnSmallestLargestBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReturnSmallestLargestFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReturnSmallestLargestFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReturnSmallestLargestFutureStub>() {
        @java.lang.Override
        public ReturnSmallestLargestFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReturnSmallestLargestFutureStub(channel, callOptions);
        }
      };
    return ReturnSmallestLargestFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ReturnSmallestLargestImplBase implements io.grpc.BindableService {

    /**
     */
    public void small(service.NumberRequest request,
        io.grpc.stub.StreamObserver<service.NumberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSmallMethod(), responseObserver);
    }

    /**
     */
    public void large(service.NumberRequest request,
        io.grpc.stub.StreamObserver<service.NumberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLargeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSmallMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                service.NumberRequest,
                service.NumberResponse>(
                  this, METHODID_SMALL)))
          .addMethod(
            getLargeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                service.NumberRequest,
                service.NumberResponse>(
                  this, METHODID_LARGE)))
          .build();
    }
  }

  /**
   */
  public static final class ReturnSmallestLargestStub extends io.grpc.stub.AbstractAsyncStub<ReturnSmallestLargestStub> {
    private ReturnSmallestLargestStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReturnSmallestLargestStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReturnSmallestLargestStub(channel, callOptions);
    }

    /**
     */
    public void small(service.NumberRequest request,
        io.grpc.stub.StreamObserver<service.NumberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSmallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void large(service.NumberRequest request,
        io.grpc.stub.StreamObserver<service.NumberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLargeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReturnSmallestLargestBlockingStub extends io.grpc.stub.AbstractBlockingStub<ReturnSmallestLargestBlockingStub> {
    private ReturnSmallestLargestBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReturnSmallestLargestBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReturnSmallestLargestBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.NumberResponse small(service.NumberRequest request) {
      return blockingUnaryCall(
          getChannel(), getSmallMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.NumberResponse large(service.NumberRequest request) {
      return blockingUnaryCall(
          getChannel(), getLargeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReturnSmallestLargestFutureStub extends io.grpc.stub.AbstractFutureStub<ReturnSmallestLargestFutureStub> {
    private ReturnSmallestLargestFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReturnSmallestLargestFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReturnSmallestLargestFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.NumberResponse> small(
        service.NumberRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSmallMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.NumberResponse> large(
        service.NumberRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLargeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SMALL = 0;
  private static final int METHODID_LARGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReturnSmallestLargestImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReturnSmallestLargestImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SMALL:
          serviceImpl.small((service.NumberRequest) request,
              (io.grpc.stub.StreamObserver<service.NumberResponse>) responseObserver);
          break;
        case METHODID_LARGE:
          serviceImpl.large((service.NumberRequest) request,
              (io.grpc.stub.StreamObserver<service.NumberResponse>) responseObserver);
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

  private static abstract class ReturnSmallestLargestBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReturnSmallestLargestBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.ReturnSmallestLargestProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReturnSmallestLargest");
    }
  }

  private static final class ReturnSmallestLargestFileDescriptorSupplier
      extends ReturnSmallestLargestBaseDescriptorSupplier {
    ReturnSmallestLargestFileDescriptorSupplier() {}
  }

  private static final class ReturnSmallestLargestMethodDescriptorSupplier
      extends ReturnSmallestLargestBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReturnSmallestLargestMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReturnSmallestLargestGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReturnSmallestLargestFileDescriptorSupplier())
              .addMethod(getSmallMethod())
              .addMethod(getLargeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
