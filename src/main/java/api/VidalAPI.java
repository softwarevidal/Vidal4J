package api;

import queries.ForeignProductByNameQuery;
import queries.ProductByNameQuery;

public class VidalAPI {

   private final FullVidalAPI fullVidalAPI;

   public VidalAPI(FullVidalAPI fullVidalAPI) {
      this.fullVidalAPI = fullVidalAPI;
   }

   
   public ProductByNameQuery searchProductsByName() {
      return new ProductByNameQuery(this.fullVidalAPI);
   }

   public ForeignProductByNameQuery searchForeignProductsByName(String name) {
      return new ForeignProductByNameQuery(name, this.fullVidalAPI);
   }
}
