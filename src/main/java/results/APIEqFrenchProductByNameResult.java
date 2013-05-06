package results;

import models.EqFrenchProductOfNameQuery;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIEqFrenchProductByNameResult extends APIPaginatedResults {
   public APIEqFrenchProductByNameResult(Feed resultFeed) {
      super(resultFeed);
   }

   public List<EqFrenchProductOfNameQuery> getEqFrenchProducts() {
      List<Entry> entries = this.feed.getEntries();
      ArrayList<EqFrenchProductOfNameQuery> eqFrenchProductsByName = new ArrayList<EqFrenchProductOfNameQuery>();

      for(Entry entry : entries) {
         eqFrenchProductsByName.add(new EqFrenchProductOfNameQuery(entry));
      }

      return eqFrenchProductsByName;
   }
}
