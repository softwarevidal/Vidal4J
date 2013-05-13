package results;

import models.OfIdProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import queries.ProductByIdQuery;

public class APIProductByIdResult extends APIResult {

   public APIProductByIdResult(Feed resultFeed) {
      super(resultFeed);
   }

   public APIProductByIdResult(Feed feed, ProductByIdQuery productByIdQuery) {
      super(feed, productByIdQuery);
   }

   public OfIdProduct getFullProduct() {
      Entry entry = this.feed.getEntries().get(0);
      return new OfIdProduct(entry, this.query.getVidalAPI());
   }
}
