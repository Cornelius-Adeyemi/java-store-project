package Store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddproductTest {

     Store store;
     @BeforeEach
    void init(){
        Manager.employManager("Adebisi");
        store = new Store(200000,(Manager) Manager.getCurretManager());
    }
    @Test
    @DisplayName("Add product to list")
    void addproduct() {
        int intSize =  store.productList.size();
        Addproduct.addproduct("mango",60,60,store);
        int fSize =  store.productList.size();
        assertEquals(intSize+1,fSize);

    }
}