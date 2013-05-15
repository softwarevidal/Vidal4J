package results;

import api.FullVidalAPI;
import org.apache.abdera.model.Feed;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getFeedFromXML;


public class PaginatedResultsTest {

   @Test
   public void shouldReturnNextLinkIfItExists() throws FileNotFoundException {
      PaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getNextPageLink().toString())
              .isEqualTo("/rest/api/products?q=asp&start-page=3&page-size=10");
   }

   @Test
   public void shouldReturnNullIfNextLinkDoesntExist() throws FileNotFoundException {
      PaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("aspegic_Short.xml");
      assertThat(apiResult.getNextPageLink()).isNull();
   }

   @Test
   public void shouldReturnPrevLinkIfItExists() throws FileNotFoundException {
      PaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getPrevPageLink().toString())
              .isEqualTo("/rest/api/products?q=asp&start-page=1&page-size=10");
   }

   @Test
   public void shouldReturnNullIfPrevLinkDoesntExist() throws FileNotFoundException {
      PaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("aspegic_Short.xml");
      assertThat(apiResult.getPrevPageLink()).isNull();
   }

   @Test
   public void shouldReturnTheTotalNumberOfResults() throws FileNotFoundException {
      PaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getTotalResultsNumber()).isEqualTo(29);
   }

   @Test
   public void shouldReturnTheNumberOfResultsPerPage() throws FileNotFoundException {
      PaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getResultsNumberPerPage()).isEqualTo(10);
   }

   @Test
   public void shouldReturnTheCurrentPageNumber() throws FileNotFoundException {
      PaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getCurrentPageNumber()).isEqualTo(2);
   }


   private PaginatedResults getAPIPaginatedResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new PaginatedResultsImpl(feed);
   }

   private class PaginatedResultsImpl extends PaginatedResults {
      public PaginatedResultsImpl(Feed resultFeed) {
         super(resultFeed, new FullVidalAPI(""), PaginatedResultsImpl.class);
      }
   }
}
