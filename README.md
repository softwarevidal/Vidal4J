Vidal4J
================================================================================

Welcome to the Vidal4J project. It is a wrapper around the Vidal REST API in
 order to use it without bothering about the URLs, and XML parsing.

Structure
--------------------------------------------------------------------------------

### VidalAPI

The workflow starts with a `VidalAPI`. It connects to the development, beta or
 production version of the APIs. With the `VidalAPI` you will choose what kind of
 research you want to do : products, foreign-products... It returns you a
 `Search`.

The start points of the APIs are only researches by name.

It returns a `Query`.

### Query

The `Query` represents... the real query. That means you can configure your
 query by setting parameters before calling `execQuery()`.

It returns a `Result`.

### Result

The `Result` represents the entire *feed*. That means you will have access to
 the header, and the list of entries.

### Item

An `Item` represents an *entry*. You will then have access to all the content
 of the entry, and you can fluently open the links.

Example
--------------------------------------------------------------------------------

Here is an example to search products by name.

Get an instance of `VidalAPI` :

``` java
VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
```

We want to search for products, right ? So :

``` java
ProductByNameQuery byNameQuery = vidalAPI.searchProductsByName();
```

Now we can configure our request :

``` java
ProductByNameQuery readyQuery = query.setQuery("asp").setPageSize(10);
```

It's time to execute it !

``` java
APIProductByNameResult result = readyQuery.execQuery();
```

So we have a result, we can then explore the header :

``` java
DateTime lastUpdate = result.getLastUpdate();
int currentPageNumber = result.getCurrentPageNumber();
String title = result.getTitle();
```

Since this request has pagination, we can also explore the other pages :

``` java
APIProductByNameResult nextPageResult = result.openNextPage();
```

But probably the most important part is to get the list of products, so :

``` java
List<OfNameProduct> products = result.getProducts();
```

Like the `Result`, we have access to all the attributes of the entries :

``` java
OfNameProduct product = products.get(0);

String name = product.getName();
MarketStatus marketStatus = product.getMarketStatus();
String refundRate = product.getRefundRate();
```

And since the products returned from a research by name are an incomplete
 representation of the product, we can open the full product fetched from a
 research by id :

``` java
APIProductByIdResult byIdResult = product.openProduct();
```