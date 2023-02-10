package Store;

import java.util.ArrayList;

public class DIsplayProducts {

    public static void displayproducts(Store store){
        ArrayList<Product> list = store.productList;
        int number = 1;
        for(Product x:list){
            System.out.println("--------------------------------------- ");
            System.out.println(number+"."+" "+ x.name + "\nprice: "+ x.price);
            System.out.println("---------------------------------------- ");
            number++;
        }
    }
}
