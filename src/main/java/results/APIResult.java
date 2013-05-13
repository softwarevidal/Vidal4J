package results;

import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Link;
import org.joda.time.DateTime;
import queries.Query;

import java.util.Date;

public abstract class APIResult<T extends Query> {
   protected Feed feed;
   protected T query;

   public APIResult(Feed resultFeed) {
      this.feed = resultFeed;
   }

   public APIResult(Feed resultFeed, T query) {
      this.feed = resultFeed;
      this.query = query;
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
