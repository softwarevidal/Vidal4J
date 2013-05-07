package results;

import api.VidalAPI;
import api.VidalAPIFactory;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;


public class APIEqFrenchProductByNameResultIT {

   @Test
   public void shouldLoadTheNextPage() throws FileNotFoundException {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIEqFrenchProductByNameResult byNameResult = vidalAPI.searchEqFrenchProduct().byName("asp")
              .setPageSize(10).setStartPage(2).execQuery();

      APIEqFrenchProductByNameResult nextPage = byNameResult.openNextPage();

      assertThat(nextPage.getEqFrenchProducts().size()).isGreaterThan(1);
      assertThat(byNameResult.getCurrentPageNumber()).isEqualTo(2);
      assertThat(nextPage.getCurrentPageNumber()).isEqualTo(3);
   }

   @Test
   public void shouldLoadThePrevPage() throws FileNotFoundException {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIEqFrenchProductByNameResult byNameResult = vidalAPI.searchEqFrenchProduct().byName("asp")
              .setPageSize(10).setStartPage(2).execQuery();

      APIEqFrenchProductByNameResult prevPage = byNameResult.openPrevPage();

      assertThat(prevPage.getEqFrenchProducts().size()).isGreaterThan(1);
      assertThat(byNameResult.getCurrentPageNumber()).isEqualTo(2);
      assertThat(prevPage.getCurrentPageNumber()).isEqualTo(1);
   }
}
