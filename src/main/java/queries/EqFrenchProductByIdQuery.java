package queries;

import api.VidalAPI;
import org.apache.abdera.model.Feed;
import results.APIEqFrenchProductByIdResult;


public class EqFrenchProductByIdQuery extends Query<EqFrenchProductByIdQuery> {

   private final int id;

   public EqFrenchProductByIdQuery(int id, VidalAPI vidalAPI) {
      super(vidalAPI);
      this.id = id;
   }


   @Override
   public APIEqFrenchProductByIdResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIEqFrenchProductByIdResult(feed, this.vidalAPI);
   }

   @Override
   protected StringBuilder buildUrl() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.vidalAPI.getBaseUrl())
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
