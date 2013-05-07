package utils;

import com.google.common.io.Resources;
import results.*;
import org.apache.abdera.Abdera;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Feed;
import org.apache.abdera.parser.Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class APIResultTools {

//   public static <T extends APIResult> T getAPIResultFromXMLResource(Class<T> clazz, String xmlSource) throws FileNotFoundException {
//      Parser parser = new Abdera().getParser();
//      String path = Resources.getResource(xmlSource).getPath();
//      File productByNameResult = new File(path);
//
//      Document<Feed> doc = parser.parse(new FileInputStream(productByNameResult));
//      Feed feed = doc.getRoot();
//      T result = null;
//      try {
//         result = clazz.getConstructor(Feed.class).newInstance(feed);
//      } catch (InstantiationException e) {
//         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//      } catch (IllegalAccessException e) {
//         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//      } catch (InvocationTargetException e) {
//         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//      } catch (NoSuchMethodException e) {
//         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//      }
//
//      return result;
//   }

   public static APIPaginatedResults getAPIPaginatedResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIPaginatedResults(feed);
   }

   public static APIProductResult getAPIProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIProductResult(feed);
   }

   public static APIForeignProductResult getAPIForeignProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIForeignProductResult(feed);
   }

   public static APIEqFrenchProductByIdResult getAPIEqFrenchProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIEqFrenchProductByIdResult(feed);
   }

   public static APIEqFrenchProductByNameResult getAPIEqFrenchProductByNameResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIEqFrenchProductByNameResult(feed);
   }

   public static APIFullProductResult getAPIFullProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIFullProductResult(feed);
   }


   public static Feed getFeedFromXML(String xmlSource) throws FileNotFoundException {
      Parser parser = new Abdera().getParser();
      String path = Resources.getResource(xmlSource).getPath();
      File file = new File(path);
      Document<Feed> doc = parser.parse(new FileInputStream(file));
      return doc.getRoot();
   }
}