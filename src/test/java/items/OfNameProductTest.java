package items;

import org.junit.Before;
import org.junit.Test;
import results.APIProductByNameResult;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIProductResultFromXMLResource;

public class OfNameProductTest {

   private OfNameProduct ofNameProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      this.ofNameProduct = this.getFirstProductFromXMLResource("productByName_Long.xml");
   }

   @Test
   public void shouldReturnTheNameOfTheProduct() {
      assertThat(this.ofNameProduct.getName()).isEqualTo("ASPIRINE RATIOPHARM 500 mg cp séc");
   }


   private OfNameProduct getFirstProductFromXMLResource(String xmlSource) throws FileNotFoundException {
      APIProductByNameResult apiProductByNameResult = getAPIProductResultFromXMLResource(xmlSource);
      return apiProductByNameResult.getProducts().get(0);
   }
}
