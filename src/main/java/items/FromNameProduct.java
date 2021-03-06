package items;

import api.FullVidalAPI;
import items.key_values.MarketStatus;
import items.key_values.VidalList;
import org.apache.abdera.model.Entry;
import results.ProductByIdResult;
import utils.DispensationPlace;
import utils.EntryTool;


public class FromNameProduct extends Item {

   public FromNameProduct(Entry entry, FullVidalAPI fullVidalAPI) {
      super(entry, fullVidalAPI);
   }


   public String getName() {
      return this.entry.getSummary();
   }

   public boolean shouldBeCarefull() {
      return EntryTool.shouldBeCarefull(this.entry);
   }

   public Company getProvider() {
      return EntryTool.getProvider(this.entry);
   }

   // Carefull: there might not be a "dispensationPlace" tag.
   public DispensationPlace getDispensationPlace() {
      return EntryTool.getDispensationPlace(this.entry);
   }

   public boolean isDopingProduct() {
      return EntryTool.isDopingProduct(this.entry);
   }

   public boolean isExceptional() {
      return EntryTool.isExceptional(this.entry);
   }

   public boolean hasPublishedDoc() {
      return EntryTool.hasPublishedDoc(this.entry);
   }

   public boolean isOutOfGHS() {
      return EntryTool.isOutOfGHS(this.entry);
   }

   public int getVidalId() {
      return EntryTool.getVidalId(this.entry);
   }

   // Carefull: there might not be a "list" tag.
   public VidalList getVidalList() {
      return EntryTool.getVidalList(this.entry);
   }

   public MarketStatus getMarketStatus() {
      return EntryTool.getMarketStatus(this.entry);
   }

   public boolean IsPrescriptivableByMidWife() {
      return EntryTool.IsPrescriptivableByMidWife(this.entry);
   }

   // Carefull: there might not be a "refund" tag.
   public String getRefundRate() {
      return EntryTool.getRefundRate(this.entry);
   }

   public boolean isRetrocedable() {
      return EntryTool.isRetrocedable(this.entry);
   }

   public ProductByIdResult openFullProduct() {
      int vidalId = this.getVidalId();
      return this.fullVidalAPI.searchProduct().byId(vidalId).execQuery();
   }
}