package results;

import models.ForeignProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import queries.ForeignProductByIdQuery;

import java.util.ArrayList;
import java.util.List;

public class APIForeignProductResult extends APIResult {

   public APIForeignProductResult(Feed resultFeed) {
      super(resultFeed);
   }

   public APIForeignProductResult(Feed feed, ForeignProductByIdQuery query) {
      super(feed, query);
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
