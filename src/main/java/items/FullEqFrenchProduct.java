package items;

import api.FullVidalAPI;
import items.key_values.AMMType;
import org.apache.abdera.model.Entry;
import utils.EntryTool;

public class FullEqFrenchProduct extends FromNameProduct {

   public FullEqFrenchProduct(Entry entry, FullVidalAPI fullVidalAPI) {
      super(entry, fullVidalAPI);
   }


   public String getActivePrinciple() {
      return EntryTool.getActivePrinciple(this.entry);
   }

   public AMMType getAMMType() {
      return EntryTool.getAMMType(this.entry);
   }

   public boolean hasPublishedDoc() {
      return EntryTool.hasPublishedDoc(this.entry);
   }

   public String getConcentration() {
      return EntryTool.getConcentration(this.entry);
   }

   public String getName() {
      return EntryTool.getNameFromVidalTag(this.entry);
   }
}
