package queries;

import api.FullVidalAPI;
import org.apache.abdera.model.Feed;
import results.APIForeignProductByIdResult;


public class ForeignProductByIdQuery extends Query<ForeignProductByIdQuery> {

   private final int id;

   public ForeignProductByIdQuery(int id, FullVidalAPI fullVidalAPI) {
      super(fullVidalAPI);
      this.id = id;
   }

   @Override
   public APIForeignProductByIdResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIForeignProductByIdResult(feed, this.fullVidalAPI);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder()
              .append(this.fullVidalAPI.getBaseUrl())
              .append("/rest/api/product/")
              .append(this.id)
              .append("/foreign-products");
   }
}
