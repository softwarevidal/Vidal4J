package searches;

import queries.ProductByIdQuery;
import queries.ProductByNameQuery;

public class ProductSearch {

   private final String baseUrl;

   public ProductSearch(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public ProductByIdQuery byId(int id) {
      return new ProductByIdQuery(this.baseUrl, id);
   }

   public ProductByNameQuery byName() {
      return new ProductByNameQuery(this.baseUrl);
   }
}
