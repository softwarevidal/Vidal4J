package items.key_values;

import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import static utils.AtomTool.getVidalTagContent;


public class Route extends AbstractKeyValueItem {
   public Route(String key, String value) {
      super(key, value);
   }

   public Route(Entry entry) {
      Element element = getVidalTagContent("route", entry);
      this.key = element.getAttributeValue("id");
      this.value = element.getText();
   }

   public int getId() {
      return Integer.parseInt(this.key);
   }

   public String getName() {
      return this.value;
   }
}
