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

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import de.hpi.cloud.news.v1test.Article;
import de.hpi.cloud.news.v1test.Author;
import de.hpi.cloud.news.v1test.GetArticleRequest;
import de.hpi.cloud.news.v1test.GetAuthorRequest;
import de.hpi.cloud.news.v1test.ListArticlesRequest;
import de.hpi.cloud.news.v1test.ListArticlesResponse;
import de.hpi.cloud.news.v1test.ListAuthorsRequest;
import de.hpi.cloud.news.v1test.ListAuthorsResponse;
import de.hpi.cloud.news.v1test.NewsServiceGrpc;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link NewsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 * <li>The default service address (news.endpoints.hpi-cloud.cloud.goog) and default port (443)
 * are used.
 * <li>Credentials are acquired automatically through Application Default Credentials.
 * <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders.
 * When build() is called, the tree of builders is called to create the complete settings
 * object. For example, to set the total timeout of listArticles to 30 seconds:
 *
 * <pre>
 * <code>
 * NewsServiceStubSettings.Builder newsServiceSettingsBuilder =
 *     NewsServiceStubSettings.newBuilder();
 * newsServiceSettingsBuilder.listArticlesSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * NewsServiceStubSettings newsServiceSettings = newsServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NewsServiceStubSettings extends StubSettings<NewsServiceStubSettings> {
  /**
   * The default scopes of the service.
   */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES = ImmutableList.<String>builder()
      .build();

  private final UnaryCallSettings<ListArticlesRequest, ListArticlesResponse> listArticlesSettings;
  private final UnaryCallSettings<GetArticleRequest, Article> getArticleSettings;
  private final UnaryCallSettings<ListAuthorsRequest, ListAuthorsResponse> listAuthorsSettings;
  private final UnaryCallSettings<GetAuthorRequest, Author> getAuthorSettings;

  /**
   * Returns the object with the settings used for calls to listArticles.
   */
  public UnaryCallSettings<ListArticlesRequest, ListArticlesResponse> listArticlesSettings() {
    return listArticlesSettings;
  }

  /**
   * Returns the object with the settings used for calls to getArticle.
   */
  public UnaryCallSettings<GetArticleRequest, Article> getArticleSettings() {
    return getArticleSettings;
  }

  /**
   * Returns the object with the settings used for calls to listAuthors.
   */
  public UnaryCallSettings<ListAuthorsRequest, ListAuthorsResponse> listAuthorsSettings() {
    return listAuthorsSettings;
  }

  /**
   * Returns the object with the settings used for calls to getAuthor.
   */
  public UnaryCallSettings<GetAuthorRequest, Author> getAuthorSettings() {
    return getAuthorSettings;
  }


  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NewsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcNewsServiceStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /**
   * Returns a builder for the default ExecutorProvider for this service.
   */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /**
   * Returns the default service endpoint.
   */
  public static String getDefaultEndpoint() {
    return "news.endpoints.hpi-cloud.cloud.goog:443";
  }


  /**
   * Returns the default service scopes.
   */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }


  /**
   * Returns a builder for the default credentials for this service.
   */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        ;
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(NewsServiceStubSettings.class))
        .setTransportToken(GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /**
   * Returns a new builder for this class.
   */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /**
   * Returns a new builder for this class.
   */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /**
   * Returns a builder containing all the values of this settings class.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected NewsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listArticlesSettings = settingsBuilder.listArticlesSettings().build();
    getArticleSettings = settingsBuilder.getArticleSettings().build();
    listAuthorsSettings = settingsBuilder.listAuthorsSettings().build();
    getAuthorSettings = settingsBuilder.getAuthorSettings().build();
  }




  /**
   * Builder for NewsServiceStubSettings.
   */
  public static class Builder extends StubSettings.Builder<NewsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<ListArticlesRequest, ListArticlesResponse> listArticlesSettings;
    private final UnaryCallSettings.Builder<GetArticleRequest, Article> getArticleSettings;
    private final UnaryCallSettings.Builder<ListAuthorsRequest, ListAuthorsResponse> listAuthorsSettings;
    private final UnaryCallSettings.Builder<GetAuthorRequest, Author> getAuthorSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "non_idempotent",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(100L))
          .setRetryDelayMultiplier(1.3)
          .setMaxRetryDelay(Duration.ofMillis(60000L))
          .setInitialRpcTimeout(Duration.ofMillis(20000L))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeout(Duration.ofMillis(20000L))
          .setTotalTimeout(Duration.ofMillis(600000L))
          .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listArticlesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getArticleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listAuthorsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getAuthorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders = ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
          listArticlesSettings,
          getArticleSettings,
          listAuthorsSettings,
          getAuthorSettings
      );

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder.listArticlesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder.getArticleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder.listAuthorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder.getAuthorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(NewsServiceStubSettings settings) {
      super(settings);

      listArticlesSettings = settings.listArticlesSettings.toBuilder();
      getArticleSettings = settings.getArticleSettings.toBuilder();
      listAuthorsSettings = settings.listAuthorsSettings.toBuilder();
      getAuthorSettings = settings.getAuthorSettings.toBuilder();

      unaryMethodSettingsBuilders = ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
          listArticlesSettings,
          getArticleSettings,
          listAuthorsSettings,
          getAuthorSettings
      );
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /**
     * Returns the builder for the settings used for calls to listArticles.
     */
    public UnaryCallSettings.Builder<ListArticlesRequest, ListArticlesResponse> listArticlesSettings() {
      return listArticlesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getArticle.
     */
    public UnaryCallSettings.Builder<GetArticleRequest, Article> getArticleSettings() {
      return getArticleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listAuthors.
     */
    public UnaryCallSettings.Builder<ListAuthorsRequest, ListAuthorsResponse> listAuthorsSettings() {
      return listAuthorsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getAuthor.
     */
    public UnaryCallSettings.Builder<GetAuthorRequest, Author> getAuthorSettings() {
      return getAuthorSettings;
    }

    @Override
    public NewsServiceStubSettings build() throws IOException {
      return new NewsServiceStubSettings(this);
    }
  }
}