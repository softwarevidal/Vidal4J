package queries;

import api.FullVidalAPI;

public abstract class PaginatedQuery<T> extends Query<T> {

   public PaginatedQuery(FullVidalAPI fullVidalAPI) {
      super(fullVidalAPI);
   }


   public T setStartPage(int pageNb) {
      return this.addParam("start-page",  Integer.toString(pageNb));
   }

   public T setPageSize(int pageSize) {
      return this.addParam("page-size", Integer.toString(pageSize));
   }
}
