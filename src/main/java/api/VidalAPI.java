package api;

import results.APIEqFrenchProductByNameResult;
import results.APIEqFrenchProductResult;
import results.APIForeignProductResult;
import results.APIProductResult;
import org.apache.abdera.Abdera;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Feed;
import org.apache.abdera.parser.Parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class VidalAPI {
   private String baseUrl;
   private Parser parser = new Abdera().getParser();


   public VidalAPI(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public APIProductResult searchProductsByName(String query) {
      IRI iri = new IRI("/rest/api/products?q=" + query);
      return this.searchProductsByURL(iri);
   }

   public APIProductResult searchProductsByNameNextPage(APIProductResult apiProductResult) {
      IRI nextPageLink = apiProductResult.getNextPageLink();
      return (nextPageLink != null) ? this.searchProductsByURL(nextPageLink) : null;
   }

   public APIProductResult searchProductsByNamePrevPage(APIProductResult apiProductResult) {
      IRI prevPageLink = apiProductResult.getPrevPageLink();
      return (prevPageLink != null) ? this.searchProductsByURL(prevPageLink) : null;
   }

   public APIProductResult searchProductsByURL(IRI iri) {
      String searchUrl = this.baseUrl + iri.toString();
      Feed feed = this.searchFeedFromURL(searchUrl);
      return (feed != null) ? new APIProductResult(feed) : null;
   }

   public APIForeignProductResult searchForeignProductsByProductId(int productId) {
      String searchUrl = this.baseUrl + "/rest/api/product/" + productId + "/foreign-products";
      Feed feed = this.searchFeedFromURL(searchUrl);
      return (feed != null) ? new APIForeignProductResult(feed) : null;
   }

   public APIEqFrenchProductResult searchEqFrenchProductsByProductId(int productId) {
      String searchUrl = this.baseUrl + "/rest/api/foreign-product/" + productId + "/products";
      Feed feed = this.searchFeedFromURL(searchUrl);
      return (feed != null) ? new APIEqFrenchProductResult(feed) : null;
   }

   public APIEqFrenchProductByNameResult searchEqFrenchProductByName(String name) {
      String searchUrl = this.baseUrl + "/rest/api/foreign-products?q=" + name;
      Feed feed = this.searchFeedFromURL(searchUrl);
      return (feed != null) ? new APIEqFrenchProductByNameResult(feed) : null;
   }


   private Feed searchFeedFromURL(String searchUrl) {
      Feed feed = null;

      try {
         URL url = new URL(searchUrl);
         Document<Feed> doc = parser.parse(url.openStream(), url.toString());
         feed = doc.getRoot();
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }

      return feed;
   }
}
