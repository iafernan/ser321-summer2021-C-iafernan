// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/returnsmallestlargest.proto

package service;

public final class ReturnSmallestLargestProto {
  private ReturnSmallestLargestProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_NumberRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_NumberRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_NumberResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_NumberResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n$services/returnsmallestlargest.proto\022\010" +
      "services\"\034\n\rNumberRequest\022\013\n\003num\030\001 \003(\001\"D" +
      "\n\016NumberResponse\022\021\n\tisSuccess\030\001 \001(\010\022\020\n\010s" +
      "olution\030\002 \001(\001\022\r\n\005error\030\003 \001(\t2\223\001\n\025ReturnS" +
      "mallestLargest\022<\n\005small\022\027.services.Numbe" +
      "rRequest\032\030.services.NumberResponse\"\000\022<\n\005" +
      "large\022\027.services.NumberRequest\032\030.service" +
      "s.NumberResponse\"\000B\'\n\007serviceB\032ReturnSma" +
      "llestLargestProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_services_NumberRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_services_NumberRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_NumberRequest_descriptor,
        new java.lang.String[] { "Num", });
    internal_static_services_NumberResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_services_NumberResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_NumberResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Solution", "Error", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}