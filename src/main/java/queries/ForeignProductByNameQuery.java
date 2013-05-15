package queries;

import api.VidalAPI;
import org.apache.abdera.model.Feed;
import results.APIForeignProductByNameResult;


public class ForeignProductByNameQuery extends PaginatedQuery<ForeignProductByNameQuery> {

   public ForeignProductByNameQuery(String name, VidalAPI vidalAPI) {
      super(vidalAPI);
      this.addParam("q", name);
   }

   @Override
   public APIForeignProductByNameResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIForeignProductByNameResult(feed, this.vidalAPI);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder()
              .append(this.vidalAPI.getBaseUrl())
              .append("/rest/api/foreign-products");
   }


   public ForeignProductByNameQuery setCountry(String country) {
      return this.addParam("country", country);
   }
}