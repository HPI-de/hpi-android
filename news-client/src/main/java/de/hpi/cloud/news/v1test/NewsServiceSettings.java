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
package de.hpi.cloud.news.v1test;

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
import de.hpi.cloud.news.v1test.stub.NewsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link NewsServiceClient}.
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
 * NewsServiceSettings.Builder newsServiceSettingsBuilder =
 *     NewsServiceSettings.newBuilder();
 * newsServiceSettingsBuilder.listArticlesSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * NewsServiceSettings newsServiceSettings = newsServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NewsServiceSettings extends ClientSettings<NewsServiceSettings> {
  /**
   * Returns the object with the settings used for calls to listArticles.
   */
  public UnaryCallSettings<ListArticlesRequest, ListArticlesResponse> listArticlesSettings() {
    return ((NewsServiceStubSettings) getStubSettings()).listArticlesSettings();
  }

  /**
   * Returns the object with the settings used for calls to getArticle.
   */
  public UnaryCallSettings<GetArticleRequest, Article> getArticleSettings() {
    return ((NewsServiceStubSettings) getStubSettings()).getArticleSettings();
  }

  /**
   * Returns the object with the settings used for calls to listAuthors.
   */
  public UnaryCallSettings<ListAuthorsRequest, ListAuthorsResponse> listAuthorsSettings() {
    return ((NewsServiceStubSettings) getStubSettings()).listAuthorsSettings();
  }

  /**
   * Returns the object with the settings used for calls to getAuthor.
   */
  public UnaryCallSettings<GetAuthorRequest, Author> getAuthorSettings() {
    return ((NewsServiceStubSettings) getStubSettings()).getAuthorSettings();
  }


  public static final NewsServiceSettings create(NewsServiceStubSettings stub) throws IOException {
    return new NewsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /**
   * Returns a builder for the default ExecutorProvider for this service.
   */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NewsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /**
   * Returns the default service endpoint.
   */
   public static String getDefaultEndpoint() {
     return NewsServiceStubSettings.getDefaultEndpoint();
   }


  /**
   * Returns the default service scopes.
   */
  public static List<String> getDefaultServiceScopes() {
    return NewsServiceStubSettings.getDefaultServiceScopes();
  }


  /**
   * Returns a builder for the default credentials for this service.
   */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NewsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return NewsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NewsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NewsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NewsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /**
   * Builder for NewsServiceSettings.
   */
  public static class Builder extends ClientSettings.Builder<NewsServiceSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(NewsServiceStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(NewsServiceStubSettings.newBuilder());
    }

    protected Builder(NewsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NewsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }


    public NewsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((NewsServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /**
     * Returns the builder for the settings used for calls to listArticles.
     */
    public UnaryCallSettings.Builder<ListArticlesRequest, ListArticlesResponse> listArticlesSettings() {
      return getStubSettingsBuilder().listArticlesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getArticle.
     */
    public UnaryCallSettings.Builder<GetArticleRequest, Article> getArticleSettings() {
      return getStubSettingsBuilder().getArticleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listAuthors.
     */
    public UnaryCallSettings.Builder<ListAuthorsRequest, ListAuthorsResponse> listAuthorsSettings() {
      return getStubSettingsBuilder().listAuthorsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getAuthor.
     */
    public UnaryCallSettings.Builder<GetAuthorRequest, Author> getAuthorSettings() {
      return getStubSettingsBuilder().getAuthorSettings();
    }

    @Override
    public NewsServiceSettings build() throws IOException {
      return new NewsServiceSettings(this);
    }
  }
}