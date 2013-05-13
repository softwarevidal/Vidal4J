package api;

import searches.EqFrenchProductSearch;
import searches.ForeignProductSearch;
import searches.ProductSearch;


public class VidalAPI {
   private String baseUrl;


   public VidalAPI(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public ProductSearch searchProduct() {
      return new ProductSearch(this.baseUrl, this);
   }

   public ForeignProductSearch searchForeignProduct() {
      return new ForeignProductSearch(this.baseUrl);
   }

   public EqFrenchProductSearch searchEqFrenchProduct() {
      return new EqFrenchProductSearch(this.baseUrl);
   }
}
