package results;

import items.FromNameProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import queries.ProductByNameQuery;

import java.util.ArrayList;
import java.util.List;

public class APIProductByNameResult extends APIPaginatedResults<ProductByNameQuery, APIProductByNameResult> {

   public APIProductByNameResult(Feed feed, ProductByNameQuery query) {
      super(feed, query, APIProductByNameResult.class, ProductByNameQuery.class);
   }


   public List<FromNameProduct> getProducts() {
      List<Entry> entries = this.feed.getEntries();
      List<FromNameProduct> fromNameProducts = new ArrayList<FromNameProduct>();

      for(Entry entry : entries) {
         fromNameProducts.add(new FromNameProduct(entry, this.query.getVidalAPI()));
      }

      return fromNameProducts;
   }
}
