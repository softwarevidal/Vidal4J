package api;

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


   private void shouldSearchAProductByName(VidalAPI vidalAPI) {
      APIProductResult apiProductResult = vidalAPI.searchProductsByName("asp");
      assertThat(apiProductResult.getTotalResultsNumber()).isGreaterThan(5);
      assertThat(apiProductResult.getTitle()).contains("Search Products - Query :");
   }
}
