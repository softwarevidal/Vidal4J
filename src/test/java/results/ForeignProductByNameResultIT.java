package results;

import api.FullVidalAPI;
import api.FullVidalAPIFactory;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;


public class ForeignProductByNameResultIT {

   @Test
   @Ignore("Fails on http://dev-software.vidal.net/excalibur-rest-snapshot/ (path issue) and on http://apirest-dev.vidal.fr/ (HTTP 401 due to recent use of 3scale authorisation)")
   public void shouldLoadTheNextPage() throws FileNotFoundException {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      ForeignProductByNameResult byNameResult = fullVidalAPI.searchForeignProduct().byName("asp")
              .setPageSize(10).setStartPage(2).execQuery();

      ForeignProductByNameResult nextPage = byNameResult.openNextPage();

      assertThat(nextPage.getForeignProducts().size()).isGreaterThan(1);
      assertThat(byNameResult.getCurrentPageNumber()).isEqualTo(2);
      assertThat(nextPage.getCurrentPageNumber()).isEqualTo(3);
   }

   @Test
   @Ignore("Fails on http://dev-software.vidal.net/excalibur-rest-snapshot/ (path issue) and on http://apirest-dev.vidal.fr/ (HTTP 401 due to recent use of 3scale authorisation)")
   public void shouldLoadThePrevPage() throws FileNotFoundException {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      ForeignProductByNameResult byNameResult = fullVidalAPI.searchForeignProduct().byName("asp")
              .setPageSize(10).setStartPage(2).execQuery();

      ForeignProductByNameResult prevPage = byNameResult.openPrevPage();

      assertThat(prevPage.getForeignProducts().size()).isGreaterThan(1);
      assertThat(byNameResult.getCurrentPageNumber()).isEqualTo(2);
      assertThat(prevPage.getCurrentPageNumber()).isEqualTo(1);
   }
}
