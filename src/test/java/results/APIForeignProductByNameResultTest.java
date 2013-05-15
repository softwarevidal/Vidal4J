package results;

import items.FromNameForeignProduct;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIEqFrenchProductByNameResultFromXMLResource;

public class APIForeignProductByNameResultTest {

   @Test
   public void shouldGetTheListOfEqFrenchProductsByName() throws FileNotFoundException {
      APIForeignProductByNameResult byNameResult =
              getAPIEqFrenchProductByNameResultFromXMLResource("eqFrenchProductsByName.xml");

      List<FromNameForeignProduct> eqFrenchProducts = byNameResult.getEqFrenchProducts();

      assertThat(eqFrenchProducts.size()).isEqualTo(25);
   }
}
