package items;

import api.VidalAPI;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.fest.assertions.Assertions.assertThat;
import static utils.APIResultTools.getFeedFromXML;

public class ItemTest {

   @Test
   public void shouldReturnTheEntryId() throws FileNotFoundException {
      Feed feed = getFeedFromXML("fullProduct.xml");
      Entry entry = feed.getEntries().get(0);
      VidalAPI vidalAPI = new VidalAPI("");

      ItemImpl item = new ItemImpl(entry, vidalAPI);
      assertThat(item.getEntryId().toString()).isEqualTo("vidal://product/15070");
   }


   private class ItemImpl extends Item {
      public ItemImpl(Entry entry, VidalAPI vidalAPI) {
         super(entry, vidalAPI);
      }
   }
}
