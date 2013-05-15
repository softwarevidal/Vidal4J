package queries;

import api.FullVidalAPIFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import results.ProductByIdResult;
import searches.ProductSearch;

import static org.fest.assertions.Assertions.assertThat;

public class ProductByIdQueryIT {

   private static ProductSearch productSearch;

   @BeforeClass
   public static void setUpOnce() {
      productSearch = FullVidalAPIFactory.getDevInstance().searchProduct();
   }

   @Test
   public void shouldReturnAProductFromId() {
      ProductByIdResult byIdResult = productSearch.byId(3).execQuery();
      assertThat(byIdResult.getTitle()).isEqualTo("Product 3");
   }
}
