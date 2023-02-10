package Store;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {

     double income;
     public  ArrayList<Product> productList = new ArrayList<>();

      public StoreOwner owner = new StoreOwner() ;

      public Manager currentManager;

    public  HashMap<String, Cashier> list = new HashMap<>();

     public Store(double income, Manager currentManager ){
         this.income = income;

         this.currentManager = currentManager;
     }
    public static void main(String[] args){

    }





}


class HireManager{

    public static void hireManager(String name, Store store){
      String output =   Manager.employManager(name);
      System.out.println(output);
      store.currentManager =(Manager) Manager.getCurretManager();
    }
}









