package searches;

import api.VidalAPI;
import queries.EqFrenchProductByIdQuery;

public class EqFrenchProductSearch extends Search {

   public EqFrenchProductSearch(String baseUrl, VidalAPI vidalAPI) {
      super(baseUrl, vidalAPI);
   }


   public EqFrenchProductByIdQuery byId(int id) {
      return new EqFrenchProductByIdQuery(this.baseUrl, id, this.vidalAPI);
   }
}
