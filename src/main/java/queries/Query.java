package queries;

import api.VidalAPI;
import org.apache.abdera.model.Feed;
import results.APIResult;

import java.util.HashMap;
import java.util.Map;

import static utils.AtomTool.searchFeedFromURL;

public abstract class Query<T> {
   protected String baseUrl;
   protected Map<String, String> params;
   protected VidalAPI vidalAPI;

   public Query() {
      this.params = new HashMap<String, String>();
   }

   public Query(String baseUrl) {
      this.baseUrl = baseUrl;
      this.params = new HashMap<String, String>();
   }

   public Query(String baseUrl, VidalAPI vidalAPI) {
      this(baseUrl);
      this.vidalAPI = vidalAPI;
   }

   public abstract APIResult execQuery();

   protected abstract StringBuilder buildUrl();


   protected T addParam(String key, String value) {
      this.params.put(key, value);
      return (T) this;
   }

   protected StringBuilder buildParams() {
      StringBuilder builder = new StringBuilder();

      if(! this.params.isEmpty()) {
         builder.append("?");

         for(Map.Entry<String, String> param : this.params.entrySet()) {
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
}