package queries;

import api.VidalAPIFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import results.APIProductByIdResult;
import searches.ProductSearch;

import static org.fest.assertions.Assertions.assertThat;

public class ProductByIdQueryIT {

   private static ProductSearch productSearch;

   @BeforeClass
   public static void setUpOnce() {
      productSearch = VidalAPIFactory.getDevInstance().searchProduct();
   }

   @Test
   public void shouldReturnAProductFromId() {
      APIProductByIdResult byIdResult = productSearch.byId(3).execQuery();
      assertThat(byIdResult.getTitle()).isEqualTo("Product 3");
   }
}
