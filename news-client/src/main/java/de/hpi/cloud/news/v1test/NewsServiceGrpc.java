package de.hpi.cloud.news.v1test;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Provides access to news from the HPI an HPImgzn.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: hpi/cloud/news/v1test/news_service.proto")
public final class NewsServiceGrpc {

  private NewsServiceGrpc() {}

  public static final String SERVICE_NAME = "hpi.cloud.news.v1test.NewsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.ListArticlesRequest,
      de.hpi.cloud.news.v1test.ListArticlesResponse> getListArticlesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListArticles",
      requestType = de.hpi.cloud.news.v1test.ListArticlesRequest.class,
      responseType = de.hpi.cloud.news.v1test.ListArticlesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.ListArticlesRequest,
      de.hpi.cloud.news.v1test.ListArticlesResponse> getListArticlesMethod() {
    io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.ListArticlesRequest, de.hpi.cloud.news.v1test.ListArticlesResponse> getListArticlesMethod;
    if ((getListArticlesMethod = NewsServiceGrpc.getListArticlesMethod) == null) {
      synchronized (NewsServiceGrpc.class) {
        if ((getListArticlesMethod = NewsServiceGrpc.getListArticlesMethod) == null) {
          NewsServiceGrpc.getListArticlesMethod = getListArticlesMethod = 
              io.grpc.MethodDescriptor.<de.hpi.cloud.news.v1test.ListArticlesRequest, de.hpi.cloud.news.v1test.ListArticlesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "hpi.cloud.news.v1test.NewsService", "ListArticles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.hpi.cloud.news.v1test.ListArticlesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.hpi.cloud.news.v1test.ListArticlesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new NewsServiceMethodDescriptorSupplier("ListArticles"))
                  .build();
          }
        }
     }
     return getListArticlesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.GetArticleRequest,
      de.hpi.cloud.news.v1test.Article> getGetArticleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetArticle",
      requestType = de.hpi.cloud.news.v1test.GetArticleRequest.class,
      responseType = de.hpi.cloud.news.v1test.Article.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.GetArticleRequest,
      de.hpi.cloud.news.v1test.Article> getGetArticleMethod() {
    io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.GetArticleRequest, de.hpi.cloud.news.v1test.Article> getGetArticleMethod;
    if ((getGetArticleMethod = NewsServiceGrpc.getGetArticleMethod) == null) {
      synchronized (NewsServiceGrpc.class) {
        if ((getGetArticleMethod = NewsServiceGrpc.getGetArticleMethod) == null) {
          NewsServiceGrpc.getGetArticleMethod = getGetArticleMethod = 
              io.grpc.MethodDescriptor.<de.hpi.cloud.news.v1test.GetArticleRequest, de.hpi.cloud.news.v1test.Article>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "hpi.cloud.news.v1test.NewsService", "GetArticle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.hpi.cloud.news.v1test.GetArticleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.hpi.cloud.news.v1test.Article.getDefaultInstance()))
                  .setSchemaDescriptor(new NewsServiceMethodDescriptorSupplier("GetArticle"))
                  .build();
          }
        }
     }
     return getGetArticleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.ListAuthorsRequest,
      de.hpi.cloud.news.v1test.ListAuthorsResponse> getListAuthorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAuthors",
      requestType = de.hpi.cloud.news.v1test.ListAuthorsRequest.class,
      responseType = de.hpi.cloud.news.v1test.ListAuthorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.ListAuthorsRequest,
      de.hpi.cloud.news.v1test.ListAuthorsResponse> getListAuthorsMethod() {
    io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.ListAuthorsRequest, de.hpi.cloud.news.v1test.ListAuthorsResponse> getListAuthorsMethod;
    if ((getListAuthorsMethod = NewsServiceGrpc.getListAuthorsMethod) == null) {
      synchronized (NewsServiceGrpc.class) {
        if ((getListAuthorsMethod = NewsServiceGrpc.getListAuthorsMethod) == null) {
          NewsServiceGrpc.getListAuthorsMethod = getListAuthorsMethod = 
              io.grpc.MethodDescriptor.<de.hpi.cloud.news.v1test.ListAuthorsRequest, de.hpi.cloud.news.v1test.ListAuthorsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "hpi.cloud.news.v1test.NewsService", "ListAuthors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.hpi.cloud.news.v1test.ListAuthorsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.hpi.cloud.news.v1test.ListAuthorsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new NewsServiceMethodDescriptorSupplier("ListAuthors"))
                  .build();
          }
        }
     }
     return getListAuthorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.GetAuthorRequest,
      de.hpi.cloud.news.v1test.Author> getGetAuthorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthor",
      requestType = de.hpi.cloud.news.v1test.GetAuthorRequest.class,
      responseType = de.hpi.cloud.news.v1test.Author.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.GetAuthorRequest,
      de.hpi.cloud.news.v1test.Author> getGetAuthorMethod() {
    io.grpc.MethodDescriptor<de.hpi.cloud.news.v1test.GetAuthorRequest, de.hpi.cloud.news.v1test.Author> getGetAuthorMethod;
    if ((getGetAuthorMethod = NewsServiceGrpc.getGetAuthorMethod) == null) {
      synchronized (NewsServiceGrpc.class) {
        if ((getGetAuthorMethod = NewsServiceGrpc.getGetAuthorMethod) == null) {
          NewsServiceGrpc.getGetAuthorMethod = getGetAuthorMethod = 
              io.grpc.MethodDescriptor.<de.hpi.cloud.news.v1test.GetAuthorRequest, de.hpi.cloud.news.v1test.Author>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "hpi.cloud.news.v1test.NewsService", "GetAuthor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.hpi.cloud.news.v1test.GetAuthorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.hpi.cloud.news.v1test.Author.getDefaultInstance()))
                  .setSchemaDescriptor(new NewsServiceMethodDescriptorSupplier("GetAuthor"))
                  .build();
          }
        }
     }
     return getGetAuthorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NewsServiceStub newStub(io.grpc.Channel channel) {
    return new NewsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NewsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new NewsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NewsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new NewsServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Provides access to news from the HPI an HPImgzn.
   * </pre>
   */
  public static abstract class NewsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists articles.
     * </pre>
     */
    public void listArticles(de.hpi.cloud.news.v1test.ListArticlesRequest request,
        io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.ListArticlesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListArticlesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an article.
     * </pre>
     */
    public void getArticle(de.hpi.cloud.news.v1test.GetArticleRequest request,
        io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.Article> responseObserver) {
      asyncUnimplementedUnaryCall(getGetArticleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists authors.
     * </pre>
     */
    public void listAuthors(de.hpi.cloud.news.v1test.ListAuthorsRequest request,
        io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.ListAuthorsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListAuthorsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an author.
     * </pre>
     */
    public void getAuthor(de.hpi.cloud.news.v1test.GetAuthorRequest request,
        io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.Author> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAuthorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListArticlesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.hpi.cloud.news.v1test.ListArticlesRequest,
                de.hpi.cloud.news.v1test.ListArticlesResponse>(
                  this, METHODID_LIST_ARTICLES)))
          .addMethod(
            getGetArticleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.hpi.cloud.news.v1test.GetArticleRequest,
                de.hpi.cloud.news.v1test.Article>(
                  this, METHODID_GET_ARTICLE)))
          .addMethod(
            getListAuthorsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.hpi.cloud.news.v1test.ListAuthorsRequest,
                de.hpi.cloud.news.v1test.ListAuthorsResponse>(
                  this, METHODID_LIST_AUTHORS)))
          .addMethod(
            getGetAuthorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                de.hpi.cloud.news.v1test.GetAuthorRequest,
                de.hpi.cloud.news.v1test.Author>(
                  this, METHODID_GET_AUTHOR)))
          .build();
    }
  }

  /**
   * <pre>
   * Provides access to news from the HPI an HPImgzn.
   * </pre>
   */
  public static final class NewsServiceStub extends io.grpc.stub.AbstractStub<NewsServiceStub> {
    private NewsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NewsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NewsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NewsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists articles.
     * </pre>
     */
    public void listArticles(de.hpi.cloud.news.v1test.ListArticlesRequest request,
        io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.ListArticlesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListArticlesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an article.
     * </pre>
     */
    public void getArticle(de.hpi.cloud.news.v1test.GetArticleRequest request,
        io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.Article> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetArticleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists authors.
     * </pre>
     */
    public void listAuthors(de.hpi.cloud.news.v1test.ListAuthorsRequest request,
        io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.ListAuthorsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAuthorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an author.
     * </pre>
     */
    public void getAuthor(de.hpi.cloud.news.v1test.GetAuthorRequest request,
        io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.Author> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAuthorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Provides access to news from the HPI an HPImgzn.
   * </pre>
   */
  public static final class NewsServiceBlockingStub extends io.grpc.stub.AbstractStub<NewsServiceBlockingStub> {
    private NewsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NewsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NewsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NewsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists articles.
     * </pre>
     */
    public de.hpi.cloud.news.v1test.ListArticlesResponse listArticles(de.hpi.cloud.news.v1test.ListArticlesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListArticlesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an article.
     * </pre>
     */
    public de.hpi.cloud.news.v1test.Article getArticle(de.hpi.cloud.news.v1test.GetArticleRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetArticleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists authors.
     * </pre>
     */
    public de.hpi.cloud.news.v1test.ListAuthorsResponse listAuthors(de.hpi.cloud.news.v1test.ListAuthorsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListAuthorsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an author.
     * </pre>
     */
    public de.hpi.cloud.news.v1test.Author getAuthor(de.hpi.cloud.news.v1test.GetAuthorRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAuthorMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Provides access to news from the HPI an HPImgzn.
   * </pre>
   */
  public static final class NewsServiceFutureStub extends io.grpc.stub.AbstractStub<NewsServiceFutureStub> {
    private NewsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NewsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NewsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NewsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists articles.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<de.hpi.cloud.news.v1test.ListArticlesResponse> listArticles(
        de.hpi.cloud.news.v1test.ListArticlesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListArticlesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an article.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<de.hpi.cloud.news.v1test.Article> getArticle(
        de.hpi.cloud.news.v1test.GetArticleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetArticleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists authors.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<de.hpi.cloud.news.v1test.ListAuthorsResponse> listAuthors(
        de.hpi.cloud.news.v1test.ListAuthorsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAuthorsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an author.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<de.hpi.cloud.news.v1test.Author> getAuthor(
        de.hpi.cloud.news.v1test.GetAuthorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAuthorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ARTICLES = 0;
  private static final int METHODID_GET_ARTICLE = 1;
  private static final int METHODID_LIST_AUTHORS = 2;
  private static final int METHODID_GET_AUTHOR = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NewsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NewsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ARTICLES:
          serviceImpl.listArticles((de.hpi.cloud.news.v1test.ListArticlesRequest) request,
              (io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.ListArticlesResponse>) responseObserver);
          break;
        case METHODID_GET_ARTICLE:
          serviceImpl.getArticle((de.hpi.cloud.news.v1test.GetArticleRequest) request,
              (io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.Article>) responseObserver);
          break;
        case METHODID_LIST_AUTHORS:
          serviceImpl.listAuthors((de.hpi.cloud.news.v1test.ListAuthorsRequest) request,
              (io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.ListAuthorsResponse>) responseObserver);
          break;
        case METHODID_GET_AUTHOR:
          serviceImpl.getAuthor((de.hpi.cloud.news.v1test.GetAuthorRequest) request,
              (io.grpc.stub.StreamObserver<de.hpi.cloud.news.v1test.Author>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class NewsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NewsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.hpi.cloud.news.v1test.NewsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NewsService");
    }
  }

  private static final class NewsServiceFileDescriptorSupplier
      extends NewsServiceBaseDescriptorSupplier {
    NewsServiceFileDescriptorSupplier() {}
  }

  private static final class NewsServiceMethodDescriptorSupplier
      extends NewsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NewsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (NewsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NewsServiceFileDescriptorSupplier())
              .addMethod(getListArticlesMethod())
              .addMethod(getGetArticleMethod())
              .addMethod(getListAuthorsMethod())
              .addMethod(getGetAuthorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
