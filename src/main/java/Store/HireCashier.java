package Store;

public class HireCashier {

    public static void hireCashier(String name,Store store){
        String output = Cashier.hireCashier(name,store);
        System.out.println(" ");
        System.out.println(output);
    }
}
