package Store;

public class Addproduct{

    public static void addproduct(String name, double price, int quantity, Store store){
        Product n = null;
        n = new Product(name, price, quantity);
        store.productList.add(n);

    }
}