package results;

import models.EqFrenchProduct;
import models.ForeignProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIEqFrenchProductResult extends APIResult {
   public APIEqFrenchProductResult(Feed resultFeed) {
      super(resultFeed);
   }

   public List<EqFrenchProduct> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<EqFrenchProduct> eqFrenchProducts = new ArrayList<EqFrenchProduct>();

      for(Entry entry : entries) {
         eqFrenchProducts.add(new EqFrenchProduct(entry));
      }

      return eqFrenchProducts;
   }
}
