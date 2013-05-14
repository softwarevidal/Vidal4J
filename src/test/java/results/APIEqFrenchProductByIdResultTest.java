package results;

import items.EqFrenchOfIdProduct;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIEqFrenchProductResultFromXMLResource;

public class APIEqFrenchProductByIdResultTest {

   @Test
   public void shouldReturnTheListOdEqFrenchProducts() throws FileNotFoundException {
      APIEqFrenchProductByIdResult eqFrenchProductResult =
              getAPIEqFrenchProductResultFromXMLResource("eqFrenchProducts.xml");

      List<EqFrenchOfIdProduct> eqFrenchOfIdProducts = eqFrenchProductResult.getEqFrenchProducts();

      assertThat(eqFrenchOfIdProducts.size()).isEqualTo(2);
   }
}
