package items;

import api.VidalAPI;
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
      VidalAPI vidalAPI = new VidalAPI("");

      item = new ItemImpl(entry, vidalAPI);
   }

   @Test
   public void shouldReturnTheEntryId() throws FileNotFoundException {
      assertThat(item.getEntryId().toString()).isEqualTo("vidal://product/15070");
   }

   @Test
   public void shouldReturnTheCategory() {
      assertThat(item.getCategory()).isEqualTo(Category.PRODUCT);
   }


   private static class ItemImpl extends Item {
      public ItemImpl(Entry entry, VidalAPI vidalAPI) {
         super(entry, vidalAPI);
      }
   }
}
