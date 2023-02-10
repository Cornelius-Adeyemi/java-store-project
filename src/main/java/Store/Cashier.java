package Store;

import java.util.HashMap;

public class Cashier extends StoreStaff{

    private static int num = 1;
    //private static HashMap<String, Cashier> list = new HashMap<>();
    private Cashier(String name, String id, String position) {
        super(name, id, position);
    }


    public static String hireCashier(String name, Store store){
        Cashier r = null;
        if(store.list.size()<6){
            String id = "cashier0" + num;
        r = new Cashier(name,id, "Cashier");
        store.list.put(id,r);
        num++;
        return "The cashier id for " + r.name+ " is: "+ id;
        }else{
            return "maximum number of cashier the store can employ is 5";
        }
    }

    public static String sackCashier(String id,Store store){

        if(store.list.containsKey(id)){
            String name = store.list.get(id).name;
            store.list.remove(id);

            return " you've successfully sacked "+name+ " from the store";
        }else{
            return "Their is no cashier with such id";
        }

    }





}
