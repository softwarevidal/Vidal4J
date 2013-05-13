package searches;

import api.VidalAPI;

public abstract class Search {

   protected String baseUrl;
   protected VidalAPI vidalAPI;

   public Search(String baseUrl) {
      this.baseUrl = baseUrl;
   }

   public Search(String baseUrl, VidalAPI vidalAPI) {
      this.baseUrl = baseUrl;
      this.vidalAPI = vidalAPI;
   }
}
