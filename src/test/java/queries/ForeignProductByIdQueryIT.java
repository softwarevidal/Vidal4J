package queries;

import api.FullVidalAPI;
import api.FullVidalAPIFactory;
import org.junit.Test;
import results.ForeignProductByIdResult;

import static org.assertj.core.api.Assertions.assertThat;

public class ForeignProductByIdQueryIT {

   @Test
   public void shouldReturnForeignProductsFromFrenchId() {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      ForeignProductByIdQuery byIdQuery = fullVidalAPI.searchForeignProduct().byFrenchProductId(15070);
      ForeignProductByIdResult result = byIdQuery.execQuery();
      assertThat(result.getTitle()).contains("ForeignProducts for Product ");
      assertThat(result.getForeignProducts().size()).isGreaterThan(1);
   }
}
