package api;

import results.APIEqFrenchProductResult;
import results.APIForeignProductResult;
import results.APIProductResult;
import org.apache.abdera.i18n.iri.IRI;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class VidalAPIIT {

   @Test
   public void shouldSearchAProductByNameOnDev() {
      this.shouldSearchAProductByName(VidalAPIFactory.getDevInstance());
   }

   @Test
   public void shouldSearchAProductByNameOnBeta() {
      this.shouldSearchAProductByName(VidalAPIFactory.getBetaInstance());
   }

   @Test
   public void shouldSearchAProductByNameOnProd() {
      this.shouldSearchAProductByName(VidalAPIFactory.getProdInstance());
   }

   @Test
   public void shouldSearchTheNextPage() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIProductResult productResult = vidalAPI.searchProductsByName("asp");
      APIProductResult nextPage = vidalAPI.searchProductsByNameNextPage(productResult);

      assertThat(nextPage.getCurrentPageNumber()).isEqualTo(2);
      assertThat(nextPage.getTotalResultsNumber()).isGreaterThan(0);
   }

   @Test
   public void shouldSearchForeignProducts() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIForeignProductResult apiForeignProductResult = vidalAPI.searchForeignProductsByProductId(15070);
      assertThat(apiForeignProductResult.getForeignProducts().size()).isGreaterThan(5);
      assertThat(apiForeignProductResult.getTitle()).contains("ForeignProducts for Product ");
   }

   @Test
   public void shouldReturnNullIfProductDoesntExistWhenSearchingForeignProducts() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIForeignProductResult apiForeignProductResult = vidalAPI.searchForeignProductsByProductId(0);
      assertThat(apiForeignProductResult).isNull();
   }

   @Test
   public void shouldSearchEqFrenchProducts() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIEqFrenchProductResult apiEqFrenchProductResult = vidalAPI.searchEqFrenchProductsByProductId(11022);
      assertThat(apiEqFrenchProductResult.getEqFrenchProducts().size()).isGreaterThan(1);
      assertThat(apiEqFrenchProductResult.getTitle()).contains("French equivalent Products for Foreign Product ");
   }

   @Test
   public void shouldReturnNullIfProductDoesntExistWhenSearchingEqFrenchProducts() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIEqFrenchProductResult apiEqFrenchProductResult = vidalAPI.searchEqFrenchProductsByProductId(0);
      assertThat(apiEqFrenchProductResult).isNull();
   }

   private void shouldSearchAProductByName(VidalAPI vidalAPI) {
      APIProductResult apiProductResult = vidalAPI.searchProductsByName("asp");
      assertThat(apiProductResult.getTotalResultsNumber()).isGreaterThan(5);
      assertThat(apiProductResult.getTitle()).contains("Search Products - Query :");
   }
}
