package queries;

import results.APIResult;

import java.util.HashMap;
import java.util.Map;

public abstract class Query<T> {
   protected String baseUrl;
   protected Map<String, String> params;

   public Query() {
      this.params = new HashMap<String, String>();
   }

   public Query(String baseUrl) {
      this.baseUrl = baseUrl;
      this.params = new HashMap<String, String>();
   }

   public abstract APIResult execQuery();


   protected T addParam(String key, String value) {
      this.params.put(key, value);
      return (T) this;
   }

   protected abstract String buildUrl();

   protected String buildParams() {
      StringBuilder builder = new StringBuilder();

      if(! this.params.isEmpty()) {
         builder.append("?");

         for(Map.Entry<String, String> param : this.params.entrySet()) {
            builder.append(param.getKey()).append("=").append(param.getValue()).append("&");
         }

         int length = builder.length();
         builder.deleteCharAt(length - 1);
      }

      return builder.toString();
   }
}