package results;

import models.OfNameProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIProductByNameResult extends APIPaginatedResults {

   public APIProductByNameResult(Feed resultFeed) {
      super(resultFeed);
   }


   public List<OfNameProduct> getProducts() {
      List<Entry> entries = this.feed.getEntries();
      List<OfNameProduct> ofNameProducts = new ArrayList<OfNameProduct>();

      for(Entry entry : entries) {
         ofNameProducts.add(new OfNameProduct(entry));
      }

      return ofNameProducts;
   }
}
