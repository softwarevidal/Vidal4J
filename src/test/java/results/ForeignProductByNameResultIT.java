package results;

import api.FullVidalAPI;
import api.FullVidalAPIFactory;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;


public class ForeignProductByNameResultIT {

   @Test
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
