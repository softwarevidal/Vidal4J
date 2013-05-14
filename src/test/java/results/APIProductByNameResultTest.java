package results;

import items.OfNameProduct;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIProductResultFromXMLResource;

public class APIProductByNameResultTest {

   @Test
   public void shouldReturnTheListOfProducts() throws FileNotFoundException {
      APIProductByNameResult apiProductByNameResult = getAPIProductResultFromXMLResource("productByName_Long.xml");
      List<OfNameProduct> ofNameProducts = apiProductByNameResult.getProducts();
      assertThat(ofNameProducts.size()).isEqualTo(10);
   }

}
