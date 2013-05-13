package results;

import models.OfNameProduct;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import queries.ProductByNameQuery;

import java.util.ArrayList;
import java.util.List;

public class APIProductByNameResult extends APIPaginatedResults<ProductByNameQuery, APIProductByNameResult> {

   public APIProductByNameResult(Feed resultFeed) {
      super(resultFeed);
   }

   public APIProductByNameResult(Feed feed, ProductByNameQuery query) {
      super(feed, query, APIProductByNameResult.class, ProductByNameQuery.class);
   }


   public List<OfNameProduct> getProducts() {
      List<Entry> entries = this.feed.getEntries();
      List<OfNameProduct> ofNameProducts = new ArrayList<OfNameProduct>();

      for(Entry entry : entries) {
         ofNameProducts.add(new OfNameProduct(entry, this.query.getVidalAPI()));
      }

      return ofNameProducts;
   }
}
