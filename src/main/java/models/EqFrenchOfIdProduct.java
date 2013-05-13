package models;

import api.VidalAPI;
import models.key_values.AMMType;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import static utils.AtomTool.getVidalTagContent;

public class EqFrenchOfIdProduct extends OfNameProduct {

   public EqFrenchOfIdProduct(Entry entry, VidalAPI vidalAPI) {
      super(entry, vidalAPI);
   }


   public String getActivePrinciple() {
      return getVidalTagContent("activePrinciples", this.entry).getText();
   }

   public AMMType getAMMType() {
      Element element = getVidalTagContent("ammType", this.entry);
      String vidalId = element.getAttributeValue("vidalId");
      String text = element.getText();
      return new AMMType(vidalId, text);
   }

   public boolean hasPublishedDoc() {
      String hasPublishedDoc = getVidalTagContent("hasPublishedDoc", this.entry).getText();
      return Boolean.parseBoolean(hasPublishedDoc);
   }

   public String getConcentration() {
      return getVidalTagContent("perVolume", this.entry).getText();
   }

   public String getName() {
      return getVidalTagContent("name", this.entry).getText();
   }
}
