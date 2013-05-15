package items;

import org.junit.Before;
import org.junit.Test;
import results.EqFrenchProductByIdResult;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIEqFrenchProductResultFromXMLResource;

public class FullEqFrenchProductTest {

   private FullEqFrenchProduct fullEqFrenchProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      this.fullEqFrenchProduct = this.getFirstForeignProductFromXMLResource("eqFrenchProducts.xml");
   }


   @Test
   public void shouldReturnTheActivePrinciple() {
      assertThat(this.fullEqFrenchProduct.getActivePrinciple()).isEqualTo("acénocoumarol");
   }

   @Test
   public void shouldReturnTheAMMType() {
      assertThat(this.fullEqFrenchProduct.getAMMType().getVidalId()).isEqualTo(20);
      assertThat(this.fullEqFrenchProduct.getAMMType().getText()).isEqualTo("AMM Française");
   }

   @Test
   public void shouldReturnWheterItHasPublishedDoc() {
      assertThat(this.fullEqFrenchProduct.hasPublishedDoc()).isTrue();
   }

   @Test
   public void shouldReturnTheConcentration() {
      assertThat(this.fullEqFrenchProduct.getConcentration()).isEqualTo("1mg");
   }

   @Test
   public void shouldReturnTheName() {
      assertThat(this.fullEqFrenchProduct.getName()).isEqualTo("MINISINTROM 1 mg cp");
   }


   private FullEqFrenchProduct getFirstForeignProductFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      EqFrenchProductByIdResult eqFrenchProductResult =
              getAPIEqFrenchProductResultFromXMLResource(xmlSource);
      return eqFrenchProductResult.getEqFrenchProducts().get(0);
   }
}
