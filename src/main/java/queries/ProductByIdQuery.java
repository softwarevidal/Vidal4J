package queries;

import api.VidalAPI;
import org.apache.abdera.model.Feed;
import results.APIProductByIdResult;


public class ProductByIdQuery extends Query<ProductByIdQuery> {

   private final int id;

   public ProductByIdQuery(String baseUrl, int id, VidalAPI vidalAPI) {
      super(baseUrl, vidalAPI);
      this.id = id;
   }

   @Override
   public APIProductByIdResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIProductByIdResult(feed, this);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder().append(this.baseUrl).append("/rest/api/product/").append(this.id);
   }
}
