package searches;

import queries.ProductByNameQuery;

public class ProductSearch {

   private final String baseUrl;

   public ProductSearch(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public ProductByNameQuery byName() {
      return new ProductByNameQuery(this.baseUrl);
   }
}
