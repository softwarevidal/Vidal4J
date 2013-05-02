package models;

import models.key_values.ATCClass;
import models.key_values.Country;
import models.key_values.GalenicForm;
import models.key_values.Route;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import static utils.AtomTool.getVidalTagContent;

public class ForeignProduct {
   private Entry entry;

   public ForeignProduct(Entry entry) {
      this.entry = entry;
   }

   public String getId() {
      return this.entry.getId().toString();
   }

   public ATCClass getATCClass() {
      Element element = getVidalTagContent("atcClass", this.entry);
      String code = element.getAttributeValue("code");
      String name = element.getText();
      return new ATCClass(code, name);
   }

   public Country getCountry() {
      Element element = getVidalTagContent("country", this.entry);
      String code = element.getAttributeValue("countryCode");
      String name = element.getText();
      return new Country(code, name);
   }

   public GalenicForm getGalenicForm() {
      Element element = getVidalTagContent("galenicForm", this.entry);
      String code = element.getAttributeValue("vidalId");
      String name = element.getText();
      return new GalenicForm(code, name);
   }

   public String getName() {
      return getVidalTagContent("name", this.entry).getText();
   }

   public Route getRoute() {
      Element element = getVidalTagContent("route", this.entry);
      String code = element.getAttributeValue("id");
      String name = element.getText();
      return new Route(code, name);
   }
}
