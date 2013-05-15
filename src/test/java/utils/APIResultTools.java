package utils;

import api.VidalAPI;
import com.google.common.io.Resources;
import queries.*;
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


   public static APIProductByNameResult getAPIProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIProductByNameResult(feed, new VidalAPI(""));
   }

   public static APIForeignProductByIdResult getAPIForeignProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIForeignProductByIdResult(feed, new VidalAPI(""));
   }

   public static APIEqFrenchProductByIdResult getAPIEqFrenchProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIEqFrenchProductByIdResult(feed, new VidalAPI(""));
   }

   public static APIForeignProductByNameResult getAPIEqFrenchProductByNameResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIForeignProductByNameResult(feed, new VidalAPI(""));
   }

   public static APIProductByIdResult getAPIFullProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new APIProductByIdResult(feed, new VidalAPI(""));
   }


   public static Feed getFeedFromXML(String xmlSource) throws FileNotFoundException {
      Parser parser = new Abdera().getParser();
      String path = Resources.getResource(xmlSource).getPath();
      File file = new File(path);
      Document<Feed> doc = parser.parse(new FileInputStream(file));
      return doc.getRoot();
   }
}