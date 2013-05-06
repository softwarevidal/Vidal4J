package models.key_values;

import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import static utils.AtomTool.getVidalTagContent;


public class ATCClass extends AbstractKeyValueItem {

   public ATCClass(String key, String value) {
      super(key, value);
   }

   public ATCClass(Entry entry) {
      Element element = getVidalTagContent("atcClass", entry);
      this.key = element.getAttributeValue("code");
      this.value = element.getText();
   }

   public String getCode() {
      return this.key;
   }

   public String getName() {
      return this.value;
   }
}
