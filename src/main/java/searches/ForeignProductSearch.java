package searches;

import queries.ForeignProductByIdQuery;

public class ForeignProductSearch {

   private final String baseUrl;

   public ForeignProductSearch(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public ForeignProductByIdQuery byFrenchProductId(int id) {
      return new ForeignProductByIdQuery(this.baseUrl, id);
   }
}
