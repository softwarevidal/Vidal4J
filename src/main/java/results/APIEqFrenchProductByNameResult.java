package results;

import models.EqFrenchOfNameProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import queries.EqFrenchProductByNameQuery;

import java.util.ArrayList;
import java.util.List;

public class APIEqFrenchProductByNameResult
        extends APIPaginatedResults<EqFrenchProductByNameQuery, APIEqFrenchProductByNameResult> {

   public APIEqFrenchProductByNameResult(Feed resultFeed, EqFrenchProductByNameQuery query) {
      super(resultFeed, query, APIEqFrenchProductByNameResult.class, EqFrenchProductByNameQuery.class);
   }


   public List<EqFrenchOfNameProduct> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<EqFrenchOfNameProduct> eqFrenchProductsByName = new ArrayList<EqFrenchOfNameProduct>();

      for(Entry entry : entries) {
         eqFrenchProductsByName.add(new EqFrenchOfNameProduct(entry, this.query.getVidalAPI()));
      }

      return eqFrenchProductsByName;
   }
}
