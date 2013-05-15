package items;

import items.key_values.ATCClass;
import items.key_values.Country;
import items.key_values.GalenicForm;
import items.key_values.Route;
import org.junit.Before;
import org.junit.Test;
import results.APIForeignProductByNameResult;
import utils.Category;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIEqFrenchProductByNameResultFromXMLResource;

public class FromNameForeignProductTest {

   private FromNameForeignProduct productOfNameQuery;

   @Before
   public void setUp() throws FileNotFoundException {
      productOfNameQuery = getFirstProductFromXML("eqFrenchProductsByName.xml");
   }

   @Test
   public void shouldReturnTheName() {
      assertThat(this.productOfNameQuery.getName()).isEqualTo("ASPEGIC powder for oral solution 500 mg");
   }

   @Test
   public void shouldReturnTheCategory() {
      assertThat(this.productOfNameQuery.getCategory()).isEqualTo(Category.FOREIGN_PRODUCT);
   }

   @Test
   public void shouldReturnTheId() {
      assertThat(this.productOfNameQuery.getEntryId().toString()).isEqualTo("vidal://foreign_product/2000031");
   }

   @Test
   public void shouldReturnTheATCClass() {
      ATCClass atcClass = this.productOfNameQuery.getATCClass();
      assertThat(atcClass.getCode()).isEqualTo("N02BA01");
      assertThat(atcClass.getName()).isEqualTo("ACETYLSALICYLIQUE ACIDE");
   }

   @Test
   public void shouldReturnTheCountry() {
      Country country = this.productOfNameQuery.getCountry();
      assertThat(country.getCountryCode()).isEqualTo("DZ");
      assertThat(country.getName()).isEqualTo("Algérie");
   }

   @Test
   public void shouldReturnTheGalenicForm() {
      GalenicForm galenicForm = this.productOfNameQuery.getGalenicForm();
      assertThat(galenicForm.getName()).isEqualTo("poudre pour solution buvable");
      assertThat(galenicForm.getVidalId()).isEqualTo(408);
   }

   @Test
   public void shouldReturnTheRoute() {
      Route route = this.productOfNameQuery.getRoute();
      assertThat(route.getId()).isEqualTo(38);
      assertThat(route.getName()).isEqualTo("orale");
   }


   private FromNameForeignProduct getFirstProductFromXML(String xmlSource) throws FileNotFoundException {
      APIForeignProductByNameResult byNameResult =
              getAPIEqFrenchProductByNameResultFromXMLResource(xmlSource);
      return byNameResult.getEqFrenchProducts().get(0);
   }
}
