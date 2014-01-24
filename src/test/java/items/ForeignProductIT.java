package items;

import api.FullVidalAPI;
import api.FullVidalAPIFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import results.EqFrenchProductByIdResult;
import results.ForeignProductByIdResult;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.APIResultTools.getAPIForeignProductResultFromXMLResource;

public class ForeignProductIT {

   private static ForeignProduct foreignProduct;

   @BeforeClass
   public static void setUpOnce() throws FileNotFoundException {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      ForeignProductByIdResult foreignProductsResult =
              getAPIForeignProductResultFromXMLResource("foreignProducts.xml", fullVidalAPI);
      foreignProduct = foreignProductsResult.getForeignProducts().get(0);
   }

   @Test
   public void shouldLoadEqFrenchProducts() {
      EqFrenchProductByIdResult result = foreignProduct.openEqFrenchProducts();
      assertThat(result.getTitle()).isEqualTo("French equivalent Products for Foreign Product 10004082");
      assertThat(result.getEqFrenchProducts().size()).isGreaterThan(1);
   }
}
