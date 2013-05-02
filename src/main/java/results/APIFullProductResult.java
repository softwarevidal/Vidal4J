package results;

import models.FullProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

public class APIFullProductResult extends APIResult {
   public APIFullProductResult(Feed resultFeed) {
      super(resultFeed);
   }

   public FullProduct getFullProduct() {
      Entry entry = this.feed.getEntries().get(0);
      return new FullProduct(entry);
   }
}
