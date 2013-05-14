package utils;

import items.OfIdProduct;
import org.junit.Before;
import org.junit.Test;
import results.APIProductByIdResult;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIFullProductResultFromXMLResource;

public class EntryToolTest {

   private OfIdProduct ofIdProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      ofIdProduct = this.getFullProductFromXMLResource("fullProduct.xml");
   }


   @Test
   public void shouldReturnIfShouldBeCarefullWithTheProduct() {
      assertThat(this.ofIdProduct.shouldBeCarefull()).isFalse();
   }

   @Test
   public void shouldReturnTheCharacteristicsOfTheProvider() {
      assertThat(this.ofIdProduct.getProvider().getVidalId()).isEqualTo(616);
      assertThat(this.ofIdProduct.getProvider().getName()).isEqualTo("Novartis Pharma SAS");
      assertThat(this.ofIdProduct.getProvider().getType()).isEqualTo("OWNER");
   }

   @Test
   public void shouldReturnTheDispensationPlace() {
      assertThat(this.ofIdProduct.getDispensationPlace()).isEqualTo(DispensationPlace.PHARMACY);
   }

   @Test
   public void shouldReturnWhetherItIsADopingProduct() {
      assertThat(this.ofIdProduct.isDopingProduct()).isFalse();
   }

   @Test
   public void shouldReturnWhetherTheProductIsExceptional() {
      assertThat(this.ofIdProduct.isExceptional()).isFalse();
   }

   @Test
   public void shouldReturnWhetherItIsOutOfGHS() {
      assertThat(this.ofIdProduct.isOutOfGHS()).isFalse();
   }

   @Test
   public void shouldReturnVidalId() {
      assertThat(this.ofIdProduct.getVidalId()).isEqualTo(15070);
   }

   @Test
   public void shouldReturnTheList() {
      assertThat(this.ofIdProduct.getVidalList().getName()).isEqualTo("I");
      assertThat(this.ofIdProduct.getVidalList().getText()).isEqualTo("Liste 1");
   }

   @Test
   public void shouldReturnTheMarketStatus() {
      assertThat(this.ofIdProduct.getMarketStatus()).isEqualTo(MarketStatus.AVAILABLE);
   }

   @Test
   public void shouldReturnWheterItIsPrescriptivableByMidWife() {
      assertThat(this.ofIdProduct.IsPrescriptivableByMidWife()).isFalse();
   }

   @Test
   public void shouldReturnTheRefundRate() {
      assertThat(this.ofIdProduct.getRefundRate()).isEqualTo("65%");
   }

   @Test
   public void shouldReturnWhetherItIsRetrocedable() {
      assertThat(this.ofIdProduct.isRetrocedable()).isFalse();
   }


   private OfIdProduct getFullProductFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      APIProductByIdResult fullProductResult = getAPIFullProductResultFromXMLResource(xmlSource);
      return fullProductResult.getFullProduct();
   }
}
