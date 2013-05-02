package models;

import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Link;
import org.joda.time.DateTime;

import javax.xml.namespace.QName;
import java.util.Date;

public class APIResult {
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

   public IRI getId() {
      return this.feed.getId();
   }

   public DateTime getLastUpdate() {
      Date updated = this.feed.getUpdated();
      DateTime updatedDateTime = new DateTime(updated.getTime());
      return updatedDateTime;
   }
}
