package models;

import org.junit.Before;
import org.junit.Test;
import results.APIProductResult;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIProductResultFromXMLResource;

public class ProductTest {

   private Product product;

   @Before
   public void setUp() throws FileNotFoundException {
      this.product = this.getFirstProductFromXMLResource("productByName_Long.xml");
   }

   @Test
   public void shouldReturnTheNameOfTheProduct() {
      assertThat(this.product.getName()).isEqualTo("ANTIGRIPPINE A L'ASPIRINE ETAT GRIPPAL cp");
   }

   @Test
   public void shouldReturnIfShouldBeCarefullWithTheProduct() {
      assertThat(this.product.shouldBeCarefull()).isFalse();
   }

   @Test
   public void shouldReturnTheCharacteristicsOfTheProvider() {
      assertThat(this.product.getProvider().getVidalId()).isEqualTo(2247);
      assertThat(this.product.getProvider().getName()).isEqualTo("Omega Pharma");
      assertThat(this.product.getProvider().getType()).isEqualTo("OWNER");
   }

   @Test
   public void shouldReturnTheDispensationPlace() {
      assertThat(this.product.getDispensationPlace().getName()).isEqualTo("PHARMACY");
      assertThat(this.product.getDispensationPlace().getText()).isEqualTo("PHARMACY");
   }

   @Test
   public void shouldReturnWhetherItIsADopingProduct() {
      assertThat(this.product.isDopingProduct()).isFalse();
   }

   @Test
   public void shouldReturnWhetherTheProductIsExceptional() {
      assertThat(this.product.isExceptional()).isFalse();
   }

   @Test
   public void shouldReturnWhetherItIsOutOfGHS() {
      assertThat(this.product.isOutOfGHS()).isFalse();
   }

   @Test
   public void shouldReturnVidalId() {
      assertThat(this.product.getVidalId()).isEqualTo(1147);
   }

   @Test
   public void shouldReturnTheList() {
      assertThat(this.product.getVidalList().getName()).isEqualTo("I");
      assertThat(this.product.getVidalList().getText()).isEqualTo("Liste 1");
   }

   @Test
   public void shouldReturnTheMarketStatus() {
      assertThat(this.product.getMarketStatus().getName()).isEqualTo("AVAILABLE");
      assertThat(this.product.getMarketStatus().getText()).isEqualTo("Commercialisé");
   }

   @Test
   public void shouldReturnWheterItIsPrescriptivableByMidWife() {
      assertThat(this.product.IsPrescriptivableByMidWife()).isFalse();
   }

   @Test
   public void shouldReturnTheRefundRate() {
      assertThat(this.product.getRefundRate()).isEqualTo("NR");
   }

   @Test
   public void shouldReturnWhetherItIsRetrocedable() {
      assertThat(this.product.isRetrocedable()).isFalse();
   }


   private Product getFirstProductFromXMLResource(String xmlSource) throws FileNotFoundException {
      APIProductResult apiProductResult = getAPIProductResultFromXMLResource(xmlSource);
      return apiProductResult.getProducts().get(0);
   }
}
