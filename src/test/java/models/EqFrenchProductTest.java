package models;

import org.junit.Before;
import org.junit.Test;
import results.APIEqFrenchProductResult;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIEqFrenchProductResultFromXMLResource;

public class EqFrenchProductTest {

   private EqFrenchProduct eqFrenchProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      this.eqFrenchProduct = this.getFirstForeignProductFromXMLResource("eqFrenchProducts.xml");
   }


   @Test
   public void shouldReturnTheActivePrinciple() {
      assertThat(this.eqFrenchProduct.getActivePrinciple()).isEqualTo("acénocoumarol");
   }

   @Test
   public void shouldReturnTheAMMType() {
      assertThat(this.eqFrenchProduct.getAMMType().getVidalId()).isEqualTo(20);
      assertThat(this.eqFrenchProduct.getAMMType().getText()).isEqualTo("AMM Française");
   }

   @Test
   public void shouldReturnWheterItHasPublishedDoc() {
      assertThat(this.eqFrenchProduct.hasPublishedDoc()).isTrue();
   }

   @Test
   public void shouldReturnTheConcentration() {
      assertThat(this.eqFrenchProduct.getConcentration()).isEqualTo("1mg");
   }


   private EqFrenchProduct getFirstForeignProductFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      APIEqFrenchProductResult eqFrenchProductResult =
              getAPIEqFrenchProductResultFromXMLResource(xmlSource);
      return eqFrenchProductResult.getEqFrenchProducts().get(0);
   }
}
