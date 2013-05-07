package results;

import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Link;
import queries.PaginatedQuery;

import javax.xml.namespace.QName;
import java.lang.reflect.InvocationTargetException;

public abstract class APIPaginatedResults<T extends PaginatedQuery, P extends APIPaginatedResults>
        extends APIResult<T> {

   private final String OPENSEARCH_TAG_URL = "http://a9.com/-/spec/opensearch/1.1/";
   private final String REL_PREV = "prev";
   private Class<P> pClass;
   private Class<T> tClass;

   public APIPaginatedResults(Feed resultFeed) {
      super(resultFeed);
   }

   public APIPaginatedResults(Feed resultFeed, T query, Class<P> pClass, Class<T> tClass) {
      super(resultFeed, query);
      this.pClass = pClass;
      this.tClass = tClass;
   }


   public P openNextPage() {
      IRI link = getNextPageLink();
      Feed feed = this.query.openPage(link);
      return this.newChildInstance(feed, this.query);
   }

   public P openPrevPage() {
      IRI link = getPrevPageLink();
      Feed feed = this.query.openPage(link);
      return this.newChildInstance(feed, this.query);
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


   private P newChildInstance(Feed feed, PaginatedQuery query) {
      P instance = null;
      try {
         instance = this.pClass.getConstructor(Feed.class, this.tClass).newInstance(feed, query);
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
