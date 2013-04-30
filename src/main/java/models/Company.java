package models;

public class Company {
   public int vidalId;
   public String name;
   public String type;


   public Company(int vidalId, String name, String type) {
      this.vidalId = vidalId;
      this.name = name;
      this.type = type;
   }


   public int getVidalId() {
      return vidalId;
   }

   public void setVidalId(int vidalId) {
      this.vidalId = vidalId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }
}
