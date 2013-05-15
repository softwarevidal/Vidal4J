package results;

import api.FullVidalAPI;
import items.FullProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

public class ProductByIdResult extends Result {

   public ProductByIdResult(Feed feed, FullVidalAPI fullVidalAPI) {
      super(feed, fullVidalAPI);
   }

   public FullProduct getFullProduct() {
      Entry entry = this.feed.getEntries().get(0);
      return new FullProduct(entry, this.fullVidalAPI);
   }
}
