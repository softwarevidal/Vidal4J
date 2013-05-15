package searches;

import api.VidalAPI;
import queries.ForeignProductByNameQuery;
import queries.ForeignProductByIdQuery;

public class ForeignProductSearch extends Search {

   public ForeignProductSearch(String baseUrl, VidalAPI vidalAPI) {
      super(baseUrl, vidalAPI);
   }

   public ForeignProductByNameQuery byName(String name) {
      return new ForeignProductByNameQuery(name, this.vidalAPI);
   }

   public ForeignProductByIdQuery byFrenchProductId(int id) {
      return new ForeignProductByIdQuery(id, this.vidalAPI);
   }
}
