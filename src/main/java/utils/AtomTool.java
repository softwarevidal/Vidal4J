package utils;

import models.key_values.Country;
import models.key_values.GalenicForm;
import models.key_values.Route;
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

   public static Country getCountry(Entry entry) {
      Element country = getVidalTagContent("country", entry);
      String countryCode = country.getAttributeValue("countryCode");
      String text = country.getText();
      return new Country(countryCode, text);
   }

   public static GalenicForm getGalenicForm(Entry entry) {
      Element element = getVidalTagContent("galenicForm", entry);
      String code = element.getAttributeValue("vidalId");
      String name = element.getText();
      return new GalenicForm(code, name);
   }

   public static Route getRoute(Entry entry) {
      Element element = getVidalTagContent("route", entry);
      String code = element.getAttributeValue("id");
      String name = element.getText();
      return new Route(code, name);
   }
}
