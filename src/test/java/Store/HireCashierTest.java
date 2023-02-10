package Store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HireCashierTest {

    Store store;
    @BeforeEach
    void init(){
        Manager.employManager("Adebisi");
        store = new Store(200000,(Manager) Manager.getCurretManager());
    }
    @Test
    @DisplayName("Testing if the the cashier was added to the list")
    void hireCashier() {

        int initialSize = store.list.size();
        HireCashier.hireCashier("Bola",store);
        int fSize = store.list.size();
        assertEquals(initialSize+1,fSize);
    }
}