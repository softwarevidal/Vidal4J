package api;

import searches.EqFrenchProductSearch;
import results.APIProductByNameResult;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Feed;
import searches.ForeignProductSearch;
import searches.ProductSearch;

import static utils.AtomTool.searchFeedFromURL;


public class VidalAPI {
   private String baseUrl;


   public VidalAPI(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public ProductSearch searchProduct() {
      return new ProductSearch(this.baseUrl);
   }

   public ForeignProductSearch searchForeignProduct() {
      return new ForeignProductSearch(this.baseUrl);
   }

   public EqFrenchProductSearch searchEqFrenchProduct() {
      return new EqFrenchProductSearch(this.baseUrl);
   }


}
