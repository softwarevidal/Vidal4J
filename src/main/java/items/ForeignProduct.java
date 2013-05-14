package items;

import api.VidalAPI;
import items.key_values.ATCClass;
import items.key_values.Country;
import items.key_values.GalenicForm;
import items.key_values.Route;
import org.apache.abdera.model.Entry;

import static utils.AtomTool.getVidalTagContent;


public class ForeignProduct extends Item {

   public ForeignProduct(Entry entry, VidalAPI vidalAPI) {
      super(entry, vidalAPI);
   }

   public String getId() {
      return this.entry.getId().toString();
   }

   public ATCClass getATCClass() {
      return new ATCClass(this.entry);
   }

   public Country getCountry() {
      return new Country(this.entry);
   }

   public GalenicForm getGalenicForm() {
      return new GalenicForm(this.entry);
   }

   public String getName() {
      return getVidalTagContent("name", this.entry).getText();
   }

   public Route getRoute() {
      return new Route(this.entry);
   }
}
