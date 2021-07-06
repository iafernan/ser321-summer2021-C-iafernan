package examples.grpcClient;

import io.grpc.stub.StreamObserver;
import service.*;

import org.json.JSONObject;

import java.util.ArrayList;

public class StoryImpl extends StoryGrpc.StoryImplBase{

    JSONObject story = new JSONObject();
    private ArrayList<String> sentences = new ArrayList<String>();

    public StoryImpl(){
        super();
    }

@Override
    public void read(Empty empty, StreamObserver<ReadResponse> responseObserver){

    System.out.println("Received from client: read request");
        ReadResponse.Builder responseBuilder = ReadResponse.newBuilder();

    try {
        if(sentences.isEmpty()){
            sentences.add("There is no story to tell yet.  Please add a sentence.");
            responseBuilder.setIsSuccess(true);
            responseBuilder.setSentence(sentences.toString());
            sentences.clear();
        }else {
            responseBuilder.setIsSuccess(true);
            responseBuilder.setSentence(sentences.toString());
        }
        ReadResponse resp = responseBuilder.build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    } catch (Exception e){
        responseBuilder.setIsSuccess(false);
        responseBuilder.setError("Failed to return the story.");
    }



}

@Override
    public void write(WriteRequest req, StreamObserver<WriteResponse> responseObserver){
    WriteResponse.Builder responseBuilder = WriteResponse.newBuilder();

    try {
      System.out.println("Received from client: " + req.getNewSentence());
      sentences.add(req.getNewSentence());
      story.put("datatype", 1);
      story.put("type", "sentence");
      story.put("data", sentences.toString());
      responseBuilder.setIsSuccess(true);
      responseBuilder.setStory(story.getString("data"));
      WriteResponse resp = responseBuilder.build();
      responseObserver.onNext(resp);
      responseObserver.onCompleted();

    } catch (Exception e){
      responseBuilder.setIsSuccess(false);
      responseBuilder.setError("Failed to return the story.");
}

}
}
