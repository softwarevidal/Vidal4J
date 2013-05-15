package queries;

import api.VidalAPI;
import org.apache.abdera.model.Feed;
import results.APIForeignProductByIdResult;


public class ForeignProductByIdQuery extends Query<ForeignProductByIdQuery> {

   private final int id;

   public ForeignProductByIdQuery(String baseUrl, int id) {
      super(baseUrl);
      this.id = id;
   }

   public ForeignProductByIdQuery(String baseUrl, int id, VidalAPI vidalAPI) {
      super(baseUrl, vidalAPI);
      this.id = id;
   }

   @Override
   public APIForeignProductByIdResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIForeignProductByIdResult(feed, this);
   }

   @Override
   protected StringBuilder buildUrl() {
      StringBuilder builder = new StringBuilder();
      builder.append(this.baseUrl).append("/rest/api/product/").append(this.id).append("/foreign-products");
      return builder;
   }
}
