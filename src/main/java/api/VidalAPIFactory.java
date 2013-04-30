package api;

public class VidalAPIFactory {

   public static VidalAPI getProdInstance() {
      return new VidalAPI("http://api.vidal.fr/rest/api");
   }

   public static VidalAPI getBetaInstance() {
      return new VidalAPI("http://apirest-beta.vidal.fr/rest/api");
   }

   public static VidalAPI getDevInstance() {
      return new VidalAPI("http://apirest-dev.vidal.fr/rest/api");
   }
}
