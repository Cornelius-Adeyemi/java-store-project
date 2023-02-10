package Store;

public class SackCashier {


    public static void sackCashier(String id, Store store){
        if(store.list.size()>1) {
            String output = Cashier.sackCashier(id,store);
            System.out.println(" ");
            System.out.println(output);
        }else{
            System.out.println("You only one have one cashier. Please employ another one before sacking the current one");
        }
    }
}