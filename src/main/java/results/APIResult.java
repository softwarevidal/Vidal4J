package results;

import api.VidalAPI;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Link;
import org.joda.time.DateTime;

import java.util.Date;

public abstract class APIResult {
   protected final Feed feed;
   protected final VidalAPI vidalAPI;

   public APIResult(Feed resultFeed, VidalAPI vidalAPI) {
      this.feed = resultFeed;
      this.vidalAPI = vidalAPI;
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
