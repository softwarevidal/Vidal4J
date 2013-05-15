package queries;

import api.FullVidalAPI;
import org.apache.abdera.model.Feed;
import results.ForeignProductByNameResult;


public class ForeignProductByNameQuery extends PaginatedQuery<ForeignProductByNameQuery> {

   public ForeignProductByNameQuery(String name, FullVidalAPI fullVidalAPI) {
      super(fullVidalAPI);
      this.addParam("q", name);
   }

   @Override
   public ForeignProductByNameResult execQuery() {
      Feed feed = this.fetchResults();
      return new ForeignProductByNameResult(feed, this.fullVidalAPI);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder()
              .append(this.fullVidalAPI.getBaseUrl())
              .append("/rest/api/foreign-products");
   }


   public ForeignProductByNameQuery setCountry(String country) {
      return this.addParam("country", country);
   }
}