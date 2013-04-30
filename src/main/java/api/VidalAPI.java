package api;

import models.APIProductResult;
import org.apache.abdera.Abdera;
import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Feed;
import org.apache.abdera.parser.Parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class VidalAPI {
   private String baseUrl;
   private Parser parser = new Abdera().getParser();


   public VidalAPI(String baseUrl) {
      this.baseUrl = baseUrl;
   }


   public APIProductResult searchProductsByName(String query) {
      IRI iri = new IRI("/rest/api/products?q=" + query);
      return this.searchProductsByURL(iri);
   }


   public APIProductResult searchProductsByURL(IRI iri) {
      APIProductResult apiProductResult = null;

      try {
         URL url = new URL(this.baseUrl + iri.toString());
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
