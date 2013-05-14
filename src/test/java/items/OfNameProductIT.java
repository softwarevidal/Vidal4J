package items;

import api.VidalAPI;
import api.VidalAPIFactory;
import org.junit.Test;
import results.APIProductByIdResult;
import results.APIProductByNameResult;

import static org.fest.assertions.Assertions.assertThat;


public class OfNameProductIT {

   @Test
   public void shouldOpenTheProduct() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIProductByNameResult byNameResult = vidalAPI.searchProduct().byName().setQuery("asp").execQuery();
      OfNameProduct nameProduct = byNameResult.getProducts().get(0);
      APIProductByIdResult byIdResult = nameProduct.openProduct();

      assertThat(byIdResult.getTitle()).contains("Product ");
   }
}
