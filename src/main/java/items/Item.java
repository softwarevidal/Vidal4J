package items;

import api.VidalAPI;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Entry;
import org.joda.time.DateTime;
import utils.Category;


public abstract class Item {

   protected Entry entry;
   protected VidalAPI vidalAPI;

   public Item(Entry entry, VidalAPI vidalAPI) {
      this.entry = entry;
      this.vidalAPI = vidalAPI;
   }

   public IRI getEntryId() {
      return this.entry.getId();
   }

   public Category getCategory() {
      String str = this.entry.getCategories().get(0).getTerm();
      return Category.valueOf(str);
   }

   public DateTime getLastUpdate() {
      long time = this.entry.getUpdated().getTime();
      return new DateTime(time);
   }
}
