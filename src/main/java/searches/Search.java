package searches;

import api.FullVidalAPI;

public abstract class Search {

   protected String baseUrl;
   protected FullVidalAPI fullVidalAPI;

   public Search(String baseUrl) {
      this.baseUrl = baseUrl;
   }

   public Search(String baseUrl, FullVidalAPI fullVidalAPI) {
      this.baseUrl = baseUrl;
      this.fullVidalAPI = fullVidalAPI;
   }
}
