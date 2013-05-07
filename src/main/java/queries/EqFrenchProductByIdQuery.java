package queries;

import org.apache.abdera.model.Feed;
import results.APIEqFrenchProductByIdResult;


public class EqFrenchProductByIdQuery extends Query<EqFrenchProductByIdQuery> {

   private final int id;

   public EqFrenchProductByIdQuery(String baseUrl, int id) {
      super(baseUrl);
      this.id = id;
   }


   @Override
   public APIEqFrenchProductByIdResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIEqFrenchProductByIdResult(feed);
   }

   @Override
   protected StringBuilder buildUrl() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.baseUrl)
                   .append("/rest/api/foreign-product/")
                   .append(this.id)
                   .append("/products");
      return stringBuilder;
   }

   public EqFrenchProductByIdQuery setSameRoutes(boolean sameRoutes) {
      return this.addParam("sameRoutes", String.valueOf(sameRoutes));
   }

   public EqFrenchProductByIdQuery setSameForm(boolean sameForm) {
      return this.addParam("sameForm", String.valueOf(sameForm));
   }
}
