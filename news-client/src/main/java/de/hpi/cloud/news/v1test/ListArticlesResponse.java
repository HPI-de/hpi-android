// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hpi/cloud/news/v1test/news_service.proto

package de.hpi.cloud.news.v1test;

/**
 * <pre>
 * Response message for listing articles using [ListArticles][hpi.cloud.news.v1test.NewsService.ListArticles].
 * </pre>
 *
 * Protobuf type {@code hpi.cloud.news.v1test.ListArticlesResponse}
 */
public  final class ListArticlesResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:hpi.cloud.news.v1test.ListArticlesResponse)
    ListArticlesResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ListArticlesResponse.newBuilder() to construct.
  private ListArticlesResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ListArticlesResponse() {
    articles_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ListArticlesResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              articles_ = new java.util.ArrayList<de.hpi.cloud.news.v1test.Article>();
              mutable_bitField0_ |= 0x00000001;
            }
            articles_.add(
                input.readMessage(de.hpi.cloud.news.v1test.Article.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        articles_ = java.util.Collections.unmodifiableList(articles_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return de.hpi.cloud.news.v1test.NewsServiceProto.internal_static_hpi_cloud_news_v1test_ListArticlesResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return de.hpi.cloud.news.v1test.NewsServiceProto.internal_static_hpi_cloud_news_v1test_ListArticlesResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            de.hpi.cloud.news.v1test.ListArticlesResponse.class, de.hpi.cloud.news.v1test.ListArticlesResponse.Builder.class);
  }

  public static final int ARTICLES_FIELD_NUMBER = 1;
  private java.util.List<de.hpi.cloud.news.v1test.Article> articles_;
  /**
   * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
   */
  public java.util.List<de.hpi.cloud.news.v1test.Article> getArticlesList() {
    return articles_;
  }
  /**
   * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
   */
  public java.util.List<? extends de.hpi.cloud.news.v1test.ArticleOrBuilder> 
      getArticlesOrBuilderList() {
    return articles_;
  }
  /**
   * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
   */
  public int getArticlesCount() {
    return articles_.size();
  }
  /**
   * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
   */
  public de.hpi.cloud.news.v1test.Article getArticles(int index) {
    return articles_.get(index);
  }
  /**
   * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
   */
  public de.hpi.cloud.news.v1test.ArticleOrBuilder getArticlesOrBuilder(
      int index) {
    return articles_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < articles_.size(); i++) {
      output.writeMessage(1, articles_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < articles_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, articles_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof de.hpi.cloud.news.v1test.ListArticlesResponse)) {
      return super.equals(obj);
    }
    de.hpi.cloud.news.v1test.ListArticlesResponse other = (de.hpi.cloud.news.v1test.ListArticlesResponse) obj;

    if (!getArticlesList()
        .equals(other.getArticlesList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getArticlesCount() > 0) {
      hash = (37 * hash) + ARTICLES_FIELD_NUMBER;
      hash = (53 * hash) + getArticlesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static de.hpi.cloud.news.v1test.ListArticlesResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(de.hpi.cloud.news.v1test.ListArticlesResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Response message for listing articles using [ListArticles][hpi.cloud.news.v1test.NewsService.ListArticles].
   * </pre>
   *
   * Protobuf type {@code hpi.cloud.news.v1test.ListArticlesResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:hpi.cloud.news.v1test.ListArticlesResponse)
      de.hpi.cloud.news.v1test.ListArticlesResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return de.hpi.cloud.news.v1test.NewsServiceProto.internal_static_hpi_cloud_news_v1test_ListArticlesResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return de.hpi.cloud.news.v1test.NewsServiceProto.internal_static_hpi_cloud_news_v1test_ListArticlesResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              de.hpi.cloud.news.v1test.ListArticlesResponse.class, de.hpi.cloud.news.v1test.ListArticlesResponse.Builder.class);
    }

    // Construct using de.hpi.cloud.news.v1test.ListArticlesResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getArticlesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (articlesBuilder_ == null) {
        articles_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        articlesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return de.hpi.cloud.news.v1test.NewsServiceProto.internal_static_hpi_cloud_news_v1test_ListArticlesResponse_descriptor;
    }

    @java.lang.Override
    public de.hpi.cloud.news.v1test.ListArticlesResponse getDefaultInstanceForType() {
      return de.hpi.cloud.news.v1test.ListArticlesResponse.getDefaultInstance();
    }

    @java.lang.Override
    public de.hpi.cloud.news.v1test.ListArticlesResponse build() {
      de.hpi.cloud.news.v1test.ListArticlesResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public de.hpi.cloud.news.v1test.ListArticlesResponse buildPartial() {
      de.hpi.cloud.news.v1test.ListArticlesResponse result = new de.hpi.cloud.news.v1test.ListArticlesResponse(this);
      int from_bitField0_ = bitField0_;
      if (articlesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          articles_ = java.util.Collections.unmodifiableList(articles_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.articles_ = articles_;
      } else {
        result.articles_ = articlesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof de.hpi.cloud.news.v1test.ListArticlesResponse) {
        return mergeFrom((de.hpi.cloud.news.v1test.ListArticlesResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(de.hpi.cloud.news.v1test.ListArticlesResponse other) {
      if (other == de.hpi.cloud.news.v1test.ListArticlesResponse.getDefaultInstance()) return this;
      if (articlesBuilder_ == null) {
        if (!other.articles_.isEmpty()) {
          if (articles_.isEmpty()) {
            articles_ = other.articles_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureArticlesIsMutable();
            articles_.addAll(other.articles_);
          }
          onChanged();
        }
      } else {
        if (!other.articles_.isEmpty()) {
          if (articlesBuilder_.isEmpty()) {
            articlesBuilder_.dispose();
            articlesBuilder_ = null;
            articles_ = other.articles_;
            bitField0_ = (bitField0_ & ~0x00000001);
            articlesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getArticlesFieldBuilder() : null;
          } else {
            articlesBuilder_.addAllMessages(other.articles_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      de.hpi.cloud.news.v1test.ListArticlesResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (de.hpi.cloud.news.v1test.ListArticlesResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<de.hpi.cloud.news.v1test.Article> articles_ =
      java.util.Collections.emptyList();
    private void ensureArticlesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        articles_ = new java.util.ArrayList<de.hpi.cloud.news.v1test.Article>(articles_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        de.hpi.cloud.news.v1test.Article, de.hpi.cloud.news.v1test.Article.Builder, de.hpi.cloud.news.v1test.ArticleOrBuilder> articlesBuilder_;

    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public java.util.List<de.hpi.cloud.news.v1test.Article> getArticlesList() {
      if (articlesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(articles_);
      } else {
        return articlesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public int getArticlesCount() {
      if (articlesBuilder_ == null) {
        return articles_.size();
      } else {
        return articlesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public de.hpi.cloud.news.v1test.Article getArticles(int index) {
      if (articlesBuilder_ == null) {
        return articles_.get(index);
      } else {
        return articlesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public Builder setArticles(
        int index, de.hpi.cloud.news.v1test.Article value) {
      if (articlesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureArticlesIsMutable();
        articles_.set(index, value);
        onChanged();
      } else {
        articlesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public Builder setArticles(
        int index, de.hpi.cloud.news.v1test.Article.Builder builderForValue) {
      if (articlesBuilder_ == null) {
        ensureArticlesIsMutable();
        articles_.set(index, builderForValue.build());
        onChanged();
      } else {
        articlesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public Builder addArticles(de.hpi.cloud.news.v1test.Article value) {
      if (articlesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureArticlesIsMutable();
        articles_.add(value);
        onChanged();
      } else {
        articlesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public Builder addArticles(
        int index, de.hpi.cloud.news.v1test.Article value) {
      if (articlesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureArticlesIsMutable();
        articles_.add(index, value);
        onChanged();
      } else {
        articlesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public Builder addArticles(
        de.hpi.cloud.news.v1test.Article.Builder builderForValue) {
      if (articlesBuilder_ == null) {
        ensureArticlesIsMutable();
        articles_.add(builderForValue.build());
        onChanged();
      } else {
        articlesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public Builder addArticles(
        int index, de.hpi.cloud.news.v1test.Article.Builder builderForValue) {
      if (articlesBuilder_ == null) {
        ensureArticlesIsMutable();
        articles_.add(index, builderForValue.build());
        onChanged();
      } else {
        articlesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public Builder addAllArticles(
        java.lang.Iterable<? extends de.hpi.cloud.news.v1test.Article> values) {
      if (articlesBuilder_ == null) {
        ensureArticlesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, articles_);
        onChanged();
      } else {
        articlesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public Builder clearArticles() {
      if (articlesBuilder_ == null) {
        articles_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        articlesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public Builder removeArticles(int index) {
      if (articlesBuilder_ == null) {
        ensureArticlesIsMutable();
        articles_.remove(index);
        onChanged();
      } else {
        articlesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public de.hpi.cloud.news.v1test.Article.Builder getArticlesBuilder(
        int index) {
      return getArticlesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public de.hpi.cloud.news.v1test.ArticleOrBuilder getArticlesOrBuilder(
        int index) {
      if (articlesBuilder_ == null) {
        return articles_.get(index);  } else {
        return articlesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public java.util.List<? extends de.hpi.cloud.news.v1test.ArticleOrBuilder> 
         getArticlesOrBuilderList() {
      if (articlesBuilder_ != null) {
        return articlesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(articles_);
      }
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public de.hpi.cloud.news.v1test.Article.Builder addArticlesBuilder() {
      return getArticlesFieldBuilder().addBuilder(
          de.hpi.cloud.news.v1test.Article.getDefaultInstance());
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public de.hpi.cloud.news.v1test.Article.Builder addArticlesBuilder(
        int index) {
      return getArticlesFieldBuilder().addBuilder(
          index, de.hpi.cloud.news.v1test.Article.getDefaultInstance());
    }
    /**
     * <code>repeated .hpi.cloud.news.v1test.Article articles = 1;</code>
     */
    public java.util.List<de.hpi.cloud.news.v1test.Article.Builder> 
         getArticlesBuilderList() {
      return getArticlesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        de.hpi.cloud.news.v1test.Article, de.hpi.cloud.news.v1test.Article.Builder, de.hpi.cloud.news.v1test.ArticleOrBuilder> 
        getArticlesFieldBuilder() {
      if (articlesBuilder_ == null) {
        articlesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            de.hpi.cloud.news.v1test.Article, de.hpi.cloud.news.v1test.Article.Builder, de.hpi.cloud.news.v1test.ArticleOrBuilder>(
                articles_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        articles_ = null;
      }
      return articlesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:hpi.cloud.news.v1test.ListArticlesResponse)
  }

  // @@protoc_insertion_point(class_scope:hpi.cloud.news.v1test.ListArticlesResponse)
  private static final de.hpi.cloud.news.v1test.ListArticlesResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new de.hpi.cloud.news.v1test.ListArticlesResponse();
  }

  public static de.hpi.cloud.news.v1test.ListArticlesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ListArticlesResponse>
      PARSER = new com.google.protobuf.AbstractParser<ListArticlesResponse>() {
    @java.lang.Override
    public ListArticlesResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ListArticlesResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ListArticlesResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ListArticlesResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public de.hpi.cloud.news.v1test.ListArticlesResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

