package models;

import org.junit.Before;
import org.junit.Test;
import results.APIForeignProductResult;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIForeignProductResultFromXMLResource;

public class ForeignProductTest {

   private ForeignProduct foreignProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      foreignProduct = this.getFirstForeignProductFromXMLResource("foreignProducts.xml");
   }


   @Test
   public void shouldReturnTheId() {
      assertThat(this.foreignProduct.getId()).isEqualTo("vidal://foreign_product/10004082");
   }

   @Test
   public void shouldReturnTheATCCLass() {
      assertThat(this.foreignProduct.getATCClass().getCode()).isEqualTo("B01AA07");
      assertThat(this.foreignProduct.getATCClass().getName()).isEqualTo("ACENOCOUMAROL");
   }

   @Test
   public void shouldReturnTheCountryCode() {
      assertThat(this.foreignProduct.getCountry().getCountryCode()).isEqualTo("AT");
      assertThat(this.foreignProduct.getCountry().getName()).isEqualTo("Autriche");
   }

   @Test
   public void shouldReturnTheGalenicForm() {
      assertThat(this.foreignProduct.getGalenicForm().getVidalId()).isEqualTo("59");
      assertThat(this.foreignProduct.getGalenicForm().getName()).isEqualTo("comprimé");
   }

   @Test
   public void shouldReturnTheName() {
      assertThat(this.foreignProduct.getName()).isEqualTo("SINTROM tablet 4 mg");
   }

   @Test
   public void shouldReturnTheRoute() {
      assertThat(this.foreignProduct.getRoute().getId()).isEqualTo(38);
      assertThat(this.foreignProduct.getRoute().getName()).isEqualTo("orale");
   }


   private ForeignProduct getFirstForeignProductFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      APIForeignProductResult foreignProductResult = getAPIForeignProductResultFromXMLResource(xmlSource);
      return foreignProductResult.getForeignProducts().get(0);
   }
}
