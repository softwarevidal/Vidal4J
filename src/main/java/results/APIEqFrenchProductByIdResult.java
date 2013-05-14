package results;

import items.EqFrenchOfIdProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import queries.EqFrenchProductByIdQuery;

import java.util.ArrayList;
import java.util.List;

public class APIEqFrenchProductByIdResult extends APIResult {

   public APIEqFrenchProductByIdResult(Feed feed, EqFrenchProductByIdQuery eqFrenchProductByIdQuery) {
      super(feed, eqFrenchProductByIdQuery);
   }

   public List<EqFrenchOfIdProduct> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<EqFrenchOfIdProduct> eqFrenchOfIdProducts = new ArrayList<EqFrenchOfIdProduct>();

      for(Entry entry : entries) {
         eqFrenchOfIdProducts.add(new EqFrenchOfIdProduct(entry, this.query.getVidalAPI()));
      }

      return eqFrenchOfIdProducts;
   }
}
