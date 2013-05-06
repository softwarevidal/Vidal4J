package models.key_values;

import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import static utils.AtomTool.getVidalTagContent;

public class GalenicForm extends AbstractKeyValueItem {
   public GalenicForm(String key, String value) {
      super(key, value);
   }

   public GalenicForm(Entry entry) {
      Element element = getVidalTagContent("galenicForm", entry);
      this.key = element.getAttributeValue("vidalId");
      this.value = element.getText();
   }

   public int getVidalId() {
      return Integer.parseInt(this.key);
   }

   public String getName() {
      return this.value;
   }
}
