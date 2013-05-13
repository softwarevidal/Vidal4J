package utils;

import org.apache.abdera.Abdera;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.apache.abdera.parser.Parser;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AtomTool {
   private static final String VIDAL_TAG_URL = "http://api.vidal.net/-/spec/vidal-api/1.0/";

   public static Element getVidalTagContent(String tagName, Entry entry) {
      QName name = new QName(VIDAL_TAG_URL, tagName, "vidal");
      Element firstChild = entry.getFirstChild(name);
      return firstChild;
   }

   public static Feed searchFeedFromURL(String searchUrl) {
      Feed feed = null;

      try {
         URL url = new URL(searchUrl);
         Parser parser = new Abdera().getParser();
         Document<Feed> doc = parser.parse(url.openStream(), url.toString());
         feed = doc.getRoot();
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }

      return feed;
   }
}
