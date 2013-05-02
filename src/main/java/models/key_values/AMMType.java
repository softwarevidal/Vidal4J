package models.key_values;

public class AMMType extends AbstractKeyValueItem {
   public AMMType(String key, String value) {
      super(key, value);
   }

   public int getVidalId() {
      return Integer.parseInt(this.key);
   }

   public String getText() {
      return this.value;
   }
}
