// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hpi/cloud/common/v1test/social_profiles.proto

package de.hpi.cloud.common.v1test;

public final class SocialProfilesProto {
  private SocialProfilesProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_hpi_cloud_common_v1test_SocialProfiles_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_hpi_cloud_common_v1test_SocialProfiles_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_Workspace_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_Workspace_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n-hpi/cloud/common/v1test/social_profile" +
      "s.proto\022\027hpi.cloud.common.v1test\"\310\002\n\016Soc" +
      "ialProfiles\022\020\n\010telegram\030\001 \001(\t\022=\n\006slacks\030" +
      "\002 \003(\0132-.hpi.cloud.common.v1test.SocialPr" +
      "ofiles.Slack\022\016\n\006github\030\003 \001(\t\022\017\n\007twitter\030" +
      "\004 \001(\t\022\021\n\tinstagram\030\005 \001(\t\022\020\n\010facebook\030\006 \001" +
      "(\t\022\020\n\010linkedIn\030\007 \001(\t\032\214\001\n\005Slack\022J\n\tworksp" +
      "ace\030\001 \001(\01327.hpi.cloud.common.v1test.Soci" +
      "alProfiles.Slack.Workspace\022\020\n\010username\030\002" +
      " \001(\t\032%\n\tWorkspace\022\n\n\002id\030\001 \001(\t\022\014\n\004name\030\002 " +
      "\001(\tB3\n\032de.hpi.cloud.common.v1testB\023Socia" +
      "lProfilesProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_hpi_cloud_common_v1test_SocialProfiles_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_hpi_cloud_common_v1test_SocialProfiles_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_hpi_cloud_common_v1test_SocialProfiles_descriptor,
        new java.lang.String[] { "Telegram", "Slacks", "Github", "Twitter", "Instagram", "Facebook", "LinkedIn", });
    internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_descriptor =
      internal_static_hpi_cloud_common_v1test_SocialProfiles_descriptor.getNestedTypes().get(0);
    internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_descriptor,
        new java.lang.String[] { "Workspace", "Username", });
    internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_Workspace_descriptor =
      internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_descriptor.getNestedTypes().get(0);
    internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_Workspace_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_hpi_cloud_common_v1test_SocialProfiles_Slack_Workspace_descriptor,
        new java.lang.String[] { "Id", "Name", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}