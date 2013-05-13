package models;

import org.junit.Before;
import org.junit.Test;
import results.APIProductByIdResult;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIFullProductResultFromXMLResource;

public class OfIdProductTest {

   private OfIdProduct ofIdProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      ofIdProduct = this.getFullProductFromXMLResource("fullProduct.xml");
   }


   @Test
   public void shouldReturnURLToEurekaSante() throws MalformedURLException, URISyntaxException {
      assertThat(this.ofIdProduct.getEurekaSanteURL().toString())
              .isEqualTo("http://www.eurekasante.fr/medicaments/fromwidget.html?idvdf=MSINTR01.htm");
   }


   private OfIdProduct getFullProductFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      APIProductByIdResult fullProductResult = getAPIFullProductResultFromXMLResource(xmlSource);
      return fullProductResult.getFullProduct();
   }
}
