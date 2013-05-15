package items.key_values;

import utils.MarketStatusEnum;

public class MarketStatus extends AbstractKeyValueItem {

   public MarketStatus(String name, String text) {
      this.key = name;
      this.value = text;
   }

   public String getName() {
      return this.key;
   }

   public String getText() {
      return this.value;
   }

   public MarketStatusEnum asEnum() {
      return MarketStatusEnum.valueOf(this.key);
   }
}
