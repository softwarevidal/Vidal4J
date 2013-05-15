package results;

import api.VidalAPI;
import items.FromNameProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIProductByNameResult extends APIPaginatedResults<APIProductByNameResult> {

   public APIProductByNameResult(Feed feed, VidalAPI vidalAPI) {
      super(feed, vidalAPI, APIProductByNameResult.class);
   }


   public List<FromNameProduct> getProducts() {
      List<Entry> entries = this.feed.getEntries();
      List<FromNameProduct> fromNameProducts = new ArrayList<FromNameProduct>();

      for(Entry entry : entries) {
         fromNameProducts.add(new FromNameProduct(entry, this.vidalAPI));
      }

      return fromNameProducts;
   }
}
