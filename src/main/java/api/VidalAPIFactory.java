package api;

public class VidalAPIFactory {

   public static VidalAPI getProdInstance() {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getProdInstance();
      return new VidalAPI(fullVidalAPI);
   }

   public static VidalAPI getBetaInstance() {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getBetaInstance();
      return new VidalAPI(fullVidalAPI);
   }

   public static VidalAPI getDevInstance() {
      FullVidalAPI fullVidalAPI = FullVidalAPIFactory.getDevInstance();
      return new VidalAPI(fullVidalAPI);
   }
}
