package results;

import models.EqFrenchOfNameProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIEqFrenchProductByNameResult extends APIPaginatedResults {
   public APIEqFrenchProductByNameResult(Feed resultFeed) {
      super(resultFeed);
   }

   public List<EqFrenchOfNameProduct> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<EqFrenchOfNameProduct> eqFrenchProductsByName = new ArrayList<EqFrenchOfNameProduct>();

      for(Entry entry : entries) {
         eqFrenchProductsByName.add(new EqFrenchOfNameProduct(entry));
      }

      return eqFrenchProductsByName;
   }
}
