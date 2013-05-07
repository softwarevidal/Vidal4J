package results;

import models.EqFrenchOfIdProduct;
import models.ForeignProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIEqFrenchProductByIdResult extends APIResult {
   public APIEqFrenchProductByIdResult(Feed resultFeed) {
      super(resultFeed);
   }

   public List<EqFrenchOfIdProduct> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<EqFrenchOfIdProduct> eqFrenchOfIdProducts = new ArrayList<EqFrenchOfIdProduct>();

      for(Entry entry : entries) {
         eqFrenchOfIdProducts.add(new EqFrenchOfIdProduct(entry));
      }

      return eqFrenchOfIdProducts;
   }
}
