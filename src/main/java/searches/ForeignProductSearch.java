package searches;

import api.FullVidalAPI;
import queries.ForeignProductByNameQuery;
import queries.ForeignProductByIdQuery;

public class ForeignProductSearch extends Search {

   public ForeignProductSearch(String baseUrl, FullVidalAPI fullVidalAPI) {
      super(baseUrl, fullVidalAPI);
   }

   public ForeignProductByNameQuery byName(String name) {
      return new ForeignProductByNameQuery(name, this.fullVidalAPI);
   }

   public ForeignProductByIdQuery byFrenchProductId(int id) {
      return new ForeignProductByIdQuery(id, this.fullVidalAPI);
   }
}
