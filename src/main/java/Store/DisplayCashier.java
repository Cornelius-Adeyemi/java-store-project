package Store;

import java.util.HashMap;

public class DisplayCashier {

   public static void display(Store store){
       int number = 1;
       for(Cashier x: store.list.values()){
          System.out.println(number + " " + x);
           System.out.println(" ");
         number++;
       }
   }
}
