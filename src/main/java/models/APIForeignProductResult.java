package models;

import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIForeignProductResult extends APIResult {

   public APIForeignProductResult(Feed resultFeed) {
      super(resultFeed);
   }


   public List<ForeignProduct> getForeignProducts() {
      List<Entry> entries = this.feed.getEntries();
      List<ForeignProduct> foreignProducts = new ArrayList<ForeignProduct>();

      for(Entry entry : entries) {
         foreignProducts.add(new ForeignProduct(entry));
      }

      return foreignProducts;
   }
}
