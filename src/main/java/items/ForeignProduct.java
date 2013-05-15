package items;

import api.FullVidalAPI;
import items.key_values.ATCClass;
import items.key_values.Country;
import items.key_values.GalenicForm;
import items.key_values.Route;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import results.EqFrenchProductByIdResult;
import utils.EntryTool;


public class ForeignProduct extends Item {

   public ForeignProduct(Entry entry, FullVidalAPI fullVidalAPI) {
      super(entry, fullVidalAPI);
   }

   public ATCClass getATCClass() {
      return EntryTool.getATCClass(this.entry);
   }

   public Country getCountry() {
      return EntryTool.getCountry(this.entry);
   }

   public GalenicForm getGalenicForm() {
      return EntryTool.getGalenicForm(this.entry);
   }

   public String getName() {
      return EntryTool.getNameFromVidalTag(this.entry);
   }

   public Route getRoute() {
      return EntryTool.getRoute(this.entry);
   }

   public EqFrenchProductByIdResult openEqFrenchProducts() {
      IRI link = this.getLinkFromTitleAttr("PRODUCTS");
      Feed feed = this.fullVidalAPI.openPage(link);
      return new EqFrenchProductByIdResult(feed, this.fullVidalAPI);
   }
}
