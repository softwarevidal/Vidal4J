package results;

import items.FullForeignProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import queries.ForeignProductByIdQuery;

import java.util.ArrayList;
import java.util.List;

public class APIForeignProductByIdResult extends APIResult {

   public APIForeignProductByIdResult(Feed feed, ForeignProductByIdQuery query) {
      super(feed, query);
   }


   public List<FullForeignProduct> getForeignProducts() {
      List<Entry> entries = this.feed.getEntries();
      List<FullForeignProduct> fullForeignProducts = new ArrayList<FullForeignProduct>();

      for(Entry entry : entries) {
         fullForeignProducts.add(new FullForeignProduct(entry, this.query.getVidalAPI()));
      }

      return fullForeignProducts;
   }
}
