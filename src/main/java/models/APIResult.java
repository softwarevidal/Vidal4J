package models;

import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Link;
import org.joda.time.DateTime;

import javax.xml.namespace.QName;
import java.util.Date;

public class APIResult {
   private final String OPENSEARCH_TAG_URL = "http://a9.com/-/spec/opensearch/1.1/";
   protected Feed feed;

   public APIResult(Feed resultFeed) {
      this.feed = resultFeed;
   }


   public String getTitle() {
      return this.feed.getTitle();
   }

   public Link getSelfLink() {
      return this.feed.getSelfLink();
   }

   public Link getNextPageLink() {
      return this.feed.getLink(Link.REL_NEXT);
   }

   public IRI getId() {
      return this.feed.getId();
   }

   public DateTime getLastUpdate() {
      Date updated = this.feed.getUpdated();
      DateTime updatedDateTime = new DateTime(updated.getTime());
      return updatedDateTime;
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
