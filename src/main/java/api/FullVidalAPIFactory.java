package api;

public class FullVidalAPIFactory {

   public static FullVidalAPI getProdInstance() {
      return new FullVidalAPI("http://api.vidal.fr");
   }

   public static FullVidalAPI getBetaInstance() {
      return new FullVidalAPI("http://apirest-beta.vidal.fr");
   }

   public static FullVidalAPI getDevInstance() {
      return new FullVidalAPI("http://apirest-dev.vidal.fr");
   }
}
