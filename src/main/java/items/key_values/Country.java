package items.key_values;

import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import static utils.AtomTool.getVidalTagContent;


public class Country extends AbstractKeyValueItem {
   public Country(String key, String value) {
      super(key, value);
   }

   public Country(Entry entry) {
      Element country = getVidalTagContent("country", entry);
      this.key = country.getAttributeValue("countryCode");
      this.value = country.getText();
   }

   public String getCountryCode() {
      return this.key;
   }

   public String getName() {
      return this.value;
   }
}
