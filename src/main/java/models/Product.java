package models;

import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import javax.xml.namespace.QName;

public class Product {
   private final String VIDAL_TAG_URL = "http://api.vidal.net/-/spec/vidal-api/1.0/";
   private Entry entry;

   public Product(Entry entry) {
      this.entry = entry;
   }


   public String getName() {
      return this.entry.getSummary();
   }

   public boolean shouldBeCarefull() {
      String beCareful = this.getVidalTagContent("beCareful").getText();
      return Boolean.parseBoolean(beCareful);
   }

   public Company getProvider() {
      Element company = this.getVidalTagContent("company");
      int vidalId = Integer.parseInt(company.getAttributeValue("vidalId"));
      String name = company.getText();
      String type = company.getAttributeValue("type");

      return new Company(vidalId, name, type);
   }

   public String getDispensationPlace() {
      return this.getVidalTagContent("dispensationPlace").getText();
   }

   public boolean isDopingProduct() {
      String drugInSport = this.getVidalTagContent("drugInSport").getText();
      return Boolean.parseBoolean(drugInSport);
   }

   public boolean isExceptional() {
      String exceptional = this.getVidalTagContent("exceptional").getText();
      return Boolean.parseBoolean(exceptional);
   }

   public boolean isOutOfGHS() {
      String horsGHS = this.getVidalTagContent("horsGHS").getText();
      return Boolean.parseBoolean(horsGHS);
   }

   public int getVidalId() {
      String id = this.getVidalTagContent("id").getText();
      return Integer.parseInt(id);
   }

   public String getMarketStatus() {
      Element marketStatus = this.getVidalTagContent("marketStatus");
      return marketStatus.getAttributeValue("name");
   }

   public boolean IsPrescriptivableByMidWife() {
      String midwife = this.getVidalTagContent("midwife").getText();
      return Boolean.parseBoolean(midwife);
   }

   public String getRefundRate() {
      return this.getVidalTagContent("refundRate").getText();
   }

   public boolean isRetrocedable() {
      String retrocession = this.getVidalTagContent("retrocession").getText();
      return Boolean.parseBoolean(retrocession);
   }



   private Element getVidalTagContent(String tagName) {
      QName name = new QName(VIDAL_TAG_URL, tagName, "vidal");
      Element firstChild = this.entry.getFirstChild(name);
      return firstChild;
   }
}
