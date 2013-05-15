package results;

import items.FullForeignProduct;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIForeignProductResultFromXMLResource;

public class APIForeignProductByIdResultTest {

   @Test
   public void shouldReturnTheListOfForeignProducts() throws FileNotFoundException {
      APIForeignProductByIdResult apiForeignProductByIdResult =
              getAPIForeignProductResultFromXMLResource("foreignProducts.xml");

      List<FullForeignProduct> fullForeignProducts = apiForeignProductByIdResult.getForeignProducts();

      assertThat(fullForeignProducts.size()).isEqualTo(35);
   }
}
