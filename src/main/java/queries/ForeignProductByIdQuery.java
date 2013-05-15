package queries;

import api.FullVidalAPI;
import org.apache.abdera.model.Feed;
import results.ForeignProductByIdResult;


public class ForeignProductByIdQuery extends Query<ForeignProductByIdQuery> {

   private final int id;

   public ForeignProductByIdQuery(int id, FullVidalAPI fullVidalAPI) {
      super(fullVidalAPI);
      this.id = id;
   }

   @Override
   public ForeignProductByIdResult execQuery() {
      Feed feed = this.fetchResults();
      return new ForeignProductByIdResult(feed, this.fullVidalAPI);
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
