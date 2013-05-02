package models;

import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import java.util.ArrayList;
import java.util.List;

public class APIProductResult extends APIPaginatedResults {

   public APIProductResult(Feed resultFeed) {
      super(resultFeed);
   }


   public List<Product> getProducts() {
      List<Entry> entries = this.feed.getEntries();
      List<Product> products = new ArrayList<Product>();

      for(Entry entry : entries) {
         products.add(new Product(entry));
      }

      return products;
   }
}
