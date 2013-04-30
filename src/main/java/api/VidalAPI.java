package api;

import models.APIProductResult;
import models.Product;
import org.apache.abdera.Abdera;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.apache.abdera.parser.Parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VidalAPI {
   private String baseUrl;
   private Parser parser = new Abdera().getParser();


   public VidalAPI(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public APIProductResult searchProductsByName(String query) {
      APIProductResult apiProductResult = null;

      try {
         URL url = new URL(this.baseUrl + "/products?q=" + query);
         Document<Feed> doc = parser.parse(url.openStream(), url.toString());
         Feed feed = doc.getRoot();
         apiProductResult = new APIProductResult(feed);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }

      return apiProductResult;
   }
}
