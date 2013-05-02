package results;

import models.ForeignProduct;
import org.junit.Test;
import results.APIForeignProductResult;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIForeignProductResultFromXMLResource;

public class APIForeignProductResultTest {

   @Test
   public void shouldReturnTheListOfForeignProducts() throws FileNotFoundException {
      APIForeignProductResult apiForeignProductResult =
              getAPIForeignProductResultFromXMLResource("foreignProducts.xml");

      List<ForeignProduct> foreignProducts = apiForeignProductResult.getForeignProducts();

      assertThat(foreignProducts.size()).isEqualTo(35);
   }
}
