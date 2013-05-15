package results;

import items.FullProduct;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIFullProductResultFromXMLResource;

public class APIProductByIdResultTest {

   @Test
   public void shouldReturnTheFullProduct() throws FileNotFoundException {
      APIProductByIdResult fullProductResult = getAPIFullProductResultFromXMLResource("fullProduct.xml");

      FullProduct fullProduct = fullProductResult.getFullProduct();

      assertThat(fullProductResult.getTitle()).contains("Product ");
      assertThat(fullProduct).isNotNull();
   }
}
