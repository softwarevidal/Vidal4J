package results;

import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Link;

import javax.xml.namespace.QName;

public abstract class APIPaginatedResults extends APIResult {
   private final String OPENSEARCH_TAG_URL = "http://a9.com/-/spec/opensearch/1.1/";
   private final String REL_PREV = "prev";

   public APIPaginatedResults(Feed resultFeed) {
      super(resultFeed);
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

   private String getOpensearchTagContent(String tagName) {
      QName name = new QName(this.OPENSEARCH_TAG_URL, tagName, "opensearch");
      Element element = this.feed.getFirstChild(name);
      return element.getText();
   }
}
