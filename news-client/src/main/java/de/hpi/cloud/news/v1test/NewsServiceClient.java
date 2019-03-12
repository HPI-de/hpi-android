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
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.paging.FixedSizeCollection;
import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.MoreExecutors;
import de.hpi.cloud.news.v1test.Article;
import de.hpi.cloud.news.v1test.stub.NewsServiceStub;
import de.hpi.cloud.news.v1test.stub.NewsServiceStubSettings;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Provides access to news from the HPI an HPImgzn.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
 *   Article.Site site = Article.Site.UNSPECIFIED;
 *   ListArticlesResponse response = newsServiceClient.listArticles(site);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the newsServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * API callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of NewsServiceSettings to
 * create(). For example:
 *
 * To customize credentials:
 *
 * <pre>
 * <code>
 * NewsServiceSettings newsServiceSettings =
 *     NewsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NewsServiceClient newsServiceClient =
 *     NewsServiceClient.create(newsServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * NewsServiceSettings newsServiceSettings =
 *     NewsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NewsServiceClient newsServiceClient =
 *     NewsServiceClient.create(newsServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NewsServiceClient implements BackgroundResource {
  private final NewsServiceSettings settings;
  private final NewsServiceStub stub;



  /**
   * Constructs an instance of NewsServiceClient with default settings.
   */
  public static final NewsServiceClient create() throws IOException {
    return create(NewsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NewsServiceClient, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final NewsServiceClient create(NewsServiceSettings settings) throws IOException {
    return new NewsServiceClient(settings);
  }

  /**
   * Constructs an instance of NewsServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use NewsServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final NewsServiceClient create(NewsServiceStub stub) {
    return new NewsServiceClient(stub);
  }

  /**
   * Constructs an instance of NewsServiceClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected NewsServiceClient(NewsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NewsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NewsServiceClient(NewsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NewsServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NewsServiceStub getStub() {
    return stub;
  }


  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists articles.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   Article.Site site = Article.Site.UNSPECIFIED;
   *   ListArticlesResponse response = newsServiceClient.listArticles(site);
   * }
   * </code></pre>
   *
   * @param site Optional.
   *
   * If specified, only articles from this site are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArticlesResponse listArticles(Article.Site site) {

    ListArticlesRequest request =
        ListArticlesRequest.newBuilder()
        .setSite(site)
        .build();
    return listArticles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists articles.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   ListArticlesRequest request = ListArticlesRequest.newBuilder().build();
   *   ListArticlesResponse response = newsServiceClient.listArticles(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListArticlesResponse listArticles(ListArticlesRequest request) {
    return listArticlesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists articles.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   ListArticlesRequest request = ListArticlesRequest.newBuilder().build();
   *   ApiFuture&lt;ListArticlesResponse&gt; future = newsServiceClient.listArticlesCallable().futureCall(request);
   *   // Do something
   *   ListArticlesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListArticlesRequest, ListArticlesResponse> listArticlesCallable() {
    return stub.listArticlesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an article.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   String id = "";
   *   Article response = newsServiceClient.getArticle(id);
   * }
   * </code></pre>
   *
   * @param id Required.
   *
   * The article ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Article getArticle(String id) {

    GetArticleRequest request =
        GetArticleRequest.newBuilder()
        .setId(id)
        .build();
    return getArticle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an article.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   String id = "";
   *   GetArticleRequest request = GetArticleRequest.newBuilder()
   *     .setId(id)
   *     .build();
   *   Article response = newsServiceClient.getArticle(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Article getArticle(GetArticleRequest request) {
    return getArticleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an article.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   String id = "";
   *   GetArticleRequest request = GetArticleRequest.newBuilder()
   *     .setId(id)
   *     .build();
   *   ApiFuture&lt;Article&gt; future = newsServiceClient.getArticleCallable().futureCall(request);
   *   // Do something
   *   Article response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetArticleRequest, Article> getArticleCallable() {
    return stub.getArticleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists authors.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   String personId = "";
   *   ListAuthorsResponse response = newsServiceClient.listAuthors(personId);
   * }
   * </code></pre>
   *
   * @param personId Optional.
   *
   * If specified, only author instances of this person are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorsResponse listAuthors(String personId) {

    ListAuthorsRequest request =
        ListAuthorsRequest.newBuilder()
        .setPersonId(personId)
        .build();
    return listAuthors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists authors.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   Article.Site site = Article.Site.UNSPECIFIED;
   *   ListAuthorsResponse response = newsServiceClient.listAuthors(site);
   * }
   * </code></pre>
   *
   * @param site Optional.
   *
   * If specified, only authors from this site are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorsResponse listAuthors(Article.Site site) {

    ListAuthorsRequest request =
        ListAuthorsRequest.newBuilder()
        .setSite(site)
        .build();
    return listAuthors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists authors.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   String personId = "";
   *   Article.Site site = Article.Site.UNSPECIFIED;
   *   ListAuthorsResponse response = newsServiceClient.listAuthors(personId, site);
   * }
   * </code></pre>
   *
   * @param personId Optional.
   *
   * If specified, only author instances of this person are returned.
   * @param site Optional.
   *
   * If specified, only authors from this site are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorsResponse listAuthors(String personId, Article.Site site) {

    ListAuthorsRequest request =
        ListAuthorsRequest.newBuilder()
        .setPersonId(personId)
        .setSite(site)
        .build();
    return listAuthors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists authors.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   ListAuthorsRequest request = ListAuthorsRequest.newBuilder().build();
   *   ListAuthorsResponse response = newsServiceClient.listAuthors(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorsResponse listAuthors(ListAuthorsRequest request) {
    return listAuthorsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists authors.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   ListAuthorsRequest request = ListAuthorsRequest.newBuilder().build();
   *   ApiFuture&lt;ListAuthorsResponse&gt; future = newsServiceClient.listAuthorsCallable().futureCall(request);
   *   // Do something
   *   ListAuthorsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListAuthorsRequest, ListAuthorsResponse> listAuthorsCallable() {
    return stub.listAuthorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an author.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   String id = "";
   *   Author response = newsServiceClient.getAuthor(id);
   * }
   * </code></pre>
   *
   * @param id Required.
   *
   * The authors ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Author getAuthor(String id) {

    GetAuthorRequest request =
        GetAuthorRequest.newBuilder()
        .setId(id)
        .build();
    return getAuthor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an author.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   String id = "";
   *   GetAuthorRequest request = GetAuthorRequest.newBuilder()
   *     .setId(id)
   *     .build();
   *   Author response = newsServiceClient.getAuthor(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Author getAuthor(GetAuthorRequest request) {
    return getAuthorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an author.
   *
   * Sample code:
   * <pre><code>
   * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
   *   String id = "";
   *   GetAuthorRequest request = GetAuthorRequest.newBuilder()
   *     .setId(id)
   *     .build();
   *   ApiFuture&lt;Author&gt; future = newsServiceClient.getAuthorCallable().futureCall(request);
   *   // Do something
   *   Author response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetAuthorRequest, Author> getAuthorCallable() {
    return stub.getAuthorCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }


}