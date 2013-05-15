package results;

import api.FullVidalAPI;
import org.apache.abdera.model.Feed;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getFeedFromXML;

public class ResultTest {

   @Test
   public void shouldReturnTheTitleOfTheFeed() throws FileNotFoundException {
      Result result = getAPIResultFromXMLResource("productByName_Long.xml");
      assertThat(result.getTitle()).isEqualTo("Search Products - Query :asp");
   }

   @Test
   public void shouldReturnTheSelfLink() throws FileNotFoundException {
      Result result = getAPIResultFromXMLResource("productByName_Long.xml");
      assertThat(result.getSelfLink().getHref().toString())
              .isEqualTo("/rest/api/products?q=asp&start-page=2&page-size=10");
   }

   @Test
   public void shouldReturnTheIdOftheFeed() throws FileNotFoundException {
      Result result = getAPIResultFromXMLResource("productByName_Long.xml");
      assertThat(result.getId().toString())
              .isEqualTo("/rest/api/products?q=asp&start-page=2&page-size=10");
   }

   @Test
   public void shouldReturnTheDateOfLastUpdate() throws FileNotFoundException {
      Result result = getAPIResultFromXMLResource("productByName_Long.xml");
      DateTime lastUpdate = result.getLastUpdate();
      assertThat(lastUpdate.getMillis()).isEqualTo(1361404800000L);
   }


   private class ResultImpl extends Result {
      public ResultImpl(Feed resultFeed) {
         super(resultFeed, new FullVidalAPI(""));
      }
   }

   private Result getAPIResultFromXMLResource(String xmlSource) throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new ResultImpl(feed);
   }
}
