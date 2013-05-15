package results;

import api.VidalAPI;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Link;
import queries.PaginatedQuery;

import javax.xml.namespace.QName;
import java.lang.reflect.InvocationTargetException;

public abstract class APIPaginatedResults<P extends APIPaginatedResults>
        extends APIResult {

   private final String OPENSEARCH_TAG_URL = "http://a9.com/-/spec/opensearch/1.1/";
   private final String REL_PREV = "prev";
   private Class<P> pClass;

   public APIPaginatedResults(Feed resultFeed, VidalAPI vidalAPI1, Class<P> pClass) {
      super(resultFeed, vidalAPI1);
      this.pClass = pClass;
   }


   public P openNextPage() {
      IRI link = getNextPageLink();
      Feed feed = this.vidalAPI.openPage(link);
      return this.newChildInstance(feed);
   }

   public P openPrevPage() {
      IRI link = getPrevPageLink();
      Feed feed = this.vidalAPI.openPage(link);
      return this.newChildInstance(feed);
   }

   public IRI getNextPageLink() {
      Link link = this.feed.getLink(Link.REL_NEXT);
      return (link != null) ? link.getHref() : null;
   }

   public IRI getPrevPageLink() {
      Link link = this.feed.getLink(this.REL_PREV);
      return (link != null) ? link.getHref() : null;
   }

   public int getTotalResultsNumber() {
      String startIndex = getOpensearchTagContent("totalResults");
      return Integer.parseInt(startIndex);
   }

   public int getResultsNumberPerPage() {
      String startIndex = getOpensearchTagContent("itemsPerPage");
      return Integer.parseInt(startIndex);
   }

   public int getCurrentPageNumber() {
      String startIndex = getOpensearchTagContent("startIndex");
      return Integer.parseInt(startIndex);
   }


   private P newChildInstance(Feed feed) {
      P instance = null;
      try {
         instance = this.pClass.getConstructor(Feed.class, VidalAPI.class).newInstance(feed, this.vidalAPI);
      } catch (NoSuchMethodException e) {
         e.printStackTrace();
      } catch (InvocationTargetException e) {
         e.printStackTrace();
      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      }
      return  instance;
   }

   private String getOpensearchTagContent(String tagName) {
      QName name = new QName(this.OPENSEARCH_TAG_URL, tagName, "opensearch");
      Element element = this.feed.getFirstChild(name);
      return element.getText();
   }
}
