package queries;

import api.FullVidalAPI;
import api.FullVidalAPIFactory;
import org.junit.Test;
import results.APIEqFrenchProductByIdResult;

import static org.fest.assertions.Assertions.assertThat;

public class EqFrenchProductByIdQueryIT {
   
   @Test
   public void withoutParamsShouldReturnMoreThanOneResult() {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      APIEqFrenchProductByIdResult byIdResult = fullVidalAPI.searchEqFrenchProduct().byId(11022).execQuery();
      assertThat(byIdResult.getEqFrenchProducts().size()).isGreaterThan(1);
   }

   @Test
   public void withParamsShouldReturnMoreThanOneResult() {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      EqFrenchProductByIdQuery byIdQuery = fullVidalAPI.searchEqFrenchProduct()
                                                   .byId(11022)
                                                   .setSameForm(false)
                                                   .setSameRoutes(true);
      APIEqFrenchProductByIdResult byIdResult = byIdQuery.execQuery();
      assertThat(byIdResult.getEqFrenchProducts().size()).isGreaterThan(1);
   }
}
