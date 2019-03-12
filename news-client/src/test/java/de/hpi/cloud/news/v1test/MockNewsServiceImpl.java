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

import com.google.api.core.BetaApi;
import com.google.common.collect.Lists;
import com.google.protobuf.GeneratedMessageV3;
import de.hpi.cloud.news.v1test.NewsServiceGrpc.NewsServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockNewsServiceImpl extends NewsServiceImplBase {
  private ArrayList<GeneratedMessageV3> requests;
  private Queue<Object> responses;

  public MockNewsServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<GeneratedMessageV3> getRequests() {
    return requests;
  }

  public void addResponse(GeneratedMessageV3 response) {
    responses.add(response);
  }

  public void setResponses(List<GeneratedMessageV3> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void listArticles(ListArticlesRequest request,
    StreamObserver<ListArticlesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListArticlesResponse) {
      requests.add(request);
      responseObserver.onNext((ListArticlesResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getArticle(GetArticleRequest request,
    StreamObserver<Article> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Article) {
      requests.add(request);
      responseObserver.onNext((Article) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listAuthors(ListAuthorsRequest request,
    StreamObserver<ListAuthorsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListAuthorsResponse) {
      requests.add(request);
      responseObserver.onNext((ListAuthorsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getAuthor(GetAuthorRequest request,
    StreamObserver<Author> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Author) {
      requests.add(request);
      responseObserver.onNext((Author) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

}