package results;

import items.FullEqFrenchProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import queries.EqFrenchProductByIdQuery;

import java.util.ArrayList;
import java.util.List;

public class APIEqFrenchProductByIdResult extends APIResult<EqFrenchProductByIdQuery> {

   public APIEqFrenchProductByIdResult(Feed feed, EqFrenchProductByIdQuery eqFrenchProductByIdQuery) {
      super(feed, eqFrenchProductByIdQuery);
   }

   public List<FullEqFrenchProduct> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<FullEqFrenchProduct> fullEqFrenchProducts = new ArrayList<FullEqFrenchProduct>();

      for(Entry entry : entries) {
         fullEqFrenchProducts.add(new FullEqFrenchProduct(entry, this.query.getVidalAPI()));
      }

      return fullEqFrenchProducts;
   }
}
