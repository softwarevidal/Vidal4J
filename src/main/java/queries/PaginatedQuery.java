package queries;

import api.VidalAPI;

public abstract class PaginatedQuery<T> extends Query<T> {

   public PaginatedQuery(VidalAPI vidalAPI) {
      super(vidalAPI);
   }


   public T setStartPage(int pageNb) {
      return this.addParam("start-page",  Integer.toString(pageNb));
   }

   public T setPageSize(int pageSize) {
      return this.addParam("page-size", Integer.toString(pageSize));
   }
}
