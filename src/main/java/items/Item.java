package items;

import api.VidalAPI;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Entry;

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
}
