package examples.grpcClient;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerMethodDefinition;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import service.*;
import java.util.Stack;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import buffers.RequestProtos.Request;
import buffers.RequestProtos.Request.RequestType;
import buffers.ResponseProtos.Response;

public class ReturnSmallestLargestImpl extends ReturnSmallestLargestGrpc.ReturnSmallestLargestImplBase{

    public ReturnSmallestLargestImpl(){
        super();
    }

    @Override
    public void small(NumberRequest request, StreamObserver<NumberResponse> responseObserver){
        NumberResponse.Builder responseBuilder = NumberResponse.newBuilder();
        double small = request.getNum(0);
        try {

            for (int i = 1; i < request.getNumList().size(); i ++) {
                if(small > request.getNum(i)){
                    small = request.getNum(i);
                }
            }

            responseBuilder.setIsSuccess(true);
            responseBuilder.setSolution(small);
            NumberResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e){
            responseBuilder.setIsSuccess(false);
            responseBuilder.setError("Function has failed.");
        }
    }

    @Override
    public void large(NumberRequest request, StreamObserver<NumberResponse> responseObserver){
        NumberResponse.Builder responseBuilder = NumberResponse.newBuilder();
        double large = request.getNum(0);
        try {

            for (int i = 1; i < request.getNumList().size(); i ++) {
                if(large < request.getNum(i)){
                    large = request.getNum(i);
                }
            }

            responseBuilder.setIsSuccess(true);
            responseBuilder.setSolution(large);
            NumberResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e){
            responseBuilder.setIsSuccess(false);
            responseBuilder.setError("Function has failed.");
        }
    }
}
