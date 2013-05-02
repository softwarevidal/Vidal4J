package models.key_values;

public class ATCClass extends AbstractKeyValueItem {

   public ATCClass(String key, String value) {
      super(key, value);
   }

   public String getCode() {
      return this.key;
   }

   public String getName() {
      return this.value;
   }
}
