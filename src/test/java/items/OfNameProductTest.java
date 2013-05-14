package items;

import org.junit.Before;
import org.junit.Test;
import results.APIProductByNameResult;
import utils.DispensationPlace;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIProductResultFromXMLResource;

public class OfNameProductTest {

   private OfNameProduct ofNameProduct;

   @Before
   public void setUp() throws FileNotFoundException {
      this.ofNameProduct = this.getFirstProductFromXMLResource("productByName_Long.xml");
   }

   @Test
   public void shouldReturnTheNameOfTheProduct() {
      assertThat(this.ofNameProduct.getName()).isEqualTo("ASPIRINE RATIOPHARM 500 mg cp séc");
   }

   @Test
   public void shouldReturnIfShouldBeCarefullWithTheProduct() {
      assertThat(this.ofNameProduct.shouldBeCarefull()).isFalse();
   }

   @Test
   public void shouldReturnTheCharacteristicsOfTheProvider() {
      assertThat(this.ofNameProduct.getProvider().getVidalId()).isEqualTo(751);
      assertThat(this.ofNameProduct.getProvider().getName()).isEqualTo("Ratiopharm");
      assertThat(this.ofNameProduct.getProvider().getType()).isEqualTo("OWNER");
   }

   @Test
   public void shouldReturnTheDispensationPlace() {
      assertThat(this.ofNameProduct.getDispensationPlace()).isEqualTo(DispensationPlace.PHARMACY);
   }

   @Test
   public void shouldReturnWhetherItIsADopingProduct() {
      assertThat(this.ofNameProduct.isDopingProduct()).isFalse();
   }

   @Test
   public void shouldReturnWhetherTheProductIsExceptional() {
      assertThat(this.ofNameProduct.isExceptional()).isFalse();
   }

   @Test
   public void shouldReturnWhetherItIsOutOfGHS() {
      assertThat(this.ofNameProduct.isOutOfGHS()).isFalse();
   }

   @Test
   public void shouldReturnVidalId() {
      assertThat(this.ofNameProduct.getVidalId()).isEqualTo(1553);
   }

   @Test
   public void shouldReturnTheList() {
      assertThat(this.ofNameProduct.getVidalList().getName()).isEqualTo("I");
      assertThat(this.ofNameProduct.getVidalList().getText()).isEqualTo("Liste 1");
   }

   @Test
   public void shouldReturnTheMarketStatus() {
      assertThat(this.ofNameProduct.getMarketStatus().getName()).isEqualTo("DELETED_ONEYEAR");
      assertThat(this.ofNameProduct.getMarketStatus().getText()).isEqualTo("Supprimé");
   }

   @Test
   public void shouldReturnWheterItIsPrescriptivableByMidWife() {
      assertThat(this.ofNameProduct.IsPrescriptivableByMidWife()).isFalse();
   }

   @Test
   public void shouldReturnTheRefundRate() {
      assertThat(this.ofNameProduct.getRefundRate()).isEqualTo("65%");
   }

   @Test
   public void shouldReturnWhetherItIsRetrocedable() {
      assertThat(this.ofNameProduct.isRetrocedable()).isFalse();
   }


   private OfNameProduct getFirstProductFromXMLResource(String xmlSource) throws FileNotFoundException {
      APIProductByNameResult apiProductByNameResult = getAPIProductResultFromXMLResource(xmlSource);
      return apiProductByNameResult.getProducts().get(0);
   }
}
