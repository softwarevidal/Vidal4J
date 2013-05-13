package api;

import queries.ForeignProductByIdQuery;
import results.APIForeignProductResult;
import results.APIProductByNameResult;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getAPIProductResultFromXMLResource;


public class VidalAPIIT {

   @Test
   public void shouldReturnForeignProductsFromFrenchId() {
      VidalAPI vidalAPI = VidalAPIFactory.getDevInstance();
      ForeignProductByIdQuery byIdQuery = vidalAPI.searchForeignProduct().byFrenchProductId(15070);
      APIForeignProductResult result = byIdQuery.execQuery();
      assertThat(result.getTitle()).contains("ForeignProducts for Product ");
      assertThat(result.getForeignProducts().size()).isGreaterThan(1);
   }
}
