package results;

import items.FromNameProduct;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIProductResultFromXMLResource;

public class APIProductByNameResultTest {

   @Test
   public void shouldReturnTheListOfProducts() throws FileNotFoundException {
      APIProductByNameResult apiProductByNameResult = getAPIProductResultFromXMLResource("productByName_Long.xml");
      List<FromNameProduct> fromNameProducts = apiProductByNameResult.getProducts();
      assertThat(fromNameProducts.size()).isEqualTo(10);
   }

}
