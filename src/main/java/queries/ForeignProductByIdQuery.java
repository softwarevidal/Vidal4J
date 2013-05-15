package queries;

import api.VidalAPI;
import org.apache.abdera.model.Feed;
import results.APIForeignProductByIdResult;


public class ForeignProductByIdQuery extends Query<ForeignProductByIdQuery> {

   private final int id;

   public ForeignProductByIdQuery(int id, VidalAPI vidalAPI) {
      super(vidalAPI);
      this.id = id;
   }

   @Override
   public APIForeignProductByIdResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIForeignProductByIdResult(feed, this);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder()
              .append(this.vidalAPI.getBaseUrl())
              .append("/rest/api/product/")
              .append(this.id)
              .append("/foreign-products");
   }
}
