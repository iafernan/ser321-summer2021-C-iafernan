// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/sort.proto

package service;

public interface SortRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.SortRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.services.Algo algo = 1;</code>
   * @return The enum numeric value on the wire for algo.
   */
  int getAlgoValue();
  /**
   * <code>.services.Algo algo = 1;</code>
   * @return The algo.
   */
  service.Algo getAlgo();

  /**
   * <pre>
   * represents the array to be sorted
   * </pre>
   *
   * <code>repeated int32 data = 2 [packed = true];</code>
   * @return A list containing the data.
   */
  java.util.List<java.lang.Integer> getDataList();
  /**
   * <pre>
   * represents the array to be sorted
   * </pre>
   *
   * <code>repeated int32 data = 2 [packed = true];</code>
   * @return The count of data.
   */
  int getDataCount();
  /**
   * <pre>
   * represents the array to be sorted
   * </pre>
   *
   * <code>repeated int32 data = 2 [packed = true];</code>
   * @param index The index of the element to return.
   * @return The data at the given index.
   */
  int getData(int index);
}
