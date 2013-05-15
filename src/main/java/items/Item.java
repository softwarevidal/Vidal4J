package items;

import api.FullVidalAPI;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Link;
import org.joda.time.DateTime;
import utils.Category;

import java.util.List;


public abstract class Item {

   protected final Entry entry;
   protected final FullVidalAPI fullVidalAPI;

   public Item(Entry entry, FullVidalAPI fullVidalAPI) {
      this.entry = entry;
      this.fullVidalAPI = fullVidalAPI;
   }

   public IRI getEntryId() {
      return this.entry.getId();
   }

   public Category getCategory() {
      String str = this.entry.getCategories().get(0).getTerm();
      return Category.valueOf(str);
   }

   public DateTime getLastUpdate() {
      long time = this.entry.getUpdated().getTime();
      return new DateTime(time);
   }

   protected IRI getLinkFromTitleAttr(String titleAttr) {
      List<Link> links = this.entry.getLinks();
      Link res = null;

      for (Link link : links) {
         boolean isRes = link.getAttributeValue("title").equals(titleAttr);
         if(isRes) {
            res = link;
         }
      }

      return (res != null) ? res.getHref() : null;
   }
}
