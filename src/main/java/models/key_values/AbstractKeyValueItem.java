package models.key_values;

public abstract class AbstractKeyValueItem {
   protected String key;
   protected String value;

   public AbstractKeyValueItem(String key, String value) {
      this.key = key;
      this.value = value;
   }

   public AbstractKeyValueItem() {}
}
