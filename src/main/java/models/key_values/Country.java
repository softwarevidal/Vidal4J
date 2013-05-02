package models.key_values;

public class Country extends AbstractKeyValueItem {
   public Country(String key, String value) {
      super(key, value);
   }

   public String getCountryCode() {
      return this.key;
   }

   public String getName() {
      return this.value;
   }
}
