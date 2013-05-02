package results;

import models.Product;
import org.junit.Test;
import results.APIProductResult;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIProductResultFromXMLResource;

public class APIProductResultTest {

   @Test
   public void shouldReturnTheListOfProducts() throws FileNotFoundException {
      APIProductResult apiProductResult = getAPIProductResultFromXMLResource("productByName_Long.xml");
      List<Product> products = apiProductResult.getProducts();
      assertThat(products.size()).isEqualTo(25);
   }

}
