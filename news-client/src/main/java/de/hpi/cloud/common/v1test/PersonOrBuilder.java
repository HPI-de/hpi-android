// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hpi/cloud/common/v1test/person.proto

package de.hpi.cloud.common.v1test;

public interface PersonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:hpi.cloud.common.v1test.Person)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required.
   * 
   * The unique ID of this person.
   * </pre>
   *
   * <code>string id = 1;</code>
   */
  java.lang.String getId();
  /**
   * <pre>
   * Required.
   * 
   * The unique ID of this person.
   * </pre>
   *
   * <code>string id = 1;</code>
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <pre>
   * The name of an individual person.
   * </pre>
   *
   * <code>.hpi.cloud.common.v1test.Person.Name person_name = 2;</code>
   */
  boolean hasPersonName();
  /**
   * <pre>
   * The name of an individual person.
   * </pre>
   *
   * <code>.hpi.cloud.common.v1test.Person.Name person_name = 2;</code>
   */
  de.hpi.cloud.common.v1test.Person.Name getPersonName();
  /**
   * <pre>
   * The name of an individual person.
   * </pre>
   *
   * <code>.hpi.cloud.common.v1test.Person.Name person_name = 2;</code>
   */
  de.hpi.cloud.common.v1test.Person.NameOrBuilder getPersonNameOrBuilder();

  /**
   * <pre>
   * The name of an organization.
   * </pre>
   *
   * <code>string organization_name = 3;</code>
   */
  java.lang.String getOrganizationName();
  /**
   * <pre>
   * The name of an organization.
   * </pre>
   *
   * <code>string organization_name = 3;</code>
   */
  com.google.protobuf.ByteString
      getOrganizationNameBytes();

  /**
   * <pre>
   * Required.
   *
   * The gender of this person.
   * </pre>
   *
   * <code>.hpi.cloud.common.v1test.Person.Gender gender = 4;</code>
   */
  boolean hasGender();
  /**
   * <pre>
   * Required.
   *
   * The gender of this person.
   * </pre>
   *
   * <code>.hpi.cloud.common.v1test.Person.Gender gender = 4;</code>
   */
  de.hpi.cloud.common.v1test.Person.Gender getGender();
  /**
   * <pre>
   * Required.
   *
   * The gender of this person.
   * </pre>
   *
   * <code>.hpi.cloud.common.v1test.Person.Gender gender = 4;</code>
   */
  de.hpi.cloud.common.v1test.Person.GenderOrBuilder getGenderOrBuilder();

  /**
   * <pre>
   * Optional.
   *
   * The date of birth.
   * </pre>
   *
   * <code>.google.type.Date date_of_birth = 5;</code>
   */
  boolean hasDateOfBirth();
  /**
   * <pre>
   * Optional.
   *
   * The date of birth.
   * </pre>
   *
   * <code>.google.type.Date date_of_birth = 5;</code>
   */
  com.google.type.Date getDateOfBirth();
  /**
   * <pre>
   * Optional.
   *
   * The date of birth.
   * </pre>
   *
   * <code>.google.type.Date date_of_birth = 5;</code>
   */
  com.google.type.DateOrBuilder getDateOfBirthOrBuilder();

  /**
   * <pre>
   * Optional.
   *
   * The email addresses of this person.
   * </pre>
   *
   * <code>repeated string email_addresses = 6;</code>
   */
  java.util.List<java.lang.String>
      getEmailAddressesList();
  /**
   * <pre>
   * Optional.
   *
   * The email addresses of this person.
   * </pre>
   *
   * <code>repeated string email_addresses = 6;</code>
   */
  int getEmailAddressesCount();
  /**
   * <pre>
   * Optional.
   *
   * The email addresses of this person.
   * </pre>
   *
   * <code>repeated string email_addresses = 6;</code>
   */
  java.lang.String getEmailAddresses(int index);
  /**
   * <pre>
   * Optional.
   *
   * The email addresses of this person.
   * </pre>
   *
   * <code>repeated string email_addresses = 6;</code>
   */
  com.google.protobuf.ByteString
      getEmailAddressesBytes(int index);

  /**
   * <pre>
   * Optional.
   *
   * A URL pointing to the avatar.
   * </pre>
   *
   * <code>string avatar = 7;</code>
   */
  java.lang.String getAvatar();
  /**
   * <pre>
   * Optional.
   *
   * A URL pointing to the avatar.
   * </pre>
   *
   * <code>string avatar = 7;</code>
   */
  com.google.protobuf.ByteString
      getAvatarBytes();

  /**
   * <pre>
   * Optional.
   * 
   * The URL pointing to this profile's homepage.
   * </pre>
   *
   * <code>string homepage = 8;</code>
   */
  java.lang.String getHomepage();
  /**
   * <pre>
   * Optional.
   * 
   * The URL pointing to this profile's homepage.
   * </pre>
   *
   * <code>string homepage = 8;</code>
   */
  com.google.protobuf.ByteString
      getHomepageBytes();

  /**
   * <pre>
   * Optional.
   *
   * The social media accounts.
   * </pre>
   *
   * <code>.hpi.cloud.common.v1test.SocialProfiles social_profiles = 9;</code>
   */
  boolean hasSocialProfiles();
  /**
   * <pre>
   * Optional.
   *
   * The social media accounts.
   * </pre>
   *
   * <code>.hpi.cloud.common.v1test.SocialProfiles social_profiles = 9;</code>
   */
  de.hpi.cloud.common.v1test.SocialProfiles getSocialProfiles();
  /**
   * <pre>
   * Optional.
   *
   * The social media accounts.
   * </pre>
   *
   * <code>.hpi.cloud.common.v1test.SocialProfiles social_profiles = 9;</code>
   */
  de.hpi.cloud.common.v1test.SocialProfilesOrBuilder getSocialProfilesOrBuilder();

  public de.hpi.cloud.common.v1test.Person.NameCase getNameCase();
}
