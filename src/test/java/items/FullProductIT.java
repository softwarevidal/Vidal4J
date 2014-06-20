package items;

import api.FullVidalAPI;
import api.FullVidalAPIFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import results.ForeignProductByIdResult;
import results.ProductByIdResult;

import static org.assertj.core.api.Assertions.assertThat;


public class FullProductIT {

   private static FullProduct fullProduct;

   @BeforeClass
   public static void setUpOnce() {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      ProductByIdResult idResult = fullVidalAPI.searchProduct().byId(1147).execQuery();
      fullProduct = idResult.getFullProduct();
   }

   @Test
   @Ignore("Fails on http://dev-software.vidal.net/excalibur-rest-snapshot/ (path issue) and on http://apirest-dev.vidal.fr/ (HTTP 401 due to recent use of 3scale authorisation)")
   public void shouldOpenForeignResults() {
      ForeignProductByIdResult result = fullProduct.openFullForeignProduct();
      assertThat(result.getTitle()).isEqualTo("ForeignProducts for Product 1147");
      assertThat(result.getForeignProducts().size()).isGreaterThan(1);
   }
}
