package items;

import api.VidalAPI;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Entry;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * CAREFUL
 * This class is not complete with all the properties of a full product.
 */
public class FullProduct extends FromNameProduct {

   public FullProduct(Entry entry, VidalAPI vidalAPI) {
      super(entry, vidalAPI);
   }

   public URL getEurekaSanteURL() throws MalformedURLException, URISyntaxException {
      IRI iri = this.getLinkFromTitleAttr("EUREKA_SANTE");
      return (iri != null) ? iri.toURL() : null;
   }
}