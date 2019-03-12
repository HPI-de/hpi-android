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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.GeneratedMessageV3;
import de.hpi.cloud.news.v1test.Article;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class NewsServiceClientTest {
  private static MockNewsService mockNewsService;
  private static MockServiceHelper serviceHelper;
  private NewsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockNewsService = new MockNewsService();
    serviceHelper = new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockNewsService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    NewsServiceSettings settings = NewsServiceSettings.newBuilder()
        .setTransportChannelProvider(channelProvider)
        .setCredentialsProvider(NoCredentialsProvider.create())
        .build();
    client = NewsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listArticlesTest() {
    ListArticlesResponse expectedResponse = ListArticlesResponse.newBuilder().build();
    mockNewsService.addResponse(expectedResponse);

    Article.Site site = Article.Site.UNSPECIFIED;

    ListArticlesResponse actualResponse =
        client.listArticles(site);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockNewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListArticlesRequest actualRequest = (ListArticlesRequest)actualRequests.get(0);

    Assert.assertEquals(site, actualRequest.getSite());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listArticlesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNewsService.addException(exception);

    try {
      Article.Site site = Article.Site.UNSPECIFIED;

      client.listArticles(site);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getArticleTest() {
    String id2 = "id23227150";
    String link = "link3321850";
    String title = "title110371416";
    String thumbnail = "thumbnail1330532588";
    String description = "description-1724546052";
    int viewCount = 1534353675;
    String content = "content951530617";
    Article expectedResponse = Article.newBuilder()
      .setId(id2)
      .setLink(link)
      .setTitle(title)
      .setThumbnail(thumbnail)
      .setDescription(description)
      .setViewCount(viewCount)
      .setContent(content)
      .build();
    mockNewsService.addResponse(expectedResponse);

    String id = "id3355";

    Article actualResponse =
        client.getArticle(id);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockNewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetArticleRequest actualRequest = (GetArticleRequest)actualRequests.get(0);

    Assert.assertEquals(id, actualRequest.getId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getArticleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNewsService.addException(exception);

    try {
      String id = "id3355";

      client.getArticle(id);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAuthorsTest() {
    ListAuthorsResponse expectedResponse = ListAuthorsResponse.newBuilder().build();
    mockNewsService.addResponse(expectedResponse);

    String personId = "personId853187141";

    ListAuthorsResponse actualResponse =
        client.listAuthors(personId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockNewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthorsRequest actualRequest = (ListAuthorsRequest)actualRequests.get(0);

    Assert.assertEquals(personId, actualRequest.getPersonId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAuthorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNewsService.addException(exception);

    try {
      String personId = "personId853187141";

      client.listAuthors(personId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAuthorsTest2() {
    ListAuthorsResponse expectedResponse = ListAuthorsResponse.newBuilder().build();
    mockNewsService.addResponse(expectedResponse);

    Article.Site site = Article.Site.UNSPECIFIED;

    ListAuthorsResponse actualResponse =
        client.listAuthors(site);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockNewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthorsRequest actualRequest = (ListAuthorsRequest)actualRequests.get(0);

    Assert.assertEquals(site, actualRequest.getSite());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAuthorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNewsService.addException(exception);

    try {
      Article.Site site = Article.Site.UNSPECIFIED;

      client.listAuthors(site);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAuthorsTest3() {
    ListAuthorsResponse expectedResponse = ListAuthorsResponse.newBuilder().build();
    mockNewsService.addResponse(expectedResponse);

    String personId = "personId853187141";
    Article.Site site = Article.Site.UNSPECIFIED;

    ListAuthorsResponse actualResponse =
        client.listAuthors(personId, site);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockNewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthorsRequest actualRequest = (ListAuthorsRequest)actualRequests.get(0);

    Assert.assertEquals(personId, actualRequest.getPersonId());
    Assert.assertEquals(site, actualRequest.getSite());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAuthorsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNewsService.addException(exception);

    try {
      String personId = "personId853187141";
      Article.Site site = Article.Site.UNSPECIFIED;

      client.listAuthors(personId, site);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAuthorTest() {
    String id2 = "id23227150";
    String personId = "personId853187141";
    String link = "link3321850";
    String description = "description-1724546052";
    int postCount = 1946899632;
    int commentCount = 1120985297;
    Author expectedResponse = Author.newBuilder()
      .setId(id2)
      .setPersonId(personId)
      .setLink(link)
      .setDescription(description)
      .setPostCount(postCount)
      .setCommentCount(commentCount)
      .build();
    mockNewsService.addResponse(expectedResponse);

    String id = "id3355";

    Author actualResponse =
        client.getAuthor(id);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockNewsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthorRequest actualRequest = (GetAuthorRequest)actualRequests.get(0);

    Assert.assertEquals(id, actualRequest.getId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getAuthorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockNewsService.addException(exception);

    try {
      String id = "id3355";

      client.getAuthor(id);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

}