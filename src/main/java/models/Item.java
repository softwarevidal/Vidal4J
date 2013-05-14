package models;

import api.VidalAPI;
import org.apache.abdera.model.Entry;

public abstract class Item {

   protected Entry entry;
   protected VidalAPI vidalAPI;

   public Item(Entry entry, VidalAPI vidalAPI) {
      this.entry = entry;
      this.vidalAPI = vidalAPI;
   }
}
