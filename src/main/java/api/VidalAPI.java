package api;

import queries.EqFrenchProductSearch;
import results.APIEqFrenchProductByNameResult;
import results.APIEqFrenchProductByIdResult;
import results.APIForeignProductResult;
import results.APIProductResult;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Feed;

import static utils.AtomTool.searchFeedFromURL;


public class VidalAPI {
   private String baseUrl;


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
      Feed feed = searchFeedFromURL(searchUrl);
      return (feed != null) ? new APIProductResult(feed) : null;
   }

   public APIForeignProductResult searchForeignProductsByProductId(int productId) {
      String searchUrl = this.baseUrl + "/rest/api/product/" + productId + "/foreign-products";
      Feed feed = searchFeedFromURL(searchUrl);
      return (feed != null) ? new APIForeignProductResult(feed) : null;
   }

   public APIEqFrenchProductByIdResult searchEqFrenchProductsByProductId(int productId) {
      String searchUrl = this.baseUrl + "/rest/api/foreign-product/" + productId + "/products";
      Feed feed = searchFeedFromURL(searchUrl);
      return (feed != null) ? new APIEqFrenchProductByIdResult(feed) : null;
   }

   public APIEqFrenchProductByNameResult searchEqFrenchProductByName(String name) {
      String searchUrl = this.baseUrl + "/rest/api/foreign-products?q=" + name;
      Feed feed = searchFeedFromURL(searchUrl);
      return (feed != null) ? new APIEqFrenchProductByNameResult(feed) : null;
   }

   public EqFrenchProductSearch searchEqFrenchProduct() {
      return new EqFrenchProductSearch(this.baseUrl);
   }


}
