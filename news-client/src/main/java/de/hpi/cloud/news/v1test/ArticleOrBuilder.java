// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hpi/cloud/news/v1test/article.proto

package de.hpi.cloud.news.v1test;

public interface ArticleOrBuilder extends
    // @@protoc_insertion_point(interface_extends:hpi.cloud.news.v1test.Article)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required.
   *
   * The unique ID (across sites) of this article.
   * </pre>
   *
   * <code>string id = 1;</code>
   */
  java.lang.String getId();
  /**
   * <pre>
   * Required.
   *
   * The unique ID (across sites) of this article.
   * </pre>
   *
   * <code>string id = 1;</code>
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <pre>
   * Required.
   *
   * Site of first appearance of this article.
   * </pre>
   *
   * <code>.hpi.cloud.news.v1test.Article.Site site = 2;</code>
   */
  int getSiteValue();
  /**
   * <pre>
   * Required.
   *
   * Site of first appearance of this article.
   * </pre>
   *
   * <code>.hpi.cloud.news.v1test.Article.Site site = 2;</code>
   */
  de.hpi.cloud.news.v1test.Article.Site getSite();

  /**
   * <pre>
   * Required.
   *
   * A link to the original source.
   * </pre>
   *
   * <code>string link = 3;</code>
   */
  java.lang.String getLink();
  /**
   * <pre>
   * Required.
   *
   * A link to the original source.
   * </pre>
   *
   * <code>string link = 3;</code>
   */
  com.google.protobuf.ByteString
      getLinkBytes();

  /**
   * <pre>
   * Required.
   *
   * The title of this news article.
   * </pre>
   *
   * <code>string title = 4;</code>
   */
  java.lang.String getTitle();
  /**
   * <pre>
   * Required.
   *
   * The title of this news article.
   * </pre>
   *
   * <code>string title = 4;</code>
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <pre>
   * Required.
   *
   * The publishing date.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp publish_date = 5;</code>
   */
  boolean hasPublishDate();
  /**
   * <pre>
   * Required.
   *
   * The publishing date.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp publish_date = 5;</code>
   */
  com.google.protobuf.Timestamp getPublishDate();
  /**
   * <pre>
   * Required.
   *
   * The publishing date.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp publish_date = 5;</code>
   */
  com.google.protobuf.TimestampOrBuilder getPublishDateOrBuilder();

  /**
   * <pre>
   * Optional.
   *
   * A URL pointing to the thumbnail image.
   * </pre>
   *
   * <code>string thumbnail = 6;</code>
   */
  java.lang.String getThumbnail();
  /**
   * <pre>
   * Optional.
   *
   * A URL pointing to the thumbnail image.
   * </pre>
   *
   * <code>string thumbnail = 6;</code>
   */
  com.google.protobuf.ByteString
      getThumbnailBytes();

  /**
   * <pre>
   * Required.
   *
   * A short text summarizing this article. Recommended for a preview.
   * </pre>
   *
   * <code>string description = 7;</code>
   */
  java.lang.String getDescription();
  /**
   * <pre>
   * Required.
   *
   * A short text summarizing this article. Recommended for a preview.
   * </pre>
   *
   * <code>string description = 7;</code>
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <pre>
   * Optional.
   *
   * IDs of the author(s).
   * </pre>
   *
   * <code>repeated string author_ids = 8;</code>
   */
  java.util.List<java.lang.String>
      getAuthorIdsList();
  /**
   * <pre>
   * Optional.
   *
   * IDs of the author(s).
   * </pre>
   *
   * <code>repeated string author_ids = 8;</code>
   */
  int getAuthorIdsCount();
  /**
   * <pre>
   * Optional.
   *
   * IDs of the author(s).
   * </pre>
   *
   * <code>repeated string author_ids = 8;</code>
   */
  java.lang.String getAuthorIds(int index);
  /**
   * <pre>
   * Optional.
   *
   * IDs of the author(s).
   * </pre>
   *
   * <code>repeated string author_ids = 8;</code>
   */
  com.google.protobuf.ByteString
      getAuthorIdsBytes(int index);

  /**
   * <pre>
   * Required.
   *
   * The actual HTML-content of this article, i.e. the long variant of description.
   * </pre>
   *
   * <code>string content = 9;</code>
   */
  java.lang.String getContent();
  /**
   * <pre>
   * Required.
   *
   * The actual HTML-content of this article, i.e. the long variant of description.
   * </pre>
   *
   * <code>string content = 9;</code>
   */
  com.google.protobuf.ByteString
      getContentBytes();

  /**
   * <pre>
   * Optional.
   *
   * Tags of this article.
   * </pre>
   *
   * <code>repeated .hpi.cloud.news.v1test.Tag tags = 10;</code>
   */
  java.util.List<de.hpi.cloud.news.v1test.Tag> 
      getTagsList();
  /**
   * <pre>
   * Optional.
   *
   * Tags of this article.
   * </pre>
   *
   * <code>repeated .hpi.cloud.news.v1test.Tag tags = 10;</code>
   */
  de.hpi.cloud.news.v1test.Tag getTags(int index);
  /**
   * <pre>
   * Optional.
   *
   * Tags of this article.
   * </pre>
   *
   * <code>repeated .hpi.cloud.news.v1test.Tag tags = 10;</code>
   */
  int getTagsCount();
  /**
   * <pre>
   * Optional.
   *
   * Tags of this article.
   * </pre>
   *
   * <code>repeated .hpi.cloud.news.v1test.Tag tags = 10;</code>
   */
  java.util.List<? extends de.hpi.cloud.news.v1test.TagOrBuilder> 
      getTagsOrBuilderList();
  /**
   * <pre>
   * Optional.
   *
   * Tags of this article.
   * </pre>
   *
   * <code>repeated .hpi.cloud.news.v1test.Tag tags = 10;</code>
   */
  de.hpi.cloud.news.v1test.TagOrBuilder getTagsOrBuilder(
      int index);

  /**
   * <pre>
   * Optional.
   *
   * The number of times this article was viewed.
   * </pre>
   *
   * <code>uint32 view_count = 16;</code>
   */
  int getViewCount();
}
