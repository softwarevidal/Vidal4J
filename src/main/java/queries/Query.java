package queries;

import api.VidalAPI;
import items.key_values.AbstractKeyValueItem;
import org.apache.abdera.model.Feed;
import results.APIResult;

import java.util.LinkedList;
import java.util.List;

import static utils.AtomTool.searchFeedFromURL;

public abstract class Query<T> {
   protected String baseUrl;
   protected List<GETParam> params;
   protected VidalAPI vidalAPI;

   public Query() {
      this.params = new LinkedList<GETParam>();
   }

   public Query(String baseUrl) {
      this.baseUrl = baseUrl;
      this.params = new LinkedList<GETParam>();
   }

   public Query(String baseUrl, VidalAPI vidalAPI) {
      this(baseUrl);
      this.vidalAPI = vidalAPI;
   }

   public abstract APIResult execQuery();

   protected abstract StringBuilder buildUrl();


   protected T addParam(String key, String value) {
      this.params.add(new GETParam(key, value));
      return (T) this;
   }

   protected T removeParam(String key) {
      for(int i=0; i<this.params.size(); i++) {
         if(this.params.get(i).getKey().equals(key)) {
            this.params.remove(i);
            this.removeParam(key);
         }
      }
      return (T) this;
   }

   protected StringBuilder buildParams() {
      StringBuilder builder = new StringBuilder();

      if(! this.params.isEmpty()) {
         builder.append("?");

         for(GETParam param : this.params) {
            builder.append(param.getKey()).append("=").append(param.getValue()).append("&");
         }

         int length = builder.length();
         builder.deleteCharAt(length - 1);
      }

      return builder;
   }

   protected Feed fetchResults() {
      StringBuilder searchUrl = this.buildUrl().append(this.buildParams());
      return searchFeedFromURL(searchUrl.toString());
   }

   public VidalAPI getVidalAPI() {
      return this.vidalAPI;
   }

   private class GETParam extends AbstractKeyValueItem {
      public GETParam(String key, String value) {
         super(key, value);
      }
      public String getKey() {
         return this.key;
      }
      public String getValue() {
         return this.value;
      }
   }
}