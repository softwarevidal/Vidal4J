package queries;

import api.VidalAPI;

public abstract class PaginatedQuery<T> extends Query<T> {

   public PaginatedQuery(String baseUrl) {
      super(baseUrl);
   }

   public PaginatedQuery(String baseUrl, VidalAPI vidalAPI) {
      super(baseUrl, vidalAPI);
   }


   public T setStartPage(int pageNb) {
      return this.addParam("start-page",  Integer.toString(pageNb));
   }

   public T setPageSize(int pageSize) {
      return this.addParam("page-size", Integer.toString(pageSize));
   }
}
