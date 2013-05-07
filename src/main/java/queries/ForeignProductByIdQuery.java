package queries;

import org.apache.abdera.model.Feed;
import results.APIForeignProductResult;


public class ForeignProductByIdQuery extends Query<ForeignProductByIdQuery> {

   private final int id;

   public ForeignProductByIdQuery(String baseUrl, int id) {
      super(baseUrl);
      this.id = id;
   }

   @Override
   public APIForeignProductResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIForeignProductResult(feed, this);
   }

   @Override
   protected StringBuilder buildUrl() {
      StringBuilder builder = new StringBuilder();
      builder.append(this.baseUrl).append("/rest/api/product/").append(this.id).append("/foreign-products");
      return builder;
   }
}
