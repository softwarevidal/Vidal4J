package results;

import models.EqFrenchProduct;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIEqFrenchProductResultFromXMLResource;

public class APIEqFrenchProductResultTest {

   @Test
   public void shouldReturnTheListOdEqFrenchProducts() throws FileNotFoundException {
      APIEqFrenchProductResult eqFrenchProductResult =
              getAPIEqFrenchProductResultFromXMLResource("eqFrenchProducts.xml");

      List<EqFrenchProduct> eqFrenchProducts = eqFrenchProductResult.getEqFrenchProducts();

      assertThat(eqFrenchProducts.size()).isEqualTo(2);
   }
}
