package results;

import models.EqFrenchProductOfNameQuery;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIEqFrenchProductByNameResultFromXMLResource;

public class APIEqFrenchProductByNameResultTest {

   @Test
   public void shouldGetTheListOfEqFrenchProductsByName() throws FileNotFoundException {
      APIEqFrenchProductByNameResult byNameResult =
              getAPIEqFrenchProductByNameResultFromXMLResource("eqFrenchProductsByName.xml");

      List<EqFrenchProductOfNameQuery> eqFrenchProducts = byNameResult.getEqFrenchProducts();

      assertThat(eqFrenchProducts.size()).isEqualTo(25);
   }
}
