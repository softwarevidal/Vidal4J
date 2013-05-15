package queries;

import api.VidalAPI;
import org.apache.abdera.model.Feed;
import results.APIProductByNameResult;
import utils.MarketStatusEnum;


public class ProductByNameQuery extends PaginatedQuery<ProductByNameQuery> {

   public static final String Q_PARAM = "q";
   public static final String STARTWITH_PARAM = "startwith";

   public ProductByNameQuery(String baseUrl, VidalAPI vidalAPI) {
      super(baseUrl, vidalAPI);
   }

   @Override
   public APIProductByNameResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIProductByNameResult(feed, this);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder().append(this.baseUrl).append("/rest/api/products");
   }

   public ProductByNameQuery setQuery(String query) {
      this.removeParam(STARTWITH_PARAM);
      return this.addParam(Q_PARAM, query);
   }

   public ProductByNameQuery setStartWith(String startWith) {
      this.removeParam(Q_PARAM);
      return this.addParam(STARTWITH_PARAM, startWith);
   }

   public ProductByNameQuery setStatus(MarketStatusEnum status) {
      return this.addParam("status", status.toString());
   }
}
