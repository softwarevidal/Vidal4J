package queries;

import api.FullVidalAPI;
import org.apache.abdera.model.Feed;
import results.ProductByNameResult;
import utils.MarketStatusEnum;


public class ProductByNameQuery extends PaginatedQuery<ProductByNameQuery> {

   public static final String Q_PARAM = "q";
   public static final String STARTWITH_PARAM = "startwith";

   public ProductByNameQuery(FullVidalAPI fullVidalAPI) {
      super(fullVidalAPI);
   }

   @Override
   public ProductByNameResult execQuery() {
      Feed feed = this.fetchResults();
      return new ProductByNameResult(feed, this.fullVidalAPI);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder()
              .append(this.fullVidalAPI.getBaseUrl())
              .append("/rest/api/products");
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
