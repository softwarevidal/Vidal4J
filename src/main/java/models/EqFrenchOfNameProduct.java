package models;

import api.VidalAPI;
import models.key_values.ATCClass;
import models.key_values.Country;
import models.key_values.GalenicForm;
import models.key_values.Route;
import org.apache.abdera.model.Entry;

import static utils.AtomTool.getVidalTagContent;


public class EqFrenchOfNameProduct extends EntryWithLinks {

   public EqFrenchOfNameProduct(Entry entry, VidalAPI vidalAPI) {
      super(entry, vidalAPI);
   }


   public String getName() {
      return getVidalTagContent("name", this.entry).getText();
   }

   public String getCategory() {
      return this.entry.getCategories().get(0).getTerm();
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

   public Route getRoute() {
      return new Route(this.entry);
   }
}
