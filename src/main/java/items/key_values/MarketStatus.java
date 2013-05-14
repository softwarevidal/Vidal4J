package items.key_values;

public class MarketStatus extends AbstractKeyValueItem {
   public MarketStatus(String key, String value) {
      super(key, value);
   }

   public String getName() {
      return this.key;
   }

   public String getText() {
      return this.value;
   }
}
