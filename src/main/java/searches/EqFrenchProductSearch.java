package searches;

import api.VidalAPI;
import queries.EqFrenchProductByIdQuery;
import queries.EqFrenchProductByNameQuery;

public class EqFrenchProductSearch extends Search {

   public EqFrenchProductSearch(String baseUrl, VidalAPI vidalAPI) {
      super(baseUrl, vidalAPI);
   }


   public EqFrenchProductByNameQuery byName(String name) {
      return new EqFrenchProductByNameQuery(this.baseUrl, name, this.vidalAPI);
   }

   public EqFrenchProductByIdQuery byId(int id) {
      return new EqFrenchProductByIdQuery(this.baseUrl, id, this.vidalAPI);
   }
}
