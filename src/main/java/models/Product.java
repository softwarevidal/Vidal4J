package models;

import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import static utils.AtomTool.getVidalTagContent;

public class Product {
   private Entry entry;

   public Product(Entry entry) {
      this.entry = entry;
   }


   public String getName() {
      return this.entry.getSummary();
   }

   public boolean shouldBeCarefull() {
      String beCareful = getVidalTagContent("beCareful", this.entry).getText();
      return Boolean.parseBoolean(beCareful);
   }

   public Company getProvider() {
      Element company = getVidalTagContent("company", this.entry);
      int vidalId = Integer.parseInt(company.getAttributeValue("vidalId"));
      String name = company.getText();
      String type = company.getAttributeValue("type");

      return new Company(vidalId, name, type);
   }

   public String getDispensationPlace() {
      return getVidalTagContent("dispensationPlace", this.entry).getText();
   }

   public boolean isDopingProduct() {
      String drugInSport = getVidalTagContent("drugInSport", this.entry).getText();
      return Boolean.parseBoolean(drugInSport);
   }

   public boolean isExceptional() {
      String exceptional = getVidalTagContent("exceptional", this.entry).getText();
      return Boolean.parseBoolean(exceptional);
   }

   public boolean isOutOfGHS() {
      String horsGHS = getVidalTagContent("horsGHS", this.entry).getText();
      return Boolean.parseBoolean(horsGHS);
   }

   public int getVidalId() {
      String id = getVidalTagContent("id", this.entry).getText();
      return Integer.parseInt(id);
   }

   public String getMarketStatus() {
      Element marketStatus = getVidalTagContent("marketStatus", this.entry);
      return marketStatus.getAttributeValue("name");
   }

   public boolean IsPrescriptivableByMidWife() {
      String midwife = getVidalTagContent("midwife", this.entry).getText();
      return Boolean.parseBoolean(midwife);
   }

   public String getRefundRate() {
      return getVidalTagContent("refundRate", this.entry).getText();
   }

   public boolean isRetrocedable() {
      String retrocession = getVidalTagContent("retrocession", this.entry).getText();
      return Boolean.parseBoolean(retrocession);
   }
}
