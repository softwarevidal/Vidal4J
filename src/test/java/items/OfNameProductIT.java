package items;

import api.FullVidalAPI;
import api.FullVidalAPIFactory;
import org.junit.Test;
import results.ProductByIdResult;
import results.ProductByNameResult;

import static org.fest.assertions.Assertions.assertThat;


public class OfNameProductIT {

   @Test
   public void shouldOpenTheProduct() {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      ProductByNameResult byNameResult = fullVidalAPI.searchProduct().byName().setQuery("asp").execQuery();
      FromNameProduct nameProduct = byNameResult.getProducts().get(0);
      ProductByIdResult byIdResult = nameProduct.openFullProduct();

      assertThat(byIdResult.getTitle()).contains("Product ");
   }
}
