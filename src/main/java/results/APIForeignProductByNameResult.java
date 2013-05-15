package results;

import items.FromNameForeignProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import queries.ForeignProductByNameQuery;

import java.util.ArrayList;
import java.util.List;

public class APIForeignProductByNameResult
        extends APIPaginatedResults<ForeignProductByNameQuery, APIForeignProductByNameResult> {

   public APIForeignProductByNameResult(Feed resultFeed, ForeignProductByNameQuery query) {
      super(resultFeed, query, APIForeignProductByNameResult.class, ForeignProductByNameQuery.class);
   }


   public List<FromNameForeignProduct> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<FromNameForeignProduct> eqFrenchProductsByName = new ArrayList<FromNameForeignProduct>();

      for(Entry entry : entries) {
         eqFrenchProductsByName.add(new FromNameForeignProduct(entry, this.query.getVidalAPI()));
      }

      return eqFrenchProductsByName;
   }
}
