package queries;

import api.FullVidalAPIFactory;
import items.ForeignProduct;
import org.junit.Test;
import results.ForeignProductByNameResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ForeignProductByNameQueryIT {

   @Test
   public void withoutParamsShouldReturnANonEmptyResult() {
      ForeignProductByNameQuery byNameQuery = FullVidalAPIFactory.getDevInstance()
              .searchForeignProduct()
              .byName("asp");

      ForeignProductByNameResult byNameResult = byNameQuery.execQuery();
      List<ForeignProduct> eqFrenchProducts = byNameResult.getForeignProducts();
      assertThat(eqFrenchProducts.size()).isGreaterThan(1);
   }

   @Test
   public void withParamsShouldReturnANonEmptyResult() {
      ForeignProductByNameQuery byNameQuery = FullVidalAPIFactory.getDevInstance()
                                                              .searchForeignProduct()
                                                              .byName("asp");

      ForeignProductByNameResult byNameResult = byNameQuery.setCountry("DZ").execQuery();
      List<ForeignProduct> eqFrenchProducts = byNameResult.getForeignProducts();
      assertThat(eqFrenchProducts.size()).isGreaterThan(1);
   }

}
