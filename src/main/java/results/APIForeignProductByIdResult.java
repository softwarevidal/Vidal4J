package results;

import api.VidalAPI;
import items.ForeignProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIForeignProductByIdResult extends APIResult {

   public APIForeignProductByIdResult(Feed feed, VidalAPI vidalAPI) {
      super(feed, vidalAPI);
   }


   public List<ForeignProduct> getForeignProducts() {
      List<Entry> entries = this.feed.getEntries();
      List<ForeignProduct> foreignProducts = new ArrayList<ForeignProduct>();

      for(Entry entry : entries) {
         foreignProducts.add(new ForeignProduct(entry, this.vidalAPI));
      }

      return foreignProducts;
   }
}
