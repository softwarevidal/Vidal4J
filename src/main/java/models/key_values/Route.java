package models.key_values;

public class Route extends AbstractKeyValueItem {
   public Route(String key, String value) {
      super(key, value);
   }

   public int getId() {
      return Integer.parseInt(this.key);
   }

   public String getName() {
      return this.value;
   }
}
