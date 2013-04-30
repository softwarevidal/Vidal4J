package utils;

import com.google.common.io.Resources;
import models.APIProductResult;
import models.APIResult;
import org.apache.abdera.Abdera;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Feed;
import org.apache.abdera.parser.Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

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

   public static APIResult getAPIResultFromXMLResource(String xmlSource) throws FileNotFoundException {
      Parser parser = new Abdera().getParser();
      String path = Resources.getResource(xmlSource).getPath();
      File productByNameResult = new File(path);

      Document<Feed> doc = parser.parse(new FileInputStream(productByNameResult));
      Feed feed = doc.getRoot();
      APIResult result = new APIResult(feed);

      return result;
   }

   public static APIProductResult getAPIProductResultFromXMLResource(String xmlSource) throws FileNotFoundException {
      Parser parser = new Abdera().getParser();
      String path = Resources.getResource(xmlSource).getPath();
      File productByNameResult = new File(path);

      Document<Feed> doc = parser.parse(new FileInputStream(productByNameResult));
      Feed feed = doc.getRoot();
      APIProductResult result = new APIProductResult(feed);

      return result;
   }
}
