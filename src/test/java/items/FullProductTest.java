package items;

import org.junit.Before;
import org.junit.Test;
import results.ProductByIdResult;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIFullProductResultFromXMLResource;

public class FullProductTest {

   private FullProduct fullProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      fullProduct = this.getFullProductFromXMLResource("fullProduct.xml");
   }


   @Test
   public void shouldReturnURLToEurekaSante() throws MalformedURLException, URISyntaxException {
      assertThat(this.fullProduct.getEurekaSanteURL().toString())
              .isEqualTo("http://www.eurekasante.fr/medicaments/fromwidget.html?idvdf=MSINTR01.htm");
   }


   private FullProduct getFullProductFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      ProductByIdResult fullProductResult = getAPIFullProductResultFromXMLResource(xmlSource);
      return fullProductResult.getFullProduct();
   }
}
