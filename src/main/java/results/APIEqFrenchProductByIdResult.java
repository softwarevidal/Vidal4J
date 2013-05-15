package results;

import api.VidalAPI;
import items.FullEqFrenchProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIEqFrenchProductByIdResult extends APIResult {

   public APIEqFrenchProductByIdResult(Feed feed, VidalAPI vidalAPI) {
      super(feed, vidalAPI);
   }

   public List<FullEqFrenchProduct> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<FullEqFrenchProduct> fullEqFrenchProducts = new ArrayList<FullEqFrenchProduct>();

      for(Entry entry : entries) {
         fullEqFrenchProducts.add(new FullEqFrenchProduct(entry, this.vidalAPI));
      }

      return fullEqFrenchProducts;
   }
}
