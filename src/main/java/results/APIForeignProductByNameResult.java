package results;

import api.VidalAPI;
import items.FromNameForeignProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIForeignProductByNameResult
        extends APIPaginatedResults<APIForeignProductByNameResult> {

   public APIForeignProductByNameResult(Feed resultFeed, VidalAPI vidalAPI) {
      super(resultFeed, vidalAPI, APIForeignProductByNameResult.class);
   }


   public List<FromNameForeignProduct> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<FromNameForeignProduct> eqFrenchProductsByName = new ArrayList<FromNameForeignProduct>();

      for(Entry entry : entries) {
         eqFrenchProductsByName.add(new FromNameForeignProduct(entry, this.vidalAPI));
      }

      return eqFrenchProductsByName;
   }
}
