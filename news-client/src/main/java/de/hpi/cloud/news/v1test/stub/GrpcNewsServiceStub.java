/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.hpi.cloud.news.v1test.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import de.hpi.cloud.news.v1test.Article;
import de.hpi.cloud.news.v1test.Article;
import de.hpi.cloud.news.v1test.Author;
import de.hpi.cloud.news.v1test.GetArticleRequest;
import de.hpi.cloud.news.v1test.GetAuthorRequest;
import de.hpi.cloud.news.v1test.ListArticlesRequest;
import de.hpi.cloud.news.v1test.ListArticlesResponse;
import de.hpi.cloud.news.v1test.ListAuthorsRequest;
import de.hpi.cloud.news.v1test.ListAuthorsResponse;
import de.hpi.cloud.news.v1test.NewsServiceSettings;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for News API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcNewsServiceStub extends NewsServiceStub {

  private static final MethodDescriptor<ListArticlesRequest, ListArticlesResponse> listArticlesMethodDescriptor =
      MethodDescriptor.<ListArticlesRequest, ListArticlesResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("hpi.cloud.news.v1test.NewsService/ListArticles")
          .setRequestMarshaller(ProtoUtils.marshaller(ListArticlesRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ListArticlesResponse.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetArticleRequest, Article> getArticleMethodDescriptor =
      MethodDescriptor.<GetArticleRequest, Article>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("hpi.cloud.news.v1test.NewsService/GetArticle")
          .setRequestMarshaller(ProtoUtils.marshaller(GetArticleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Article.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListAuthorsRequest, ListAuthorsResponse> listAuthorsMethodDescriptor =
      MethodDescriptor.<ListAuthorsRequest, ListAuthorsResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("hpi.cloud.news.v1test.NewsService/ListAuthors")
          .setRequestMarshaller(ProtoUtils.marshaller(ListAuthorsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ListAuthorsResponse.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetAuthorRequest, Author> getAuthorMethodDescriptor =
      MethodDescriptor.<GetAuthorRequest, Author>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("hpi.cloud.news.v1test.NewsService/GetAuthor")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAuthorRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Author.getDefaultInstance()))
          .build();


  private final BackgroundResource backgroundResources;

  private final UnaryCallable<ListArticlesRequest, ListArticlesResponse> listArticlesCallable;
  private final UnaryCallable<GetArticleRequest, Article> getArticleCallable;
  private final UnaryCallable<ListAuthorsRequest, ListAuthorsResponse> listAuthorsCallable;
  private final UnaryCallable<GetAuthorRequest, Author> getAuthorCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcNewsServiceStub create(NewsServiceStubSettings settings) throws IOException {
    return new GrpcNewsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNewsServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcNewsServiceStub(NewsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNewsServiceStub create(ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNewsServiceStub(NewsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNewsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected GrpcNewsServiceStub(NewsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcNewsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNewsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected GrpcNewsServiceStub(NewsServiceStubSettings settings, ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<ListArticlesRequest, ListArticlesResponse> listArticlesTransportSettings =
        GrpcCallSettings.<ListArticlesRequest, ListArticlesResponse>newBuilder()
            .setMethodDescriptor(listArticlesMethodDescriptor)
            .build();
    GrpcCallSettings<GetArticleRequest, Article> getArticleTransportSettings =
        GrpcCallSettings.<GetArticleRequest, Article>newBuilder()
            .setMethodDescriptor(getArticleMethodDescriptor)
            .build();
    GrpcCallSettings<ListAuthorsRequest, ListAuthorsResponse> listAuthorsTransportSettings =
        GrpcCallSettings.<ListAuthorsRequest, ListAuthorsResponse>newBuilder()
            .setMethodDescriptor(listAuthorsMethodDescriptor)
            .build();
    GrpcCallSettings<GetAuthorRequest, Author> getAuthorTransportSettings =
        GrpcCallSettings.<GetAuthorRequest, Author>newBuilder()
            .setMethodDescriptor(getAuthorMethodDescriptor)
            .build();

    this.listArticlesCallable = callableFactory.createUnaryCallable(listArticlesTransportSettings,settings.listArticlesSettings(), clientContext);
    this.getArticleCallable = callableFactory.createUnaryCallable(getArticleTransportSettings,settings.getArticleSettings(), clientContext);
    this.listAuthorsCallable = callableFactory.createUnaryCallable(listAuthorsTransportSettings,settings.listAuthorsSettings(), clientContext);
    this.getAuthorCallable = callableFactory.createUnaryCallable(getAuthorTransportSettings,settings.getAuthorSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }


  public UnaryCallable<ListArticlesRequest, ListArticlesResponse> listArticlesCallable() {
    return listArticlesCallable;
  }

  public UnaryCallable<GetArticleRequest, Article> getArticleCallable() {
    return getArticleCallable;
  }

  public UnaryCallable<ListAuthorsRequest, ListAuthorsResponse> listAuthorsCallable() {
    return listAuthorsCallable;
  }

  public UnaryCallable<GetAuthorRequest, Author> getAuthorCallable() {
    return getAuthorCallable;
  }

  @Override
  public final void close() {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }

}