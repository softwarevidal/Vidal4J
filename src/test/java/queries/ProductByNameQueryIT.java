package queries;

import api.FullVidalAPIFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import results.ProductByNameResult;
import searches.ProductSearch;
import utils.MarketStatusEnum;

import static org.fest.assertions.Assertions.assertThat;

public class ProductByNameQueryIT {

   private static ProductSearch productSearch;

   @BeforeClass
   public static void setUpOnce() {
      productSearch = FullVidalAPIFactory.getDevInstance().searchProduct();
   }

   @Test
   public void withOutParamsShouldReturnManyResults() {
      ProductByNameResult byNameResult = productSearch.byName().execQuery();
      assertThat(byNameResult.getTitle()).contains("Search Products - Query :");
      assertThat(byNameResult.getTotalResultsNumber()).isGreaterThan(5000);
      assertThat(byNameResult.getProducts().size()).isGreaterThan(1);
   }

   @Test
   public void withQueryParamShouldReturnNonEmptyResults() {
      ProductByNameResult byNameResult = productSearch.byName().setQuery("asp").execQuery();
      assertNonEmptyResults(byNameResult);
   }

   @Test
   public void withStartwithParamShouldReturnNonEmptyResults() {
      ProductByNameResult byNameResult = productSearch.byName().setStartWith("asp").execQuery();
      assertNonEmptyResults(byNameResult);
   }

   @Test
   public void withStatusParamShouldReutrnNonEmptyResults() {
      ProductByNameResult byNameResult = productSearch.byName().setStatus(MarketStatusEnum.AVAILABLE).execQuery();
      assertNonEmptyResults(byNameResult);
   }


   private void assertNonEmptyResults(ProductByNameResult byNameResult) {
      assertThat(byNameResult.getTitle()).contains("Search Products - Query :");
      assertThat(byNameResult.getTotalResultsNumber()).isGreaterThan(1);
   }
}
