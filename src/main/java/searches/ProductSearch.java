package searches;

import api.FullVidalAPI;
import queries.ProductByIdQuery;
import queries.ProductByNameQuery;

public class ProductSearch extends Search {

   public ProductSearch(String baseUrl, FullVidalAPI fullVidalAPI) {
      super(baseUrl, fullVidalAPI);
   }


   public ProductByIdQuery byId(int id) {
      return new ProductByIdQuery(id, this.fullVidalAPI);
   }

   public ProductByNameQuery byName() {
      return new ProductByNameQuery(this.fullVidalAPI);
   }
}
