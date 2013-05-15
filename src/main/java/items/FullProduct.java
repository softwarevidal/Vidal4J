package items;

import api.FullVidalAPI;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import results.ForeignProductByIdResult;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * CAREFUL
 * This class is not complete with all the properties of a full product.
 */
public class FullProduct extends FromNameProduct {

   public FullProduct(Entry entry, FullVidalAPI fullVidalAPI) {
      super(entry, fullVidalAPI);
   }

   public URL getEurekaSanteURL() throws MalformedURLException, URISyntaxException {
      IRI iri = this.getLinkFromTitleAttr("EUREKA_SANTE");
      return (iri != null) ? iri.toURL() : null;
   }

   public IRI getForeignProductsLink() {
      return this.getLinkFromTitleAttr("FOREIGN_PRODUCTS");
   }

   public ForeignProductByIdResult openFullForeignProduct() {
      IRI link = this.getForeignProductsLink();
      Feed feed = this.fullVidalAPI.openPage(link);
      return new ForeignProductByIdResult(feed, this.fullVidalAPI);
   }
}