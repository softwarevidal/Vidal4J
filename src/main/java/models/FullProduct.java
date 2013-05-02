package models;

import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Link;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;


/**
 * CAREFUL
 * This class is not complete with all the properties of a full product.
 */
public class FullProduct extends Product {
   public FullProduct(Entry entry) {
      super(entry);
   }

   public URL getEurekaSanteURL() throws MalformedURLException, URISyntaxException {
      List<Link> links = this.entry.getLinks();
      Link eureka = null;

      for (Link link : links) {
         boolean isEureka = link.getAttributeValue("title").equals("EUREKA_SANTE");
         if(isEureka) {
            eureka = link;
         }
      }

      return (eureka != null) ? eureka.getHref().toURL() : null;
   }
}
