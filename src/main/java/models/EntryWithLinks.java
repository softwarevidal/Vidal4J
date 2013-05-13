package models;

import api.VidalAPI;
import org.apache.abdera.model.Entry;

public abstract class EntryWithLinks {

   protected Entry entry;
   protected VidalAPI vidalAPI;

   public EntryWithLinks(Entry entry) {
      this.entry = entry;
   }

   public EntryWithLinks(Entry entry, VidalAPI vidalAPI) {
      this(entry);
      this.vidalAPI = vidalAPI;
   }
}
