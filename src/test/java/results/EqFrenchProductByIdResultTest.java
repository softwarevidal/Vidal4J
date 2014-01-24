package results;

import items.FullEqFrenchProduct;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.APIResultTools.getAPIEqFrenchProductResultFromXMLResource;

public class EqFrenchProductByIdResultTest {

   @Test
   public void shouldReturnTheListOdEqFrenchProducts() throws FileNotFoundException {
      EqFrenchProductByIdResult eqFrenchProductResult =
              getAPIEqFrenchProductResultFromXMLResource("eqFrenchProducts.xml");

      List<FullEqFrenchProduct> fullEqFrenchProducts = eqFrenchProductResult.getEqFrenchProducts();

      assertThat(fullEqFrenchProducts.size()).isEqualTo(2);
   }
}
