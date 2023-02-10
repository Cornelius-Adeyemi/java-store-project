package Store;

public class GetCashierDetails {

    public static String getdetail(int i, Store store){
        int num = 0;
       String  cas = "";
        for (Cashier j:store.list.values()){
            if(num ==i){
                cas = j.id;
                break;
            }
            num++;
        }
        return cas;
    }
}
