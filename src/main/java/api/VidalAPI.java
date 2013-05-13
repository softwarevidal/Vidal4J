package api;

import searches.EqFrenchProductSearch;
import results.APIProductByNameResult;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Feed;
import searches.ForeignProductSearch;

import static utils.AtomTool.searchFeedFromURL;


public class VidalAPI {
   private String baseUrl;


   public VidalAPI(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public APIProductByNameResult searchProductsByName(String query) {
      IRI iri = new IRI("/rest/api/products?q=" + query);
      return this.searchProductsByURL(iri);
   }

   public APIProductByNameResult searchProductsByNameNextPage(APIProductByNameResult apiProductByNameResult) {
      IRI nextPageLink = apiProductByNameResult.getNextPageLink();
      return (nextPageLink != null) ? this.searchProductsByURL(nextPageLink) : null;
   }

   public APIProductByNameResult searchProductsByNamePrevPage(APIProductByNameResult apiProductByNameResult) {
      IRI prevPageLink = apiProductByNameResult.getPrevPageLink();
      return (prevPageLink != null) ? this.searchProductsByURL(prevPageLink) : null;
   }

   public APIProductByNameResult searchProductsByURL(IRI iri) {
      String searchUrl = this.baseUrl + iri.toString();
      Feed feed = searchFeedFromURL(searchUrl);
      return (feed != null) ? new APIProductByNameResult(feed) : null;
   }

   public ForeignProductSearch searchForeignProduct() {
      return new ForeignProductSearch(this.baseUrl);
   }

   public EqFrenchProductSearch searchEqFrenchProduct() {
      return new EqFrenchProductSearch(this.baseUrl);
   }


}
