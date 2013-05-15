package items;

import org.junit.Before;
import org.junit.Test;
import results.APIForeignProductByIdResult;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIForeignProductResultFromXMLResource;

public class FullForeignProductTest {

   private FullForeignProduct fullForeignProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      fullForeignProduct = this.getFirstForeignProductFromXMLResource("foreignProducts.xml");
   }


   @Test
   public void shouldReturnTheId() {
      assertThat(this.fullForeignProduct.getEntryId().toString()).isEqualTo("vidal://foreign_product/10004082");
   }

   @Test
   public void shouldReturnTheATCCLass() {
      assertThat(this.fullForeignProduct.getATCClass().getCode()).isEqualTo("B01AA07");
      assertThat(this.fullForeignProduct.getATCClass().getName()).isEqualTo("ACENOCOUMAROL");
   }

   @Test
   public void shouldReturnTheCountryCode() {
      assertThat(this.fullForeignProduct.getCountry().getCountryCode()).isEqualTo("AT");
      assertThat(this.fullForeignProduct.getCountry().getName()).isEqualTo("Autriche");
   }

   @Test
   public void shouldReturnTheGalenicForm() {
      assertThat(this.fullForeignProduct.getGalenicForm().getVidalId()).isEqualTo(59);
      assertThat(this.fullForeignProduct.getGalenicForm().getName()).isEqualTo("comprimé");
   }

   @Test
   public void shouldReturnTheName() {
      assertThat(this.fullForeignProduct.getName()).isEqualTo("SINTROM tablet 4 mg");
   }

   @Test
   public void shouldReturnTheRoute() {
      assertThat(this.fullForeignProduct.getRoute().getId()).isEqualTo(38);
      assertThat(this.fullForeignProduct.getRoute().getName()).isEqualTo("orale");
   }


   private FullForeignProduct getFirstForeignProductFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      APIForeignProductByIdResult foreignProductResult = getAPIForeignProductResultFromXMLResource(xmlSource);
      return foreignProductResult.getForeignProducts().get(0);
   }
}
