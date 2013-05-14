package utils;

import items.Company;
import items.key_values.*;
import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;

import static utils.AtomTool.getVidalTagContent;

public class EntryTool {

   public static boolean shouldBeCarefull(Entry entry) {
      String beCareful = getVidalTagContent("beCareful", entry).getText();
      return Boolean.parseBoolean(beCareful);
   }

   public static Company getProvider(Entry entry) {
      Element company = getVidalTagContent("company", entry);
      int vidalId = Integer.parseInt(company.getAttributeValue("vidalId"));
      String name = company.getText();
      String type = company.getAttributeValue("type");

      return new Company(vidalId, name, type);
   }

   public static DispensationPlace getDispensationPlace(Entry entry) {
      Element element = getVidalTagContent("dispensationPlace", entry);
      String name = element.getAttributeValue("name");
      return DispensationPlace.valueOf(name);
   }

   public static boolean isDopingProduct(Entry entry) {
      String drugInSport = getVidalTagContent("drugInSport", entry).getText();
      return Boolean.parseBoolean(drugInSport);
   }

   public static boolean isExceptional(Entry entry) {
      String exceptional = getVidalTagContent("exceptional", entry).getText();
      return Boolean.parseBoolean(exceptional);
   }

   public static boolean isOutOfGHS(Entry entry) {
      String horsGHS = getVidalTagContent("horsGHS", entry).getText();
      return Boolean.parseBoolean(horsGHS);
   }

   public static int getVidalId(Entry entry) {
      String id = getVidalTagContent("id", entry).getText();
      return Integer.parseInt(id);
   }

   public static VidalList getVidalList(Entry entry) {
      Element element = getVidalTagContent("list", entry);
      String name = element.getAttributeValue("name");
      String text = element.getText();
      return new VidalList(name, text);
   }

   public static MarketStatus getMarketStatus(Entry entry) {
      Element element = getVidalTagContent("marketStatus", entry);
      String name = element.getAttributeValue("name");
      return MarketStatus.valueOf(name);
   }

   public static boolean IsPrescriptivableByMidWife(Entry entry) {
      String midwife = getVidalTagContent("midwife", entry).getText();
      return Boolean.parseBoolean(midwife);
   }

   public static String getRefundRate(Entry entry) {
      return getVidalTagContent("refundRate", entry).getText();
   }

   public static boolean isRetrocedable(Entry entry) {
      String retrocession = getVidalTagContent("retrocession", entry).getText();
      return Boolean.parseBoolean(retrocession);
   }

   public static String getActivePrinciple(Entry entry) {
      return getVidalTagContent("activePrinciples", entry).getText();
   }

   public static AMMType getAMMType(Entry entry) {
      Element element = getVidalTagContent("ammType", entry);
      String vidalId = element.getAttributeValue("vidalId");
      String text = element.getText();
      return new AMMType(vidalId, text);
   }

   public static boolean hasPublishedDoc(Entry entry) {
      String hasPublishedDoc = getVidalTagContent("hasPublishedDoc", entry).getText();
      return Boolean.parseBoolean(hasPublishedDoc);
   }

   public static String getConcentration(Entry entry) {
      return getVidalTagContent("perVolume", entry).getText();
   }

   public static String getNameFromVidalTag(Entry entry) {
      return getVidalTagContent("name", entry).getText();
   }

   public static ATCClass getATCClass(Entry entry) {
      return new ATCClass(entry);
   }

   public static Country getCountry(Entry entry) {
      return new Country(entry);
   }

   public static GalenicForm getGalenicForm(Entry entry) {
      return new GalenicForm(entry);
   }

   public static Route getRoute(Entry entry) {
      return new Route(entry);
   }
}
