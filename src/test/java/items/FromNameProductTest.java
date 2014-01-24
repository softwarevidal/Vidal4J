package items;

import org.junit.Before;
import org.junit.Test;
import results.ProductByNameResult;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.APIResultTools.getAPIProductResultFromXMLResource;

public class FromNameProductTest {

   private FromNameProduct fromNameProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      this.fromNameProduct = this.getFirstProductFromXMLResource("productByName_Long.xml");
   }

   @Test
   public void shouldReturnTheNameOfTheProduct() {
      assertThat(this.fromNameProduct.getName()).isEqualTo("ASPIRINE RATIOPHARM 500 mg cp séc");
   }


   private FromNameProduct getFirstProductFromXMLResource(String xmlSource) throws FileNotFoundException {
      ProductByNameResult apiProductByNameResult = getAPIProductResultFromXMLResource(xmlSource);
      return apiProductByNameResult.getProducts().get(0);
   }
}
