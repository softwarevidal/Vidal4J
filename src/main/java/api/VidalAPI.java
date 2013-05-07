package api;

import searches.EqFrenchProductSearch;
import results.APIForeignProductResult;
import results.APIProductResult;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Feed;
import searches.ForeignProductSearch;

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

   public ForeignProductSearch searchForeignProduct() {
      return new ForeignProductSearch(this.baseUrl);
   }

   public EqFrenchProductSearch searchEqFrenchProduct() {
      return new EqFrenchProductSearch(this.baseUrl);
   }


}
