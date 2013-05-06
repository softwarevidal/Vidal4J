package models.key_values;

public class GalenicForm extends AbstractKeyValueItem {
   public GalenicForm(String key, String value) {
      super(key, value);
   }

   public int getVidalId() {
      return Integer.parseInt(this.key);
   }

   public String getName() {
      return this.value;
   }
}
