package Store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SackCashierTest {

    Store store;
    @BeforeEach
    void init(){
        Manager.employManager("Adebisi");
        store = new Store(200000,(Manager) Manager.getCurretManager());
    }
    @Test
    @DisplayName("testing the sack method")
    void sackCashier() {
        HireCashier.hireCashier("musa",store);
        HireCashier.hireCashier("kola",store);
        HireCashier.hireCashier("john" ,store);
        String list = store.list.keySet().toArray(new String[0])[0];
        int iSize = store.list.size();
        SackCashier.sackCashier(list,store);
        int fSize = store.list.size();
        assertEquals(iSize-1,fSize);
        assertFalse(store.list.containsKey(list));
        //System.out.println(list);
    }
}