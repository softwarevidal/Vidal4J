package items;

import api.VidalAPI;
import items.key_values.ATCClass;
import items.key_values.Country;
import items.key_values.GalenicForm;
import items.key_values.Route;
import org.apache.abdera.model.Entry;
import utils.EntryTool;

import static utils.AtomTool.getVidalTagContent;


public class EqFrenchOfNameProduct extends Item {

   public EqFrenchOfNameProduct(Entry entry, VidalAPI vidalAPI) {
      super(entry, vidalAPI);
   }


   public String getName() {
      return getVidalTagContent("name", this.entry).getText();
   }

   public ATCClass getATCClass() {
      return EntryTool.getATCClass(this.entry);
   }

   public Country getCountry() {
      return EntryTool.getCountry(this.entry);
   }

   public GalenicForm getGalenicForm() {
      return EntryTool.getGalenicForm(this.entry);
   }

   public Route getRoute() {
      return EntryTool.getRoute(this.entry);
   }
}
