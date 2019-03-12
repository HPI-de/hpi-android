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

/**
 * A client to News API.
 *
 * The interfaces provided are listed below, along with usage samples.
 *
 * =================
 * NewsServiceClient
 * =================
 *
 * Service Description: Provides access to news from the HPI an HPImgzn.
 *
 * Sample for NewsServiceClient:
 * <pre>
 * <code>
 * try (NewsServiceClient newsServiceClient = NewsServiceClient.create()) {
 *   Article.Site site = Article.Site.UNSPECIFIED;
 *   ListArticlesResponse response = newsServiceClient.listArticles(site);
 * }
 * </code>
 * </pre>
 *
 */

package de.hpi.cloud.news.v1test;