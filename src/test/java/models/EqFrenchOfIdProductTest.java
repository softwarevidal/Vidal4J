package models;

import org.junit.Before;
import org.junit.Test;
import results.APIEqFrenchProductByIdResult;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIEqFrenchProductResultFromXMLResource;

public class EqFrenchOfIdProductTest {

   private EqFrenchOfIdProduct eqFrenchOfIdProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      this.eqFrenchOfIdProduct = this.getFirstForeignProductFromXMLResource("eqFrenchProducts.xml");
   }


   @Test
   public void shouldReturnTheActivePrinciple() {
      assertThat(this.eqFrenchOfIdProduct.getActivePrinciple()).isEqualTo("acénocoumarol");
   }

   @Test
   public void shouldReturnTheAMMType() {
      assertThat(this.eqFrenchOfIdProduct.getAMMType().getVidalId()).isEqualTo(20);
      assertThat(this.eqFrenchOfIdProduct.getAMMType().getText()).isEqualTo("AMM Française");
   }

   @Test
   public void shouldReturnWheterItHasPublishedDoc() {
      assertThat(this.eqFrenchOfIdProduct.hasPublishedDoc()).isTrue();
   }

   @Test
   public void shouldReturnTheConcentration() {
      assertThat(this.eqFrenchOfIdProduct.getConcentration()).isEqualTo("1mg");
   }

   @Test
   public void shouldReturnTheName() {
      assertThat(this.eqFrenchOfIdProduct.getName()).isEqualTo("MINISINTROM 1 mg cp");
   }


   private EqFrenchOfIdProduct getFirstForeignProductFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      APIEqFrenchProductByIdResult eqFrenchProductResult =
              getAPIEqFrenchProductResultFromXMLResource(xmlSource);
      return eqFrenchProductResult.getEqFrenchProducts().get(0);
   }
}
