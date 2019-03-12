// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hpi/cloud/common/v1test/social_profiles.proto

package de.hpi.cloud.common.v1test;

public interface SocialProfilesOrBuilder extends
    // @@protoc_insertion_point(interface_extends:hpi.cloud.common.v1test.SocialProfiles)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Optional.
   *
   * The Telegram handle.
   * </pre>
   *
   * <code>string telegram = 1;</code>
   */
  java.lang.String getTelegram();
  /**
   * <pre>
   * Optional.
   *
   * The Telegram handle.
   * </pre>
   *
   * <code>string telegram = 1;</code>
   */
  com.google.protobuf.ByteString
      getTelegramBytes();

  /**
   * <pre>
   * Optional.
   *
   * The Slack handles.
   * </pre>
   *
   * <code>repeated .hpi.cloud.common.v1test.SocialProfiles.Slack slacks = 2;</code>
   */
  java.util.List<de.hpi.cloud.common.v1test.SocialProfiles.Slack> 
      getSlacksList();
  /**
   * <pre>
   * Optional.
   *
   * The Slack handles.
   * </pre>
   *
   * <code>repeated .hpi.cloud.common.v1test.SocialProfiles.Slack slacks = 2;</code>
   */
  de.hpi.cloud.common.v1test.SocialProfiles.Slack getSlacks(int index);
  /**
   * <pre>
   * Optional.
   *
   * The Slack handles.
   * </pre>
   *
   * <code>repeated .hpi.cloud.common.v1test.SocialProfiles.Slack slacks = 2;</code>
   */
  int getSlacksCount();
  /**
   * <pre>
   * Optional.
   *
   * The Slack handles.
   * </pre>
   *
   * <code>repeated .hpi.cloud.common.v1test.SocialProfiles.Slack slacks = 2;</code>
   */
  java.util.List<? extends de.hpi.cloud.common.v1test.SocialProfiles.SlackOrBuilder> 
      getSlacksOrBuilderList();
  /**
   * <pre>
   * Optional.
   *
   * The Slack handles.
   * </pre>
   *
   * <code>repeated .hpi.cloud.common.v1test.SocialProfiles.Slack slacks = 2;</code>
   */
  de.hpi.cloud.common.v1test.SocialProfiles.SlackOrBuilder getSlacksOrBuilder(
      int index);

  /**
   * <pre>
   * Optional.
   *
   * The GitHub username (not display name!).
   * </pre>
   *
   * <code>string github = 3;</code>
   */
  java.lang.String getGithub();
  /**
   * <pre>
   * Optional.
   *
   * The GitHub username (not display name!).
   * </pre>
   *
   * <code>string github = 3;</code>
   */
  com.google.protobuf.ByteString
      getGithubBytes();

  /**
   * <pre>
   * Optional.
   *
   * The Twitter handle.
   * </pre>
   *
   * <code>string twitter = 4;</code>
   */
  java.lang.String getTwitter();
  /**
   * <pre>
   * Optional.
   *
   * The Twitter handle.
   * </pre>
   *
   * <code>string twitter = 4;</code>
   */
  com.google.protobuf.ByteString
      getTwitterBytes();

  /**
   * <pre>
   * Optional.
   *
   * The Instagram handle.
   * </pre>
   *
   * <code>string instagram = 5;</code>
   */
  java.lang.String getInstagram();
  /**
   * <pre>
   * Optional.
   *
   * The Instagram handle.
   * </pre>
   *
   * <code>string instagram = 5;</code>
   */
  com.google.protobuf.ByteString
      getInstagramBytes();

  /**
   * <pre>
   * Optional.
   *
   * The Facebook handle.
   * </pre>
   *
   * <code>string facebook = 6;</code>
   */
  java.lang.String getFacebook();
  /**
   * <pre>
   * Optional.
   *
   * The Facebook handle.
   * </pre>
   *
   * <code>string facebook = 6;</code>
   */
  com.google.protobuf.ByteString
      getFacebookBytes();

  /**
   * <pre>
   * Optional.
   *
   * The LinkedIn handle.
   * </pre>
   *
   * <code>string linkedIn = 7;</code>
   */
  java.lang.String getLinkedIn();
  /**
   * <pre>
   * Optional.
   *
   * The LinkedIn handle.
   * </pre>
   *
   * <code>string linkedIn = 7;</code>
   */
  com.google.protobuf.ByteString
      getLinkedInBytes();
}
