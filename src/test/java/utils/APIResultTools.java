package utils;

import api.FullVidalAPI;
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

   public static ProductByNameResult getAPIProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new ProductByNameResult(feed, new FullVidalAPI(""));
   }

   public static ForeignProductByIdResult getAPIForeignProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new ForeignProductByIdResult(feed, new FullVidalAPI(""));
   }

   public static EqFrenchProductByIdResult getAPIEqFrenchProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new EqFrenchProductByIdResult(feed, new FullVidalAPI(""));
   }

   public static ForeignProductByNameResult getAPIEqFrenchProductByNameResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new ForeignProductByNameResult(feed, new FullVidalAPI(""));
   }

   public static ProductByIdResult getAPIFullProductResultFromXMLResource(String xmlSource)
           throws FileNotFoundException {
      Feed feed = getFeedFromXML(xmlSource);
      return new ProductByIdResult(feed, new FullVidalAPI(""));
   }


   public static Feed getFeedFromXML(String xmlSource) throws FileNotFoundException {
      Parser parser = new Abdera().getParser();
      String path = Resources.getResource(xmlSource).getPath();
      File file = new File(path);
      Document<Feed> doc = parser.parse(new FileInputStream(file));
      return doc.getRoot();
   }
}