package queries;

import api.VidalAPI;
import api.VidalAPIFactory;
import org.junit.Test;
import results.APIForeignProductResult;

import static org.fest.assertions.Assertions.assertThat;

public class ForeignProductByIdQueryIT {

   @Test
   public void shouldReturnForeignProductsFromFrenchId() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      ForeignProductByIdQuery byIdQuery = vidalAPI.searchForeignProduct().byFrenchProductId(15070);
      APIForeignProductResult result = byIdQuery.execQuery();
      assertThat(result.getTitle()).contains("ForeignProducts for Product ");
      assertThat(result.getForeignProducts().size()).isGreaterThan(1);
   }
}
