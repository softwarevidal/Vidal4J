package queries;

import api.FullVidalAPI;
import org.apache.abdera.model.Feed;
import results.APIForeignProductByNameResult;


public class ForeignProductByNameQuery extends PaginatedQuery<ForeignProductByNameQuery> {

   public ForeignProductByNameQuery(String name, FullVidalAPI fullVidalAPI) {
      super(fullVidalAPI);
      this.addParam("q", name);
   }

   @Override
   public APIForeignProductByNameResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIForeignProductByNameResult(feed, this.fullVidalAPI);
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