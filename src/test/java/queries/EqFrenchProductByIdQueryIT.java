package queries;

import api.VidalAPI;
import api.VidalAPIFactory;
import org.junit.Test;
import results.APIEqFrenchProductByIdResult;

import static org.fest.assertions.Assertions.assertThat;

public class EqFrenchProductByIdQueryIT {
   
   @Test
   public void withoutParamsShouldReturnMoreThanOneResult() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIEqFrenchProductByIdResult byIdResult = vidalAPI.searchEqFrenchProduct().byId(11022).execQuery();
      assertThat(byIdResult.getEqFrenchProducts().size()).isGreaterThan(1);
   }

   @Test
   public void withParamsShouldReturnMoreThanOneResult() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      EqFrenchProductByIdQuery byIdQuery = vidalAPI.searchEqFrenchProduct()
                                                   .byId(11022)
                                                   .setSameForm(false)
                                                   .setSameRoutes(true);
      APIEqFrenchProductByIdResult byIdResult = byIdQuery.execQuery();
      assertThat(byIdResult.getEqFrenchProducts().size()).isGreaterThan(1);
   }
}
