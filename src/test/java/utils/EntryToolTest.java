package utils;

import items.FullProduct;
import org.junit.Before;
import org.junit.Test;
import results.ProductByIdResult;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.APIResultTools.getAPIFullProductResultFromXMLResource;

public class EntryToolTest {

   private FullProduct fullProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      fullProduct = this.getFullProductFromXMLResource("fullProduct.xml");
   }


   @Test
   public void shouldReturnIfShouldBeCarefullWithTheProduct() {
      assertThat(this.fullProduct.shouldBeCarefull()).isFalse();
   }

   @Test
   public void shouldReturnTheCharacteristicsOfTheProvider() {
      assertThat(this.fullProduct.getProvider().getVidalId()).isEqualTo(616);
      assertThat(this.fullProduct.getProvider().getName()).isEqualTo("Novartis Pharma SAS");
      assertThat(this.fullProduct.getProvider().getType()).isEqualTo("OWNER");
   }

   @Test
   public void shouldReturnTheDispensationPlace() {
      assertThat(this.fullProduct.getDispensationPlace()).isEqualTo(DispensationPlace.PHARMACY);
   }

   @Test
   public void shouldReturnWhetherItIsADopingProduct() {
      assertThat(this.fullProduct.isDopingProduct()).isFalse();
   }

   @Test
   public void shouldReturnWhetherTheProductIsExceptional() {
      assertThat(this.fullProduct.isExceptional()).isFalse();
   }

   @Test
   public void shouldReturnWhetherItIsOutOfGHS() {
      assertThat(this.fullProduct.isOutOfGHS()).isFalse();
   }

   @Test
   public void shouldReturnVidalId() {
      assertThat(this.fullProduct.getVidalId()).isEqualTo(15070);
   }

   @Test
   public void shouldReturnTheList() {
      assertThat(this.fullProduct.getVidalList().getName()).isEqualTo("I");
      assertThat(this.fullProduct.getVidalList().getText()).isEqualTo("Liste 1");
   }

   @Test
   public void shouldReturnTheMarketStatus() {
      assertThat(this.fullProduct.getMarketStatus().asEnum()).isEqualTo(MarketStatusEnum.AVAILABLE);
   }

   @Test
   public void shouldReturnWheterItIsPrescriptivableByMidWife() {
      assertThat(this.fullProduct.IsPrescriptivableByMidWife()).isFalse();
   }

   @Test
   public void shouldReturnTheRefundRate() {
      assertThat(this.fullProduct.getRefundRate()).isEqualTo("65%");
   }

   @Test
   public void shouldReturnWhetherItIsRetrocedable() {
      assertThat(this.fullProduct.isRetrocedable()).isFalse();
   }


   private FullProduct getFullProductFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      ProductByIdResult fullProductResult = getAPIFullProductResultFromXMLResource(xmlSource);
      return fullProductResult.getFullProduct();
   }
}
