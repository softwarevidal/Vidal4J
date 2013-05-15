package queries;

import api.VidalAPI;
import org.apache.abdera.model.Feed;
import results.APIForeignProductByNameResult;


public class ForeignProductByNameQuery extends PaginatedQuery<ForeignProductByNameQuery> {

   public ForeignProductByNameQuery(String baseUrl, String name, VidalAPI vidalAPI) {
      super(baseUrl, vidalAPI);
      this.addParam("q", name);
   }

   @Override
   public APIForeignProductByNameResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIForeignProductByNameResult(feed, this);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder().append(this.baseUrl).append("/rest/api/foreign-products");
   }


   public ForeignProductByNameQuery setCountry(String country) {
      return this.addParam("country", country);
   }
}