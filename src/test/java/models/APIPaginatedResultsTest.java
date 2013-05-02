package models;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIPaginatedResultFromXMLResource;


public class APIPaginatedResultsTest {

   @Test
   public void shouldReturnNextLinkIfItExists() throws FileNotFoundException {
      APIPaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getNextPageLink().toString())
              .isEqualTo("/rest/api/products?q=asp&start-page=2&page-size=25");
   }

   @Test
   public void shouldReturnNullIfNextLinkDoesntExist() throws FileNotFoundException {
      APIPaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("aspegic_Short.xml");
      assertThat(apiResult.getNextPageLink()).isNull();
   }

   @Test
   public void shouldReturnTheTotalNumberOfResults() throws FileNotFoundException {
      APIPaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getTotalResultsNumber()).isEqualTo(29);
   }

   @Test
   public void shouldReturnTheNumberOfResultsPerPage() throws FileNotFoundException {
      APIPaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getResultsNumberPerPage()).isEqualTo(25);
   }

   @Test
   public void shouldReturnTheCurrentPageNumber() throws FileNotFoundException {
      APIPaginatedResults apiResult = getAPIPaginatedResultFromXMLResource("productByName_Long.xml");
      assertThat(apiResult.getCurrentPageNumber()).isEqualTo(1);
   }
}
