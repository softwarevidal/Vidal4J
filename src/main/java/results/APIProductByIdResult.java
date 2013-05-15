package results;

import api.VidalAPI;
import items.FullProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import queries.ProductByIdQuery;

public class APIProductByIdResult extends APIResult {

   public APIProductByIdResult(Feed feed, VidalAPI vidalAPI) {
      super(feed, vidalAPI);
   }

   public FullProduct getFullProduct() {
      Entry entry = this.feed.getEntries().get(0);
      return new FullProduct(entry, this.vidalAPI);
   }
}
