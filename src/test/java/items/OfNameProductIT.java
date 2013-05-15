package items;

import api.FullVidalAPI;
import api.FullVidalAPIFactory;
import org.junit.Test;
import results.APIProductByIdResult;
import results.APIProductByNameResult;

import static org.fest.assertions.Assertions.assertThat;


public class OfNameProductIT {

   @Test
   public void shouldOpenTheProduct() {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      APIProductByNameResult byNameResult = fullVidalAPI.searchProduct().byName().setQuery("asp").execQuery();
      FromNameProduct nameProduct = byNameResult.getProducts().get(0);
      APIProductByIdResult byIdResult = nameProduct.openFullProduct();

      assertThat(byIdResult.getTitle()).contains("Product ");
   }
}
