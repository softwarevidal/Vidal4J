Vidal4J
================================================================================

Welcome to the Vidal4J project. It is a wrapper around the Vidal REST API in
 order to use it without bothering about the URLs, and XML parsing.

Make a query
--------------------------------------------------------------------------------

Get a instance of the VidalAPI using the VidalAPIFactory. This will enable you
 to choose between the production, beta or development version.

``` java
VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
```

Queries are methods of the VidalAPI. So for instance, to search products by
 name :

``` java
APIProductResult productResult = vidalAPI.searchProductsByName("asp");
```

This will send a request on the URL :

> http://apirest-dev.vidal.fr/rest/api/products?q=asp

Structure of the results
--------------------------------------------------------------------------------

### The returned type

Each query will return a specific `API***Result` type extending `APIResult`. It
 represents the whole ATOM XML returned. Thus, you will have access to the
 headers, and the entries.

### Structure of the entries

The entries are also specificaly typed in each result, so you will have a nice
 semantic access to its attributes.

Handling pagination
-------------------------------------------------------------------------------- 

If the `API***Result` supports pagination, it will contain the link to the
 previous and next page, and the VidalAPI will make the query. So you must pass
 your `API***Result` to the VidalAPI. For instance :

``` java
APIProductResult nextPage = vidalAPI.searchProductsByNameNextPage(productResult);
```
