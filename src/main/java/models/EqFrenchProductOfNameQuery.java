package models;

import models.key_values.ATCClass;
import models.key_values.Country;
import models.key_values.GalenicForm;
import models.key_values.Route;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;
import utils.AtomTool;

import static utils.AtomTool.getVidalTagContent;

public class EqFrenchProductOfNameQuery {

   private final Entry entry;

   public EqFrenchProductOfNameQuery(Entry entry) {
      this.entry = entry;
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
      Element atcClass = getVidalTagContent("atcClass", this.entry);
      String code = atcClass.getAttributeValue("code");
      String text = atcClass.getText();
      return new ATCClass(code, text);
   }

   public Country getCountry() {
      return AtomTool.getCountry(this.entry);
   }

   public GalenicForm getGalenicForm() {
      return AtomTool.getGalenicForm(this.entry);
   }

   public Route getRoute() {
      return AtomTool.getRoute(this.entry);
   }
}
