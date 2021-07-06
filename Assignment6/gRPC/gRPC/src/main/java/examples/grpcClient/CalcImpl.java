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

public class CalcImpl extends CalcGrpc.CalcImplBase {

    public CalcImpl(){
        super();

    }

@Override
    public void add(CalcRequest request, StreamObserver<CalcResponse> responseObserver) {
        double sum = 0;
        CalcResponse.Builder responseBuilder = CalcResponse.newBuilder();
        try {

            for (Double i : request.getNumList()) {
                sum += i;
            }

            responseBuilder.setIsSuccess(true);
            responseBuilder.setSolution(sum);
            CalcResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e){
            responseBuilder.setIsSuccess(false);
            responseBuilder.setError("Addition function has failed.");
        }

    }

    @Override
    public void subtract(CalcRequest request, StreamObserver<CalcResponse> responseObserver) {
        double sub = request.getNum(0);
        CalcResponse.Builder responseBuilder = CalcResponse.newBuilder();
        try {

            for (int i = 1; i < request.getNumList().size(); i ++) {
                sub -= request.getNum(i);
            }

            responseBuilder.setIsSuccess(true);
            responseBuilder.setSolution(sub);
            CalcResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e){
            responseBuilder.setIsSuccess(false);
            responseBuilder.setError("Subtraction function has failed.");
        }

    }

    @Override
    public void multiply(CalcRequest request, StreamObserver<CalcResponse> responseObserver) {
        double mult = 1;
        CalcResponse.Builder responseBuilder = CalcResponse.newBuilder();
        try {

            for (Double i : request.getNumList()) {
                mult *= i;
            }

            responseBuilder.setIsSuccess(true);
            responseBuilder.setSolution(mult);
            CalcResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e){
            responseBuilder.setIsSuccess(false);
            responseBuilder.setError("Multiplication function has failed.");
        }

    }

    @Override
    public void divide(CalcRequest request, StreamObserver<CalcResponse> responseObserver) {
        double firstNum;
        double div;
        double sum = 0;
        CalcResponse.Builder responseBuilder = CalcResponse.newBuilder();
        try {

            firstNum = request.getNum(0);

            for (int i = 1; i < request.getNumList().size(); i ++) {
                sum += request.getNum(i);
            }

            div = firstNum/sum;

            responseBuilder.setIsSuccess(true);
            responseBuilder.setSolution(div);
            CalcResponse response = responseBuilder.build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e){
            responseBuilder.setIsSuccess(false);
            responseBuilder.setError("Division function has failed.");
        }

    }
}
