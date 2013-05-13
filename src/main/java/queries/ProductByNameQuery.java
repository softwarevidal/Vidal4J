package queries;

import org.apache.abdera.model.Feed;
import results.APIProductByNameResult;


public class ProductByNameQuery extends PaginatedQuery<ProductByNameQuery> {

   public static final String Q_PARAM = "q";
   public static final String STARTWITH_PARAM = "startwith";

   public ProductByNameQuery(String baseUrl) {
      super(baseUrl);
   }

   @Override
   public APIProductByNameResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIProductByNameResult(feed);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder().append(this.baseUrl).append("/rest/api/products");
   }

   public ProductByNameQuery setQuery(String query) {
      this.params.remove(STARTWITH_PARAM);
      return this.addParam(Q_PARAM, query);
   }

   public ProductByNameQuery setStartWith(String startWith) {
      this.params.remove(Q_PARAM);
      return this.addParam(STARTWITH_PARAM, startWith);
   }

   public ProductByNameQuery setStatus(String status) {
      return this.addParam("status", status);
   }
}
