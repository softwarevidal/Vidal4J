package queries;

import org.apache.abdera.model.Feed;
import results.APIEqFrenchProductByNameResult;


public class EqFrenchProductByNameQuery extends PaginatedQuery<EqFrenchProductByNameQuery> {

   public EqFrenchProductByNameQuery(String baseUrl, String name) {
      super(baseUrl);
      this.addParam("q", name);
   }

   @Override
   public APIEqFrenchProductByNameResult execQuery() {
      Feed feed = this.fetchResults();
      return new APIEqFrenchProductByNameResult(feed, this);
   }

   @Override
   protected StringBuilder buildUrl() {
      return new StringBuilder().append(this.baseUrl).append("/rest/api/foreign-products");
   }


   public EqFrenchProductByNameQuery setCountry(String country) {
      return this.addParam("country", country);
   }
}