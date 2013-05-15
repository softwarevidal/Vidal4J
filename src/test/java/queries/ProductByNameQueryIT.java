package queries;

import api.VidalAPIFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import results.APIProductByNameResult;
import searches.ProductSearch;
import utils.MarketStatusEnum;

import static org.fest.assertions.Assertions.assertThat;

public class ProductByNameQueryIT {

   private static ProductSearch productSearch;

   @BeforeClass
   public static void setUpOnce() {
      productSearch = VidalAPIFactory.getDevInstance().searchProduct();
   }

   @Test
   public void withOutParamsShouldReturnManyResults() {
      APIProductByNameResult byNameResult = productSearch.byName().execQuery();
      assertThat(byNameResult.getTitle()).contains("Search Products - Query :");
      assertThat(byNameResult.getTotalResultsNumber()).isGreaterThan(5000);
      assertThat(byNameResult.getProducts().size()).isGreaterThan(1);
   }

   @Test
   public void withQueryParamShouldReturnNonEmptyResults() {
      APIProductByNameResult byNameResult = productSearch.byName().setQuery("asp").execQuery();
      assertNonEmptyResults(byNameResult);
   }

   @Test
   public void withStartwithParamShouldReturnNonEmptyResults() {
      APIProductByNameResult byNameResult = productSearch.byName().setStartWith("asp").execQuery();
      assertNonEmptyResults(byNameResult);
   }

   @Test
   public void withStatusParamShouldReutrnNonEmptyResults() {
      APIProductByNameResult byNameResult = productSearch.byName().setStatus(MarketStatusEnum.AVAILABLE).execQuery();
      assertNonEmptyResults(byNameResult);
   }


   private void assertNonEmptyResults(APIProductByNameResult byNameResult) {
      assertThat(byNameResult.getTitle()).contains("Search Products - Query :");
      assertThat(byNameResult.getTotalResultsNumber()).isGreaterThan(1);
   }
}
