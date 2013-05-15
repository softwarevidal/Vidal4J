package items;

import api.FullVidalAPI;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.Category;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getFeedFromXML;

public class ItemTest {

   private static ItemImpl item;

   @BeforeClass
   public static void setUp() throws FileNotFoundException {
      Feed feed = getFeedFromXML("fullProduct.xml");
      Entry entry = feed.getEntries().get(0);
      FullVidalAPI fullVidalAPI = new FullVidalAPI("");

      item = new ItemImpl(entry, fullVidalAPI);
   }

   @Test
   public void shouldReturnTheEntryId() {
      assertThat(item.getEntryId().toString()).isEqualTo("vidal://product/15070");
   }

   @Test
   public void shouldReturnTheLastUpdatedDate() {
      assertThat(item.getLastUpdate().getMillis()).isEqualTo(1361404800000L);
   }

   @Test
   public void shouldReturnTheCategory() {
      assertThat(item.getCategory()).isEqualTo(Category.PRODUCT);
   }


   private static class ItemImpl extends Item {
      public ItemImpl(Entry entry, FullVidalAPI fullVidalAPI) {
         super(entry, fullVidalAPI);
      }
   }
}
