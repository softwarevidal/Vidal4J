package queries;

import api.FullVidalAPI;
import org.junit.Before;
import org.junit.Test;
import results.Result;

import static org.fest.assertions.Assertions.assertThat;

public class QueryTest {

   private QueryTestImpl query;

   @Before
   public void setUp() {
      query = new QueryTestImpl(new FullVidalAPI(""));
   }

   @Test
   public void paramsBuilderShouldBeEmptyIfNoParams() {
      String s = this.query.buildParams().toString();
      assertThat(s).isEqualTo("");
   }

   @Test
   public void paramsBuilderShouldStartWithIntegPointIfThereAreParams() {
      QueryTestImpl withParams = this.query.addParam("name", "toto");
      assertThat(withParams.buildParams().toString()).startsWith("?");
   }

   @Test
   public void paramsBuilderShouldBeKeyValue() {
      QueryTestImpl withParams = this.query.addParam("name", "toto");
      assertThat(withParams.buildParams().toString()).contains("name=toto");
   }

   @Test
   public void paramsBuilderShouldBeSeperatedByECom() {
      QueryTestImpl withParams = this.query.addParam("name", "toto").addParam("city", "paris");
      assertThat(withParams.buildParams().toString()).contains("name=toto&city=paris");
   }

   @Test
   public void paramsBuilderShouldNotEndWithECom() {
      QueryTestImpl withParams = this.query.addParam("name", "toto").addParam("city", "paris");
      assertThat(withParams.buildParams().toString()).endsWith("name=toto&city=paris");
   }

   @Test
   public void paramsBuilderShouldSupportListOfParams() {
      QueryTestImpl withParamList = this.query.addParam("name", "toto").addParam("name", "toto");
      assertThat(withParamList.buildParams().toString()).endsWith("name=toto&name=toto");
   }

   @Test
   public void shouldRemoveAllOccurencesOfAParamFromItsKey() {
      QueryTestImpl query = this.query.addParam("city", "paris").addParam("name", "toto").addParam("name", "tata");
      query.removeParam("name");
      assertThat(query.buildParams().toString()).isEqualTo("?city=paris");
   }

   @Test
   public void shouldNotCrashWhenRemovingParamOfNoParam() {
      QueryTestImpl noParam = this.query;
      assertThat(noParam.removeParam("toto")).isNotNull();
   }


   private class QueryTestImpl extends Query<QueryTestImpl> {
      public QueryTestImpl(FullVidalAPI fullVidalAPI) {
         super(fullVidalAPI);
      }
      @Override
      public Result execQuery() {
         return null;  //To change body of implemented methods use File | Settings | File Templates.
      }
      @Override
      protected StringBuilder buildUrl() {
         return null;
      }
   }
}
