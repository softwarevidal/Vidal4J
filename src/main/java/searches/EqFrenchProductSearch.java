package searches;

import queries.EqFrenchProductByIdQuery;
import queries.EqFrenchProductByNameQuery;

public class EqFrenchProductSearch {

   private final String baseUrl;

   public EqFrenchProductSearch(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public EqFrenchProductByNameQuery byName(String name) {
      return new EqFrenchProductByNameQuery(this.baseUrl, name);
   }

   public EqFrenchProductByIdQuery byId(int id) {
      return new EqFrenchProductByIdQuery(this.baseUrl, id);
   }
}
