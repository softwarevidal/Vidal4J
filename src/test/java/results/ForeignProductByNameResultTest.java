package results;

import items.ForeignProduct;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIEqFrenchProductByNameResultFromXMLResource;

public class ForeignProductByNameResultTest {

   @Test
   public void shouldGetTheListOfEqFrenchProductsByName() throws FileNotFoundException {
      ForeignProductByNameResult byNameResult =
              getAPIEqFrenchProductByNameResultFromXMLResource("eqFrenchProductsByName.xml");

      List<ForeignProduct> eqFrenchProducts = byNameResult.getForeignProducts();

      assertThat(eqFrenchProducts.size()).isEqualTo(25);
   }
}
