package queries;

import api.FullVidalAPI;
import org.apache.abdera.model.Feed;
import results.ProductByIdResult;


public class ProductByIdQuery extends Query<ProductByIdQuery> {

   private final int id;

   public ProductByIdQuery(int id, FullVidalAPI fullVidalAPI) {
      super(fullVidalAPI);
      this.id = id;
   }

   @Override
   public ProductByIdResult execQuery() {
      Feed feed = this.fetchResults();
      return new ProductByIdResult(feed, this.fullVidalAPI);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder()
              .append(this.fullVidalAPI.getBaseUrl())
              .append("/rest/api/product/")
              .append(this.id);
   }
}
