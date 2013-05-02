package results;

import models.FullProduct;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIFullProductResultFromXMLResource;

public class APIFullProductResultTest {

   @Test
   public void shouldReturnTheFullProduct() throws FileNotFoundException {
      APIFullProductResult fullProductResult = getAPIFullProductResultFromXMLResource("fullProduct.xml");

      FullProduct fullProduct = fullProductResult.getFullProduct();

      assertThat(fullProductResult.getTitle()).contains("Product ");
      assertThat(fullProduct).isNotNull();
   }
}
