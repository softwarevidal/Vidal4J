package models.key_values;

public class DispensationPlace extends AbstractKeyValueItem {
   public DispensationPlace(String key, String value) {
      super(key, value);
   }

   public String getName() {
      return this.key;
   }

   public String getText() {
      return this.value;
   }
}
