package utils;

import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import javax.xml.namespace.QName;

public class AtomTool {
   private static final String VIDAL_TAG_URL = "http://api.vidal.net/-/spec/vidal-api/1.0/";

   public static Element getVidalTagContent(String tagName, Entry entry) {
      QName name = new QName(VIDAL_TAG_URL, tagName, "vidal");
      Element firstChild = entry.getFirstChild(name);
      return firstChild;
   }
}
