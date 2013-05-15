package results;

import api.FullVidalAPI;
import items.ForeignProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIForeignProductByNameResult
        extends APIPaginatedResults<APIForeignProductByNameResult> {

   public APIForeignProductByNameResult(Feed resultFeed, FullVidalAPI fullVidalAPI) {
      super(resultFeed, fullVidalAPI, APIForeignProductByNameResult.class);
   }


   public List<ForeignProduct> getForeignProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<ForeignProduct> eqFrenchProductsByName = new ArrayList<ForeignProduct>();

      for(Entry entry : entries) {
         eqFrenchProductsByName.add(new ForeignProduct(entry, this.fullVidalAPI));
      }

      return eqFrenchProductsByName;
   }
}
