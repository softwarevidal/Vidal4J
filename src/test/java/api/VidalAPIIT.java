package api;

import queries.ForeignProductByIdQuery;
import results.APIForeignProductResult;
import results.APIProductResult;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIProductResultFromXMLResource;


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
   public void shouldSearchTheNextPage() throws FileNotFoundException {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIProductResult productResult = getAPIProductResultFromXMLResource("productByName_Long.xml");
      APIProductResult nextPage = vidalAPI.searchProductsByNameNextPage(productResult);

      assertThat(nextPage.getCurrentPageNumber()).isEqualTo(3);
      assertThat(nextPage.getTotalResultsNumber()).isGreaterThan(0);
   }

   @Test
   public void shouldSearchThePrevPage() throws FileNotFoundException {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      APIProductResult productResult = getAPIProductResultFromXMLResource("productByName_Long.xml");
      APIProductResult prevPage = vidalAPI.searchProductsByNamePrevPage(productResult);

      assertThat(prevPage.getCurrentPageNumber()).isEqualTo(1);
      assertThat(prevPage.getTotalResultsNumber()).isGreaterThan(0);
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
   public void shouldReturnForeignProductsFromFrenchId() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      ForeignProductByIdQuery byIdQuery = vidalAPI.searchForeignProduct().byFrenchProductId(15070);
      APIForeignProductResult result = byIdQuery.execQuery();
      assertThat(result.getTitle()).contains("ForeignProducts for Product ");
      assertThat(result.getForeignProducts().size()).isGreaterThan(1);
   }


   private void shouldSearchAProductByName(VidalAPI vidalAPI) {
      APIProductResult apiProductResult = vidalAPI.searchProductsByName("asp");
      assertThat(apiProductResult.getTotalResultsNumber()).isGreaterThan(5);
      assertThat(apiProductResult.getTitle()).contains("Search Products - Query :");
   }
}
