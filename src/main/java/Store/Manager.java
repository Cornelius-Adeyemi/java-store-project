package Store;

public class Manager extends StoreStaff {

    private static Manager myManager = null;

    private Manager(String name, String id, String position) {
        super(name, id, position);
    }

    public static String employManager(String name){
        if(myManager ==null){
          String id= "manager111";
          String title = "Manager";

          myManager= new Manager(name, id,title);
          return "A new manager has been employed to manage the store. The manager id is "+id;
        }else {

            return "The store already has a manger";
        }

    }


    public static Object getCurretManager(){
        if(myManager ==null){
           return new String("The store has no manager at the moment");
        }else{
            return myManager;
        }
    }
    public static String sackCurrentManager(){
        if(myManager == null){

            return "The store doesn't have a manager at the moment";
        }
        myManager =null;
        return "You've successfully sacked the current manager";
    }

}
