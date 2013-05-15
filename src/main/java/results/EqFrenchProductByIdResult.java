package results;

import api.FullVidalAPI;
import items.FullEqFrenchProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class EqFrenchProductByIdResult extends Result {

   public EqFrenchProductByIdResult(Feed feed, FullVidalAPI fullVidalAPI) {
      super(feed, fullVidalAPI);
   }

   public List<FullEqFrenchProduct> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<FullEqFrenchProduct> fullEqFrenchProducts = new ArrayList<FullEqFrenchProduct>();

      for(Entry entry : entries) {
         fullEqFrenchProducts.add(new FullEqFrenchProduct(entry, this.fullVidalAPI));
      }

      return fullEqFrenchProducts;
   }
}
