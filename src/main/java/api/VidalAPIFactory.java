package api;

public class VidalAPIFactory {

   public static VidalAPI getProdInstance() {
      return new VidalAPI("http://api.vidal.fr");
   }

   public static VidalAPI getBetaInstance() {
      return new VidalAPI("http://apirest-beta.vidal.fr");
   }

   public static VidalAPI getDevInstance() {
      return new VidalAPI("http://apirest-dev.vidal.fr");
   }
}
