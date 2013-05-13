package queries;

import org.apache.abdera.model.Feed;
import results.APIProductByIdResult;


public class ProductByIdQuery extends Query<ProductByIdQuery> {

   private final int id;

   public ProductByIdQuery(String baseUrl, int id) {
      super(baseUrl);
      this.id = id;
   }

   @Override
   public APIProductByIdResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIProductByIdResult(feed);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder().append(this.baseUrl).append("/rest/api/product/").append(this.id);
   }
}
