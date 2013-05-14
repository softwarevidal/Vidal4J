package api;

import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Feed;
import searches.EqFrenchProductSearch;
import searches.ForeignProductSearch;
import searches.ProductSearch;

import static utils.AtomTool.searchFeedFromURL;


public class VidalAPI {
   private String baseUrl;


   public VidalAPI(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public ProductSearch searchProduct() {
      return new ProductSearch(this.baseUrl, this);
   }

   public ForeignProductSearch searchForeignProduct() {
      return new ForeignProductSearch(this.baseUrl, this);
   }

   public EqFrenchProductSearch searchEqFrenchProduct() {
      return new EqFrenchProductSearch(this.baseUrl, this);
   }

   public Feed openPage(IRI uri) {
      String url = null;
      if(uri != null) {
         url = this.baseUrl + uri.toString();
      }
      return (url != null) ? searchFeedFromURL(url) : null;
   }
}
