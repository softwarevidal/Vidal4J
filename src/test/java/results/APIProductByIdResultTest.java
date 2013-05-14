package results;

import items.OfIdProduct;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIFullProductResultFromXMLResource;

public class APIProductByIdResultTest {

   @Test
   public void shouldReturnTheFullProduct() throws FileNotFoundException {
      APIProductByIdResult fullProductResult = getAPIFullProductResultFromXMLResource("fullProduct.xml");

      OfIdProduct ofIdProduct = fullProductResult.getFullProduct();

      assertThat(fullProductResult.getTitle()).contains("Product ");
      assertThat(ofIdProduct).isNotNull();
   }
}
