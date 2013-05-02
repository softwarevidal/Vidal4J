package models.key_values;

public class VidalList extends AbstractKeyValueItem {
   public VidalList(String key, String value) {
      super(key, value);
   }

   public String getName() {
      return this.key;
   }

   public String getText() {
      return this.value;
   }
}
