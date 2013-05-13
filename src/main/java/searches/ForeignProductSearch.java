package searches;

import api.VidalAPI;
import queries.ForeignProductByIdQuery;

public class ForeignProductSearch extends Search {

   public ForeignProductSearch(String baseUrl, VidalAPI vidalAPI) {
      super(baseUrl, vidalAPI);
   }


   public ForeignProductByIdQuery byFrenchProductId(int id) {
      return new ForeignProductByIdQuery(this.baseUrl, id, this.vidalAPI);
   }
}
