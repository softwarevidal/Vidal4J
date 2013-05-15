package searches;

import api.FullVidalAPI;
import queries.EqFrenchProductByIdQuery;

public class EqFrenchProductSearch extends Search {

   public EqFrenchProductSearch(String baseUrl, FullVidalAPI fullVidalAPI) {
      super(baseUrl, fullVidalAPI);
   }


   public EqFrenchProductByIdQuery byId(int id) {
      return new EqFrenchProductByIdQuery(id, this.fullVidalAPI);
   }
}
