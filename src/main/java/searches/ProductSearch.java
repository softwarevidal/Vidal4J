package searches;

import api.VidalAPI;
import queries.ProductByIdQuery;
import queries.ProductByNameQuery;

public class ProductSearch extends Search {

   public ProductSearch(String baseUrl, VidalAPI vidalAPI) {
      super(baseUrl, vidalAPI);
   }


   public ProductByIdQuery byId(int id) {
      return new ProductByIdQuery(id, this.vidalAPI);
   }

   public ProductByNameQuery byName() {
      return new ProductByNameQuery(this.vidalAPI);
   }
}
