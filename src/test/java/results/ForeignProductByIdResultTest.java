package results;

import api.FullVidalAPI;
import items.ForeignProduct;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIForeignProductResultFromXMLResource;

public class ForeignProductByIdResultTest {

   @Test
   public void shouldReturnTheListOfForeignProducts() throws FileNotFoundException {
      ForeignProductByIdResult foreignProductByIdResult =
              getAPIForeignProductResultFromXMLResource("foreignProducts.xml", new FullVidalAPI(""));

      List<ForeignProduct> foreignProducts = foreignProductByIdResult.getForeignProducts();

      assertThat(foreignProducts.size()).isEqualTo(35);
   }
}
